package com.vht.csv;

import com.opencsv.bean.CsvBindByName;


// in case object has nested object2
public class User2 {
    @CsvBindByName(column = "ID")
    private Long id;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Email")
    private String email;

    @CsvBindByName(column = "Country")
    private String country;
    @CsvBindByName(column = "City")
    private String city;

    public User2() {}

    public User2(Long id, String name, String email, Country country) {
        this.id = id;
        this.name = name;
        this.email = email;

        this.country = country.country;
        this.city = country.city;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getCity() { return city; }
    public void setCity(String city) {
        this.city = city;
    }
}
