package com.tiagoribeirosantos.bookstoremanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BookstoremanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoremanagerApplication.class, args);
    }
}