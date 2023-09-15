package ifrn.pi.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.eventos.Models.Events;

public interface EvetRepository extends JpaRepository <Events, Long>{
    
}
