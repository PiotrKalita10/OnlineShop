package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Product {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("description")
    private String description;
    @JsonProperty("category")
    private String category;
    @JsonProperty("image")
    private String image;
    private Double ratingRate;
    private Double ratingCount;
    @JsonProperty("rating")
    private void unpackNest(Map<String, Double> rating) {
        this.ratingRate =  rating.get("rate");
        this.ratingCount =  rating.get("count");
    }
    public Product(Integer id, String title, Double price, String description, String category, String image, Double ratingRate, Double ratingCount) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.ratingRate = ratingRate;
        this.ratingCount = ratingCount;
    }

    public Product() {
    }

    public Double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", ratingRate='" + ratingRate + '\'' +
                ", ratingCount='" + ratingCount + '\'' +
                '}';
    }
}
