package demo.controllers;

import demo.Customer;
import demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.net.URI;
import java.net.URISyntaxException;
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
        return "index.html";
//        return customers;
    }

    @Transactional
    @RequestMapping(value = "/add", params = {"firstname", "lastname"}, method = RequestMethod.GET)
    String AddCustomer(String firstname, String lastname) {
        custRepo.save(new Customer(firstname, lastname));
        return "saved";
    }

//    @RequestMapping(value = "/getText", params = {"text"}, method = RequestMethod.GET)
//    public String getText(String text) {
//        return text;
//    }

    @RequestMapping(value= "/getText",method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<String> addUser(@ModelAttribute(value="inputText") String inputText, BindingResult result ){
        ResponseEntity response = new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
        if(!result.hasErrors()) {
            response = response.accepted().headers(new HttpHeaders()).body("{\"statusText\": \"" + inputText + "\"}");
//            response = new ResponseEntity<>("{\"statusText\": \"" + inputText + "\"}", new HttpHeaders(), HttpStatus.OK);
//        response.body("blah");
        }else{
            response = response.badRequest().headers(new HttpHeaders()).body(null);
        }
        return response;
    }
}
