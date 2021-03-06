package calculator.safari;

import calculator.models.Inputs;
import calculator.models.Result;
import calculator.safari.calc.Calc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SafariApplicationController {

    // To call this method go to http://localhost:8080/hello/{placeholder}
    @GetMapping("/hello/{your_name}")
    public String home(@PathVariable("your_name") String name, Model model) {
        model.addAttribute("name", name);
        return "index.html";
    }

    // To call this method go to http://localhost:8080/calculate
    @GetMapping("/calculate")
    public String calculate(Model model){
        model.addAttribute("inputs", new Inputs());
        return "calc.html";
    }

    // This method is called after press button in /calculate web-page
    @PostMapping("/calculate")
    public String calculateSubmit(@ModelAttribute Inputs input, Model model){
        Result res = new Result(new Calc().execute(input));

        model.addAttribute("result", res);
        return "result.html";
    }

}
