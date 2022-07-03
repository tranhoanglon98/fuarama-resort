package util.enterInformation;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Regex {
    private static final String NAME_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]*)+$";
    private static final String ID_REGEX = "^\\d{12}$";
    private static final String PHONE_NUMBER_REGEX = "^0[1-9]\\d{8}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z\\d]+@[a-zA-Z]+\\.[a-zA-Z]+$";
    private static final String EMPLOYEE_ID_REGEX = "^E-\\d{6}$";
    private static final String CUSTOMER_ID_REGEX = "^C-\\d{6}$";
    private static final String SERVICE_NAME_REGEX = "^[A-Z][a-z]+-\\d\\d+$";
    private static final String BOOKING_CODE_REGEX = "^BK-\\d{4}$";

    public static boolean checkNameFormat(String name) {
        return name.matches(NAME_REGEX);
    }

    public static boolean checkDayFormat(String date) {
        try {
                LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return true;
        } catch (DateTimeException e) {
            return false;
        }
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

    public static boolean checkServiceNameFormat(String serviceName){
        return serviceName.matches(SERVICE_NAME_REGEX);
    }

    public static boolean checkBookingCodeFormat(String bookingCode){
        return bookingCode.matches(BOOKING_CODE_REGEX);
    }
}
