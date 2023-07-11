package com.example.truecaller;


import com.example.truecaller.repo.TrieContacts;
import jakarta.inject.Singleton;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Boolean.TRUE;


@Singleton
@Getter
public class GlobalRepo {
    private Set<String> globalSpamList = new HashSet<>();
    private TrieContacts globalTrieContacts = new TrieContacts();

    public boolean addGlobalSpam(String mobileNo){

        return TRUE;
    }

}
