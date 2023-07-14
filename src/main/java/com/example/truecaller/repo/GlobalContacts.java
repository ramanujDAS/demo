package com.example.truecaller.repo;

import com.example.truecaller.model.Contact;
import jakarta.inject.Singleton;
import orestes.bloomfilter.BloomFilter;
import orestes.bloomfilter.FilterBuilder;
import orestes.bloomfilter.cachesketch.ExpiringBloomFilterMemory;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.FALSE;

@Singleton
public class GlobalContacts {

    private Map<String, Contact> gloabContacts;
    private Map<String, String> globalContactWithMobile;

    private BloomFilter<String>  bloomFilter;
    public GlobalContacts() {
        gloabContacts = new HashMap<>();
        globalContactWithMobile= new HashMap<>();
        bloomFilter= new FilterBuilder(1000000,.01).buildCountingBloomFilter();
    }

    public Contact getContactByName(String name) {
        System.out.println("bloomFilter  ::"+name+" "+bloomFilter.contains(name));
        return gloabContacts.get(name);
    }

    public Contact getContactByMobile(String mobile) {
        System.out.println("bloomFilter  ::"+mobile+" "+bloomFilter.contains(mobile));
        return gloabContacts.get(globalContactWithMobile.get(mobile));
    }

    public void addContact(Contact contact) {
        bloomFilter.add(contact.getPhone());
        bloomFilter.add(contact.getName());
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
