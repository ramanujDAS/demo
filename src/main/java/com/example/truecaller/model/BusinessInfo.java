package com.example.truecaller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class BusinessInfo {
    private String businessName;
    private String businessDesc;
    private String businessContact;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessDesc() {
        return businessDesc;
    }

    public void setBusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc;
    }

    public String getBusinessContact() {
        return businessContact;
    }

    public void setBusinessContact(String businessContact) {
        this.businessContact = businessContact;
    }

    @Override
    public String toString() {
        return "BusinessInfo{" +
                "businessName='" + businessName + '\'' +
                ", businessDesc='" + businessDesc + '\'' +
                ", businessContact='" + businessContact + '\'' +
                '}';
    }
}
