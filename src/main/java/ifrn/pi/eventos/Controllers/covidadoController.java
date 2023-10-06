package ifrn.pi.eventos.Controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.eventos.Models.Convidados;
import ifrn.pi.eventos.Models.Events;
import ifrn.pi.eventos.repositories.ConvidadoRepository;
import ifrn.pi.eventos.repositories.EvetRepository;

@Controller
@RequestMapping("/Events")
public class covidadoController {
    @Autowired
    private EvetRepository er;
    @Autowired
    private ConvidadoRepository cr;

    @GetMapping("/{id}/deleteConvidado")
    public String apagarCovidado(@PathVariable long id) {
        Optional<Convidados> opt = cr.findById(id);
        if (!opt.isEmpty()) {
            Convidados convidados = opt.get();
            long idEvento = convidados.getEvents().getId(); // Obtém o ID do evento associado ao convidado
            cr.delete(convidados);
            // Redireciona de volta para a página de detalhes do evento
            return "redirect:/Events/" + idEvento;
        }
        return "redirect:/Events";
    }
    @GetMapping("/{idEvent}/Convidado/{idConvidado}/Edit")
    public ModelAndView editCovidado(@PathVariable long idEvent, @PathVariable Long idConvidado) {
       ModelAndView md = new ModelAndView();
       Optional<Convidados> optConvidado = cr.findById(idConvidado);
       Optional<Events> optEvent = er.findById(idEvent);
       if(optConvidado.isEmpty() || optEvent.isEmpty()){
        md.setViewName("redirect:/Events");
        return md;
       }
       Events events = optEvent.get();
       Convidados convidados = optConvidado.get();
       if (events.getId() != convidados.getEvents().getId()) {
         md.setViewName("redirect:/Events");
        return md;
       }
       md.setViewName("Events/detalhes");
       md.addObject("Convidado", convidados);
       md.addObject("Events", events);
       md.addObject("Convidados",cr.findByEvents(events));
       return md;
    }
    
}
