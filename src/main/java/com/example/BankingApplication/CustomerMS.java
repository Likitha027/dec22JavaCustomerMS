package com.example.BankingApplication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class
CustomerMS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CustomerId;
    private String CustomerName;
    private String emailId;
    private String Gender;
    private String PanCard;
    private String Address;

}
