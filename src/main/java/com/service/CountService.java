package com.service;


import com.model.Client;
import com.model.Count;
import com.repo.ClientRepo;
import com.repo.CountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountService {
    @Autowired
    CountRepo countRepo;
    @Autowired
    ClientService clientService;

    public void createCount() {
        Count count = new Count();

        if(countRepo != null)
            countRepo.save(count);
    }

    public void deleteCount(Count count) {
        if(countRepo != null)
            countRepo.delete(count);
    }

    public Count getCountById(Long id) {
        if(countRepo != null)
            return countRepo.getOne(id);

        return null;
    }

    public List<Count> getAllCounts() {
        if(countRepo != null)
            return countRepo.findAll();

        return null;
    }

    public void changeOwner(long countId, long clientIdFrom, long clientIdTo) {
        Client clientTo = clientService.getClientById(clientIdTo);
        Client clientFrom = clientService.getClientById(clientIdFrom);

        Count countForChange = clientFrom.getCounts().get((int) countId);

        if(countForChange != null) {
            clientTo.getCounts().add(countForChange);

            countForChange = null;
        }
    }

    public double withdraw(long countID, double howMuch, String currency) {
            switch (currency) {
                case ("DOLLAR"):
                    countRepo.getOne(countID).setMoney( countRepo.getOne(countID).getMoney() - howMuch);
                    break;

                case ("EURO"):
                    countRepo.getOne(countID).setMoney(Count.getEuro(countRepo.getOne(countID)) - howMuch);
                    break;

                case ("RUB"):
                    countRepo.getOne(countID).setMoney(Count.getRub(countRepo.getOne(countID)) - howMuch);
                    break;
            }

            return countRepo.getOne(countID).getMoney();
    }



    public void replenish(long countID, double howMuch, String currency) {
        switch (currency) {
            case ("DOLLAR"):
                countRepo.getOne(countID).setMoney( countRepo.getOne(countID).getMoney() + howMuch);
                break;

            case ("EURO"):
                countRepo.getOne(countID).setMoney(Count.getEuro(countRepo.getOne(countID)) + howMuch);
                break;

            case ("RUB"):
                countRepo.getOne(countID).setMoney(Count.getRub(countRepo.getOne(countID)) + howMuch);
                break;
        }
    }


    public void transfer(long countIdFrom, long countIdTo, double howMuch, String currency) {
        replenish(countIdTo, withdraw(countIdFrom, howMuch, currency), currency);
    }
}
