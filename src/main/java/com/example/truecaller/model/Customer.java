package com.example.truecaller.model;

public class Customer extends  User{
    public Customer(String customerName, String mobileNo) {
        super(customerName, mobileNo);
    }
    @Override
    public void addPersonalInfo(PersonalInfo personalInfo) {
        setPersonalInfo(personalInfo);
    }

    @Override
    public void addBusinessInfo(BusinessInfo businessInfo) {
        setBusinessInfo(businessInfo);
    }

    @Override
    public boolean addBlockList(String mobileNo) {
       return getBlockList().add(mobileNo);
    }

    @Override
    public boolean removeBlocklist(String mobileNo) {
        return getBlockList().remove(mobileNo);
    }

    @Override
    public boolean canCall(String mobileNo) {
        return !getBlockList().contains(mobileNo);
    }

}
