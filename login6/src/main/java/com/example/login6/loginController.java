package com.example.login6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class loginController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/test")
    public String test(){
        return "working";
    }

    @RequestMapping("/sign")
    public String signUp(){

        return "<form action=\"/login\">\n" +
                "  <label for=\"fname\">First name:</label><br>\n" +
                "  <input type=\"text\" id=\"fname\" name=\"fname\" value=\"\"><br>\n" +
                "  <label for=\"lname\">Last name:</label><br>\n" +
                "  <input type=\"text\" id=\"lname\" name=\"lname\" value=\"\"><br><br>\n" +
                "  <label for=\"Username\">UserName:</label><br>\n" +
                "  <input type=\"text\" id=\"uname\" name=\"uname\" value=\"\"><br><br>\n" +
                "  <label for=\"password\">Password:</label><br>\n" +
                "  <input type=\"password\" id=\"password\" name=\"password\" value=\"\"><br><br>\n" +
                "  <label for=\"password\"> Confirm Password:</label><br>\n" +
                "  <input type=\"password\" id=\"cpassword\" name=\"cpassword\" value=\"\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> \n";
    }



    @RequestMapping(value="/login",method = RequestMethod.GET )
    public String logIn(@RequestParam String uname,@RequestParam String password ,@RequestParam String fname,@RequestParam String lname){
        save(uname,password,fname,lname);
        return "\n" +
                "<form action=\"/submitted\">\n" +
                "  <label for=\"fname\">UserName:</label><br>\n" +
                "  <input type=\"text\" id=\"Username\" name=\"Username\" value=\"\"><br><br>\n" +
                "  <label for=\"lname\">Password:</label><br>\n" +
                "  <input type=\"password\" id=\"Password\" name=\"Password\" value=\"\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Login\">\n" +
                "</form> ";
    }
    private void save(String un,String pas,String firNam,String lasNam) {
        User user = new User();
        user.setUserName(un);
        user.setPassword(pas);
        user.setFirstName(firNam);
        user.setLastName(lasNam);

        User savedUser = repo.save(user);
    }

    @RequestMapping(value="/submitted",method = RequestMethod.GET )
    public String final1(@RequestParam String Username , @RequestParam String Password){

        return "FORM SUBMITTED " +" Thanks "+ Username + "Your Password is :" + Password;
    }


}
