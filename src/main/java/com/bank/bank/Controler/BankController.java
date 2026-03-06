package com.bank.bank.Controler;


import com.bank.bank.Entity.BankEntity;
import com.bank.bank.Service.BankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService){
        this.bankService = bankService;
    }

    //CREATE
    @PostMapping
    public BankEntity createBank(@RequestBody BankEntity bank){
        return bankService.saveBank(bank);
    }

    //READ ALL
    @GetMapping
    public List<BankEntity> getAllBanks(){
        return bankService.getallBanks();
    }

    //READ By ID
    @GetMapping("/{id}")
    public BankEntity getBAnkById(@PathVariable int id){
        return bankService.getBankById(id)
                .orElseThrow(() -> new RuntimeException("Bank not found!!"));
    }

    //UPDATE
    @PutMapping("/{id}")
    public BankEntity updateBank(@PathVariable int id,@RequestBody BankEntity bank){
        return bankService.updateBank(id, bank);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public String deleteBank(@PathVariable int id){
        bankService.deleteBank(id);
        return "Bank Deleted Successfully";
    }

    //Withdraw
    @PostMapping("/{id}/withdraw")
    public BankEntity withdraw(@PathVariable int id, @RequestParam double amount) {
        return bankService.withdraw(id, amount);
    }

    //DEPOSIT
    @PostMapping("/{id}/deposit")
    public BankEntity deposit(@PathVariable int id, @RequestParam double amount) {
        return bankService.deposit(id, amount);
    }
}
