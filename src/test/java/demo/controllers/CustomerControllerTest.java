package demo.controllers;

import demo.Customer;
import demo.DemoApplication;
import demo.repositories.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.*;

/**
 * Created by Charlie on 7/23/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration    //Integration - fire up tomcat
@Transactional
public class CustomerControllerTest {

    @Autowired
    CustomerController controller;

    @Test
    public void controllerNotNull() {
        Assert.assertNotNull(controller);
    }


    @Test
    public void testAddCustomer() {
        String result = controller.AddCustomer("hello", "there");
        isTrue(result.equals("saved"));
    }

   /* @Test
    public void integrationTestAddCustomer() throws Exception {
        mockMvc.perform(get("/add?firstname=calvin&lastname=fernandes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("firstName", is("calvin")))
        ;
    }*/
}
