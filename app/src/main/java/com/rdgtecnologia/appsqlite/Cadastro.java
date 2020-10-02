package com.rdgtecnologia.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    private EditText edtNome, edtQtde, edtValor, edtCodigo;
    private Button btnSalvar;
    private Produto prod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = findViewById(R.id.edtNome);
        edtQtde = findViewById(R.id.edtQtde);
        edtValor = findViewById(R.id.edtValor);
        edtCodigo = findViewById(R.id.edtCodigo);
        btnSalvar = findViewById(R.id.btnCadastrar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prod = new Produto();
                prod.setNome(edtNome.getText().toString());
                prod.setCodigo(edtCodigo.getText().toString());
                prod.setValor(Double.parseDouble(edtValor.getText().toString()));
                prod.setQtde(Long.parseLong(edtQtde.getText().toString()));

                Toast.makeText(getBaseContext(),
                        "Produto Castrado: " + prod.toString(),
                        Toast.LENGTH_LONG).show();

                limpar();

            }

            private void limpar() {
                edtNome.setText(null);
                edtCodigo.setText(null);
                edtValor.setText(null);
                edtQtde.setText(null);
            }
        });


    }


}
