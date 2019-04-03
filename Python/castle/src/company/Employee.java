package company;

import java.time.LocalDate;

public class Employee implements Comparable {
    private String name;
    private double salary;
    private LocalDate hireDay;


    public Employee(String name , Double salary, int year, int month , int day){
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }

    public String getName(){
        return this.name;
    }

    public Double getSalary(){
        return this.salary;
    }

    public LocalDate getHireDay(){
        return this.hireDay;
    }


    @Override
    public int compareTo(Object otherObject) {
        Employee other = (Employee) otherObject;
        return Double.compare(this.salary,other.salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
