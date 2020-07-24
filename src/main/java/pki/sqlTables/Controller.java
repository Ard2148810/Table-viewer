package pki.sqlTables;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/")
    public String index(@RequestParam(required = false) String name) {
        if(name == null || name.equals("")) {
            name = "World";
        }
        return "Hello, " + name + "!";
    }
}
