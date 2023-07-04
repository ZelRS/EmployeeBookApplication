package skypro.course2.hw6.model;


import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private Integer numOfDepartment;
    private int salary;


    public Employee(Integer numOfDepartment, String firstName, String lastName, int salary) {
        this.numOfDepartment = numOfDepartment;
        this.firstName = firstName;
        this.lastName = lastName;
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
        if (numOfDepartment < 1 || numOfDepartment > 5) {
            throw new IllegalArgumentException("Такого отдела не существует!");
        }
        this.numOfDepartment = numOfDepartment;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nРаботник: " + firstName + " " + lastName + ". Зарплата: " + salary
                + " руб. в месяц\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}