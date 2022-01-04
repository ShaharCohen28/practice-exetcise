package exercise;

public class Test {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
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
        double sum = 0, count = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
            count++;
        }
        System.out.println("The average salary is " + sum / count);
    }

    public static void printManagementAverageSalary(Employee[] employees) {
        double sum = 0, count = 0;
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
}
