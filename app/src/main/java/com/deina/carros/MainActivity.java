package com.deina.carros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.deina.carros.controllers.CarroDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView lvCarros;
    FloatingActionButton fabNovo;

    CarroDAO carroDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCarros = findViewById(R.id.lvCarros);
        fabNovo = findViewById(R.id.fabNovo);

        carroDAO = new CarroDAO();

        fabNovo.setOnClickListener(v -> startActivity(new Intent(this, CadastroActivity.class)));

        lvCarros.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, DetalhesActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        });

        lvCarros.setOnItemLongClickListener((parent, view, position, id) -> {
            carroDAO.excluir(position);
            Toast.makeText(this, "Carro excluído!", Toast.LENGTH_SHORT).show();
            onResume();
            return false;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        lvCarros.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                carroDAO.getEstoque()
        ));
    }
}