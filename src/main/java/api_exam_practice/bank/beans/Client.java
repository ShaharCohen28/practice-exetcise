package api_exam_practice.bank.beans;

public abstract class Client extends Person{
    protected float interestRate;
    protected Account account;

    public Client(float interestRate, Account account) {
        this.interestRate = interestRate;
        this.account = account;
    }

    public float getInterestRate() {
        return interestRate;
    }

    protected void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("interest rate: ").append(this.interestRate).append("\n");
        stringBuilder.append(this.account.toString());
        return stringBuilder.toString();
    }
}
