package com.tiagoribeirosantos.bookstoremanager.controller;

import com.tiagoribeirosantos.bookstoremanager.dto.BookDTO;
import com.tiagoribeirosantos.bookstoremanager.dto.MessageResponseDTO;
import com.tiagoribeirosantos.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping                                                    //Método Post para enviar
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id){
        return bookService.findById(id);
    }
}
