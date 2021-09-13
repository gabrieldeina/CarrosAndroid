package com.deina.carros.controllers;

import com.deina.carros.models.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroDAO {


    private static List<Carro> estoque = new ArrayList<>();

    public void salvar(Carro carro) {
        estoque.add(carro);
    }

    public void excluir(int position) {
        estoque.remove(position);
    }

    public Carro getCarro(int position) {
        return estoque.get(position);
    }

    public List<Carro> getEstoque() {
        return estoque;
    }
}
