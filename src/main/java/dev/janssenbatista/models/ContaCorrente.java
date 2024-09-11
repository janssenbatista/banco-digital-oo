package dev.janssenbatista.models;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    protected void imprimirInfosComuns() {
        System.out.println("=== Dados da Conta Corrente ===");
        super.imprimirInfosComuns();
    }
}
