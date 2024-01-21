package br.com.dev.teste;

import br.com.dev.entity.Address;
import br.com.dev.entity.Department;
import br.com.dev.entity.Employee;

import java.util.Locale;
import java.util.Scanner;
import java.util.function.DoubleFunction;

public class main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner leitor = new Scanner(System.in);
        System.out.print("Nome do Departamento: ");
        String nomeDepartamento = leitor.next();
        System.out.print("Dia do Pagamento: ");
        int diaPagamento = leitor.nextInt();
        System.out.print("Email: ");
        String email = leitor.next();
        System.out.print("Telefone: ");
        String telefone = leitor.next();

        Department departamento = new Department(nomeDepartamento, diaPagamento, new Address(email, telefone));

        System.out.print("Quantos funcionários tem o departamento? ");
        int qdtDepartamento = leitor.nextInt();

        for (int i = 1; i <= qdtDepartamento; i++){
            departamento.addEmployee(createEmployee(leitor, i));
        }

        leitor.close();
        showReport(departamento);
    }

    private static void showReport(Department departamento) {
        System.out.println("\nFOLHA DE PAGAMENTO");
        System.out.printf("Departamento %s = R$ %.2f", departamento.getNome(), departamento.payRoll());
        System.out.printf("\nPagamento realizado no dia %d", departamento.getPayDay());
        System.out.println("\nFuncionários:");
        for (Employee employee : departamento.getEmployees()){
            System.out.println(employee.getName());
        }

        System.out.println("Para dúvidas favor entrar em contato: " + departamento.getAddress().getEmail());
    }

    public static Employee createEmployee(Scanner leitor, int i){
        System.out.printf("Dados funcionario %d\n", i);
        System.out.print("Nome: ");
        leitor.nextLine();
        String nome = leitor.nextLine();
        System.out.print("Salário: ");
        double salario = leitor.nextDouble();

        return new Employee(nome, salario);
    }
}
