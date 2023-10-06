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
import ifrn.pi.eventos.Models.Convidados;
import ifrn.pi.eventos.Models.Events;
import ifrn.pi.eventos.repositories.ConvidadoRepository;
import ifrn.pi.eventos.repositories.EvetRepository;

@Controller
@RequestMapping("/Events")
public class EventsController {
    @Autowired
    private EvetRepository er;
    
    @Autowired
    private ConvidadoRepository cr;

    @GetMapping("/form")
    public String form() {
        return "Events/formEvent";
    }

    @PostMapping
    public String processarFormulario(Events eventos){
        System.out.println(eventos);
        er.save(eventos);
        return "redirect:/Events";
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
     List<Convidados> convidados = cr.findByEvents(events);
     md.addObject("Convidados", convidados);
     return md;
    }
    
    @PostMapping("/{idEvent}")
    public String salvarConvidado(@PathVariable Long idEvent, Convidados convidados){
        System.out.println("Id do Evento:" + idEvent);
        System.out.println(convidados);
        Optional<Events> opt = er.findById(idEvent);
        if (opt.isEmpty()) {
            return "redirect:/Events";
        }

        Events events = opt.get();
        convidados.setEvents(events);
        cr.save(convidados);
        
        return "redirect:/Events/{idEvent}";
        
    }
    @GetMapping("/{id}/delete")
    public String apagarEvent(@PathVariable long id){
        Optional<Events> opt = er.findById(id);
        if(!opt.isEmpty()){
            Events events = opt.get();
            List<Convidados> convidados = cr.findByEvents(events);
            cr.deleteAll(convidados);
            er.delete(events);
        }
        return "redirect:/Events/{id}";
    }
}