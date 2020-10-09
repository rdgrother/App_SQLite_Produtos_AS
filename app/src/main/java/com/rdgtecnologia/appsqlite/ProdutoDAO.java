package com.rdgtecnologia.appsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ProdutoDAO {

    private SQLiteDatabase db;
    private Helper dbHelper;

    public ProdutoDAO(Context context) {

    }

    public void abrirBanco() {
        db = dbHelper.getWritableDatabase();
    }

    public void fecharBanco() {
        dbHelper.close();
    }

    public long inserir(Produto prod) {

        ContentValues cv = new ContentValues();
        cv.put(dbHelper.NM_PRODUTO, prod.getNome());
        cv.put(dbHelper.QT_PRODUTO, prod.getQtde());
        cv.put(dbHelper.CD_PRODUTO, prod.getCodigo());
        cv.put(dbHelper.VL_PRODUTO, prod.getValor());

        return db.update(dbHelper.TBL_PRODUTO,
                cv,
                null,
                null);
    }

    public ArrayList<Produto> consultar() {
        ArrayList<Produto> prodAux = new ArrayList<>();

        Cursor cursor = db.query(
                dbHelper.TBL_PRODUTO,
                dbHelper.TBL_PROUTO_COLUNAS,
                null,
                null,
                null,
                null,
                dbHelper.NM_PRODUTO);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Produto prod = new Produto();

            prod.setNome(cursor.getString(1));
            prod.setCodigo(cursor.getString(1));
            prod.setQtde(cursor.getLong(3));
            prod.setValor(cursor.getDouble(2));
            cursor.moveToNext();
            prodAux.add(prod);

        }

        cursor.close();

        return prodAux;


    }

}