package skypro.course2.employeeBook.model;


import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static skypro.course2.employeeBook.service.impl.EmployeeServiceImpl.numOfDepValidation;

public class Employee {
    private final String firstName;
    private final String lastName;
    private Integer numOfDepartment;
    private int salary;


    public Employee(Integer numOfDepartment, String firstName, String lastName, int salary) {
        numOfDepValidation(numOfDepartment);
        this.numOfDepartment = numOfDepartment;
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getNumOfDepartment() {
        return numOfDepartment;
    }

    public int getSalary() {
        return salary;
    }

    public void setNumOfDepartment(Integer numOfDepartment) {
        numOfDepValidation(numOfDepartment);
        this.numOfDepartment = numOfDepartment;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numOfDepartment=" + numOfDepartment +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(numOfDepartment, employee.numOfDepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, numOfDepartment, salary);
    }
}