package dev.janssenbatista.models;

import dev.janssenbatista.exceptions.SaldoInsuficienteException;
import dev.janssenbatista.exceptions.ValorInvalidoException;
import lombok.Getter;

@Getter
public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor para saque deve ser maior que zero");
        }
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return;
        }
        throw new SaldoInsuficienteException("Saldo insuficiente para saque");
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor para depósito deve ser maior que zero");
        }
        this.saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor para transferência deve ser maior que zero");
        }
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("Você não possui saldo suficiente para realizar a transferência");
        }
        this.saldo -= valor;
        contaDestino.depositar(valor);
    }

    public void imprimirInfosComuns() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }


}
