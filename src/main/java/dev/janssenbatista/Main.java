package dev.janssenbatista;

import dev.janssenbatista.models.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Inter");
        Cliente c1 = new Cliente();
        c1.setNome("João");
        Cliente c2 = new Cliente();
        c2.setNome("Maria");
        Conta cc1 = new ContaCorrente(c1);
        cc1.depositar(200);
        Conta cp1 = new ContaPoupanca(c1);
        cp1.depositar(100);
        Conta cc2 = new ContaCorrente(c2);
        cc2.depositar(500);
        cc1.transferir(100, cc2);
        // Imprimindo informação das contas
        cc1.imprimirInfosComuns();
        cp1.imprimirInfosComuns();
        cc2.imprimirInfosComuns();
        // adicionando contas ao banco
        banco.getContas().addAll(List.of(cc1, cp1, cc2));
        // Imprimindo nome dos clientes
        banco.imprimirNomeDosClientes();
    }
}