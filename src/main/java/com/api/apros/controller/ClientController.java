package com.api.apros.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.apros.model.Client;
import com.api.apros.service.validator.exceptions.ValidationException;

public interface ClientController {

    public List<Client> getClients();

    public void addClient(@RequestBody Client client) throws ValidationException;

    public void deleteClient(@PathVariable("id") int id);
}
