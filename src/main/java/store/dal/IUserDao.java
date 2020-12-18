package store.dal;

import store.common.User;

import java.util.List;

public interface IUserDao {
    void createUser(User user);
    void removeUser(User user);
    User getUserById(int id);
    void addMoneyForBalance(User user, double sum);
    List<User> getAllUsers();
    void editUser(User user);
    List<User> getWithJoin();
}