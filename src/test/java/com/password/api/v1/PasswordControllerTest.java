package com.password.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.password.domain.service.PasswordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("PasswordController API Tests")
class PasswordControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PasswordService passwordService;

    @InjectMocks
    private PasswordController passwordController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(passwordController).build();
    }

    @Test
    @DisplayName("Should return true for a valid password")
    void testValidatePasswordReturnsTrueForValidPassword() throws Exception {
        String password = "Valid123!";
        when(passwordService.passwordIsValid(password)).thenReturn(true);

        String requestBody = objectMapper.writeValueAsString(Map.of("password",password));

        mockMvc.perform(post("/password/validate")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    @DisplayName("Should return false for an invalid password")
    void testValidatePasswordReturnsFalseForInvalidPassword() throws Exception {
        String password = "invalid";
        when(passwordService.passwordIsValid(password)).thenReturn(false);

        String requestBody = objectMapper.writeValueAsString((Map.of("password",password)));

        mockMvc.perform(post("/password/validate")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
}
