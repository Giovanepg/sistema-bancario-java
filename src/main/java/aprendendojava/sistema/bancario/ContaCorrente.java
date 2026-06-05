/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aprendendojava.sistema.bancario;

/**
 *
 * @author Anônimo
 */
public class ContaCorrente extends ContaBancaria
        implements Tributavel {

    private static final double LIMITE_CHEQUE_ESPECIAL = 1000.0;

    public ContaCorrente(int numero,String titular, double saldo) {
        super(numero, titular, saldo);
    }

    @Override
    public double calcularRendimento() {
        return 0;
    }

    @Override
    public double calcularImposto() {
        return getSaldo() * 0.0038;
    }

    @Override
    public void sacar(double valor)
            throws OperacaoInvalidaException {

        if (!isAtiva()) {
            throw new OperacaoInvalidaException("Conta bloqueada.");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser maior que zero.");
        }

        if (valor > getSaldo() + LIMITE_CHEQUE_ESPECIAL) {
            throw new SaldoInsuficienteException("Limite do cheque especial excedido.");
        }

        removerSaldo(valor);
    }
}
