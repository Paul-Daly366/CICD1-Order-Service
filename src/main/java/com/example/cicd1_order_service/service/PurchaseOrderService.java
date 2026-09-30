package com.example.cicd1_order_service.service;

import com.example.cicd1_order_service.model.PurchaseOrder;
import com.example.cicd1_order_service.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository repository;

    public PurchaseOrderService(PurchaseOrderRepository repository) {
        this.repository = repository;
    }

    public List<PurchaseOrder> getAll(){
        return repository.findAll();
    }

    public PurchaseOrder create(PurchaseOrder order){
        order.setId(null);
        return repository.save(order);
    }
}
