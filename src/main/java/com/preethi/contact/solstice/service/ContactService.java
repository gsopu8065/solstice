package com.preethi.contact.solstice.service;

import com.preethi.contact.solstice.dao.ContactDAO;
import com.preethi.contact.solstice.model.Contact;
import com.preethi.contact.solstice.model.License;
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

    public Contact addLicense(String id, License license){

        Contact contact = contactDAO.findOne(id);
        contact.setLicense(license);
        contactDAO.save(contact);
        return contact;
    }
}
