package com.service;


import com.dto.Client;
import com.model.Account;
import com.model.Count;
import com.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;


public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientRepository clientRepository;


    public void withdraw(Client client, Integer pin, Integer countID, double howMuch, String currency) {
        if(client.getCounts().get(countID).getPin() == pin) {
            switch (currency) {
                case ("DOLLAR"):
                    do {
                        countID++;
                    } while (client.getCounts().get(countID).getMoney() > howMuch);

                    client.getCounts().get(countID).setMoney(client.getCounts().get(countID).getMoney() - howMuch);
                    break;

                case ("EURO"):
                    client.getCounts().get(countID).setMoney(Count.getEuro(client.getCounts().get(countID)) - howMuch);
                    break;

                case ("RUB"):
                    client.getCounts().get(countID).setMoney(Count.getRub(client.getCounts().get(countID)) - howMuch);
                    break;
            }
        }
    }

    @Override
    public List<Account> findAll() {
        if(clientRepository != null)
            return clientRepository.findAll();

        return null;
    }

    @Override
    public Account getOne(Long aLong) {
        if(clientRepository != null)
            return clientRepository.getOne(aLong);

        return null;
    }

    @Override
    public <S extends Account> S save(S s) {
        if(clientRepository != null) {
            if(clientRepository.getOne(s.getId()) == null)
                clientRepository.save(s);

            return s;
        }
        return null;
    }

    @Override
    public void deleteById(Long aLong) {
        if(clientRepository != null) {
            clientRepository.deleteById(aLong);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public <S extends Account> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public List<Account> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Account> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Account account) { }

    @Override
    public void deleteAll(Iterable<? extends Account> iterable) { }

    @Override
    public void deleteAll() { }

    @Override
    public <S extends Account> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Account> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() { }

    @Override
    public <S extends Account> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Account> iterable) { }

    @Override
    public void deleteAllInBatch() { }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Account> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Account> boolean exists(Example<S> example) {
        return false;
    }
}
