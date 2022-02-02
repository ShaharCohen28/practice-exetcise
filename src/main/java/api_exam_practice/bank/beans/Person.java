package api_exam_practice.bank.beans;

public abstract class Person {
    private static int counter = 1;
    protected int id;
    protected String name;
    protected double age;

    public static int totalUsers=0;
    public static double totalSum=0;

    public Person() {
        this.id = counter++;
        this.name = "Client " + id;
        this.age=(Math.random()*104)+16;
        totalUsers++;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ").append(this.id).append(" ");
        stringBuilder.append("name: ").append(this.name).append(" ");
        stringBuilder.append("age: ").append(this.age).append("\n");
        return stringBuilder.toString();
    }
}
