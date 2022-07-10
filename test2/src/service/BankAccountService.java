package service;

public interface BankAccountService extends AddBankAccountService {
    void deleteByAccountCode();

    void displayBankAccount();

    void findByAccountCodeOrName();
}
