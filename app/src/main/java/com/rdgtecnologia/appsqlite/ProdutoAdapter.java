package com.rdgtecnologia.appsqlite;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProdutoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Produto> listaProduto;
    private LayoutInflater inflater;
    public TextView detNome;
    public TextView detCodigo;
    public TextView detQtde;
    public TextView detValor;
    public TextView txtId;

    //Construtor
    public ProdutoAdapter(Context context, ArrayList<Produto> listaProduto){

        this.context = context;
        this.listaProduto = listaProduto;
        inflater = LayoutInflater.from(context);

    }

    public void add(Produto prod){
        this.listaProduto.add(prod);
    }

    public void remove(Produto prod){
        this.listaProduto.remove(prod);
    }

    //Retornando o tamanho da lista para ser mostrada
    @Override
    public int getCount() {
        return listaProduto.size();
    }

    @Override
    public Object getItem(int i) {
        return listaProduto.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Produto prod = this.listaProduto.get(i);
        try {

            if (view == null) view = inflater.inflate(R.layout.detalhe_produto, null);



            txtId = view.findViewById(R.id.txtId);
            detNome = view.findViewById(R.id.detProduto);
            detCodigo = view.findViewById(R.id.detCodigo);
            detQtde = view.findViewById(R.id.detQtde);
            detValor = view.findViewById(R.id.detValor);

            txtId.setText("ID: " + prod.getId());
            detNome.setText("Produto: " + prod.getNome());
            detCodigo.setText("Código: " + prod.getCodigo());
            detQtde.setText("Quantidade: " + prod.getQtde());
            detValor.setText("Valor: " + prod.getValor());

        } catch (Exception e) {
            Log.e("GETVIEW", e.getMessage());
        }

        return null;
    }
}
