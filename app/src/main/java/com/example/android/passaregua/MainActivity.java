package com.example.android.passaregua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText editTotalGasto;
    EditText editTotalGastoBebida;
    EditText editPessoasBeberam;
    EditText editPessoasNaoBeberam;
    TextView txtValorBeberam;
    TextView txtValorNaoBeberam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTotalGasto = (EditText) findViewById(R.id.totalConta);
        editTotalGastoBebida = (EditText) findViewById(R.id.totalBebida);
        editPessoasBeberam = (EditText) findViewById(R.id.totalPessoasBeberam);
        editPessoasNaoBeberam = (EditText) findViewById(R.id.totalPessoasNaoBeberam);
        txtValorBeberam = (TextView) findViewById(R.id.precoBebem);
        txtValorNaoBeberam = (TextView) findViewById(R.id.precoNaobebem);
    }

    public void limparCampos(View view){
        editPessoasBeberam.setText("");
        editPessoasNaoBeberam.setText("");
        editTotalGastoBebida.setText("");
        editTotalGasto.setText("");
        txtValorNaoBeberam.setText("$0");
        txtValorBeberam.setText("$0");


    }

    public void calcularPrecos(View view){
        try{
            String valorConta = editTotalGasto.getText().toString();
            double valor = Double.parseDouble(valorConta);
            String valorBebidas = editTotalGastoBebida.getText().toString();
            double valorBebida = Double.parseDouble(valorBebidas);
            String valorNumeroBeberam = editPessoasBeberam.getText().toString();
            double numeroBeberam = Double.parseDouble(valorNumeroBeberam);
            String valorNumeroNaoBeberam = editPessoasBeberam.getText().toString();
            double numeroNaoBeberam = Double.parseDouble(valorNumeroNaoBeberam);

            double diferencaPreco = valor-valorBebida;
            double valorNaoBeberam = diferencaPreco/(numeroNaoBeberam+numeroBeberam);
            double valorBeberam = (valorBebida/numeroBeberam) + valorNaoBeberam;

            txtValorBeberam.setText("$"+valorBeberam);
            txtValorNaoBeberam.setText("$"+valorNaoBeberam);

        }catch (Exception ex){
            Toast toast = Toast.makeText(this,"Insira somente numeros nos campos",Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
