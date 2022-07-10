package common;

public class NotFoundBankAccountException extends Exception{

    public NotFoundBankAccountException() {
    }

    public NotFoundBankAccountException(String message) {
        super(message);
    }
}
