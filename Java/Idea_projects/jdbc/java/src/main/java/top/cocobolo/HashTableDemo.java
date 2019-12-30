package top.cocobolo;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(3);
        Scanner in = new Scanner(System.in);
        char key ;
        while(true){
            System.out.println("a: add   添加雇员");
            System.out.println("l: list  遍历整个雇员表");
            System.out.println("e: exit  退出");
            System.out.println("f: find  根据id查找雇员信息");
            key = in.next().charAt(0);
            switch (key){
                case 'a':
                    System.out.println("输入id:");
                    int id = in.nextInt();
                    System.out.println("输入name:");
                    String name = in.next();
                    Employee emp = new Employee(id,name);
                    hashTable.add(emp);
                    break;
                case 'l':
                    hashTable.traversal();
                    break;
                case 'f':
                    System.out.println("输入待查找id:");
                    int idToFind = in.nextInt();
                    if(hashTable.findEmpById(idToFind) == null){
                        System.out.println("未找到id为"+idToFind+"的雇员");
                    }else{
                        System.out.println("id为"+idToFind+"的雇员信息为"+hashTable.findEmpById(idToFind));
                    }
                    break;
                default:
                    return;
            }

        }
    }
}

class HashTable{

    private EmployeeList[] table;
    private int size;

    public HashTable(int size){
        // 重要! 此时只是创建了一个数组 但每个元素都是null
        table = new EmployeeList[size];
        this.size=size;
        for (int i = 0; i < size; i++) {
            //此时才把数组中每一个链表初始化了
            table[i] = new EmployeeList();
        }
    }

    public void add(Employee emp){
        int index = getIndex(emp);
        table[index].add(emp);
    }

    public int getIndex(Employee emp){
        return emp.id%size;
    }

    public void traversal(){
        for (int i = 0; i < size; i++) {
            table[i].traversal(i);
        }
    }

    public Employee findEmpById(int id){
        return table[id%size].findEmpById(id);
    }
}

class EmployeeList{
    private Employee head;

    public void add(Employee emp){
        if(head == null){
            head = emp;
            return;
        }
        Employee p = head;
        while(p.next != null){
            p = p.next;
        }
        p.next = emp;
    }

    public void traversal(int i){
        if(head == null){
            System.out.println("第"+(i+1)+"条链表为空.");
            return;
        }
        System.out.print("第"+(i+1)+"条链表信息为:");
        Employee p = head;
        while(p != null){
            System.out.print("->"+p);
            p = p.next;
        }
        System.out.println();
    }

    public Employee findEmpById(int id){
        boolean found = false;
        Employee p = head;
        while(p != null){
            if(p.id == id){
                found = true;
                break;
            }else{
                p = p.next;
            }
        }
        if(found){
            return p;
        }else {
            return null;
        }
    }
}

class Employee{
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
