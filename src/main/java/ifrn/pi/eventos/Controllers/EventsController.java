package ifrn.pi.eventos.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventsController {
    @RequestMapping("/Events/form")
    public String form() {
        return "formEvent";
    }
}
