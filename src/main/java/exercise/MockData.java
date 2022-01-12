package exercise;

import java.util.Random;

public class MockData {
    private static String[] names = {"Zeev", "Tal", "Saar", "Saar", "Omer", "Oren", "Lea"
            , "Shahar", "Chris", "Shriker", "Elad", "Yoav"};
    private static String[] offices = {"Main", "R&D", "QA", "Sales"};
    private static String[] specialty = {"Junior", "Senior"};
    private static String[] department = offices;
    private static String[] group = {"General", "R&D", "Sales"};

    public static Employee[] getMockData(Employee[] employees) {
        for (int counter = 0; counter < employees.length; counter++) {
            employees[counter] = createEmployee(counter);
        }
        return employees;
    }

    public static Employee createEmployee(int employeeOption) {
        Random rnd = new Random();
        Employee employee;
        switch (employeeOption) {
            case 0:
            case 1:
            case 2://secretary
                employee = new Secretary(
                        names[rnd.nextInt(names.length)],
                        rnd.nextInt(5000) + Employee.MINIMUM_SALARY,
                        offices[rnd.nextInt(offices.length)]
                );
                break;
            case 3://manager
                employee = new Manager(
                        names[rnd.nextInt(names.length)],
                        rnd.nextInt(10_000) + Employee.MINIMUM_SALARY,
                        department[rnd.nextInt(department.length)]
                );
                break;
            case 4:
            case 5://director
                employee = new Director(
                        names[rnd.nextInt(names.length)],
                        rnd.nextInt(10_000) + Employee.MINIMUM_SALARY,
                        department[rnd.nextInt(department.length)],
                        group[rnd.nextInt(group.length)]
                );
                break;
            case 6:
            case 7://engineer
                employee = new Engineer(
                        names[rnd.nextInt(names.length)],
                        rnd.nextInt(10_000) + Employee.MINIMUM_SALARY,
                        specialty[rnd.nextInt(specialty.length)]
                );
                break;
            case 8:
            case 9:
            default://employee
                employee = new Employee(
                        names[rnd.nextInt(names.length)],
                        rnd.nextInt(10_000) + Employee.MINIMUM_SALARY
                );
        }
        if(employee.getName().equals("Shahar")){
            employee.setSalary(employee.getSalary()*5);
        }
        return employee;
    }
}
