package com.example.truecaller.model;

import com.example.truecaller.exception.BadRequest;
import com.example.truecaller.exception.WrongConfigurationException;
import com.example.truecaller.util.UserCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

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
    private Set<Contact> contactList;
    private String HashedPassword;
    private PersonalInfo personalInfo;
    private BusinessInfo businessInfo;

    public abstract void register(String customerName, String MobileNo);

    public abstract void addPersonalInfo(PersonalInfo personalInfo);

    public abstract void addBusinessInfo(BusinessInfo businessInfo);

    public abstract boolean addContact(Contact contacts);

    public abstract boolean removeContact(Contact contacts);

    public abstract boolean addBlockList(String mobileNo);

    public abstract boolean removeBlocklist(String mobileNo);

    public abstract boolean canCall(String mobileNo);

    public abstract boolean addGlobalSpam(String mobileNo);

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
