package com.example.truecaller.repo;

import jakarta.inject.Singleton;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;


public class GlobalSpamList {

    private Set<String> spamSet = new HashSet<>();
    private static GlobalSpamList spamList;

    public static synchronized GlobalSpamList getInstance() {
        if (spamList == null) {
            return new GlobalSpamList();
        }
        return spamList;
    }

    private GlobalSpamList() {
        spamSet = new HashSet<>();
    }

    public boolean isSpam(String mobile) {
        return spamSet.contains(mobile);
    }

    public int getSize() {
        return spamSet.size();
    }

    public void add(String mobile) {
        spamSet.add(mobile);
    }

    public boolean remove(String mobile) {
        return spamSet.remove(mobile);
    }
}
