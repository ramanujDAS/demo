package com.example.truecaller;

import com.example.truecaller.exception.BadRequest;
import com.example.truecaller.exception.WrongConfigurationException;
import com.example.truecaller.model.BusinessInfo;
import com.example.truecaller.model.Contact;
import com.example.truecaller.model.Customer;
import com.example.truecaller.model.User;
import com.example.truecaller.repo.GlobalSpamList;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TrueCaller {


    GlobalSpamList spamList;

    public  void startApplication() throws WrongConfigurationException, BadRequest, ParseException {


        /** Users should be able to register **/
        System.out.println("1.Users should be able to register");

        User user1 = new Customer("Ramanuj Singh", "9831635312");
        user1.register();
        /** user adding business **/
        BusinessInfo businessInfo = new BusinessInfo();
        businessInfo.setBusinessName("software");
        businessInfo.setBusinessContact("9831633512");
        user1.setBusinessInfo(businessInfo);
        /** add contacts by user**/
        Contact contact1 = new Contact();
        contact1.setName("Shatabdi");
        contact1.setPhone("8274909956");
        contact1.setEmail("shatabdi@gmail..com");
        user1.addContact(contact1);
        Contact contact2 = new Contact();
        contact2.setPhone("8274909965");
        contact2.setName("Sunny");
        user1.addContact(contact2);
        /**import contacts**/
        List<Contact> contactList = new ArrayList<>();
        user1.importContacts(contactList);

        /** block contacts for user**/
        user1.addBlockList("9572912072");
        /**report spam to global list**/
        spamList=GlobalSpamList.getInstance();
        spamList.add("9572912072");
        /**unblock**/
        System.out.println(("phone  unblocked {}"+ user1.removeBlocklist("8274909956")));
        /**Users should be notified when suspected junk caller calls**/
        /**Users should be able to identify caller when call comes**/
        /** Users should be able to upgrade to premium plans**/
        user1.upgradeUser();
        System.out.println(user1);
        user1.upgradeUser();
        System.out.println(user1);

        /**Users should be able to search for contacts by mobile **/
        Contact contactFind = new Contact();
        contactFind.setPhone("8274909956");
        for (Contact contact : user1.getContactList()) {
            if (contact.equals(contactFind)) {
                System.out.println("contact found by mobile"+ contact.toString());
                break;
            }
        }
        /**Users should be able to search for contacts by name **/
        Contact contactFind1 = new Contact();
        contactFind1.setName("Shatabdi");
        for (Contact contact : user1.getContactList()) {
            if (contact.equals(contactFind1)) {
                System.out.println("contact found by name "+contact.toString());
                break;
            }
        }
        /**Users should be able to search from global directory*/

    }
}
