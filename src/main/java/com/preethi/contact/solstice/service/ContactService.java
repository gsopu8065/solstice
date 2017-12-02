package com.preethi.contact.solstice.service;

import com.preethi.contact.solstice.dao.ContactDAO;
import com.preethi.contact.solstice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Method;

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
    public Phone[] getContactPhone(String id){
        Contact contact = contactDAO.findOne(id);
        if(contact != null)
        {
            return contact.getPhone();
        }
        else {
            return new Contact().getPhone();
        }
    }

    public void setContactPhone(String id, Phone[] phone){
        Contact contact = contactDAO.findOne(id);
        if(contact != null) {
            contact.setPhone(phone);
            contactDAO.save(contact);
        }
    }

    public Address[] getContactAddress(String id){
        Contact contact = contactDAO.findOne(id);
        if(contact != null)
        {
            return contact.getAddress();
        }
        else {
            return new Contact().getAddress();
        }
    }

    public void setContactAddress(String id, Address[] address){
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

    public Contact createOrUpdateGenericContact(GenericTable contact){

        //String parameter
        Class[] paramString = new Class[1];
        paramString[0] = String.class;

        try {
            Class cls = Class.forName("com.preethi.contact.solstice.model.Contact");
            Object contact1 = cls.newInstance();

            for (GenericColumn contactColums : contact.getColumns()) {
                Method method = cls.getDeclaredMethod("set"+contactColums.getColumnName(), paramString);
                method.invoke(contact1, contactColums.getColumnValue());
            }

            return contactDAO.save(Contact.class.cast(contact1));
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
