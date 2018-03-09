package com.contact.solstice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.contact.solstice.model.Contact;

/**
 * Created by srujangopu on 8/11/17.
 */
@Repository
public interface ContactDAO extends MongoRepository<Contact, String> {

}
