package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;


public class User {


    private String addressCity;
    private String addressStreet;
    private Integer addressNumber;
    private String addressZipcode;
    private Double geolocationLat;
    private Double geolocationLong;


    @JsonProperty("email")
    private String email;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    @JsonProperty("__v")
    private Integer __v;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("name")
    private void unpackName(Map<String, Object> name) {
        this.firstname = (String) name.get("firstname");
        this.lastname = (String) name.get("lastname");

    }

    @JsonProperty("address")
    private void unpackAddress(Map<String, Object> address) {
        Map<String, String> geolocation = (Map<String, String>) address.get("geolocation");
        this.addressCity = (String) address.get("city");
        this.addressStreet = (String) address.get("street");
        this.addressNumber = (Integer) address.get("number");
        this.addressZipcode = (String) address.get("zipcode");
        this.geolocationLat = Double.valueOf(geolocation.get("lat"));
        this.geolocationLong = Double.valueOf(geolocation.get("long"));

    }

    public User() {
    }

    public User(String addressCity, String addressStreet, Integer addressNumber, String addressZipcode, Double geolocationLat, Double geolocationLong, String email, String username, String password, Integer __v, String firstname, String lastname, Integer id, String phone) {
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
        this.addressZipcode = addressZipcode;
        this.geolocationLat = geolocationLat;
        this.geolocationLong = geolocationLong;
        this.email = email;
        this.username = username;
        this.password = password;
        this.__v = __v;
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.phone = phone;
    }
    public Double getGeolocationLat() {
        return geolocationLat;
    }
    public Double getGeolocationLong() {
        return geolocationLong;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    @Override
    public String toString() {
        return "org.example.User{" +
                "addressCity='" + addressCity + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                ", addressNumber=" + addressNumber +
                ", addressZipcode='" + addressZipcode + '\'' +
                ", geolocationLat=" + geolocationLat +
                ", geolocationLong=" + geolocationLong +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", __v=" + __v +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", id=" + id +
                ", phone='" + phone + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(addressCity, user.addressCity) && Objects.equals(addressStreet, user.addressStreet)
                && Objects.equals(addressNumber, user.addressNumber) && Objects.equals(addressZipcode, user.addressZipcode)
                && Objects.equals(geolocationLat, user.geolocationLat) && Objects.equals(geolocationLong, user.geolocationLong)
                && Objects.equals(email, user.email) && Objects.equals(username, user.username)
                && Objects.equals(password, user.password) && Objects.equals(__v, user.__v)
                && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname)
                && Objects.equals(id, user.id) && Objects.equals(phone, user.phone);
    }
    @Override
    public int hashCode() {
        return Objects.hash(addressCity, addressStreet, addressNumber, addressZipcode, geolocationLat, geolocationLong, email, username, password, __v, firstname, lastname, id, phone);
    }
}
