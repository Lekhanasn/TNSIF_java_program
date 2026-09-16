package com.mall.shopmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String ownerName;
    private String category;
    private Integer floorNumber;
    private String contact;
    private double monthlyRent;

    public Shop() {
    }

    public Shop(Integer id, String name, String ownerName, String category,
                Integer floorNumber, String contact, double monthlyRent) {
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this.category = category;
        this.floorNumber = floorNumber;
        this.contact = contact;
        this.monthlyRent = monthlyRent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    @Override
    public String toString() {
        return "Shop [id=" + id + ", name=" + name + ", ownerName=" + ownerName
                + ", category=" + category + ", floorNumber=" + floorNumber
                + ", contact=" + contact + ", monthlyRent=" + monthlyRent + "]";
    }
}
