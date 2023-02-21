package com.example.BankingApplication;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
public class BankingApplication {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(BankingApplication.class, args);

    }
}