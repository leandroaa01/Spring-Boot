package ifrn.pi.eventos.Models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String local;
    @NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
    @NotNull
    private String time;
     public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate( LocalDate date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "Evento [id=" + id + ", name=" + name + ", local=" + local + ", date=" + date + ", time=" + time + "]";
    }
    
}
