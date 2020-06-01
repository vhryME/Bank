package com.service;


import com.model.Count;
import com.model.User;
import com.repo.ClientRepo;
import com.repo.CountRepo;
import com.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BankService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    CountRepo countRepo;


    public void createUser(User user) {
        if(userRepo != null && clientRepo != null && countRepo != null) {
            userRepo.save(user);
            clientRepo.save(user.getClient());
            countRepo.save(user.getClient().getCounts().get(0));
        }
    }


    public void deleteUser(User user) {
        if(userRepo != null && clientRepo != null && countRepo != null) {
            userRepo.delete(user);
            clientRepo.delete(user.getClient());

            for(long i = 0; i < user.getClient().getCounts().size(); i++) {
                countRepo.deleteById(i);
            }
        }
    }


    public User getUser(String name) {
        return userRepo.getByName(name);
    }


    public List<User> getAll() {
        return userRepo.findAll();
    }


    public double withdraw(User user, int pin, int countID, double howMuch, String currency) {
        if(user.getClient().getCounts().get(countID).getPin() == pin) {
            switch (currency) {
                case ("DOLLAR"):
                    do {
                        countID++;
                    } while (user.getClient().getCounts().get(countID).getMoney() > howMuch);

                    user.getClient().getCounts().get(countID).setMoney(user.getClient().getCounts().get(countID).getMoney()
                            - howMuch);
                    break;

                case ("EURO"):
                    user.getClient().getCounts().get(countID).setMoney(Count.getEuro(user.getClient().getCounts().get(countID))
                            - howMuch);
                    break;

                case ("RUB"):
                    user.getClient().getCounts().get(countID).setMoney(Count.getRub(user.getClient().getCounts().get(countID))
                            - howMuch);
                    break;
            }

            return user.getClient().getCounts().get(countID).getMoney();
        }

        return 0.0;
    }


    public void replenish(User user, int countID, double howMuch, String currency) {
        switch (currency) {
            case ("DOLLAR"):
                do {
                    countID++;
                } while (user.getClient().getCounts().get(countID).getMoney() > howMuch);

                user.getClient().getCounts().get(countID).setMoney(user.getClient().getCounts().get(countID).getMoney()
                        + howMuch);
                break;

            case ("EURO"):
                user.getClient().getCounts().get(countID).setMoney(Count.getEuro(user.getClient().getCounts().get(countID))
                        + howMuch);
                break;

            case ("RUB"):
                user.getClient().getCounts().get(countID).setMoney(Count.getRub(user.getClient().getCounts().get(countID))
                        + howMuch);
                break;
        }
    }


    public void transfer(int countIdFrom, int countIdTo, int pin, User from, User to, double howMuch, String currency) {
        if(from.getClient().getCounts().get(countIdFrom).getPin() == pin) {
            replenish(to, countIdTo, withdraw(from, pin, countIdFrom, howMuch, currency), currency);
        }
    }
}
