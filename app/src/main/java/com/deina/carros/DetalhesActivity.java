package com.deina.carros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.deina.carros.controllers.CarroDAO;
import com.deina.carros.models.Carro;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvModelo;
    TextView tvMarca;
    TextView tvAno;
    TextView tvCor;
    TextView tvMotor;
    TextView tvCombustivel;
    TextView tvFipe;

    CarroDAO carroDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvModelo = findViewById(R.id.tvModelo);
        tvMarca = findViewById(R.id.tvMarca);
        tvAno = findViewById(R.id.tvAno);
        tvCor = findViewById(R.id.tvCor);
        tvMotor = findViewById(R.id.tvMotor);
        tvCombustivel = findViewById(R.id.tvCombustivel);
        tvFipe = findViewById(R.id.tvFipe);

        carroDAO = new CarroDAO();

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", -1);

        if (position == -1) {
            finish();
        }

        Carro carro = carroDAO.getCarro(position);

        tvModelo.setText("Modelo: " + carro.getModelo());
        tvMarca.setText("Marca: " + carro.getMarca());
        tvAno.setText("Ano: " + Integer.toString(carro.getAno()));
        tvCor.setText("Cor: " + carro.getCor());
        tvMotor.setText("Motor: " + carro.getMotor());
        tvCombustivel.setText("Combustível: " + carro.getCombustivel());
        tvFipe.setText("FIPE: R$" + carro.getFipe());
    }
}