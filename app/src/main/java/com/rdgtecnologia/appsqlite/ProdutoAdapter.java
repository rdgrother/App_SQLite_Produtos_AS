package com.rdgtecnologia.appsqlite;

import android.content.Context;
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
    public TextView tvNome;
    public TextView tvCodigo;
    public TextView tvQtde;
    public TextView tvValor;

    public ProdutoAdapter(Context context, ArrayList<Produto> listaProduto){

        this.context = context;
        this.listaProduto = listaProduto;
        inflater = LayoutInflater.from(context);

    }

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
        return null;
    }
}
