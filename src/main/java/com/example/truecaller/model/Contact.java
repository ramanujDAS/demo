package com.example.truecaller.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;


@Getter
@Setter
@ToString
@Builder
public class Contact {
    private String name;
    private String phone;
    private String email;

    @Override
    public boolean equals(Object obj) {
        if (Objects.isNull(obj)) return false;
        if (!(obj instanceof Contact)) return false;
        return this.phone.equals(((Contact) obj).phone)||this.name.equals(((Contact) obj).name);
    }

}
