package com.repo;


import com.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Account, Long> {}
