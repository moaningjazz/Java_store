package store.dal;

import org.hibernate.SessionFactory;

public interface IHibernateFactory {
    SessionFactory getSessionFactory();
}
