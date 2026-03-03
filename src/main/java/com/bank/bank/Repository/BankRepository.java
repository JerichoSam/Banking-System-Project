package com.bank.bank.Repository;


import com.bank.bank.Entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<BankEntity, Integer> {

    List<BankEntity> findBankById(Integer Id);
}
