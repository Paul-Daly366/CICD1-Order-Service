package com.example.cicd1_order_service.controller;

import com.example.cicd1_order_service.model.PurchaseOrder;
import com.example.cicd1_order_service.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class PurchaseOrderController {
    private final PurchaseOrderService service;
    private final PurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(PurchaseOrderService service, PurchaseOrderService purchaseOrderService) {
        this.service = service;
        this.purchaseOrderService = purchaseOrderService;
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
    public String testCatalogConnection(@PathVariable("productId") Long productId){
        return purchaseOrderService.testCatalogConnection(productId);
    }
}
