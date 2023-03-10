import by.teachmeskills.penkovsky.hw10.util.StringUtils;

import java.util.Scanner;
public class HomeWork10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println(
                """
                        Choose task:
                        1. normalizationString
                        2. formatCreditCardNumber
                        3. getAbbreviatedName
                        4. isBelarussianPassport
                        5. isStrongPassword
                        6. isValidEmail
                        0. Exit"""
        );
        while (true) {
            System.out.println("Task number: ");
            int taskNumber = scanner.nextInt();
            switch (taskNumber) {
                case 1 -> {
                    System.out.print("Введите строку: ");
                    String input = scan.nextLine();
                    String output = StringUtils.normalizationString(input);
                    System.out.println("Нормализованная строка: " + output);
                }
                case 2 -> {
                    System.out.println("Уважаемый пользователь, введите пожалуйста номер банковской карты: ");
                    String creditBankCard = scan.nextLine();
                    System.out.println("Уважаемый пользователь, введенный номер банковской карты представлен в замаскированном виде: ");
                    System.out.println(StringUtils.formatCreditCardNumber(creditBankCard));
                }
                case 3 -> {
                    System.out.print("Уважаемый пользователь, введите пожалуйста имя: ");
                    String name = scan.nextLine();
                    System.out.print(name + ", введите пожалуйста вашу фамилию: ");
                    String surname = scan.nextLine();
                    System.out.print(surname + " " + name + ", введите пожалуйста ваше отчество (если оно имеется): ");
                    String patronymic = scan.nextLine();
                    System.out.println(StringUtils.getAbbreviatedName(surname, name, patronymic));
                }
                case 4 -> {
                    System.out.print("Уважаемый пользователь, введите пожалуйста свой номер паспорта:  ");
                    String numberOdPassport = scan.nextLine();
                    System.out.println("Ваш паспорт является белорусским? " + "Ответ: " + StringUtils.PassportUtils.isBelarussianPassport(numberOdPassport));
                }
                case 5 -> {
                    System.out.print("Уважаемый пользователь, введите пожалуйста пароль:  ");
                    String password = scan.nextLine();
                    System.out.println("Ваш пароль является надежным? " + "Ответ: " + StringUtils.isStrongPassword(password));
                }
                case 6 -> {
                    System.out.print("Input email address: ");
                    String email = scan.nextLine();
                    System.out.println("Введенные данные является ли email адресом? " + "Ответ: " + StringUtils.isValidEmail(email));
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Введены некорректные данные");
            }
        }
    }
}


