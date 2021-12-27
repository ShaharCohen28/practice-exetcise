package ObjectsPractice.Targil1;

import java.util.Arrays;

public class College {
    private String name;
    private int numOfLecturers;
    private Lecturer[] allLecturers;

    public  College(String name, int maxLecturers){
        setName(name);
        allLecturers=new Lecturer[maxLecturers];
        numOfLecturers=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfLecturers() {
        return numOfLecturers;
    }

    public int getMaxLecturers(){
        return allLecturers.length;
    }

    public boolean addLecturer(Lecturer lecturer){
        if(numOfLecturers==allLecturers.length){
            return false;
        }
        allLecturers[numOfLecturers]=lecturer;
        numOfLecturers++;
        return true;
    }

    public void sortByPenFalls(){
        Lecturer temp;
        for (int i = 0; i <numOfLecturers ; i++) {
            for (int j = 0; j <numOfLecturers-i-1 ; j++) {
                if(allLecturers[j].getNumOfTimesPenFalls()>allLecturers[j+1].getNumOfTimesPenFalls()){
                    temp=allLecturers[j+1];
                    allLecturers[j+1]=allLecturers[j];
                    allLecturers[j]=temp;
                }
            }
        }
    }



    @Override
    public String toString() {
        return "College{" +
                "name='" + name + '\'' +
                ", numOfLecturers=" + numOfLecturers +
                "\nallLecturers=" + Arrays.toString(allLecturers) +
                '}';
    }
}
