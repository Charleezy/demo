package demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Charlie on 7/18/2015.
 */
@Controller
public class CharlieController {
    @RequestMapping("/")
    String home() {
        //return "Hello World!";
        return "forward:/index.html";
        //return View("index.html");
    }
}
