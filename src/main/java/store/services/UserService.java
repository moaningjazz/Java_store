package store.services;

import org.springframework.stereotype.Component;
import store.common.User;
import store.dal.IUserDao;

import java.util.List;

@Component
public class UserService implements IUserService {
    IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(userDao.getUserById(id));
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void addMoneyForBalance(int idUser, double sum) {
        userDao.addMoneyForBalance(userDao.getUserById(idUser), sum);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public List<User> getWithJoin() {
        return userDao.getWithJoin();
    }
}
