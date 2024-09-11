package dev.janssenbatista.models;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirInfosComuns() {
        System.out.println("=== Dados da Conta Poupança ===");
        super.imprimirInfosComuns();
    }
}
