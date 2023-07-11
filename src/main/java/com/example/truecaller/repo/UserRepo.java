package com.example.truecaller.repo;

import com.example.truecaller.model.User;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class UserRepo {

    private Map<String, User> userList;

    public UserRepo() {
        userList = new HashMap<>();
    }

    public void register(User user) {
        userList.put(user.getMobileNo(), user);

    }

    public void remove(User user) {
        userList.remove(user.getMobileNo());
    }
}
