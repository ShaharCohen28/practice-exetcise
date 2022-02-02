package api_exam_practice.bank.beans;

public class VipClient extends Client{

    public VipClient() {
        super((float)0.1, new Account());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("vip client").append(super.toString());
        return stringBuilder.toString();
    }
}
