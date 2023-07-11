package com.example.truecaller.repo;

import com.example.truecaller.model.Contact;
import jakarta.inject.Singleton;
import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Boolean.FALSE;

@Singleton
public class TrieContacts {

    private Map<String, Contact> gloabContacts;
    private Map<String, String> globalContactWithMobile;

    public TrieContacts() {
        gloabContacts = new HashMap<>();
        globalContactWithMobile= new HashMap<>();
    }

    public Contact getContactByName(String name) {
        return gloabContacts.get(name);
    }

    public Contact getContactByMobile(String mobile) {
        return gloabContacts.get(globalContactWithMobile.get(mobile));
    }

    public void addContact(Contact contact) {
        gloabContacts.put(contact.getName(), contact);
        globalContactWithMobile.put(contact.getPhone(), contact.getName());
    }

    public boolean deleteContact(Contact contact) {
        gloabContacts.remove(contact.getName());
        globalContactWithMobile.remove(contact.getPhone());
        return FALSE;
    }

    public int getSize() {
        return gloabContacts.size();
    }
}
