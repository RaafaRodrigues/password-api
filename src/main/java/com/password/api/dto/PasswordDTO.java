package com.password.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PasswordDTO {
    @NotNull
    private String password;
}
