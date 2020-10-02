package com.rdgtecnologia.appsqlite;

import java.io.Serializable;

public class Produto implements Serializable  { // Processo que uma instâcia de objetos se transforma em uma sequencia de bytes
    private String nome, codigo;
    private long qtde;
    private double valor;

    public Produto(){

    }

    public Produto(String nome, String codigo, long qtde, double valor) {
        this.nome = nome;
        this.codigo = codigo;
        this.qtde = qtde;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", qtde=" + qtde +
                ", valor=" + valor +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public long getQtde() {
        return qtde;
    }

    public void setQtde(long qtde) {
        this.qtde = qtde;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
