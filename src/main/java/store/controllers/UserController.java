package store.controllers;

import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import store.common.User;
import store.services.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Transactional
    @RequestMapping(value = "User/Create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @Transactional
    @RequestMapping(value = "User/Remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeUser(@RequestBody int id) {
        userService.removeUser(id);
    }

    @Transactional
    @RequestMapping(value = "User/GetById/{id}", method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @Transactional
    @RequestMapping(value = "User/AddMoney", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addMoneyForBalance(@RequestBody int idUser, @RequestBody double sum) {
        userService.addMoneyForBalance(idUser, sum);
    }

    @Transactional
    @RequestMapping(value = "User/GetAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Transactional
    @RequestMapping(value = "User/Edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }

    @Transactional
    @RequestMapping(value = "User/GetAllWithJoin", method = RequestMethod.POST, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public List<User> getWithJoin() {
        return userService.getWithJoin();
    }
}
