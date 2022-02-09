package com.tiagoribeirosantos.bookstoremanager.service;

import com.tiagoribeirosantos.bookstoremanager.dto.MessageResponseDTO;
import com.tiagoribeirosantos.bookstoremanager.entity.Book;
import com.tiagoribeirosantos.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(Book book) {                   //Insere e cria um livro e gera ID
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Livro criado com sucesso com ID: " + savedBook.getId())
                .build();
    }
}
