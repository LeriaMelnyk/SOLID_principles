package ua.edu.chnu.kkn.solid_violation.srp;

public class AccountService {


    private TransactionRepository transactionRepository;
    private Clock clock;


    public AccountService(TransactionRepository transactionRepository, Clock clock, Console console) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;

    }

    public void deposit(int amount) {
        transactionRepository.add(transactionWith(amount));
    }


    public void withdraw(int amount) {
        transactionRepository.add(transactionWith(-amount));
    }


    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }

}
