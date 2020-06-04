package com.service;


import com.model.Client;
import com.model.Count;
import com.model.Currency;
import com.repo.ClientRepo;
import com.repo.CountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CountService {
    @Autowired
    CountRepo countRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    ClientService clientService;


    @Transactional
    public void createCount(Count count) {
        if(countRepo != null && !countRepo.existsById(count.getId()) && count != null)
            countRepo.save(count);
    }


    @Transactional
    public void deleteCount(Count count) {
        if(countRepo != null && countRepo.existsById(count.getId()) && count != null)
            countRepo.delete(count);
    }


    public Count getCountById(Long id) {
        if(countRepo != null && countRepo.existsById(id))
            return countRepo.getOne(id);

        return null;
    }


    public List<Count> getAllCounts() {
        if(countRepo != null)
            return countRepo.findAll();

        return null;
    }


    @Transactional
    public void changeOwner(long countId, long clientIdFrom, long clientIdTo) {
        if(clientService != null && clientRepo.existsById(clientIdFrom) && clientRepo.existsById(clientIdTo)) {

            Client clientTo = clientService.getClientById(clientIdTo);
            Client clientFrom = clientService.getClientById(clientIdFrom);

            if(countRepo.existsById(countId)) {
                if(clientFrom.getCounts() != null) {

                    Count countForChange = clientFrom.getCounts().get((int) countId);

                    if (countForChange != null) {
                        clientTo.getCounts().add(countForChange);

                        countForChange = null;
                    }
                }
            }
        }
    }


    @Transactional
    public double withdraw(long countID, double howMuch, Currency currency) {
        if (countRepo.existsById(countID)) {
            Count countForWithdraw = countRepo.getOne(countID);

            switch (currency) {
                case DOLLAR:
                    countForWithdraw.setMoney(countForWithdraw.getMoney() - howMuch);
                    break;

                case EURO:
                    countForWithdraw.setMoney(Count.getEuro(countForWithdraw) - howMuch);
                    break;

                case RUB:
                    countForWithdraw.setMoney(Count.getRub(countForWithdraw) - howMuch);
                    break;
            }

            return countRepo.getOne(countID).getMoney();
        }

        return 0.0;
    }


    @Transactional
    public void replenish(long countID, double howMuch, Currency currency) {
        if (countRepo.existsById(countID)) {
            Count countForReplenish = countRepo.getOne(countID);

            switch (currency) {
                case DOLLAR:
                    countForReplenish.setMoney(countForReplenish.getMoney() + howMuch);
                    break;

                case EURO:
                    countForReplenish.setMoney(Count.getEuro(countForReplenish) + howMuch);
                    break;

                case RUB:
                    countForReplenish.setMoney(Count.getRub(countForReplenish) + howMuch);
                    break;
            }
        }
    }


    @Transactional
    public void transfer(long countIdFrom, long countIdTo, double howMuch, Currency currency) {
        if(countRepo.existsById(countIdFrom) && countRepo.existsById(countIdTo))
            replenish(countIdTo, withdraw(countIdFrom, howMuch, currency), currency);
    }
}
