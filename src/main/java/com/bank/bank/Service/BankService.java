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

}
