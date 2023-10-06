package ifrn.pi.eventos.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.eventos.Models.Convidado;
import ifrn.pi.eventos.Models.Evento;


public interface ConvidadoRepository extends JpaRepository <Convidado, Long>{
    
    List<Convidado> findByEvento(Evento evento);
}

