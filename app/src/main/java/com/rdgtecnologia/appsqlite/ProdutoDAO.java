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
        this.dbHelper = new Helper(context);

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

        return db.insertOrThrow(dbHelper.TBL_PRODUTO,
                null,
                cv);


    }

    public ArrayList<Produto> consultar() {
        ArrayList<Produto> prodAux = new ArrayList<>();
        String sql = "SELECT * FROM " + dbHelper.TBL_PRODUTO + ";";

        Cursor cursor = db.rawQuery(sql, null);

                /*dbHelper.TBL_PRODUTO,
                dbHelper.TBL_PROUTO_COLUNAS,
                null,
                null,
                null,
                null,
                dbHelper.NM_PRODUTO);*/

        if (cursor.moveToFirst()){
            do {
                Produto prod = new Produto();
                prod.setId(cursor.getInt(cursor.getColumnIndex("id")));
                prod.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                prod.setCodigo(cursor.getString(cursor.getColumnIndex("codigo")));
                prod.setValor(cursor.getDouble(cursor.getColumnIndex("valor")));
                prod.setQtde(cursor.getLong(cursor.getColumnIndex("quantidade")));
                cursor.moveToNext();
                prodAux.add(prod);
            }while (cursor.moveToNext());
            cursor.close();
        }


        /*while (!cursor.isAfterLast()) {
            Produto prod = new Produto();

            prod.setNome(cursor.getString(1));
            prod.setCodigo(cursor.getString(1));
            prod.setQtde(cursor.getLong(3));
            prod.setValor(cursor.getDouble(2));
            cursor.moveToNext();
            prodAux.add(prod);

        }

        cursor.close(); */

        return prodAux;

    }

}