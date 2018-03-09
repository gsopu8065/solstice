package com.contact.solstice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.contact.solstice.model.*;
import com.contact.solstice.service.ContactService;

/**
 * Created by Sivaram Polamraju on 03/09/18.
 */
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/solstice/createContact", method = RequestMethod.POST)
    public Contact createContact(@RequestBody Contact contact){
        return contactService.createOrUpdateContact(contact);
    }

    @RequestMapping(value = "/solstice/contact/{contactId}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable String contactId){
        return contactService.getContact(contactId);
    }

    @RequestMapping(value = "/solstice/updateContact", method = RequestMethod.POST)
    public Contact updateContact(@RequestBody Contact contact){
        return contactService.createOrUpdateContact(contact);
    }

    @RequestMapping(value = "/solstice/deleteContact/{contactId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteContact(@PathVariable String contactId){
        contactService.deleteContact(contactId);
        return ResponseEntity.status(200).build();
    }
    
    @RequestMapping(value = "/solstice/getContactByMobileNumber/{mobileNumber}", method = RequestMethod.GET)
    public Contact getContactByNumber(@PathVariable String mobileNumber){
        return contactService.getContactByMobileNumber(mobileNumber);
    }
    
    @RequestMapping(value = "/solstice/getAllContactsFromSameCity/{city}", method = RequestMethod.GET)
    public List<Contact> getAllContactsFromSameCity(@PathVariable String city){
        return contactService.getAllContactsFromSameCity(city);
    }

    @RequestMapping(value = "/checkServer", method = RequestMethod.GET)
    public String sample(){
        return "Hello Solstice";
    }


}
