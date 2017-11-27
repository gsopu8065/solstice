package com.preethi.contact.solstice.controller;

import com.preethi.contact.solstice.model.Address;
import com.preethi.contact.solstice.model.Contact;
import com.preethi.contact.solstice.model.License;
import com.preethi.contact.solstice.model.Phone;
import com.preethi.contact.solstice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by srujangopu on 8/11/17.
 */
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    private final String AuthKey = "authentication";

    @RequestMapping(value = "/solstice/createContact", method = RequestMethod.POST)
    public Contact createContact(@RequestBody Contact contact, @RequestHeader(value= AuthKey) String authentication){
        return contactService.createOrUpdateContact(contact);
    }

    @RequestMapping(value = "/solstice/contact/{contactId}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable String contactId,  @RequestHeader(value= AuthKey) String authentication){
        return contactService.getContact(contactId);
    }

    @RequestMapping(value = "/solstice/updateContact", method = RequestMethod.POST)
    public Contact updateContact(@RequestBody Contact contact,  @RequestHeader(value= AuthKey) String authentication){
        return contactService.createOrUpdateContact(contact);
    }

    @RequestMapping(value = "/solstice/deleteContact/{contactId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteContact(@PathVariable String contactId,  @RequestHeader(value= AuthKey) String authentication){
        contactService.deleteContact(contactId);
        return ResponseEntity.status(200).build();
    }


    @RequestMapping(value = "/solstice/license/{contactId}", method = RequestMethod.GET)
    public License getLicense(@PathVariable String contactId, @RequestHeader(value= AuthKey) String authentication){
        return contactService.getContactLicense(contactId);
    }

    @RequestMapping(value = "/solstice/updateLicense/{contactId}", method = RequestMethod.POST)
    public Contact addLicense(@PathVariable String contactId, @RequestBody License license,  @RequestHeader(value= AuthKey) String authentication){
        return contactService.addLicense(contactId, license);
    }

    @RequestMapping(value = "/solstice/phone/{contactId}", method = RequestMethod.GET)
    public Phone getPhone(@PathVariable String contactId, @RequestHeader(value= AuthKey) String authentication){
        return contactService.getContactPhone(contactId);
    }

    @RequestMapping(value = "/solstice/updatePhone/{contactId}", method = RequestMethod.POST)
    public ResponseEntity<?> updateContact(@PathVariable String contactId, @RequestBody Phone phone,  @RequestHeader(value= AuthKey) String authentication){
        contactService.setContactPhone(contactId, phone);
        return ResponseEntity.status(200).build();
    }

    @RequestMapping(value = "/solstice/address/{contactId}", method = RequestMethod.GET)
    public Address getAddress(@PathVariable String contactId, @RequestHeader(value= AuthKey) String authentication){
        return contactService.getContactAddress(contactId);
    }

    @RequestMapping(value = "/solstice/updateAddress/{contactId}", method = RequestMethod.POST)
    public ResponseEntity<?> updateAddress(@PathVariable String contactId, @RequestBody Address address,  @RequestHeader(value= AuthKey) String authentication){
        contactService.setContactAddress(contactId, address);
        return ResponseEntity.status(200).build();
    }


    @RequestMapping(value = "/checkServer", method = RequestMethod.GET)
    public String sample(@RequestHeader(value= AuthKey) String authentication){
        return "HelloWorld";
    }


}
