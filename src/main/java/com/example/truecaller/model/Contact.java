package com.example.truecaller.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;


public class Contact {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String phone;
    private String email;

    @Override
    public boolean equals(Object obj) {
        if (Objects.isNull(obj)) return false;
        if (!(obj instanceof Contact)) return false;
        return this.phone.equals(((Contact) obj).phone)||this.name.equals(((Contact) obj).name);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
