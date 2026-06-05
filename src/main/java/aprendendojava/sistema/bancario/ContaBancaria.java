/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package aprendendojava.sistema.bancario;

/**
 *
 * @author Anônimo
 */
public abstract class ContaBancaria implements Bloqueavel {
    private int numero;
    private String titular;
    private double saldo;
    private boolean ativa = true;
   
    public ContaBancaria(int numero, String titular, double saldo){
        this.numero = numero;
        setTitular(titular);
        this.saldo = saldo;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public String getTitular(){
        return titular;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void setTitular(String titular){
       if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O titular não pode ser nulo ou vazio.");
        }
            this.titular = titular;
    }
    
    public abstract double calcularRendimento();
    
    public void depositar(double valor)
            throws OperacaoInvalidaException {

        if (!ativa) {
            throw new OperacaoInvalidaException(
                    "Conta bloqueada.");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException(
                    "O valor do depósito deve ser maior que zero.");
        }

        saldo += valor;
    }
    
    public void sacar(double valor)
            throws OperacaoInvalidaException {

        if (!ativa) {
            throw new OperacaoInvalidaException(
                    "Conta bloqueada.");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException(
                    "O valor do saque deve ser maior que zero.");
        }

        if (valor > saldo) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente.");
        }

        saldo -= valor;
    }
    
      @Override
    public void bloquear() {
        ativa = false;
    }

    @Override
    public void desbloquear() {
        ativa = true;
    }

    @Override
    public boolean isAtiva() {
        return ativa;
    }
    
     protected void adicionarSaldo(double valor) {
        saldo += valor;
    }

    protected void removerSaldo(double valor) {
        saldo -= valor;
    }
}

