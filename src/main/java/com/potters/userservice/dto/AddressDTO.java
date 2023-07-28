package com.potters.userservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class AddressDTO {
    private String street;
    @NotEmpty(message = "City can not be blank..")
    private String city;
    @NotEmpty(message = "Country can not be blank..")
    private String country;
    @NotEmpty(message = "Pin code can not be blank..")
    private String pinCode;
}
