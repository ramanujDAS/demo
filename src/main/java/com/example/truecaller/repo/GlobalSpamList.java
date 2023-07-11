package com.example.truecaller.repo;

import jakarta.inject.Singleton;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Singleton
@Getter
public class GlobalSpamList {

    private Set<String> spamSet = new HashSet<>();

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
