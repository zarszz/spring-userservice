package com.zarszz.userservice.controller;

import com.zarszz.userservice.requests.v1.email.ValidateSecretCodeDto;
import com.zarszz.userservice.service.SecretCodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/secret-code")
public class SecretCodeController {
    @Autowired
    SecretCodeServiceImpl secretCodeService;

    @PostMapping(value = "validate")
    ResponseEntity<String> validateSecretCode(@Valid @RequestBody ValidateSecretCodeDto validateSecretCodeDto) throws Exception {
        var isValid = secretCodeService.validate(validateSecretCodeDto);
        if (!isValid) return ResponseEntity.badRequest().body("Validation failed. Code invalid");
        return ResponseEntity.ok("Validation Success");
    }
}