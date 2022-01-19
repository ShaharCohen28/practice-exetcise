package furniture_store;

public class Bed extends Furniture{
    private boolean isDoubleBed;

    public Bed() {
        this(MockFurniture.randomLength(),
                MockFurniture.randomWidth(),
                MockFurniture.randomHeight(),
                MockFurniture.randomColor(),
                MockFurniture.randomIsDoubleBed());
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
    public String draw() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ||\n");
        stringBuilder.append("   ||                  ||\n");
        stringBuilder.append("||/||____              ||\n");
        stringBuilder.append("|| /     )__________||_/|\n");
        stringBuilder.append("||/_____/_/_/_/_/_/_/||/|\n");
        stringBuilder.append("||(___)/_/_/_/_/_/__||  |\n");
        stringBuilder.append("||     |_|_|_|_|_|__|| /|\n");
        stringBuilder.append("||     |_|_|_|_|_|__||/||\n");
        stringBuilder.append("||~~~~~~~~~~~~~~~~~~||\n");
        stringBuilder.append("||                  ||\n");
        return stringBuilder.toString();
    }
}
