package pl.sda.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class MyController {
    @GetMapping
    public String test() {
        return "somepage";
    }

    @GetMapping("/other")
    public ModelAndView other() {
        Map<String, String> model = new HashMap<>();
        model.put("test", "Jav1a!");
        return new ModelAndView("someotherpage", model);
    }

    @GetMapping("/path-params/{input}")
    public ModelAndView paramsTest(@PathVariable("input") String input) {
        Map<String, String> model = new HashMap<>();
        model.put("test", input);
        return new ModelAndView("someotherpage", model);
    }

    @GetMapping("/request-params")
    public ModelAndView requestParamsTest(@RequestParam("klucz") String input) {
        Map<String, String> model = new HashMap<>();
        model.put("test", input);
        return new ModelAndView("someotherpage", model);
    }


}
