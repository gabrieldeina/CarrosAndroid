package com.deina.carros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.deina.carros.controllers.CarroDAO;
import com.deina.carros.models.Carro;

public class CadastroActivity extends AppCompatActivity {

    EditText etModelo;
    EditText etMarca;
    EditText etCor;
    EditText etMotor;
    EditText etCombustivel;
    EditText etAno;
    EditText etFipe;
    Button btnCadastrar;

    CarroDAO carroDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etModelo = findViewById(R.id.etModelo);
        etMarca = findViewById(R.id.etMarca);
        etCor = findViewById(R.id.etCor);
        etMotor = findViewById(R.id.etMotor);
        etCombustivel = findViewById(R.id.etCombustivel);
        etAno = findViewById(R.id.etAno);
        etFipe = findViewById(R.id.etFipe);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        carroDAO = new CarroDAO();

        btnCadastrar.setOnClickListener(v -> {
            if (etModelo.getText().toString().isEmpty() ||
                    etMarca.getText().toString().isEmpty() ||
                    etCor.getText().toString().isEmpty() ||
                    etMotor.getText().toString().isEmpty() ||
                    etCombustivel.getText().toString().isEmpty() ||
                    etAno.getText().toString().isEmpty() ||
                    etFipe.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {
                Carro carro = new Carro(
                        etMarca.getText().toString(),
                        etModelo.getText().toString(),
                        Integer.parseInt(etAno.getText().toString()),
                        etCor.getText().toString(),
                        etMotor.getText().toString(),
                        etCombustivel.getText().toString(),
                        etFipe.getText().toString()
                );

                carroDAO.salvar(carro);

                Toast.makeText(this, "Carro salvo com sucesso!", Toast.LENGTH_SHORT).show();

                finish();
            }

        });
    }
}