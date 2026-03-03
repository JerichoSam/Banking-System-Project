package com.bank.bank.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Bank")
public class BankEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "ACCOUNTNUMBER")
    private int accountNumber;

    @Column(name = "OWNERNAME")
    private String ownerName;

    @Column(name = "BALANCE")
    private double balance;


}
