package com.preethi.contact.solstice.service;

import com.preethi.contact.solstice.dao.ContactDAO;
import com.preethi.contact.solstice.model.Contact;
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
}
