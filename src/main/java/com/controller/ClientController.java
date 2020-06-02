package com.controller;


import com.model.Client;
import com.model.Count;
import com.model.User;
import com.service.ClientService;
import com.service.CountService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class ClientController {
    @Autowired
    UserService userService;
    @Autowired
    ClientService clientService;
    @Autowired
    CountService countService;

    @RequestMapping(value = "/became-client", method = RequestMethod.GET)
    public void becameClient(@RequestParam String name, @RequestParam String login, @RequestParam String password,
                             @RequestParam Date enterTime) {
        User user = new User(name, login, password, enterTime);
        Count count = new Count();
        List<Count> counts = new ArrayList<>();

        counts.add(count);

        Client client = new Client(user, counts);

        userService.createUser(user);
        countService.saveCount(count);
        clientService.createClient(client);
    }
}
