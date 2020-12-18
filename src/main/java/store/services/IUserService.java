package store.services;

import store.common.User;

import java.util.List;

public interface IUserService {
    void createUser(User user);
    void removeUser(int id);
    User getUserById(int id);
    void addMoneyForBalance(int idUser, double sum);
    List<User> getAllUsers();
    void editUser(User user);
    List<User> getWithJoin();
}
