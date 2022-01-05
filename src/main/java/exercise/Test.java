package exercise;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Company company=Company.getInstance("company :)");
        Employee[] employees = new Employee[10];
        /*
        employees[0] = new Secretary("csdc", 23424, "grgreg");
        employees[1] = new Secretary("cds", 4242, " ddcs");
        employees[2] = new Manager("Sfsdfs", 223453, "stst");
        employees[3] = new Manager("vegsrvs", 35354, "frsw");
        employees[4] = new Employee("sfsfs", 4243);
        employees[5] = new Employee("afsafds", 3243);
        employees[6] = new Employee("dsdscd", 543542);
        employees[7] = new Director("ssfds", 5433453, "rsfsvs", "rwfrww");
        employees[8] = new Engineer("fdgds", 3424, "dfgeg");
        employees[9] = new Engineer("ssfsf", 43242, "dsfsf");
         */

        for (int index = 0; index <employees.length ; index++) {
            addEmployee(employees,index);
        }

        printEmployeesDetails(employees);
        printAverageSalary(employees);
        printManagementAverageSalary(employees);

    }

    public static void printEmployeesDetails(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void printAverageSalary(Employee[] employees) {
        double sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
            count++;
        }
        System.out.println("The average salary is " + sum / count);
    }

    public static void printManagementAverageSalary(Employee[] employees) {
        double sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                sum += employee.getSalary();
                count++;
            }
        }
        try {
            System.out.println("The average management salary is " + sum / count);
        } catch (ArithmeticException err) {
            System.out.println("No managers");
        }

    }

    public static void addEmployee(Employee[] employees, int index){
        Scanner input=new Scanner(System.in);
        String name, secondaryOption, directorOption;
        double salary;
        int option;
        boolean isOK=false;

        System.out.println("Please enter employee name");
        name= input.next();
        System.out.println("Please enter employee's salary");
        salary=input.nextDouble();
        System.out.println("1- add regular employee" +
                "\n2- add secretary" +
                "\n3- add engineer" +
                "\n4- add manager" +
                "\n5- add director");
        option= input.nextInt();
        do{
            switch (option){
                case 1:
                    employees[index]=new Employee(name,salary);
                    isOK=true;
                    break;
                case 2:
                    System.out.println("Please enter secretary's  office");
                    secondaryOption=input.next();
                    employees[index]=new Secretary(name,salary,secondaryOption);
                    isOK=true;
                    break;
                case 3:
                    System.out.println("Please enter engineer's speciality");
                    secondaryOption=input.next();
                    employees[index]=new Engineer(name,salary,secondaryOption);
                    isOK=true;
                    break;
                case 4:
                    System.out.println("Please enter manager's department");
                    secondaryOption=input.next();
                    employees[index]=new Manager(name,salary,secondaryOption);
                    isOK=true;
                    break;
                case 5:
                    System.out.println("Please enter director's department");
                    secondaryOption=input.next();
                    System.out.println("Please enter director's group");
                    directorOption=input.next();
                    employees[index]=new Director(name,salary,secondaryOption, directorOption);
                    isOK=true;
                    break;
                default:
                    System.out.println("Invalid input, try again");
            }
        }while(!isOK);

    }
}
