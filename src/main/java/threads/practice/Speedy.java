package threads.practice;

public class Speedy implements Runnable {
    private String name;
    private boolean flag;
    private Speedy enemy;

    public Speedy(String name,Speedy enemy) {
        this.name=name;
        setEnemy(enemy);
        this.flag = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public Speedy getEnemy() {
        return enemy;
    }

    public void setEnemy(Speedy enemy) {
        this.enemy = enemy;
    }

    public void stopFlag() {
        this.flag = true;
    }

    @Override
    public void run() {
        /*
        int counter=1, sleepTime;
        while (!flag&&counter<=100){
            System.out.println(counter++);
            sleepTime=(int)(Math.random()*1000);
            System.out.println("going to sleep for " + sleepTime + " ms");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
         */
        for (int counter = 0; counter < 100; counter++) {
            if (flag) {
                break;
            }
            System.out.println(this.name + ": "+(counter+1));
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(!this.flag) {
            this.getEnemy().stopFlag();
        }
    }

    public static Speedy theLoser(Speedy speedy1, Speedy speedy2) {
        if (speedy1.flag) {
            return speedy1;
        }else if(speedy2.flag){
           return speedy2;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("speedy name: ").append(this.name).append("\n");
        stringBuilder.append("flag: ").append(this.flag).append("\n");
        stringBuilder.append("enemy name: ").append(this.enemy.name).append("\n");
        return stringBuilder.toString();
    }
}
