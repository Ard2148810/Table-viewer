package pki.sqlTables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pki.sqlTables.content.tables.TableDataEntity;
import pki.sqlTables.content.tables.TableDataService;

import java.util.List;

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
