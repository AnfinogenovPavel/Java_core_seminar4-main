# Java Core (семинары)

![Java Core](https://github.com/AnfinogenovPavel/Java_core_seminar5-main/blob/main/src/main/resources/Java_core.jpg)

## Урок 4. Обработка исключений


### Задача 1.

В класс покупателя добавить перечисление с гендерами, внедрить Lombok https://habr.com/ru/articles/345520/

#### Решение

Для начала необходимо добавить плагины lombok в IDE. В моей версии Intellij IDEA они добавлены и включены:


Затем добавляем необходимый блок кода в файл pom.mxl:

```xml
<dependencies>
	<dependency>
		<groupId>org.projectlombok</groupId>
		<artifactId>lombok</artifactId>
		<version>1.18.30</version>
		<scope>provided</scope>
	</dependency>
</dependencies>
```

После обновления Maven должно получиться так:

![Lombok XML](https://github.com/AnfinogenovPavel/Java_core_seminar4-main/blob/main/src/main/resources/LombokXML.png)

Далее добавляем четвертое поле gender, а так же пишем метод проверки муж/жен:

![Added Gender](https://github.com/AnfinogenovPavel/Java_core_seminar4-main/blob/main/src/main/resources/AddedGender.png)

*+*

<details>

  <summary>Нажмите, чтобы открыть КОД</summary>

```java
package Shop;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Customer {
    private String surnameFirstNamePatronymic;
    private int age;
    private String phone;
    private String gender;

    public boolean isMale() {
        return "муж".equalsIgnoreCase(gender);
    }
}

```

</details>

А так же не забываем заполнить вновь добавленное поле в Main:

![Added Gender 2](https://github.com/AnfinogenovPavel/Java_core_seminar4-main/blob/main/src/main/resources/AddedGender2.png)

---


### Задача 2.

Добавить в основную программу перечисление с праздниками (нет праздника, Новый Год, 8 марта, 23 февраля), написать метод, принимающий массив покупателей, поздравляющий всех сотрудников с Новым Годом, женщин с 8 марта, а мужчин с 23 февраля, если сегодня соответствующий день.

#### Решение

В классе Main добавляем нумерованный список с праздниками:

![Added Holiday](https://github.com/AnfinogenovPavel/Java_core_seminar4-main/blob/main/src/main/resources/AddedHoliday.png)

Далее добавляем определение текущего праздника и поздравление сотрудников в зависимости от текущего праздника. 
А после пишем метод поздравления покупателей, в зависимости от пола и праздника:

![Congratulate Customers](https://github.com/AnfinogenovPavel/Java_core_seminar4-main/blob/main/src/main/resources/CongratulateCustomers.png)

<details>

  <summary>Нажмите, чтобы открыть КОД</summary>

```java
        // Определение текущего праздника (просто для примера)
        Holiday currentHoliday = getCurrentHoliday();

        // Поздравление сотрудников в зависимости от текущего праздника
        congratulateCustomers(Shop.customers, currentHoliday);

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
```
</details>

Ниже прописываем метод, который будет возвращать текущий праздник или его отсутствие:

![Get Current Day](https://github.com/AnfinogenovPavel/Java_core_seminar4-main/blob/main/src/main/resources/GetCurrentDay.png)

<details>

  <summary>Нажмите, чтобы открыть КОД</summary>

```java
    private static Holiday getCurrentHoliday() {
    // Здесь также предположим, что сегодня 23 февраля
    return Holiday.defendersDay;
}
```

Все готово. Проверяем работу внесенных изменений:

<details>

<summary>Нажмите, чтобы открыть СКРИНШОТЫ ПРОВЕРОК</summary>

![NoHoliday](https://raw.githubusercontent.com/Terekhov-A-S/Java_core_seminar4/main/src/main/resources/NoHoliday.png)
![defendersDay](https://raw.githubusercontent.com/Terekhov-A-S/Java_core_seminar4/main/src/main/resources/23f.png)
![internationalWomensDay](https://raw.githubusercontent.com/Terekhov-A-S/Java_core_seminar4/main/src/main/resources/8m.png)

</details>
