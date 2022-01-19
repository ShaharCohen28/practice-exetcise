package furniture_store;

public abstract class Furniture implements Drawable {
    protected int length;
    protected int width;
    protected int height;
    protected String color;

    public Furniture(){
        this(100,100,100,"black");
    }

    public Furniture(int length, int width, int height, String color) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Length: ").append(this.length).append("\n");
        stringBuilder.append("Width: ").append(this.width).append("\n");
        stringBuilder.append("Height: ").append(this.height).append("\n");
        stringBuilder.append("Color: ").append(this.color).append("\n");
        return stringBuilder.toString();
    }
}
