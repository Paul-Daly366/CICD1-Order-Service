package com.example.cicd1_order_service.service;

import com.example.cicd1_order_service.client.dto.ProductResponse;
import com.example.cicd1_order_service.model.PurchaseOrder;
import com.example.cicd1_order_service.repository.PurchaseOrderRepository;
import com.example.cicd1_order_service.client.CatalogClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository repository;
    private final CatalogClient catalogClient;

    public PurchaseOrderService(PurchaseOrderRepository repository, CatalogClient catalogClient) {
        this.repository = repository;
        this.catalogClient = catalogClient;
    }

    public List<PurchaseOrder> getAll(){
        return repository.findAll();
    }

    public PurchaseOrder create(PurchaseOrder order){
        order.setId(null);
        return repository.save(order);
    }

    public ProductResponse testCatalogConnection(Long productId){
        return catalogClient.getProductById(productId);
    }

    public ProductResponse getProductForOrder(Long orderId){
        PurchaseOrder order = repository.findById(orderId).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        return catalogClient.getProductById(order.getProductId());
    }
}
