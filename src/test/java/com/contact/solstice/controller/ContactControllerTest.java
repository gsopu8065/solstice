package com.contact.solstice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.contact.solstice.model.Contact;
import com.contact.solstice.service.ContactService;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
public class ContactControllerTest {
	@Autowired
    private MockMvc mvc;
	@MockBean
    private ContactService service;
     
     @Test
	 public void getContactByNumberTest() throws Exception{
    	 Contact expectedContact = getContact();
    	 Mockito.when(
    			 service.getContactByMobileNumber(Mockito.anyString()
 						)).thenReturn(expectedContact);
    	 RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
 				"/solstice/getContactByMobileNumber/8644978262").accept(
 				MediaType.APPLICATION_JSON);

 		 mvc.perform(requestBuilder).
 				andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedContact.getName()));

      }
     
    public Contact getContact(){
    	Contact contact = new Contact();
    	contact.setName("Sivaram Polamraju");
    	return contact;
    }
     
}
