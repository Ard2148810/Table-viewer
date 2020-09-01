package pki.sqlTables;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardingController {

    // Forward paths to index.html to let React Router handle paths

    @RequestMapping("/tables/{name}")
    public String forward(@PathVariable String name) {
        return  "forward:/";
    }
}
