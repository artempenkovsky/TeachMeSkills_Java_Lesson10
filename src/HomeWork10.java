import by.teachmeskills.penkovsky.hw10.util.StringUtils;
import java.util.Scanner;
public class HomeWork10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Уважаемый пользователь, введите номер задачи согласно списку: ");
        System.out.println("Задача 1");
        System.out.println("Задача 2");
        System.out.println("Задача 3");
        System.out.println("Задача 4");
        System.out.println("Задача 5");
        System.out.println("Задача 6");

        int task = scanner.nextInt();
        Scanner scan = new Scanner(System.in);
        if (task >= 1 && task <= 6) {
            switch (task) {
                case 1 -> {
                    System.out.println("Уважаемый пользователь, введите пожалуйста строковые данные: ");
                    String inputString = scan.nextLine();
                    System.out.print("Возвращаемое значение:\n");
                    System.out.println(StringUtils.normalizationString(inputString));
                }
                case 2 -> {
                    System.out.println("Уважаемый пользователь, введите пожалуйста номер банковской карты: ");
                    String bankCard = scan.nextLine();
                    System.out.println("Уважаемый пользователь, введенный номер банковской карты представлен в замаскированном виде: ");
                    System.out.println(StringUtils.hideBankCard(bankCard));
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
                    System.out.println("Ваш паспорт является белорусским? " + "Ответ: " + StringUtils.isBelarussianPassport(numberOdPassport));
                }
                case 5 -> {
                    System.out.print("Уважаемый пользователь, введите пожалуйста пароль:  ");
                    String password = scan.nextLine();
                    System.out.println("Ваш паспорт является белорусским? " + "Ответ: " + StringUtils.isReliablePassword(password));


                }
                default -> System.out.println("This number doesn't exist. Enter number from 1 to 6");
            }
        }
    }
}


