package common.enterInformation;

public class Regex {
    private static final String NAME_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]*)+$";
    private static final String ID_REGEX = "^\\d{12}$";
    private static final String PHONE_NUMBER_REGEX = "^0[1-9]\\d{8}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z\\d]+@[a-zA-Z]+\\.[a-zA-Z]+$";
    private static final String EMPLOYEE_ID_REGEX = "^E-\\d{6}$";
    private static final String CUSTOMER_ID_REGEX = "^C-\\d{6}$";
    private static final String HOUSE_SERVICE_CODE_REGEX = "^SVHO-\\d{4}$";
    private static final String VILLA_SERVICE_CODE_REGEX = "^SVVL-\\d{4}$";
    private static final String ROOM_SERVICE_CODE_REGEX = "^SVRO-\\d{4}$";

    public static boolean checkNameFormat(String name) {
        return name.matches(NAME_REGEX);
    }

    public static Boolean checkIdFormat(String id) {
        return id.matches(ID_REGEX);
    }

    public static boolean checkPhoneNumberFormat(String phoneNumber) {
        return phoneNumber.matches(PHONE_NUMBER_REGEX);
    }

    public static boolean checkEmailFormat(String email){
        return email.matches(EMAIL_REGEX);
    }

    public static boolean checkEmployeeIdFormat(String employeeId){
        return employeeId.matches(EMPLOYEE_ID_REGEX);
    }

    public static boolean checkCustomerIdFormat(String customerId){
        return customerId.matches(CUSTOMER_ID_REGEX);
    }

    public static boolean checkServiceCodeFormat(String serviceCode,String service){
        boolean isRightFormat = false;
        switch (service){
            case "house":isRightFormat = serviceCode.matches(HOUSE_SERVICE_CODE_REGEX);break;
            case "villa":isRightFormat =serviceCode.matches(VILLA_SERVICE_CODE_REGEX);break;
            case "room":isRightFormat = serviceCode.matches(ROOM_SERVICE_CODE_REGEX);break;
        }
      return isRightFormat;
    }
}
