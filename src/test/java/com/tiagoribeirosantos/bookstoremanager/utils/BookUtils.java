package com.tiagoribeirosantos.bookstoremanager.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.tiagoribeirosantos.bookstoremanager.dto.BookDTO;
import com.tiagoribeirosantos.bookstoremanager.entity.Book;

import static com.tiagoribeirosantos.bookstoremanager.utils.AuthorUtils.createFakeAuthor;
import static com.tiagoribeirosantos.bookstoremanager.utils.AuthorUtils.createFakeAuthorDTO;

;

public class BookUtils {
    private static final com.github.javafaker.Faker faker = Faker.instance();

    public static BookDTO createFakeBookDTO() {
        return BookDTO.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .pages(faker.number().numberBetween(0, 200))
                .chapters(faker.number().numberBetween(1, 20))
                .isbn("0-596-52068-9")
                .publisherName(faker.book().publisher())
                .author(createFakeAuthorDTO())
                .build();
    }

    public static Book createFakeBook() {
        return Book.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .pages(faker.number().numberBetween(0, 200))
                .chapters(faker.number().numberBetween(1, 20))
                .isbn("0-596-52068-9")
                .publisherName(faker.book().publisher())
                .author(createFakeAuthor())
                .build();
    }


    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
