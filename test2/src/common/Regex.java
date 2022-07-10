package common;

public class Regex {
    private static final String NAME_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]*)+$";
    private static final String ACCOUNT_CODE_REGEX = "^\\d{9}$";
    private static final String CARD_NUMBER_REGEX = "^\\d{16}$";


    public static boolean checkNameFormat(String name){
        return name.matches(NAME_REGEX);
    }

    public static boolean checkAccountCodeFormat(String accountCode){
        return accountCode.matches(ACCOUNT_CODE_REGEX);
    }

    public static boolean checkCardNumberFormat(String cardNumber){
        return cardNumber.matches(CARD_NUMBER_REGEX);
    }

}
