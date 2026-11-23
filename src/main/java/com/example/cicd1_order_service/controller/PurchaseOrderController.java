package com.example.cicd1_order_service.controller;

import com.example.cicd1_order_service.client.dto.ProductResponse;
import com.example.cicd1_order_service.model.PurchaseOrder;
import com.example.cicd1_order_service.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class PurchaseOrderController {
    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<PurchaseOrder> getPurchaseOrders() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseOrder create(@RequestBody PurchaseOrder order) {
        return service.create(order);
    }

    @GetMapping("/test-catalog/{productId}")
    public ProductResponse testCatalogConnection(@PathVariable("productId") Long productId){
        return service.testCatalogConnection(productId);
    }

    @GetMapping("/{id}/product")
    public ProductResponse getProductForOrder(@PathVariable Long id){
        return service.getProductForOrder(id);
    }
}
