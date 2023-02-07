package com.example.BankingApplication;
import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingApplication {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(BankingApplication.class, args);
    }

}