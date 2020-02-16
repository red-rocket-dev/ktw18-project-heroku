package pl.sda.project.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
    @GetMapping("/xyz")
    public ModelAndView test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return new ModelAndView("loggedInPage",
                "currentUser",
                currentPrincipalName);
    }

    @GetMapping("/abc")
    public String testAbc() {
        return "loggedInPage";
    }
}
