
import org.example.Cart;
import org.example.DataProcessor;
import org.example.Product;
import org.example.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {

    DataProcessor dataProcessor;
    List<Product> productTestData = List.of(
            new Product(1, "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", 109.95, "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday", "men's clothing", "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg", 3.9, 120.0),
            new Product(2, "Mens Casual Premium Slim Fit T-Shirts ", 22.3, "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.", "men's clothing", "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg", 4.1, 259.0),
            new Product(3, "Mens Cotton Jacket", 55.99, "great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.", "men's clothing", "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg", 4.7, 500.0),
            new Product(4, "Mens Casual Slim Fit", 15.99, "The color could be slightly different between on the screen and in practice. / Please note that body builds vary by person, therefore, detailed size information should be reviewed below on the product description.", "men's clothing", "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg", 2.1, 430.0),
            new Product(5, "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet", 695.0, "From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the oceans pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.", "jewelery", "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg", 4.6, 400.0),
            new Product(6, "Solid Gold Petite Micropave ", 168.0, "Satisfaction Guaranteed. Return or exchange any order within 30 days.Designed and sold by Hafeez Center in the United States. Satisfaction Guaranteed. Return or exchange any order within 30 days.", "jewelery", "https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_.jpg", 3.9, 70.0),
            new Product(7, "White Gold Plated Princess", 9.99, "Classic Created Wedding Engagement Solitaire Diamond Promise Ring for Her. Gifts to spoil your love more for Engagement, Wedding, Anniversary, Valentine s Day...", "jewelery", "https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg", 3.0, 400.0));
    List<User> userTestData = List.of(
            new User("kilcoole", "new road", 7682, "12926-3874", -37.3159, 81.1496, "john@gmail.com", "johnd", "m38rmF$", 0, "john", "doe", 1, "1-570-236-7033"),
            new User("kilcoole", "Lovers Ln", 7267, "12926-3874", -37.3159, 81.1496, "morrison@gmail.com", "mor_2314", "83r5^_", 0, "david", "morrison", 2, "1-570-236-7033"),
            new User("Cullman", "Frances Ct", 86, "29567-1452", 40.3467, -30.131, "kevin@gmail.com", "kevinryan", "kev02937@", 0, "kevin", "ryan", 3, "1-567-094-1345"),
            new User("San Antonio", "Hunters Creek Dr", 6454, "98234-1734", 50.3467, -20.131, "don@gmail.com", "donero", "ewedon", 0, "don", "romer", 4, "1-765-789-6734"),
            new User("san Antonio", "adams St", 245, "80796-1234", 40.3467, -40.131, "derek@gmail.com", "derek", "jklg*_56", 0, "derek", "powell", 5, "1-956-001-1945"));

    List<Cart> cartsTestData = List.of(
            new Cart(1, 1, "2020-03-02T00:00:00.000Z", List.of(Map.of("productId", 1, "quantity", 4), Map.of("productId", 2, "quantity", 1), Map.of("productId", 3, "quantity", 6)), 0),
            new Cart(2, 1, "2020-01-02T00:00:00.000Z", List.of(Map.of("productId", 1, "quantity", 10), Map.of("productId", 2, "quantity", 4), Map.of("productId", 5, "quantity", 2)), 0),
            new Cart(3, 2, "2020-03-01T00:00:00.000Z", List.of(Map.of("productId", 1, "quantity", 2), Map.of("productId", 1, "quantity", 1)), 0),
            new Cart(4, 3, "2020-01-01T00:00:00.000Z", List.of(Map.of("productId", 1, "quantity", 4)), 0));

    @BeforeEach
    void setup() {
        dataProcessor = new DataProcessor();
    }

    @Test
    void shouldReturnCorrectGroupOfCategoriesFromCorrectValues() {
        Map<String, Double> expectedValue = Map.of("men's clothing", 204.23, "jewelery", 872.99);
        Map<String, Double> actualValue = dataProcessor.getCategories(productTestData);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldReturnTheMostExpensiveCartFromCorrectValues() {
        String expectedValue = "org.example.Cart{id=2, userId=1, date='2020-01-02T00:00:00.000Z', products=[{productId=1, quantity=10}, {productId=2, quantity=4}, {productId=5, quantity=2}], __v=0} Max price: 2578.7 john doe";
        String actualValue = dataProcessor.getTheMostExpensiveCart(cartsTestData, productTestData, userTestData);
        assertEquals(expectedValue, actualValue);

    }

    @Test
    void shouldReturnFurthestLivingFromCorrectValue() {

        Map.Entry<User, User> exceptedValue = Map.entry(new User("kilcoole", "new road", 7682, "12926-3874", -37.3159, 81.1496, "john@gmail.com", "johnd", "m38rmF$", 0, "john", "doe", 1, "1-570-236-7033"),
                new User("san Antonio", "adams St", 245, "80796-1234", 40.3467, -40.131, "derek@gmail.com", "derek", "jklg*_56", 0, "derek", "powell", 5, "1-956-001-1945"));
        Map.Entry<User, User> actualValue = dataProcessor.getFurthestLiving(userTestData);
        assertEquals(exceptedValue, actualValue);
    }
}