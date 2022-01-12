package exercise;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Company {
    //private static Company singleInstance=null;
    private List<Employee> employees = new ArrayList<>();
    private String name;
    private static final String pattern = "###,###.00";
    private static final DecimalFormat decimalFormat = new DecimalFormat(pattern);

    /*
    private Company(String name){
        this.name=name;
    }

    public static Company getInstance(String name){
        if(singleInstance==null){
            singleInstance=new Company(name);
        }
        return singleInstance;
    }

     */

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Company name: ");
        stringBuilder.append(this.name);
        stringBuilder.append("\n");
        for (Employee employee : this.employees) {
            stringBuilder.append(employee.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    private void checkException() throws CompanyReportException {
        if (this.employees.isEmpty()) {
            throw new CompanyReportException("The list of employees is empty", this.name, "Data Unavailable");
        }
        if (this.employees == null) {
            throw new CompanyReportException("The list of employees doesn't exist", this.name, "Data Unavailable");
        }
    }

    public String getAverageSalary() throws CompanyReportException {
        checkException();
        double sum = 0;
        for (Employee employee : this.employees) {
            sum += employee.getSalary();
        }
        return decimalFormat.format(sum / employees.size());
    }

    public String getManagementAverageSalary() throws CompanyReportException {
        checkException();
        double sum = 0;
        int count = 0;
        for (Employee employee : this.employees) {
            if (employee instanceof Manager) {
                sum += employee.getSalary();
                count++;
            }
        }
        return decimalFormat.format(sum / count);
    }

    public String getYearlyPayment() throws CompanyReportException {
        checkException();
        double totalMonthlySalary = 0;
        for (Employee employee : this.employees) {
            totalMonthlySalary += employee.getSalary();
        }
        return decimalFormat.format(12 * totalMonthlySalary);
    }

    public int getTotalNumOfEmployees() throws CompanyReportException {
        checkException();
        return this.employees.size();
    }

    public int getTotalNumOfManagers() throws CompanyReportException {
        checkException();
        int count = 0;
        for (Employee employee : this.employees) {
            if (employee instanceof Manager) {
                count++;
            }
        }
        return count;
    }
}
