package exercise;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private static Company singleInstance=null;
    private List<Employee> employees;
    private String name;

    private Company(String name){
        this.name=name;
    }

    public static Company getInstance(String name){
        if(singleInstance==null){
            singleInstance=new Company(name);
        }
        return singleInstance;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee){
        if(this.employees.isEmpty()){
            this.employees=new ArrayList<Employee>();
        }
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        int pointer=0;
        Employee temp=employees.get(pointer);
        while(temp!=null){
            if(temp.equals(employee)){
                break;
            }
            temp=employees.get(++pointer);
        }
        employees.remove(pointer);
    }

    public void printEmployees(){
        int pointer=0;
        Employee temp=this.employees.get(pointer);
        while(temp!=null){
            System.out.println(temp);
            temp=this.employees.get(++pointer);
        }
    }
}
