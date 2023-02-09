package by.teachmeskills.penkovsky.hw10.util;

public class StringUtils {
    public static String normalizationString(String inputString) {
        if (inputString.length() == 0) {
            return inputString;
        }
        inputString = inputString.trim();
        char[] newString = inputString.toCharArray();
        int count = 1;
        for (int i = 1; i < newString.length; i++) {
            if (!(Character.isWhitespace(newString[i - 1]) && Character.isWhitespace(newString[i]))) {
                newString[count++] = newString[i];
            }
        }
        return new String(newString, 0, count);
    }

    public static String hideBankCard(String bankCard) {
        int bankCardLength = 16;
        if (bankCard.length() != bankCardLength) {
            throw new IllegalArgumentException("Произошла ошибка! Проверьте введенные данные." +
                    "Минимальный размер номера банковской карты составляет 16 символов.");
        }
        if (bankCard.length() < 4) {
            return bankCard;
        } else {
            String newbankCardNumber = "";
            for (int i = 0; i < bankCard.length(); i++) {
                if (i > 4) {
                    newbankCardNumber += "*";
                }
            }
            newbankCardNumber += bankCard.substring(bankCard.length() - 4);
            return newbankCardNumber;
        }
    }

    public static String getAbbreviatedName(String surname, String name, String patronymic) {
        if (surname.length() == 0 || name.length() == 0) {
            throw new IllegalArgumentException("Уважаемый пользователь! Проверьте введенные данные");
        }
        if (patronymic.length() != 0) {
            return surname + " " + name.toUpperCase().charAt(0) + "." + patronymic.toUpperCase().charAt(0) + ".";
        }
        return surname + " " + name.toUpperCase().charAt(0) + ".";
    }

    public static boolean isBelarussianPassport(String numberOdPassport) {
        if (numberOdPassport.length() != 9) {
            throw new IllegalArgumentException("Уважаемый пользователь! Проверьте введенные данные");
        }
        char[] charNum = numberOdPassport.toCharArray();
        if ((charNum[0] >= 'A' && charNum[0] <= 'Z') || (charNum[0] >= 'a' && charNum[0] <= 'z')) {
            return true;
        }
        if ((charNum[1] >= 'A' && charNum[1] <= 'Z') || (charNum[1] >= 'a' && charNum[1] <= 'z')) {
            return true;
        }
        for (int i = 2; i < charNum.length; i++) {
            if (!Character.isDigit(charNum[i])) {
                //if (charNum[i] >= '0' || charNum[i] <= '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isReliablePassword(String password) {
        if (password.length() < 9) {
            throw new IllegalArgumentException("Уважаемый пользователь! Пароль не надежен");
        }
        char[] passwordToChar = password.toCharArray();
        int quantityOfUppercaseLetter = 0;
        int quantityOfLowerCaseLetter = 0;
        int quantityOfNumbers = 0;

        for (char c : passwordToChar) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'А' && c <= 'Я') || c == 'Ё')
                quantityOfUppercaseLetter++;
            else if ((c >= 'a' && c <= 'z') || (c >= 'а' && c <= 'я') || c == 'ё')
                quantityOfLowerCaseLetter++;
            else if (c >= '0' && c <= '9')
                quantityOfNumbers++;
        }

        return quantityOfNumbers >= 1 && quantityOfLowerCaseLetter >= 1 && quantityOfUppercaseLetter >= 1;
    }
}




