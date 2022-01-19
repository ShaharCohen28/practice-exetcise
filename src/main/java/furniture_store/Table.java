package furniture_store;

public class Table extends Furniture implements Drawable{
    private int numberOfSeats;

    public Table() {
        this(100,100,100,"black",6);
    }

    public Table(int length, int width, int height, String color, int numberOfSeats) {
        super(length, width, height, color);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Table:\n").append(super.toString());
        stringBuilder.append("Number of seats: ").append(this.numberOfSeats).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public void draw() {
        System.out.println("   =====================");
        System.out.println("  /                   /");
        System.out.println(" /                   /|");
        System.out.println("===================== |");
        System.out.println(" | |               |  |");
        System.out.println(" | |               |  |");
        System.out.println(" | |               |  |");
        System.out.println(" |                 |");
        System.out.println(" |                 |");
        System.out.println(" |                 |");
        System.out.println();
    }
}
