package com.api.apros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.apros.model.Client;
import com.api.apros.service.ClientServiceImpl;
import com.api.apros.service.validator.exceptions.ValidationException;

@RestController
public class ClientControllerImpl {
	
    @Autowired
	ClientServiceImpl clientServiceImpl;
	
	@RequestMapping(value = "/personas", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Client> getClients() {
		
		List<Client> listOfClients = clientServiceImpl.getAllClients();
		return listOfClients;
	}

	@RequestMapping(value = "/personas/alta", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addClient(@RequestBody Client client) throws ValidationException {
		clientServiceImpl.addClient(client);
		
	}

	@RequestMapping(value = "/personas/baja/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteClient(@PathVariable("id") int id) {
		clientServiceImpl.deleteClient(id);
	}	
}
