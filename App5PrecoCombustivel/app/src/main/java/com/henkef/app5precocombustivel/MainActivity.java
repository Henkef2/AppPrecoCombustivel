package com.henkef.app5precocombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoEtanol, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoEtanol     = findViewById(R.id.editPrecoEtanol);
        editPrecoGasolina   = findViewById(R.id.editPrecoGasolina);
        textResultado       = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view){

        //recuperar valores digitados
        String precoEtanol   = editPrecoEtanol.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar os campos digitados
        Boolean camposValidados = validarCampos(precoEtanol, precoGasolina);
        if ( camposValidados ){

            //convertendo string para numeros
            //essa conversão é necessaria pois os valores recuperados em editPrecoEtanol e Gasolina são do tipo String
            Double valorEtanol   = Double.parseDouble( precoEtanol );
            Double valorGasolina = Double.parseDouble( precoGasolina );

            /* Fazer cálculo de menor preço
            *Se (valorEtanol / valorGasolina) >= 0.7 é melhor utilizar gasolina
            * senão é melhor utilizar etanol
             */

            Double resultado = valorEtanol / valorGasolina;
            if ( resultado >= 0.7){
                textResultado.setText("Melhor utilizar Gasolina");
            } else {
                textResultado.setText("Melhor utilizar Etanol");
            }

        } else {

            textResultado.setText("Preencha os preços primeiro!");

        }

    }

    public Boolean validarCampos( String pEtanol, String pGasolina ){
        Boolean camposValidados = true;

        if ( pEtanol == null || pEtanol.equals("")){
            camposValidados = false;
        } else if( pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;

    }
}