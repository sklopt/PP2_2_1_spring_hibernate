package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("В гараже находятся следующие машины: \n");
        List<Car> cars = userService.listCars();
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println("\nЧтобы узнать владельца, введите модель и серию машины");
        System.out.println("Сначала введите модель машины: ");
        String model = sc.nextLine();
        System.out.println("Теперь введите серию машины: ");
        int series = sc.nextInt();
        List<User> result_user = userService.userCar(model, series);
        for (User user : result_user) {
            System.out.println("Владелец машины: " + user.toString());
        }
        sc.close();
        context.close();
    }
}

//        userService.add(new User("Shamil", "Gilmanov", "sklopt@rambler.ru", new Car("Hyundai Palisade", 2023)));
//        userService.add(new User("Timur", "Gilmanov", "freelance@mail.ru", new Car("Audi RS8", 2023)));
//        userService.add(new User("Aidar", "Gilmanov", "sber@mail.ru", new Car("Tesla Model X", 2023)));
//        userService.add(new User("Airat", "Gilmanov", "gazprom@mail.ru", new Car("Lexus LX570", 2023)));
//        userService.add(new User("Vener", "Gilmanov", "mvd@mail.ru", new Car("Chevrolet Camaro", 2023)));
//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println("Car = " + user.getUserCar().toString());
//            System.out.println();
//        }
