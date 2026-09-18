package com.example.cicd1_order_service.service;

import com.example.cicd1_order_service.model.PurchaseOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final List<PurchaseOrder> orders = new ArrayList<PurchaseOrder>();
    private long nextId = 1;

    public List<PurchaseOrder> getAll(){
        return orders;
    }

    public PurchaseOrder create(PurchaseOrder order){
        order.setId(nextId++);
        orders.add(order);
        return order;
    }
}
