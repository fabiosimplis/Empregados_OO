package br.com.dev.entity;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String nome;
    private int payDay;
    private Address address;
    private List<Employee> employees = new ArrayList<>();

    public Department(String nome, int payDay, Address address) {
        this.nome = nome;
        this.payDay = payDay;
        this.address = address;
    }

    public String getNome() {
        return nome;
    }

    public int getPayDay() {
        return payDay;
    }

    public Address getAddress() {
        return address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    public double payRoll(){

        if (employees.isEmpty()){
            System.out.println("Não há funcionários cadastrados!!!");
            return 0.00;
        }
        double total = 0.00;
        for(Employee employee : employees){
            total += employee.getSalary();
        }

        return total;
    }
}
