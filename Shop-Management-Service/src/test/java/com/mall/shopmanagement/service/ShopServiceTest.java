package com.mall.shopmanagement.service;

import com.mall.shopmanagement.entity.Shop;
import com.mall.shopmanagement.repository.ShopRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShopServiceTest {

    @Mock
    private ShopRepository repo;

    @InjectMocks
    private ShopService service;

    @Test
    void shouldListAllShops() {
        when(repo.findAll()).thenReturn(List.of(
                new Shop(1, "Fashion Hub", "Arun", "Clothing", 1, "9876543210", 45000),
                new Shop(2, "Tech World", "Priya", "Electronics", 2, "9876501234", 60000)
        ));

        assertEquals(2, service.listAll().size());
        verify(repo, times(1)).findAll();
    }

    @Test
    void shouldGetShopById() {
        Shop shop = new Shop(1, "Fashion Hub", "Arun", "Clothing", 1, "9876543210", 45000);
        when(repo.findById(1)).thenReturn(Optional.of(shop));

        assertEquals("Fashion Hub", service.get(1).getName());
    }

    @Test
    void shouldThrowWhenShopDoesNotExist() {
        when(repo.findById(99)).thenReturn(Optional.empty());

        assertThrows(java.util.NoSuchElementException.class, () -> service.get(99));
    }
}
