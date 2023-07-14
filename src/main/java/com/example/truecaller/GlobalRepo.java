package com.example.truecaller;


import com.example.truecaller.repo.GlobalContacts;
import jakarta.inject.Singleton;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Boolean.TRUE;


@Singleton
@Getter
public class GlobalRepo {
    private Set<String> globalSpamList = new HashSet<>();
    private GlobalContacts globalTrieContacts = new GlobalContacts();

    public boolean addGlobalSpam(String mobileNo){

        return TRUE;
    }

}
