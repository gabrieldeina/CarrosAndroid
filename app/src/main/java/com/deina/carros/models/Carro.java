package com.deina.carros.models;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private String motor;
    private String combustivel;
    private String fipe;

    public Carro() {
    }

    public Carro(String marca, String modelo, int ano, String cor, String motor, String combustivel, String fipe) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.motor = motor;
        this.combustivel = combustivel;
        this.fipe = fipe;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getFipe() {
        return fipe;
    }

    public void setFipe(String fipe) {
        this.fipe = fipe;
    }

    @Override
    public String toString() {
        return this.marca + " " + this.modelo;
    }
}
