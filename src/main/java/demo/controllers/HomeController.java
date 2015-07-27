package demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Charlie on 7/26/2015.
 */
@Controller
public class HomeController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//    public String greeting() {
        model.addAttribute("name", name);
        return "greeting.html";
    }

}
