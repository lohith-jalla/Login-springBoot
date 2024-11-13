package com.security.login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {

    private final Services s;

    public controller(Services s) {
        this.s=s;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(ModelMap map , @RequestParam String email ,@RequestParam String password){
        boolean isUser = s.isUser(email , password);
        if(!isUser){
            map.put("error", "Invalid email or password");
            return "login";
        }
        map.put("email", email);
        map.put("password", password);
        return "welcome";
    }

    @GetMapping("/signup")
    public String Signup(ModelMap map){
        return "signup";
    }

    @PostMapping("/signup")
    public String PostSignUp(ModelMap map , @RequestParam String email ,@RequestParam String password){
     s.createUser(email,password);
     return "redirect:/login";
    }
}
