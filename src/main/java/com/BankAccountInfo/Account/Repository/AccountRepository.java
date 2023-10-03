package com.BankAccountInfo.Account.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<com.BankAccountInfo.Account.Model.Account, Long> {
}
