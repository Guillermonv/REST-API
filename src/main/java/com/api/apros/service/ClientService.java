package com.api.apros.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.api.apros.model.Client;
import com.api.apros.service.validator.exceptions.ValidationException;


public interface ClientService {

    @Transactional
    public List<Client> getAllClients();

    @Transactional
    public void addClient(Client client) throws ValidationException;

    @Transactional
    public void deleteClient(int id);
}
