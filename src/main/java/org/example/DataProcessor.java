package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class DataProcessor {
    private static double round(double value) {
        int precision = 2;
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(precision, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    static double distance(User user1, User user2) {
        double x0 = (user1.getGeolocationLat() - user2.getGeolocationLat());
        double y0 = user1.getGeolocationLong() - user2.getGeolocationLong();
        return Math.sqrt(x0 * x0 + y0 * y0);
    }

    public Map.Entry<User, User> getFurthestLiving(List<User> users) {
        Map.Entry<User, User> furthestLiving = null;
        double max = 0.0;
        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (distance(users.get(i), users.get(j)) > max) {
                    max = distance(users.get(i), users.get(j));
                    furthestLiving = Map.entry(users.get(i), users.get(j));
                }
            }
        }
        return furthestLiving;
    }

    public String getTheMostExpensiveCart(List<Cart> carts, List<Product> products, List<User> users) {
        double maxValue = 0;
        User user = new User();
        Cart mostExpensiveCart = null;
        for (Cart cart : carts) {
            double value = cart.getProducts().stream().mapToDouble(c -> products.get(c.get("productId") - 1).getPrice() * c.get("quantity")).sum();
            if (value > maxValue) {
                maxValue = value;
                mostExpensiveCart = carts.get(cart.getId() - 1);
                user = users.get(cart.getUserId() - 1);
            }
        }
        return mostExpensiveCart + " Max price: " + maxValue + " " + user.getFirstname() + " " + user.getLastname();
    }

    public Map<String, Double> getCategories(List<Product> products) {
        Map<String, Double> categories = new HashMap<>();
        products.forEach(p -> {
            if (categories.containsKey(p.getCategory())) {
                categories.replace(p.getCategory(), round(categories.get(p.getCategory()) + p.getPrice()));
            } else {
                categories.put(p.getCategory(), round(p.getPrice()));
            }
        });
        return categories;
    }

}