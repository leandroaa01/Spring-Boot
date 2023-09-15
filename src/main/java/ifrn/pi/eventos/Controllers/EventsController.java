package ifrn.pi.eventos.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventsController {

    

    @RequestMapping("/Events/form")
    public String form() {
        return "formEvent";
    }

    @PostMapping("/Events/processarFormulario")
    public String processarFormulario(
             String nome,
             String local,
             String data,
             String horario) {
        
        System.out.println("Nome: " + nome);
        System.out.println("Local: " + local);
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horario);

        // Redirecione para uma página de confirmação
        return "confirmacao";
    }

    
}