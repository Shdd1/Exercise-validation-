package com.example.exercisevalidationq3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Event {

     @Size(min = 3,message = "id Length must be more than 2")
    @NotEmpty(message = " id Can not be empty")
    private String  id;

    @Positive(message = "capacity must be positive number")
    @NotNull(message = "Capacity Can not be null")
    @Min(value = 26,message = "Capacity must be more than 25 ")
    private int capacity;
    
    @Size(min = 16,message = "description Length must be more than 15")
    @NotEmpty(message = " Description Can not be empty")
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

}
