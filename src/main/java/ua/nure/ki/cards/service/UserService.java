package ua.nure.ki.cards.service;

import ua.nure.ki.cards.dao.ResultDao;
import ua.nure.ki.cards.dao.UserDao;
import ua.nure.ki.cards.data.User;

import java.util.List;

public class UserService {

    private static UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }


    public User findById(Integer id) {
        userDao.openCurrentSession();
        User user = (User)userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public List<User> findAll() {
        userDao.openCurrentSession();
        List<User> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }

    public List<User> findAllbyId(int id) {
        userDao.openCurrentSession();
        List<User> users = userDao.findAllbyId(id);
        userDao.closeCurrentSession();
        return users;
    }

    public static UserDao getUserDao() {
        return userDao;
    }

}
