package company;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import static java.util.Collections.sort;

public class Manager extends Employee {
    private double bonus = 0.0;

    public Manager(String name , double salary, int year, int month , int day){
        super(name, salary, year, month, day);
        this.bonus = 0d;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public Double getSalary() {
        return super.getSalary()+bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Double.valueOf(bonus).equals(Double.valueOf(manager.bonus));
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonus);
    }

    @Override
    public String toString() {
        return super.toString()+"Manager{" +
                "bonus=" + bonus +
                '}';
    }

    @Override
    public int compareTo(Object otherObject) {
        Manager other = (Manager) otherObject;
        return Double.compare(this.getSalary(), other.getSalary());
    }

    public static void main(String[] args){
        Manager manager = new Manager("lz",12000,2019,5,15);
        manager.setBonus(2000);
        Employee[] staff = new Employee[3];
        staff[0] = (Employee) manager;
        manager.setBonus(200);
        //staff[0].setBonus(300d);
        System.out.println(staff[0].getSalary());//动态绑定
        ArrayList<Manager> managers= new ArrayList<>(2);
        managers.add(new Manager("lz",10000,2019,5,15));
        managers.add(new Manager("tq",16666,2019,5,15));
        managers.get(5).setBonus(7777);
        System.out.println(managers);
        sort(managers);
        System.out.println(managers);


    }
}
