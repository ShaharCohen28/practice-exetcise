package furniture_store;

public class Bed extends Furniture implements Drawable{
    private boolean isDoubleBed;

    public Bed() {
        this(100,100,100,"black",true);
    }

    public Bed(int length, int width, int height, String color, boolean isDoubleBed) {
        super(length, width, height, color);
        this.isDoubleBed=isDoubleBed;
    }

    public boolean isDoubleBed() {
        return isDoubleBed;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Bed:\n").append(super.toString());
        stringBuilder.append("The bed is ").append(this.isDoubleBed?"double bed":"single bed").append("\n");
        return stringBuilder.toString();
    }

    @Override
    public void draw() {
        System.out.println("   ||");
        System.out.println("   ||                  ||");
        System.out.println("||/||____              ||");
        System.out.println("|| /     )__________||_/|");
        System.out.println("||/_____/_/_/_/_/_/_/||/|");
        System.out.println("||(___)/_/_/_/_/_/__||  |");
        System.out.println("||     |_|_|_|_|_|__|| /|");
        System.out.println("||     |_|_|_|_|_|__||/||");
        System.out.println("||~~~~~~~~~~~~~~~~~~||");
        System.out.println("||                  ||");
        System.out.println();
    }
}
