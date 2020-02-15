package pl.sda.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SampleController {
    @GetMapping("/xyz")
    public String test() {
        return "loggedInPage";
    }

    @GetMapping("/abc")
    public String testAbc() {
        return "loggedInPage";
    }
}
