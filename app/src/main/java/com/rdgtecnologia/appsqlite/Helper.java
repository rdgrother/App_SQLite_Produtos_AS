package com.rdgtecnologia.appsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.HeterogeneousExpandableList;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

    public static final String TBL_PRODUTO = "produto";
    public static final String ID_PRODUTO = "id";
    public static final String NM_PRODUTO = "nome";
    public static final String CD_PRODUTO = "codigo";
    public static final String QT_PRODUTO = "quantidade";
    public static final String VL_PRODUTO = "valor";

    public static final String[] TBL_PROUTO_COLUNAS = {
            //Helper.ID_PRODUTO,
            Helper.NM_PRODUTO, Helper.QT_PRODUTO, Helper.VL_PRODUTO};

    public static final String DATA_BASE = "Estoque";
    public static final int DATABASE_VERSION = 1;

    public Helper(Context context) {
        super(context, DATA_BASE, null, DATABASE_VERSION);
    }

    public Helper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE" + TBL_PRODUTO
                + " ( " +
                ID_PRODUTO + "integer primary key autoincrement, " +
                NM_PRODUTO + "text not null" +
                CD_PRODUTO + "text not null, " +
                VL_PRODUTO + "double not null, " +
                QT_PRODUTO + "integer not null);";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE" + TBL_PRODUTO;

        sqLiteDatabase.execSQL(sql);

        onCreate(sqLiteDatabase);

    }
}
