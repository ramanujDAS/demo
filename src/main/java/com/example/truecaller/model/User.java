package com.example.truecaller.model;

import com.example.truecaller.exception.BadRequest;
import com.example.truecaller.exception.WrongConfigurationException;
import com.example.truecaller.repo.UserRepo;
import com.example.truecaller.util.UserCategory;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.*;

import static java.lang.Boolean.TRUE;

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
    private List<Contact> contactList;
    private String HashedPassword;
    private PersonalInfo personalInfo;
    private BusinessInfo businessInfo;
    @Inject
    UserRepo userRepo;

    public User(String customerName, String mobileNo) {
        this.userName = customerName;
        this.mobileNo = mobileNo;
        contactList = new ArrayList<>();
        blockList = new HashSet<>();
        setUserCategory(UserCategory.NORMAL);
    }

    public void register() {
        setId(UUID.randomUUID().toString());
        setUserName(userName);
        setMobileNo(mobileNo);
        userRepo.register(this);
    }

    public abstract void addPersonalInfo(PersonalInfo personalInfo);

    public abstract void addBusinessInfo(BusinessInfo businessInfo);

    public  boolean addContact(Contact contacts){
        return contactList.add(contacts);
    }

    public  boolean removeContact(Contact contacts){
       return contactList.remove(contacts);

    }

    public abstract boolean addBlockList(String mobileNo);

    public abstract boolean removeBlocklist(String mobileNo);

    public abstract boolean canCall(String mobileNo);
    public boolean upgradeUser() throws BadRequest, WrongConfigurationException {

        switch (this.userCategory) {
            case HIGHER:
                throw new BadRequest("user is already at HIGHER Category");
            case MEDIUM:
                setUserCategory(UserCategory.HIGHER);
                break;
            case NORMAL:
                setUserCategory(UserCategory.MEDIUM);
                break;
            default:
                throw new WrongConfigurationException("invalid user category upgrade");
        }
        return TRUE;
    }

    public boolean importContacts(List<Contact> contacts) throws WrongConfigurationException {
        checkLimit(contactList.size());
        contactList.addAll(contacts);
        return TRUE;
    }

    private boolean checkLimit(int currentSize) throws WrongConfigurationException {
        if (this.userCategory.equals(UserCategory.NORMAL)) {
            if (currentSize <= userCategory.getLimit()) {
                return TRUE;
            }
            return Boolean.FALSE;
        } else if (this.userCategory.equals(UserCategory.MEDIUM)) {
            if (currentSize <= userCategory.getLimit()) {
                return TRUE;
            }
            return Boolean.FALSE;
        } else if (this.userCategory.equals(UserCategory.HIGHER)) {
            if (currentSize <= userCategory.getLimit()) {
                return TRUE;
            }
            return Boolean.FALSE;
        } else {
            throw new WrongConfigurationException("invalid user category");
        }
    }
}
