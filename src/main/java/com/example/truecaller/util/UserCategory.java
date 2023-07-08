package com.example.truecaller.util;

import lombok.Getter;


public enum UserCategory {
    NORMAL(ContactLimit.NORMAL),
    MEDIUM(ContactLimit.MIDIUM),
    HIGHER(ContactLimit.HIGHER);

    private int limitContacts;

    UserCategory(int limitContacts) {
        this.limitContacts = limitContacts;
    }




}
