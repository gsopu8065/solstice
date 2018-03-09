package com.contact.solstice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.solstice.dao.ContactDAO;
import com.contact.solstice.model.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sivaram Polamraju on 03/09/18.
 */
@Service
public class ContactService {

    @Autowired
    private ContactDAO contactDAO;

    public Contact createOrUpdateContact(Contact contact){
        return contactDAO.save(contact);
    }

    public void deleteContact(String id){
        contactDAO.delete(id);
    }

    public Contact getContact(String id){
        return contactDAO.findOne(id);
    }
    
    public Contact getContactByMobileNumber(String mobileNumber){
        String id = null;
        List<Contact> contact  =  (List<Contact>) contactDAO.findAll();
        if(contact != null)
        {
        	for(int i=0;i<contact.size();i++){
             if(contact.get(i).getPhone().getMobile().equalsIgnoreCase(mobileNumber)){
            	 id =contact.get(i).getId();
            	 return contactDAO.findOne(id);
             }
        	}
        }
        return new Contact();
    }
    
    public List<Contact> getAllContactsFromSameCity(String city){
        String id = null;
        List<Contact> allcontacts = new ArrayList<Contact>();
        List<Contact> contact  =  (List<Contact>) contactDAO.findAll();
        if(contact != null)
        {
        	for(int i=0;i<contact.size();i++){
             if(contact.get(i).getAddress().getCity().equalsIgnoreCase(city)){
            	 id =contact.get(i).getId();
            	 allcontacts.add(contactDAO.findOne(id));           	 
             }
             
        	}
        	return allcontacts;
        }
        return allcontacts;
    }

}
