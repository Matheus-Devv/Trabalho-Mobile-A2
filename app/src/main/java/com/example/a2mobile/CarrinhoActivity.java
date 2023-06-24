package com.example.a2mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2mobile.model.Roupa;
import com.example.a2mobile.model.RoupasAdapter;

import org.parceler.Parcels;

import java.util.List;


public class CarrinhoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Carrinho");
        setContentView(R.layout.activity_carrinho);

        // Obter a lista de roupas selecionadas do intent
        List<Roupa> listaRoupasSelecionadas = Parcels.unwrap(getIntent().getParcelableExtra("listaRoupasSelecionadas"));


        RecyclerView recyclerView = findViewById(R.id.recycler_activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RoupasAdapter roupasAdapter = new RoupasAdapter(this, listaRoupasSelecionadas, recyclerView);
        recyclerView.setAdapter(roupasAdapter);


        Button buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarParaMainActivity();
            }
        });


        Button buttonCadastro = findViewById(R.id.buttonCadastro);
        buttonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCadastro();
            }
        });
    }

    private void voltarParaMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void abrirCadastro() {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
        finish();
    }

}
