package com.example.truecaller.util;

import com.example.truecaller.util.ContactLimit;
import lombok.Getter;


public enum UserCategory {
    NORMAL(ContactLimit.NORMAL),
    MEDIUM(ContactLimit.MIDIUM),
    HIGHER(ContactLimit.HIGHER);

    private int limit;

    UserCategory(int limitContacts) {
        this.limit = limitContacts;
    }


    public int getLimit() {
        return limit;
    }
}
