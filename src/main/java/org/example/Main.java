package org.example;

public class Main {
    public static void main(String[] args) {
        DataProcessor dataProcessor = new DataProcessor();
        System.out.println("Products categories:" );
        System.out.println( dataProcessor.getCategories(ProductMapper.mapper()));
        System.out.println("Two users living furthest away from each other:");
        System.out.println( dataProcessor.getFurthestLiving(UserMapper.mapper()));
        System.out.println("Most expensive cart:");
        System.out.println( dataProcessor.getTheMostExpensiveCart(CartMapper.mapper(), ProductMapper.mapper(), UserMapper.mapper()));

    }
}