package ru.skypro.lessons.springboot.weblibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Эта Аннотация указывает Spring Boot на главный и запускающий класс
public class WebLibraryApplication {

    public static void  main(String[] args) {
        SpringApplication.run(WebLibraryApplication.class, args);


    }

}
