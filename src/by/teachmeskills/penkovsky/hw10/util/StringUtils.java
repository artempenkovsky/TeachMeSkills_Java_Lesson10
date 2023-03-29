package by.teachmeskills.penkovsky.hw10.util;

public class StringUtils {
    public static String normalizationString(String inputString) {
        inputString = inputString.trim();
        inputString = inputString.replaceAll("\\s+", " ");
        return inputString;
    }

    public static String formatCreditCardNumber(String creditCardNumber) {
        int creditCardNumberLength = 16;
        if (creditCardNumber.length() != creditCardNumberLength) {
            throw new IllegalArgumentException("Произошла ошибка! Проверьте введенные данные." +
                    "Минимальный размер номера банковской карты составляет 16 символов.");
        }
        String maskedCreditCardNumber = "**** ** ** " + creditCardNumber.substring(12);

        return maskedCreditCardNumber;
    }

    public static String getAbbreviatedName(String lastName, String firstName, String patronymic) {
        if (lastName.length() == 0 || firstName.length() == 0) {
            throw new IllegalArgumentException("Уважаемый пользователь! Проверьте введенные данные");
        }
        String initials = "";
        if (!patronymic.isEmpty()) {
            initials = " " + patronymic.charAt(0) + ".";
        }
        String fullName = lastName + " " + firstName.charAt(0) + ".";
        if (!initials.isEmpty()) {
            fullName += initials;
        }
        return fullName;
    }

    public class PassportUtils {
        public static final int PASSPORT_SERIES_LENGTH = 2;
        public static final int PASSPORT_DIGITS_LENGTH = 7;
        public static final int PASSPORT_NUMBER_LENGTH = PASSPORT_SERIES_LENGTH + PASSPORT_DIGITS_LENGTH;

        public static boolean isBelarussianPassport(String numberOfPassport) {
            if (numberOfPassport.length() != PASSPORT_NUMBER_LENGTH) {
                return false;
            }
            for (int i = 0; i < PASSPORT_SERIES_LENGTH; i++) {
                char c = numberOfPassport.charAt(i);
                if (c < 'A' || c > 'Z') {
                    return false;
                }
            }
            for (int i = PASSPORT_SERIES_LENGTH; i < PASSPORT_NUMBER_LENGTH; i++) {
                char c = numberOfPassport.charAt(i);
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (hasLowerCase && hasUpperCase && hasDigit) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        if (email.contains(" ")) {
            return false;
        }
        int atSymbolCount = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                atSymbolCount++;
            }
        }
        if (atSymbolCount != 1) {
            return false;
        }
        int atSymbolIndex = email.indexOf('@');
        if (atSymbolIndex == 0 || atSymbolIndex == email.length() - 1) {
            return false;
        }
        if (email.charAt(atSymbolIndex - 1) == email.charAt(atSymbolIndex + 1)) {
            return true;
        }
        return true;
    }
}




