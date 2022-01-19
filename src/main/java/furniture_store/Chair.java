package furniture_store;

public class Chair extends Furniture implements Drawable{
    private int numberOfLegs;

    public Chair() {
        this(100,100,100,"black",4);
    }

    public Chair(int length, int width, int height, String color, int numberOfLegs) {
        super(length, width, height, color);
        this.numberOfLegs = numberOfLegs;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Chair:\n").append(super.toString());
        stringBuilder.append("Number of legs: ").append(this.numberOfLegs).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public void draw() {
        System.out.println("  i_______i");
        System.out.println("  I_______I");
        System.out.println("  I       I");
        System.out.println("  I_______I");
        System.out.println(" /       /I");
        System.out.println("(______(  I");
        System.out.println("I  I    I I");
        System.out.println("I       I");
        System.out.println();
    }
}
