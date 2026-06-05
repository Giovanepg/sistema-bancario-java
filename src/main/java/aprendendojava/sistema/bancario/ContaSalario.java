/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aprendendojava.sistema.bancario;

/**
 *
 * @author Anônimo
 */
public class ContaSalario extends ContaBancaria {

    public ContaSalario(int numero, String titular,double saldo) {
        super(numero, titular, saldo);
    }

    @Override
    public double calcularRendimento() {
        return 0;
    }
}
