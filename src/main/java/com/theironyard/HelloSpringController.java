package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by benjamindrake on 11/9/15.
 */
@Controller
public class HelloSpringController {
    @RequestMapping("/person")
    public String person(
            Model model,
            @RequestParam(defaultValue = "Bob") String name,
            @RequestParam(defaultValue = "Charleston") String city,
            @RequestParam(defaultValue = "30") Integer age)
    {
        Person p = new Person(name, city, age);
        model.addAttribute("person", p);
        return "person";
    }

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String username =(String) session.getAttribute("username");
        model.addAttribute("username", username);
        return "home";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username) {
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        return "redirect:/";
    }


}
