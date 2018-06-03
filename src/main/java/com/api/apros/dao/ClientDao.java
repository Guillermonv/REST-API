package com.api.apros.dao;

import java.util.List;

import com.api.apros.model.Client;

public interface ClientDao {

    public List<Client> getAllClients();

    public Client addClient(Client client);

    public void deleteClient(int id);
}
