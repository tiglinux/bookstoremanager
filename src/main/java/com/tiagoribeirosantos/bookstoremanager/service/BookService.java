package com.tiagoribeirosantos.bookstoremanager.service;

import com.tiagoribeirosantos.bookstoremanager.dto.BookDTO;
import com.tiagoribeirosantos.bookstoremanager.dto.MessageResponseDTO;
import com.tiagoribeirosantos.bookstoremanager.entity.Book;
import com.tiagoribeirosantos.bookstoremanager.mapper.BookMapper;
import com.tiagoribeirosantos.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {                   //Insere e cria um livro e gera ID
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Livro criado com sucesso com ID: " + savedBook.getId())
                .build();
    }

    public BookDTO findById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return bookMapper.toDto(optionalBook.get());
    }
}
