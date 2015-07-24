package demo.controllers;

import demo.Customer;
import demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Charlie on 7/18/2015.
 */
@RestController
public class CharlieController {

    CustomerRepository custRepo;

    @Autowired
    public CharlieController(CustomerRepository customerRepository) {
        custRepo = customerRepository;
    }

    @RequestMapping(value = "/", produces="application/json")
//    Iterable<Customer> home(){
    String home() {
        List<Customer> customers = custRepo.findAll();
        return customers.toString();
//        return customers;
    }

    @RequestMapping(value = "/charlie", params = {"firstname", "lastname"}, method = RequestMethod.GET)
    String AddCustomer(String firstname, String lastname) {
        custRepo.save(new Customer(firstname, lastname));
        return "saved";
    }

    @RequestMapping(value = "/getText", params = {"text"}, method = RequestMethod.GET)
    String getText(String text) {
        return text;
    }
}
