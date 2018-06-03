package com.api.apros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apros.dao.ClientDAOImpl;
import com.api.apros.model.Client;
import com.api.apros.service.validator.ClientValidator;
import com.api.apros.service.validator.exceptions.ValidationException;
import org.springframework.transaction.annotation.Transactional;

@Service("ClientService")
public class ClientServiceImpl  {

	@Autowired
	ClientDAOImpl clientDAO;

	@Autowired
	ClientValidator clientValidator;

	@Transactional
	public List<Client> getAllClients() {
		return clientDAO.getAllClients();
	}

	@Transactional
	public void addClient(Client client) throws ValidationException {
		clientValidator.validateClient(client);
		clientDAO.addClient(client);
	}

	@Transactional
	public void deleteClient(int id) {
		clientDAO.deleteClient(id);
	}
}
