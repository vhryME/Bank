package com.controllers;


import com.model.Client;
import com.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestAPICotroller {
    @Autowired
    ClientRepository repository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addClient(@RequestParam String name, @RequestParam String address, @RequestParam String login,
                          @RequestParam String password, @RequestParam String pin, @RequestParam String currency) {

        Client client = new Client(name, address, login, password, pin, currency);

        repository.save(client);
    }
}
