package com.mall.shopmanagement.controller;

import com.mall.shopmanagement.entity.Shop;
import com.mall.shopmanagement.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class ShopController {

    @Autowired
    private ShopService service;

    // RESTful API method for Retrieval - all records
    @GetMapping("/shops")
    public List<Shop> list() {
        return service.listAll();
    }

    // RESTful API method for Retrieval - specific record
    @GetMapping("/shops/{id}")
    public ResponseEntity<Shop> get(@PathVariable Integer id) {
        try {
            Shop shop = service.get(id);
            return new ResponseEntity<>(shop, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Create
    @PostMapping("/shops")
    public ResponseEntity<Shop> add(@RequestBody Shop shop) {
        Shop savedShop = service.save(shop);
        return new ResponseEntity<>(savedShop, HttpStatus.CREATED);
    }

    // RESTful API method for Update
    @PutMapping("/shops/{id}")
    public ResponseEntity<?> update(@RequestBody Shop shop, @PathVariable Integer id) {
        try {
            Shop existingShop = service.get(id);
            shop.setId(existingShop.getId());
            service.save(shop);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Delete
    @DeleteMapping("/shops/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
