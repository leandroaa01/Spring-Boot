package ifrn.pi.eventos.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable() Long id){
        ModelAndView md = new ModelAndView();
        Optional<Events> opt = er.findById(id);
        if(opt.isEmpty()){
            md.setViewName("redirect:/Events");
            return md;
        }
     md.setViewName("Events/detalhes");
     Events events = opt.get();

     md.addObject("Events", events);
     return md;
    }
    
}