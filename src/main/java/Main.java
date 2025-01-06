import Shop.Customer;
import Shop.Order;
import Shop.Product;
import Shop.Shop;

import java.util.List;
import java.util.Objects;

import static Shop.Shop.customers;
import static Shop.Shop.products;

enum Holiday {
    noHoliday,
    newYear,
    internationalWomensDay,
    defendersDay
}

public class Main {
    public static void main(String[] args) {
        Shop.customers.add(new Customer("Иванов Семён Петрович", 36, "8-956-745-59-32", "муж"));
        Shop.customers.add(new Customer("Петров Сергей Гаврилович", 54, "8-963-475-32-15", "муж"));
        Shop.customers.add(new Customer("Ламатханова Таисия Олеговна", 19, "8-985-456-37-68", "жен"));
        Shop.products.add(new Product("Машинка", 1300));
        Shop.products.add(new Product("Кукла", 2450));
        Shop.products.add(new Product("Конструктор", 900));
        Shop.products.add(new Product("Машинка", 1300));
        Shop.products.add(new Product("Машинка", 7000));
        Shop.products.add(new Product("Кукла", 5600));
        Shop.orders.add(new Order(customers.get(0), products.get(2), 4));
        Shop.orders.add(new Order(customers.get(2), products.get(1), 10));
        Shop.orders.add(new Order(customers.get(1), products.get(0), 3));
        Shop.orders.add(new Order(customers.get(0), products.get(3), 6));
        Shop.orders.add(new Order(customers.get(1), products.get(5), 7));
        Shop.orders.add(new Order(customers.get(2), products.get(4), 2));

        Shop.orders.removeIf(Objects::isNull);
        System.out.println("Итоговое количество заказов = " + Shop.orders.size());
        ;

        // Определение текущего праздника (просто для примера)
        Holiday currentHoliday = getCurrentHoliday();

        // Поздравление сотрудников в зависимости от текущего праздника
        congratulateCustomers(Shop.customers, currentHoliday);
    }

    private static void congratulateCustomers(List<Customer> customers, Holiday holiday) {
        for (Customer customer : customers) {
            if (holiday == Holiday.newYear) {
                System.out.println("С Новым Годом, " + customer.getSurnameFirstNamePatronymic() + "!");
            } else if (holiday == Holiday.internationalWomensDay && !customer.isMale()) {
                System.out.println("С 8 Марта, " + customer.getSurnameFirstNamePatronymic() + "!");
            } else if (holiday == Holiday.defendersDay && customer.isMale()) {
                System.out.println("С 23 Февраля, " + customer.getSurnameFirstNamePatronymic() + "!");
            } else if (holiday == Holiday.noHoliday) {
                System.out.println("Сегодня не праздничный день");
                break;
            }
        }
    }

    private static Holiday getCurrentHoliday() {
        // Здесь также предположим, что сегодня 23 февраля
        return Holiday.defendersDay;
    }
}


