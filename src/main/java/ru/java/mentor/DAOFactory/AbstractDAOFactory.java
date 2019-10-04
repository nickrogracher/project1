package ru.java.mentor.DAOFactory;

import org.hibernate.Session;
import ru.java.mentor.util.PropertyReader;
import ru.java.mentor.util.ReaderException;

import java.io.IOException;

public class AbstractDAOFactory {

    private static DAO dao;
    private static AbstractDAOFactory abstractDAOFactory;

    public static AbstractDAOFactory getInstance(){
        if (abstractDAOFactory == null){
            abstractDAOFactory = new AbstractDAOFactory();
        }
        return abstractDAOFactory;
    }

    public static DAO getDAO(Session session) {
        if (PropertyReader.getInstacne().getConnection().equals("hibernate")) {
            dao = new HibernateDAO(session);
        } else {
            dao = new JdbcDAO();
        }
        return dao;
    }
}
