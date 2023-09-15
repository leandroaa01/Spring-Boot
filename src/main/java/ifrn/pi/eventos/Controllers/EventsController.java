package ifrn.pi.eventos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.pi.eventos.Models.Events;
import ifrn.pi.eventos.repositories.EvetRepository;

@Controller
public class EventsController {
    @Autowired
    private EvetRepository er;

    @RequestMapping("/Events/form")
    public String form() {
        return "formEvent";
    }

    @PostMapping("/Events/processarFormulario")
    public String processarFormulario(Events eventos){
        System.out.println(eventos);
        er.save(eventos);

        // Redirecione para uma página de confirmação
        return "confirmacao";
    }

    
}