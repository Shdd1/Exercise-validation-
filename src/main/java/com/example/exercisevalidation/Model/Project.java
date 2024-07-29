package com.example.exercisevalidation.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
@AllArgsConstructor
public class Project {
    @NotNull(message = " Id Can not be null")
    @NotEmpty(message = "ID should be not Empty")
    @Size(min=3,message = "Length must be more than 2")
    private String id;

    @NotNull(message = " Title Can not be null")
    @NotEmpty(message = "Title should be not Empty")
    @Size(min=9,message ="Length must more than 9 " )
    @NotBlank
    private String title;

    @NotNull(message = "Description Can not be null")
    @NotBlank
    @Size(min = 16,message = "Length must be more than 15")
    @NotEmpty(message = "Description should be not Empty")
    private String description;

    @NotNull(message = "Status Can not be null")
    @NotBlank
    @NotEmpty(message = "Status should be not Empty")
    private String status;

    @NotNull(message = "company Name Can not be null")
    @NotBlank
    @Size(min = 7,message = "Length must be more than 6 ")
    @NotEmpty(message = "company Name should be not Empty")
    private String companyName;
}
