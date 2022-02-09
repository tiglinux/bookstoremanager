package com.tiagoribeirosantos.bookstoremanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Integer pages;

    @NotNull
    private Integer chapters;

    @NotBlank
    @Pattern(regexp = "(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]",
            message = "ISBN format must be a valid format")
    private String isbn;

    @NotBlank
    private String publisherName;

    @Valid
    @NotNull
    private AuthorDTO author;


}
