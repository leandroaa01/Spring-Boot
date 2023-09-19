package ifrn.pi.eventos.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.eventos.Models.Events;
import ifrn.pi.eventos.repositories.EvetRepository;

@Controller
@RequestMapping("/Events")
public class EventsController {
    @Autowired
    private EvetRepository er;

    @GetMapping("/form")
    public String form() {
        return "Events/formEvent";
    }

    @PostMapping
    public String processarFormulario(Events eventos){
        System.out.println(eventos);
        er.save(eventos);

        // Redirecione para uma página de confirmação
        return "Events/confirmacao";
    }

    @GetMapping
    public ModelAndView listar () {
      List<Events> events = er.findAll();
      ModelAndView mv = new ModelAndView("Events/lista");
      mv.addObject("Events", events);
     return mv;
    }
    
}