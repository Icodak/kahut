package fr.isep.arlara.kahut;

import fr.isep.arlara.kahut.repository.HousingRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KahutApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(KahutApplication.class, args);
        //HousingRepository repo = context.getBean(HousingRepository.class);

    }

}
