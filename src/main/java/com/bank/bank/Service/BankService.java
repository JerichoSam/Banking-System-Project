package com.bank.bank.Service;

import com.bank.bank.Entity.BankEntity;
import com.bank.bank.Repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }

    //CREATE
    public BankEntity saveBank(BankEntity bankEntity){
        return bankRepository.save(bankEntity);
    }

    //READ ALL
    public List<BankEntity> getallBanks(){
        return bankRepository.findAll();
    }

    // READ By ID
    public Optional<BankEntity> getBankById(int id){
        return bankRepository.findById(id);
    }

    //UPDATE
    public BankEntity updateBank(int id, BankEntity updatedBankEntity){
        return bankRepository.findById(id)
                .map(bankEntity ->{
                    bankEntity.setAccountNumber(updatedBankEntity.getAccountNumber());
                    bankEntity.setOwnerName(updatedBankEntity.getOwnerName());
                    bankEntity.setBalance(updatedBankEntity.getBalance());
                    return  bankRepository.save(bankEntity);
                })
                .orElseThrow(() -> new RuntimeException("Bank Not Found!"));
    }

    //DELETE
    public void deleteBank(int id){
        bankRepository.deleteById(id);
    }

    //WITHDRAW
    public BankEntity withdraw(int id,double amount){
        BankEntity bankEntity =bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank account not found"));

        if(bankEntity.getBalance() < amount){
            throw new RuntimeException("Insufficient Balance!!");
        }

        double newBalance = bankEntity.getBalance() - amount;
        bankEntity.setBalance(newBalance);

        return bankRepository.save(bankEntity);
    }

    //DEPOSIT
    public BankEntity deposit(int id, double amount){
        BankEntity bankEntity = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank account not found"));

        double newBalance = bankEntity.getBalance() + amount;
        bankEntity.setBalance(newBalance);

        return bankRepository.save(bankEntity);
    }
}
