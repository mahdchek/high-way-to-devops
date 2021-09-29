package com.rte.highwaytodevops;

import com.rte.highwaytodevops.entities.Personne;
import com.rte.highwaytodevops.repository.PersonneRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class Controller {


    private final PersonneRepository personneRepository;

    public Controller(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }


    @GetMapping("api")
    public AppDetails getAppDetails() {
        return AppDetails.builder()
                .appName("High-way-to-Devops")
                .version("V.1.0.2").build();
    }


    @PostConstruct
    public void initData() {
        Personne p1 = Personne.builder()
                .id(1L)
                .login("mchekini")
                .lastName("CHEKINI")
                .password("test")
                .firstName("mahdi")
                .tjm(610L)
                .build();

        personneRepository.save(p1);
    }


    @GetMapping("api/personnes")
    public List<Personne> getPersonnes() {

        return personneRepository.findAll();

    }
}
