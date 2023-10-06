package ifrn.pi.eventos.Controllers;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ifrn.pi.eventos.Models.Convidados;
import ifrn.pi.eventos.repositories.ConvidadoRepository;
import ifrn.pi.eventos.repositories.EvetRepository;

@Controller
@RequestMapping("/Events")
public class covidadoController {
    @Autowired
    private EvetRepository er;
    
    @Autowired
    private ConvidadoRepository cr;

    @GetMapping("/{id}/deleteCovidado")
    public String apagarCovidado(@PathVariable long id){
        Optional<Convidados> opt = cr.findById(id);

        if(!opt.isEmpty()){
            Convidados convidados = opt.get();
            cr.delete(convidados);
           
        }
        return "redirect:/Events";
    }
    
}
