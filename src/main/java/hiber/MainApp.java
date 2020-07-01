package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        //System.out.println(userService.getUserByCar((long) 1, 1749343 ).getFirstName()); //получение юзера по car id и series

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car(1749343, "Tesla")));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car(4994374, "Lada")));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car(7973486, "UAZ")));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car(6939474,"Mercedes")));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getName());
            System.out.println();
        }

        context.close();
    }
}
