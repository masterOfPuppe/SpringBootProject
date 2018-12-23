package com.example.safari;

import businnessLogic.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SafariApplicationController {

    @GetMapping("/hello/{your_name}")
    public String home(@PathVariable("your_name") String name, Model model) {
        model.addAttribute("name", name);
        return "index.html";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name",
            required = false,
            defaultValue = "Springboot") String name,
                           Model model){
        model.addAttribute("name", name);
        model.addAttribute("greeting", new Greeting());
        return "greeting.html";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting){
        return "result.html";
    }

}
