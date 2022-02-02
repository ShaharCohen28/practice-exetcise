package api_exam_practice.bank.beans;

public class RegularClient extends Client{

    public RegularClient() {
        super((float) 0.05, new Account());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("regular client").append(super.toString());
        return stringBuilder.toString();
    }
}
