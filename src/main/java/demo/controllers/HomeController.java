package demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Charlie on 7/26/2015.
 */
@Controller
public class HomeController {

    @RequestMapping("/echo")
//    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    public ModelAndView getText() {
//        model.addAttribute("name", name);
//        return "getText.html";
        ModelAndView modelAndView = new ModelAndView("getText");
        return modelAndView;
    }

}
