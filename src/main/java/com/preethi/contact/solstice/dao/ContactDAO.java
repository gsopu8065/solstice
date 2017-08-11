package com.preethi.contact.solstice.dao;

import com.preethi.contact.solstice.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by srujangopu on 8/11/17.
 */
@Repository
public interface ContactDAO extends MongoRepository<Contact, String> {

}
