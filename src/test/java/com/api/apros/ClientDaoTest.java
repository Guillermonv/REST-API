package com.api.apros;

import com.api.apros.model.Client;
import com.api.apros.service.ClientServiceImpl;
import com.api.apros.service.validator.ClientValidator;
import com.api.apros.service.validator.exceptions.ValidationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guille on 6/2/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@Transactional
public class ClientDaoTest {

    @InjectMocks
    ClientServiceImpl clientService;

    @InjectMocks
    ClientValidator clientValidator;

    private SessionFactory mockedSessionFactory;

    private Session mockedSession;

    private Transaction mockedTransaction;

    @Before
    public void setUp() {
        clientValidator = new ClientValidator();
        mockedSessionFactory = Mockito.mock(SessionFactory.class);
        mockedSession = Mockito.mock(Session.class);
        mockedTransaction = Mockito.mock(Transaction.class);
        Mockito.when(mockedSessionFactory.openSession()).thenReturn(mockedSession);
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.beginTransaction()).thenReturn(mockedTransaction);
        //clientDAO.setSessionFactory(this.mockedSessionFactory);
    }


    @Test
    public void clientServiceTest_HappyPath() throws ValidationException {

        Client client = new Client();
        client.setNombre("Dummy");
        client.setApellido("Data");
        client.setDNI(333);
        client.setEdad(18);
        client.setID(1);

        clientValidator.validateClient(client);

    }


    @Test(expected = ValidationException.class)
    public void clientServiceTest_failDueToInvalidAge() throws ValidationException {

        Client client = new Client();
        client.setNombre("Dummy");
        client.setApellido("Data");
        client.setDNI(333);
        //Invalid Age
        client.setEdad(180);
        client.setID(1);

        clientValidator.validateClient(client);

    }


}