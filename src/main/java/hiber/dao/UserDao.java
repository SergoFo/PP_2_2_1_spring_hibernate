package hiber.dao;

import hiber.model.*;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User findUserByCar(String model, int series);
   void addCar(Car car);
}