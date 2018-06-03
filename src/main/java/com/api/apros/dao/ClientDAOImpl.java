package com.api.apros.dao;

import java.util.List;

import com.api.apros.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Client> getAllClients() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Client> clientsList = session.createQuery("from Client").list();
		return clientsList;
	}

	public Client addClient(Client client) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(client);
		return client;
	}

	public void deleteClient(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Client p = (Client) session.load(Client.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
