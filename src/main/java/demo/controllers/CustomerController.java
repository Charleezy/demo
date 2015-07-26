package demo.controllers;

import demo.Customer;
import demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Charlie on 7/18/2015.
 */
@RestController
public class CustomerController {

    CustomerRepository custRepo;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        custRepo = customerRepository;
    }

    @RequestMapping(value = "/", method=RequestMethod.GET)
//    Iterable<Customer> home(){
    String home() {
//        List<Customer> customers = custRepo.findAll();
//        return customers.toString();
        return "forward:/index.html";
//        return customers;
    }

    @Transactional
    @RequestMapping(value = "/add", params = {"firstname", "lastname"}, method = RequestMethod.GET)
    String AddCustomer(String firstname, String lastname) {
        custRepo.save(new Customer(firstname, lastname));
        return "saved";
    }

    @RequestMapping(value = "/getText", params = {"text"}, method = RequestMethod.GET)
    public String getText(String text) {
        return text;
    }
}
