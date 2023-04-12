package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class Cart {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("products")
    private List<Map<String, Integer>> products;
    @JsonProperty("__v")
    private Integer __v;

    public Cart() {
    }

    public Cart(Integer id, Integer userId, String date, List<Map<String, Integer>> products, Integer __v) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.products = products;
        this.__v = __v;
    }
    public Integer getId() {
        return id;
    }
    public Integer getUserId() {
        return userId;
    }
    public List<Map<String, Integer>> getProducts() {
        return products;
    }
    @Override
    public String toString() {
        return "org.example.Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", date='" + date + '\'' +
                ", products=" + products +
                ", __v=" + __v +
                '}';
    }
}
