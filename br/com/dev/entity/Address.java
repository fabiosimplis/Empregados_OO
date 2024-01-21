package br.com.dev.entity;

public class Address {

    private String email;
    private String phone;

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
}
