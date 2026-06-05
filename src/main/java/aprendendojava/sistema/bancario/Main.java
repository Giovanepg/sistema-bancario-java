/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aprendendojava.sistema.bancario;

/**
 *
 * @author Anônimo
 */
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<ContaBancaria> contas = new ArrayList<>();
        contas.add(new ContaCorrente(1, "Joao", 1000.00));
        
        contas.add(new ContaPoupanca(2,"Maria",2000.00));

        contas.add(new ContaSalario(3,"Pedro",1500.00));

        System.out.println("=== RENDIMENTOS DAS CONTAS ===\n");

        for (ContaBancaria conta : contas) {
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Tipo: " + conta.getClass().getSimpleName());
            System.out.println("Saldo: R$ " + conta.getSaldo());
            System.out.println("Rendimento: R$ " + conta.calcularRendimento());

            System.out.println("----------------------------");
        }

        System.out.println(
                "\n=== TESTE DE SALDO INSUFICIENTE ===");

        try {
            ContaBancaria contaTeste = new ContaSalario(4, "Carlos", 500.00);
            contaTeste.sacar(1000.00);
            
        } catch (SaldoInsuficienteException e) {
            System.out.println("SaldoInsuficienteException capturada:");

            System.out.println(e.getMessage());

        } catch (OperacaoInvalidaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== TESTE DE CONTA BLOQUEADA ===");

        try {
            ContaBancaria contaTeste = new ContaCorrente(5,"Ana",1000.00);
            contaTeste.bloquear();
            contaTeste.depositar(500.00);

        } catch (OperacaoInvalidaException e) {
            System.out.println("OperacaoInvalidaException capturada:");
            System.out.println(e.getMessage());
        }
        System.out.println("\n=== FIM DOS TESTES ===");
    }
}