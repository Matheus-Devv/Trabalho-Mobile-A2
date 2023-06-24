package com.example.a2mobile.model;

import org.parceler.Parcel;

import java.util.Objects;

@Parcel
public class Roupa {

    private String nome;
    private String tamanho;
    private Double preco;
    //    private Drawable drawable;
    private int drawableResId;


    public Roupa(String nome, String tamanho, Double preco, int drawableResId) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
        this.drawableResId = drawableResId;
    }

    public Roupa() {
    }

    public int getDrawableResId() {
        return drawableResId;
    }

    public void setDrawableResId(int drawableResId) {
        this.drawableResId = drawableResId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Roupa{" +
                "nome='" + nome + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roupa roupa = (Roupa) o;
        return Objects.equals(nome, roupa.nome) && Objects.equals(tamanho, roupa.tamanho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tamanho);
    }
}
