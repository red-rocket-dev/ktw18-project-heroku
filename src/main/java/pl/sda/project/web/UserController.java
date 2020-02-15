package pl.sda.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.project.entity.UserEntity;
import pl.sda.project.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String postSaveProduct(@ModelAttribute UserEntity userEntity) {
        userService.save(userEntity);
        return "redirect:/xyz";
    }

    @GetMapping("/save")
    public ModelAndView getSaveProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userRegister");
        modelAndView.getModel().put("user", new UserEntity());
        return modelAndView;
    }
}
