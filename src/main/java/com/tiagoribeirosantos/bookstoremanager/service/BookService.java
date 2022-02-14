package com.tiagoribeirosantos.bookstoremanager.service;

import com.tiagoribeirosantos.bookstoremanager.dto.BookDTO;
import com.tiagoribeirosantos.bookstoremanager.dto.MessageResponseDTO;
import com.tiagoribeirosantos.bookstoremanager.entity.Book;
import com.tiagoribeirosantos.bookstoremanager.mapper.BookMapper;
import com.tiagoribeirosantos.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDto(book);
    }

    public class BookNotFoundException extends Exception {
        public BookNotFoundException(Long id) {
            super(String.format("Book with ID not found", id));
        }
    }
}
