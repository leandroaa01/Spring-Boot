package ifrn.pi.eventos.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventsController {
    @RequestMapping("/Events/form")
    public String form(){
        return "formEvent";
    }

    @RequestMapping("/Events/processarFormulario")
    public String processarFormulario(
            @RequestParam("Nome") String nome,
            @RequestParam("local") String local,
            @RequestParam("data") String data,
            @RequestParam("time") String horario) {
        
        System.out.println("Nome: " + nome);
        System.out.println("Local: " + local);
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horario);

        // Redirecione para uma página de confirmação
        return "confirmacao";
    }
}