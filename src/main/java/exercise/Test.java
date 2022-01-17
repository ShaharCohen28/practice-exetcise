package exercise;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        final int EMPLOYEES_SIZE = 10;
        Company company = new Company("company :)");
        int random;
        //Employee temp=MockData.getMocKDate((int)(Math.random()*EMPLOYEES_SIZE));

        Employee[] employees = MockData.getMockData(new Employee[EMPLOYEES_SIZE]);
        Employee.printAll(employees);
        System.out.println("-------------------------");
        System.out.println("employees average salary: "+Employee.printAverageSalary(employees));
        System.out.println("minimum salary: "+Employee.MINIMUM_SALARY);
        System.out.println("management average salary: "+Employee.printManagementAverageSalary(employees));

        for (Employee employee : employees) {
            company.addEmployee(employee);
        }
        for (int counter = 0; counter < EMPLOYEES_SIZE; counter++) {
            company.addEmployee(MockData.createEmployee(counter));
        }
        System.out.println(company);

        random=(int)(Math.random()*EMPLOYEES_SIZE);
        System.out.println("Employee removed at place " + random);
        company.removeEmployee(company.getEmployees().get(random));


        try {
            System.out.println("Total employees: " + company.getTotalNumOfEmployees());
            System.out.println("Average salary: " + company.getAverageSalary());
            System.out.println("Total mangers: " + company.getTotalNumOfManagers());
            System.out.println("Management average salary: " + company.getManagementAverageSalary());
            System.out.println("Yearly payment: " + company.getYearlyPayment());
            System.out.println("----------------------------");
            System.out.println(company);
        }catch (CompanyReportException err){
            System.out.println("Hello " + err.getCompanyName() + "\n" + err.getReportName() + "\n" + err.getMessage());
        }


    }
}
