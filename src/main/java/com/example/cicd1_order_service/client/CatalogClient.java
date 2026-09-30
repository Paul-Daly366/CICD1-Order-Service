package com.example.cicd1_order_service.client;

import com.example.cicd1_order_service.client.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "catalog-service",
        url = "http://localhost:8082"
)
public interface CatalogClient {
    @GetMapping("/products/{id}")
    ProductResponse getProductById(@PathVariable("id") Long id);
}
