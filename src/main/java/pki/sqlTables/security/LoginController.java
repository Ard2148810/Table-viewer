package pki.sqlTables.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    @CrossOrigin
    public String getLoginPage() {
        return  "forward:/";
    }

}
