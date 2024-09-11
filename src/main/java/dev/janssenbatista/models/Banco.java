package dev.janssenbatista.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Banco {
    @Setter
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void imprimirNomeDosClientes() {
        System.out.printf("O banco %s possui os seguintes clientes:\n", this.nome);
        contas.stream().map(Conta::getCliente).distinct().forEach(System.out::println);
    }
}
