package com.password.api.v1;

import com.password.api.dto.PasswordDTO;
import com.password.domain.service.PasswordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/password")
@RequiredArgsConstructor
public class PasswordController {
    private final PasswordService passwordService;

    @Operation(
            summary = "Validate a password",
            description = "Validates the provided password based on predefined security rules (length, digits, lowercase, etc.)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Password validation result (true/false)"),
            @ApiResponse(responseCode = "400", description = "Invalid input, password is missing or invalid")
    })
    @PostMapping("/validate")
    public ResponseEntity<Boolean> validatePassword(
            @Parameter(description = "Payload containing the password to be validated")
            @RequestBody @Valid PasswordDTO payload) {
        return ResponseEntity.ok(passwordService.passwordIsValid(payload.getPassword()));
    }
}
