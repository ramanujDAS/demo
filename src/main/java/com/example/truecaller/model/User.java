package com.example.truecaller.model;

import com.example.truecaller.util.UserCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public abstract class User {
    @NotNull
    private String id;
    private String userName;
    private String mobileNo;

    private UserCategory userCategory;
    private Set<String> blockList;
    private Set<Contacts> contactList;
    private String HashedPassword;
    private PersonalInfo personalInfo;
    private BusinessInfo businessInfo;

    public abstract void register(String customerName, String MobileNo);

    public abstract void addPersonalInfo(PersonalInfo personalInfo);

    public abstract void addBusinessInfo(BusinessInfo businessInfo);

    public abstract boolean addContact(Contacts contacts);

    public abstract boolean removeContact(Contacts contacts);

    public abstract boolean addBlockList(String mobileNo);

    public abstract boolean removeBlocklist(String mobileNo);

    public abstract boolean canCall(String mobileNo);

    public abstract boolean addGlobalSpam(String mobileNo);

    public boolean upgradeUser() {
        return Boolean.FALSE;
    }

    public boolean importContacts(List<Contacts> contacts) {

        return Boolean.FALSE;
    }

    ;


}
