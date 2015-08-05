package demo.controllers;

import demo.Customer;
import demo.Post;
import demo.repositories.CustomerRepository;
import demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Charlie on 7/30/2015.
 */
@RestController
public class PostController {
    PostRepository postRepo;

    @Autowired
    public PostController(PostRepository postRepository) {
        postRepo = postRepository;
    }

    @RequestMapping("/newPost")
//    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    public ModelAndView newPost() {
//        model.addAttribute("name", name);
//        return "getText.html";
        ModelAndView modelAndView = new ModelAndView("newPost");
        return modelAndView;
    }

    @Transactional
    @RequestMapping(value = "/savePost", method=RequestMethod.GET)
    //@RequestMapping(value = "/savePost", params = {"inputText=inputText", "userName=username"}, method = RequestMethod.GET)
    String AddCustomer(@RequestParam("inputText") String inputText,@RequestParam("userName") String userName) {
        postRepo.save(new Post(inputText, userName));
        return inputText;
    }

    //Assumed getting posts for a user does not mean we get children of the posts
    @RequestMapping(value = "/posts/index", method=RequestMethod.GET)
    List<Post> getPostsForUser(@RequestParam("userName") String userName){
        return postRepo.findByUserName(userName);
    }
}
