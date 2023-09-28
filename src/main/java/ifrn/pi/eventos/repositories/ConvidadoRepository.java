package ifrn.pi.eventos.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.eventos.Models.Convidados;
import ifrn.pi.eventos.Models.Events;


public interface ConvidadoRepository extends JpaRepository <Convidados, Long>{
    
    List<Convidados> findByEvents(Events events);
}

