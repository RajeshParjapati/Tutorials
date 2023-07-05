package com.potters.userservice.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class UserDTO {
    @NotEmpty(message = "Name can not be blank..")
    private String name;
    @Email(message = "Not a valid email.")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String phoneNo;
    @Min(value = 18, message = "Age must be greater than 18 or equals to 18")
    @Max(value = 100, message = "Invalid Age: Exceeds 100 years")
    private Integer age;
}
