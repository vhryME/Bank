package com.repo;


import com.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {}
