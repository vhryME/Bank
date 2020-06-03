package com.controller;


import com.model.Count;
import com.model.Currency;
import com.service.ClientService;
import com.service.CountService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CountController {
    @Autowired
    UserService userService;
    @Autowired
    ClientService clientService;
    @Autowired
    CountService countService;


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public void createCount() {
        Count count = new Count();
        countService.createCount(count);
    }

    @RequestMapping(value = "/change-owner", method = RequestMethod.GET)
    public void changeOwner(@RequestParam long countId, @RequestParam long clientIdFrom, @RequestParam long clientIdTo) {
        countService.changeOwner(countId, clientIdFrom, clientIdTo);
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public void withdraw(@RequestParam long countID, @RequestParam double howMuch, @RequestParam Currency currency) {
        countService.withdraw(countID, howMuch, currency);
    }

    //Replenish some money on your count
    @RequestMapping(value = "/replenish", method = RequestMethod.GET)
    public void replenish(@RequestParam double howMuch, @RequestParam Currency currency, @RequestParam int countID) {
        countService.replenish(countID, howMuch, currency);
    }

    //Tranfer from on user to another
    @RequestMapping(value = "/tranfer", method = RequestMethod.GET)
    public void transfer(@RequestParam int countIdFrom, @RequestParam int countIdTo, @RequestParam double howMuch,
                         @RequestParam Currency currency) {
        countService.transfer(countIdFrom, countIdTo, howMuch, currency);
    }
}
