package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview.adapter.MeuAdapter;
import com.example.listview.modelos.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Tarefa> tarefas = new ArrayList<>();
    private ArrayAdapter<Tarefa> arrayAdapterTarefa;
    private TextView textViewDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarTarefas();


        listView = findViewById(R.id.list_view_tarefas);
        textViewDescricao = findViewById(R.id.text_view_descricao);

        arrayAdapterTarefa = new MeuAdapter(MainActivity.this,
                            (ArrayList<Tarefa>)tarefas);
        listView.setAdapter(arrayAdapterTarefa);

        //Clique curto - chamar outra activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast toast = Toast.makeText(getApplicationContext(),
                        //"Teste", Toast. LENGTH_LONG);
                //toast.show();
                Intent intent = new Intent(MainActivity.this, TarefaActivity.class);
                intent.putExtra("TITULO", tarefas.get(i).getNome());
                intent.putExtra("DESCRICAO", tarefas.get(i).getDescricao());
                startActivity(intent);
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                tarefas.get(i).setStatus(!tarefas.get(i).getStatus());
                listView.invalidateViews();
                return false;
            }
        });


    }

    public void criarTarefas() {
        this.tarefas.add(new Tarefa("1", "Estudar Android", false, "Tarefa do IMC"));
        this.tarefas.add(new Tarefa("2", "Projeto Integrador", false, "Fazer layout"));
        this.tarefas.add(new Tarefa("3", "GTA", true, "Jogar"));
    }

}
