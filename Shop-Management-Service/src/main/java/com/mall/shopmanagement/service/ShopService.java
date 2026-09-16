package com.mall.shopmanagement.service;

import com.mall.shopmanagement.entity.Shop;
import com.mall.shopmanagement.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ShopService {

    @Autowired
    private ShopRepository repo;

    public List<Shop> listAll() {
        return repo.findAll();
    }

    public Shop get(Integer id) {
        return repo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Shop save(Shop shop) {
        return repo.save(shop);
    }

    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException();
        }
        repo.deleteById(id);
    }
}
