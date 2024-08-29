package com.example.logging_exercise.controllers;


import com.example.logging_exercise.services.CustomError;
import com.example.logging_exercise.services.HelloService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Value("${custom.var1}")
    private int var1;

    @Value("${custom.var2}")
    private int var2;

    @Autowired
    private HelloService helloService;

    @GetMapping("/")
    public String welcome() {
        String message = "Welcome to the Custom Logging Application!";
        logger.info(message);
        return message;
    }

    @GetMapping("/exp")
    public int calculateExponent() {
        logger.info("Calculating exponent: {}^{}", var1, var2);
        int result = helloService.calculatePower(var1, var2);
        logger.info("Result of {}^{} is {}", var1, var2, result);
        return result;
    }

    @GetMapping("/get-errors")
    public void triggerError() {
        logger.error("Triggering custom error!");
        throw new CustomError("This is a custom error for logging purposes!");
    }
}