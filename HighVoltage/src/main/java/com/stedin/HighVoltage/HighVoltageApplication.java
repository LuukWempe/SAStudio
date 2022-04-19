package com.stedin.HighVoltage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stedin.HighVoltage.model.FileManager;
import com.stedin.HighVoltage.services.StationService;

@SpringBootApplication
public class HighVoltageApplication {

    public static void main(String[] args) {
        SpringApplication.run(HighVoltageApplication.class, args);
    }
}