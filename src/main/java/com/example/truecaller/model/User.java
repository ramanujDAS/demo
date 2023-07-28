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

    private UserRepo userRepo;

    public User(String customerName, String mobileNo) {
        this.userName = customerName;
        this.mobileNo = mobileNo;
        contactList = new ArrayList<>();
        blockList = new HashSet<>();
        userRepo= new UserRepo();
        this.userCategory=UserCategory.NORMAL;
    }

    public void register() {
        this.id=(UUID.randomUUID().toString());
        this.userName=(userName);
        this.mobileNo=(mobileNo);
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
                this.userCategory=(UserCategory.HIGHER);
                break;
            case NORMAL:
                this.userCategory=(UserCategory.MEDIUM);
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
            if(currentSize <= userCategory.getLimit()) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public UserCategory getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }

    public Set<String> getBlockList() {
        return blockList;
    }

    public void setBlockList(Set<String> blockList) {
        this.blockList = blockList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public String getHashedPassword() {
        return HashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        HashedPassword = hashedPassword;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public BusinessInfo getBusinessInfo() {
        return businessInfo;
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void setBusinessInfo(BusinessInfo businessInfo) {
        this.businessInfo=businessInfo;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", userCategory=" + userCategory +
                ", blockList=" + blockList +
                ", contactList=" + contactList +
                ", HashedPassword='" + HashedPassword + '\'' +
                ", personalInfo=" + personalInfo +
                ", businessInfo=" + businessInfo +
                ", userRepo=" + userRepo +
                '}';
    }
}
