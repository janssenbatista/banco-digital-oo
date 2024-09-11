package dev.janssenbatista.models;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirInfosComuns() {
        System.out.println("=== Dados da Conta Corrente ===");
        super.imprimirInfosComuns();
    }
}
