package com.example.truecaller.util;

import com.example.truecaller.util.ContactLimit;
import lombok.Getter;

@Getter
public enum UserCategory {
    NORMAL(ContactLimit.NORMAL),
    MEDIUM(ContactLimit.MIDIUM),
    HIGHER(ContactLimit.HIGHER);

    private int limit;

    UserCategory(int limitContacts) {
        this.limit = limitContacts;
    }





}
