package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        System.out.println(" НАЧАЛО РАБОТЫ \n");

        System.out.println("1. Создание таблицы:");
        userService.createUsersTable();

        System.out.println("\n2. Добавление пользователей:");
        userService.saveUser("John", "Doe", (byte) 25);
        userService.saveUser("Jane", "Smith", (byte) 30);
        userService.saveUser("Bob", "Johnson", (byte) 35);
        userService.saveUser("Alice", "Williams", (byte) 28);

        System.out.println("\n3. Получение всех пользователей:");
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("   " + user);
        }

        System.out.println("\n4. Очистка таблицы:");
        userService.cleanUsersTable();

        System.out.println("\n5. Удаление таблицы:");
        userService.dropUsersTable();

        System.out.println("\n РАБОТА ЗАВЕРШЕНА ");

        Util.shutdown();
    }
}