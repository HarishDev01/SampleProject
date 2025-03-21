package com.harish.SpringBootRest.controller;

import com.harish.SpringBootRest.model.SkuProfile;
import com.harish.SpringBootRest.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.harish.SpringBootRest.service.ProjectService;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    ProjectService service;

    @GetMapping("/items/{sku}")
    public ResponseEntity<List<SkuProfile>> getSkubyId(@PathVariable String sku) {
        System.out.println("requested Sku -Id  "+sku);

        List<SkuProfile> s = service.getItemsById(sku);

        if (s.isEmpty()) {
            // If no items are found, return a 404 Not Found response
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);  // You can return an empty body or a specific error message
        }

        return ResponseEntity.ok(s);
    }

    @GetMapping("/item/{id}")
    public Student getSku(@PathVariable String id) {
       Optional<Student> skuList = service.getByItem(id); // Assuming service.getByItem returns List<SkuProfile>
        System.out.println("Student -Id  "+id);
       return skuList.orElse(null);
    }

    @PostMapping("/addItem")
    public ResponseEntity<SkuProfile> createItem(@RequestBody SkuProfile skuProfile) {
        // Call service to save the item
        SkuProfile savedItem = service.addSku(skuProfile);

        // Return a response with the saved item and 201 CREATED status
        return ResponseEntity.status(201).body(savedItem);
    }

}
