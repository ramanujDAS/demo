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

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TrueCaller {

    @Inject
    GlobalSpamList spamList;
    public void startApplication() throws WrongConfigurationException, BadRequest {
     /** Users should be able to register **/
        System.out.println("1.Users should be able to register");

       User user1= new Customer("Ramanuj Singh","9831635312");
       user1.register();
    /** user adding business **/
        BusinessInfo businessInfo= new BusinessInfo();
        businessInfo.setBusinessName("software");
        businessInfo.setBusinessContact("9831633512");
        user1.setBusinessInfo(businessInfo);
       /** add contacts by user**/

        user1.addContact(Contact.builder().name("Shatabdi").email("shatabdi@gmail..com").phone("8274909956").build());
        user1.addContact(Contact.builder().name("Sunny").phone("8274909965").build());
       /**import contacts**/
       List<Contact> contactList=new ArrayList<>();
       user1.importContacts(contactList);

       /** block contacts for user**/
       user1.addBlockList("9572912072");
       /**report spam to global list**/
       spamList.add("9572912072");
       /**unblock**/
       log.info("phone  unblocked {}",user1.removeBlocklist("8274909956"));
        /**Users should be notified when suspected junk caller calls**/
        /**Users should be able to identify caller when call comes**/
        /** Users should be able to upgrade to premium plans**/
        user1.upgradeUser();
        System.out.println(user1);
        user1.upgradeUser();
        System.out.println(user1);

        /**Users should be able to search for contacts by mobile **/
        Contact contactFind= Contact.builder().phone("8274909965").build();
        for(Contact contact: user1.getContactList())
        {
            if(contact.equals(contactFind))
            {
               log.info("contact found by mobile",contact.toString());break;
            }
        }
        /**Users should be able to search for contacts by name **/
        Contact contactFind1= Contact.builder().name("Shatabdi").build();
        for(Contact contact: user1.getContactList())
        {
            if(contact.equals(contactFind1))
            {
                log.info("contact found by name",contact.toString());break;
            }
        }
        /**Users should be able to search from global directory*/

    }
}
