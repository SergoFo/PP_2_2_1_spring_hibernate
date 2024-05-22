package hiber;

import hiber.config.AppConfig;
import hiber.model.*;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        // Создание и добавление пользователей с машинами
        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        Car car1 = new Car("Honda", 2);
        user1.setCar(car1);
        car1.setUser(user1);
        userService.add(user1);

        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        Car car2 = new Car("Toyota", 4);
        user2.setCar(car2);
        car2.setUser(user2);
        userService.add(user2);

        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        Car car3 = new Car("Haval", 7);
        user3.setCar(car3);
        car3.setUser(user3);
        userService.add(user3);

        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        Car car4 = new Car("Lada", 2107);
        user4.setCar(car4);
        car4.setUser(user4);
        userService.add(user4);

        // Вывод списка всех пользователей
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        // Извлечение пользователя по модели и серии машины
        User userByCar = userService.getUserByCar("Toyota", 4);
        System.out.println("User with Toyota 4: " + userByCar);

        context.close();
    }
}
