package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TarefaActivity extends AppCompatActivity {

    private TextView textViewTitulo;
    private TextView textViewDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);

        textViewTitulo = findViewById(R.id.text_view_tarefa_titulo);
        textViewDescricao = findViewById(R.id.text_view_descricao);

        Intent intent = getIntent();
        String titulo = intent.getStringExtra("TITULO");
        String descricao = intent.getStringExtra("DESCRICAO");

        textViewTitulo.setText(titulo);
        textViewDescricao.setText(descricao);
    }
}
