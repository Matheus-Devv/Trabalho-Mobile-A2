package com.example.a2mobile.model;

import android.graphics.drawable.Drawable;

import java.util.Objects;

public class Roupa {

    private String nome;
    private String tamanho;
    private Drawable drawable;

    public Roupa(String nome, String tamanho, Drawable drawable) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.drawable = drawable;
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

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public String toString() {
        return "Roupa{" +
                "nome='" + nome + '\'' +
                ", tamanho=" + tamanho +
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
