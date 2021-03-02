package com.looplex.kanbanapi.repository;

import com.looplex.kanbanapi.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    /*
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
        };
    }*/

    /*
    @Bean
    CommandLineRunner initDatabase(StudentRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Student("Vinicius", "Santana")));
            log.info("Preloading " + repository.save(new Student("Andrew", "Filgueira")));
            log.info("Preloading " + repository.save(new Student("Beatriz", "Patriota")));
            log.info("Preloading " + repository.save(new Student("Alejandro", "Tarafa")));
            log.info("Preloading " + repository.save(new Student("Fabio", "Nagao")));
            log.info("Preloading " + repository.save(new Student("Rafael", "Parente")));
            log.info("Preloading " + repository.save(new Student("Angelo", "Caldeira")));
            log.info("Preloading " + repository.save(new Student("Alex", "Souza")));
            log.info("Preloading " + repository.save(new Student("Vinicius", "Alves")));
            log.info("Preloading " + repository.save(new Student("Vinicius", "Wieber")));
            log.info("Preloading " + repository.save(new Student("Lais", "Alves")));
        };
    }*/


    @Bean
    CommandLineRunner initDatabase(TaskRepository repository) {

        String[] tagsArray = {"Apple", "Banana", "Orange", "Grapes"};

        return args -> {
            log.info("Preloading " + repository.save(new Task("description1", "document", "done", "responsible", "creationDate", "dueDate", tagsArray)));
            log.info("Preloading " + repository.save(new Task("description2", "document", "waiting", "responsible", "creationDate", "dueDate", tagsArray)));
            log.info("Preloading " + repository.save(new Task("description3", "document", "done", "responsible", "creationDate", "dueDate", tagsArray)));
            log.info("Preloading " + repository.save(new Task("description4", "document", "waiting", "responsible", "creationDate", "dueDate", tagsArray)));
            log.info("Preloading " + repository.save(new Task("description5", "document", "done", "responsible", "creationDate", "dueDate", tagsArray)));
            log.info("Preloading " + repository.save(new Task("description6", "document", "waiting", "responsible", "creationDate", "dueDate", tagsArray)));
            log.info("Preloading " + repository.save(new Task("description7", "document", "done", "responsible", "creationDate", "dueDate", tagsArray)));
            log.info("Preloading " + repository.save(new Task("description8", "document", "waiting", "responsible", "creationDate", "dueDate", tagsArray)));
        };
    }
}