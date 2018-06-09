package pl.coderslab.wzorce;

//facade demo

public class AtmApi {
private BankAccount bankAccount;
private Transfer transfer;
private PhoneCard phoneCard;
private Loan loan;

    public AtmApi(BankAccount bankAccount, Transfer transfer, PhoneCard phoneCard, Loan loan) {
        this.bankAccount = bankAccount;
        this.transfer = transfer;
        this.phoneCard = phoneCard;
        this.loan = loan;
    }

    public void deposit(){
        this.bankAccount.deposit();
    }
    public void payOut(){
        this.bankAccount.payOut();
    }
    public void transferMoney(){
        this.transfer.transferMoney();
    }
    public void recharge() {
        this.phoneCard.recharge();
    }
    public void getLoan() {
        this.loan.getLoan();
    }

}
