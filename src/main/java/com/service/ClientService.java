package com.service;


import com.model.Client;
import com.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;

    public void createClient(Client client) {
        if(clientRepo != null && !clientRepo.existsById(client.getId()) && client != null)
            clientRepo.save(client);
    }


    public void deleteUser(Client client) {
        if(clientRepo != null && clientRepo.existsById(client.getId()) && client != null)
            clientRepo.delete(client);
    }


    public Client getClientById(long id) {
        if(clientRepo != null && clientRepo.existsById(id))
            return clientRepo.getOne(id);

        return null;
    }


    public List<Client> getAllClients() {
        if(clientRepo != null)
            return clientRepo.findAll();

        return null;
    }
}
