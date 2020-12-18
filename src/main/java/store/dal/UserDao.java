package store.dal;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import store.common.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class UserDao implements IUserDao {
    IHibernateFactory hibernateFactory;

    public UserDao(IHibernateFactory hibernateFactory) {
        this.hibernateFactory = hibernateFactory;
    }

    @Override
    public void createUser(User user) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.save(user);
    }

    @Override
    public void removeUser(User user) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.remove(user);
    }

    @Override
    public User getUserById(int id) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        User user;
        user = session.get(User.class, id);
        return user;
    }

    @Override
    public void addMoneyForBalance(User user, double sum) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        user.balance += sum;
        session.update(user);
    }

    @Override
    public List<User> getAllUsers() {
        Session session = hibernateFactory.getSessionFactory().openSession();

        List<User> users;
        users = session.createQuery("From User").list();
        return users;
    }

    @Override
    public void editUser(User user) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.update(user);
    }

    @Override
    public List<User> getWithJoin() {
        EntityManager entityManager = hibernateFactory.getSessionFactory().createEntityManager();
        Query query = entityManager.createQuery(
                "SELECT DISTINCT user FROM User user INNER JOIN user.purchasedProduct products");
        List<User> resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }
}
