package api_exam_practice.bank.beans;

public class Account {
    private double balance;

    public Account() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("account balance: ").append(this.balance).append("\n");
        return stringBuilder.toString();
    }
}
