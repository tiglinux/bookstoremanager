package com.tiagoribeirosantos.bookstoremanager.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class ClienteService {
    public String mostrar() {
        return "Olá, tiago!";
    }
}
