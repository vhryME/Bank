package com.controller;


import com.dto.Client;
import com.model.Account;
import com.model.Count;
import com.repo.ClientRepository;
import com.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RestAPICotroller {
    @Autowired
    ClientServiceImpl service;

    //Adding new Client in Bank DB
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addClient(@RequestParam String name, @RequestParam String login,
                          @RequestParam String password, @RequestParam Integer pin, @RequestParam Double money,
                          @RequestParam String currency) {

        Account account = new Account(name, login, password);
        List<Count> counts = new ArrayList<>();

        counts.add(new Count(money, currency, pin));

        Client client = new Client(account, counts);

        service.save(account);
    }

    //Showing all clients of your Bank
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Account> showAll() {
        return service.findAll();
    }

    //Deleting client by id
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam Long id) {
        service.deleteById(id);
    }


    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public void withdraw(@RequestParam Integer pin, @RequestParam double howMuch,
                         @RequestParam String currency, @RequestParam int countID) {

        //This is not complished version, only demonstrating
        service.withdraw(client, countID, howMuch, currency);
    }
}
