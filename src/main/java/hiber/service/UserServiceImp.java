package hiber.service;

import hiber.dao.UserDao;
import hiber.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        if (user.getCar() != null) {
            Car car = user.getCar();
            user.setCar(null);
            userDao.add(user); // Сохранить пользователя без машины
            car.setId(user.getId()); // Установить ID машины равным ID пользователя
            user.setCar(car);
            userDao.addCar(car); // Сохранить машину
        } else {
            userDao.add(user);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByCar(String model, int series) {
        return userDao.findUserByCar(model, series);
    }

}