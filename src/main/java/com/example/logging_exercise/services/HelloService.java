package com.example.logging_exercise.services;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;


@Service
public class HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    public int calculatePower(int base, int exponent) {
        logger.debug("Starting power calculation: {}^{}", base, exponent);
        int result = (int) Math.pow(base, exponent);
        logger.debug("Finished power calculation: result = {}", result);
        return result;
    }
}
