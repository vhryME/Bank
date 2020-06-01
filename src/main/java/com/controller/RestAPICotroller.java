package com.controller;


import com.model.Client;
import com.model.Count;
import com.model.User;
import com.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class RestAPICotroller {
    @Autowired
    BankService service;

    //Adding new Client in Bank DB
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void createUser(@RequestParam String name, @RequestParam String login, @RequestParam String password,
                           @RequestParam Integer pin, @RequestParam Double money, @RequestParam String currency) {

        Count count = new Count(money, currency, pin);

        List<Count> counts = new ArrayList<>();
        counts.add(count);

        Client client = new Client(counts);

        User user = new User(client, name, login, password, new Date());

        service.createUser(user);
    }


    //Withdraw some money on your count
    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public void withdraw(@RequestParam String login, @RequestParam Integer pin, @RequestParam double howMuch,
                         @RequestParam String currency, @RequestParam int countID) {

        service.withdraw(service.getUser(login), pin, countID, howMuch, currency);
    }


    //Replenish some money on your count
    @RequestMapping(value = "/replenish", method = RequestMethod.GET)
    public void replenish(@RequestParam String login, @RequestParam double howMuch, @RequestParam String currency,
                          @RequestParam int countID) {

        service.replenish(service.getUser(login), countID, howMuch, currency);
    }


    //Tranfer from on user to another
    @RequestMapping(value = "/tranfer", method = RequestMethod.GET)
    public void transfer(@RequestParam int countIdFrom, @RequestParam int countIdTo, @RequestParam Integer pin,
                        @RequestParam String nameFrom, @RequestParam String nameTo, @RequestParam double howMuch,
                        @RequestParam String currency) {

        service.transfer(countIdFrom, countIdTo, pin, service.getUser(nameFrom),
                        service.getUser(nameTo), howMuch, currency);
    }


    //Showing all users of your bank
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> showAll() {
        return service.getAll();
    }
}
