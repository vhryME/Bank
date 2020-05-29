package com.controller;


import com.model.Client;
import com.model.Count;
import com.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RestAPICotroller {
    @Autowired
    ClientRepository repository;

    //Adding new Client in Bank DB
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addClient(@RequestParam String name, @RequestParam String address, @RequestParam String login,
                          @RequestParam String password, @RequestParam String pin, @RequestParam Double money,
                          @RequestParam String currency) {

        Client client = new Client(name, address, login, password, pin, new Count(money, currency));

        repository.save(client);
    }

    //Showing all clients of your Bank
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Client> showAll() {
        return repository.findAll();
    }

    //Deleting client by id
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam Integer id) {
        repository.deleteById(id);
    }


    /*@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public void withdraw(@RequestParam String login, @RequestParam String password, @RequestParam String pin,
                         @RequestParam double howMuch, @RequestParam String currency, @RequestParam int whichCount) {

        List<Client> clients = repository.findAll();

        for(Client client : clients) {
            if(client.getLogin().equals(login) && client.getPassword().equals(password) && client.getPin().equals(pin)){
                switch (currency) {
                    case "EURO":
                        client.getCounts().get(whichCount) = Count.getEuro(client.getCounts().get(whichCount)) - howMuch;
                }
            }
        }
    }*/
}
