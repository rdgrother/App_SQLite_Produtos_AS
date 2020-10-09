package com.rdgtecnologia.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Busca extends AppCompatActivity {

    private ProdutoAdapter adapter;
    private ArrayList<Produto> prodAux;
    private ListView lvProdutos;
    private int posSelec = -1;
    private ProdutoDAO prodDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca);

        lvProdutos = findViewById(R.id.lvProdutos);

        prodDAO = new ProdutoDAO(this);
        prodDAO.abrirBanco();
        prodAux = prodDAO.consultar();

        adapter = new ProdutoAdapter(this, prodAux);
        lvProdutos.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        lvProdutos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                posSelec = i; // o posSelec recebe a posição do item selecionado e retona falso para que nada seja feito após isso, apenas as opçoes do menu
                return false;
            }
        });

        registerForContextMenu(lvProdutos);
    }

    protected void onResume(){
        super.onResume();
        prodDAO.abrirBanco();

    }

    protected void onPause(){
        super.onPause();
        prodDAO.fecharBanco();
    }
}

