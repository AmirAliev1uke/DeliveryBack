package com._ukeCompany.delivery_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckcontroller {
    @GetMapping("/health")
    public String HealthCheckcontroller() {
        return "OK";
    }
}
