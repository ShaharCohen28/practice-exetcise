package homework.Targil1;

public class TestProduct {
    public static void main(String[] args) {
        Product product=new Product("something", 10.0);
        System.out.println(product.toString());
        System.out.println("product full price is: " + product.getPriceInculdingVat());
    }
}
