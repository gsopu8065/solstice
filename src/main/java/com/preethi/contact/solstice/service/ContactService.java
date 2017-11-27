package com.preethi.contact.solstice.service;

import com.preethi.contact.solstice.dao.ContactDAO;
import com.preethi.contact.solstice.model.Address;
import com.preethi.contact.solstice.model.Contact;
import com.preethi.contact.solstice.model.License;
import com.preethi.contact.solstice.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by srujangopu on 8/11/17.
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
    public Phone getContactPhone(String id){
        Contact contact = contactDAO.findOne(id);
        if(contact != null)
        {
            return contact.getPhone();
        }
        else {
            return new Contact().getPhone();
        }
    }

    public void setContactPhone(String id, Phone phone){
        Contact contact = contactDAO.findOne(id);
        if(contact != null) {
            contact.setPhone(phone);
            contactDAO.save(contact);
        }
    }

    public Address getContactAddress(String id){
        Contact contact = contactDAO.findOne(id);
        if(contact != null)
        {
            return contact.getAddress();
        }
        else {
            return new Contact().getAddress();
        }
    }

    public void setContactAddress(String id, Address address){
        Contact contact = contactDAO.findOne(id);
        if(contact != null) {
            contact.setAddress(address);
            contactDAO.save(contact);
        }
    }

    public Contact addLicense(String id, License license){

        Contact contact = contactDAO.findOne(id);
        contact.setLicense(license);
        contactDAO.save(contact);
        return contact;
    }

    public License getContactLicense(String id){
        Contact contact = contactDAO.findOne(id);
        if(contact != null)
        {
            return contact.getLicense();
        }
        else {
            return new Contact().getLicense();
        }
    }
}
