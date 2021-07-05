package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double Numero1 = 0.0;
    private double Numero2 = 0.0;
    private int operacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void numeroPreionado(String digito) {
        TextView txt = findViewById(R.id.txt);

        if (txt.getText().equals("0") || txt.getText().equals("0.0")) {
            txt.setText(digito);
        }else{
            txt.setText(txt.getText() + digito);
        }

        try {
            if (operacion == 0) {
                Numero1 = Double.parseDouble((String) txt.getText());
            } else {
                Numero2 = Double.parseDouble((String) txt.getText());
            }
        }catch(Exception e){
            txt.setText("Syntax error");
        }
    }

    private void operadorPresionada(int operacion) {
        if(Numero2 != 0){
            resultado();
        }
        this.operacion = operacion;
        TextView txt = findViewById(R.id.txt);
        txt.setText("0");
        TextView txt_top = findViewById(R.id.txt_superior);
        if(EsEntero(Numero1)) {
            txt_top.setText((int)Numero1 + "");
        }else{
            txt_top.setText(Numero1 + "");
        }
    }

    public void igual(View view){
        resultado();
    }

    private void resultado() {
        double resultado;
        switch (operacion) {
            case 1:
                resultado = Numero1 + Numero2;
                break;
            case 2:
                resultado = Numero1 - Numero2;
                break;
            case 3:
                resultado = Numero1 * Numero2;
                break;
            case 4:
                resultado = Numero1 / Numero2;
                break;
            default:
                resultado = 0.0;
                break;
        }
        TextView txt = findViewById(R.id.txt);
        TextView txt_top = findViewById(R.id.txt_superior);
        if(EsEntero(resultado)) {
            txt.setText((int)resultado + "");
        }else{
            txt.setText(resultado + "");
        }
        txt_top.setText("");
        Numero1 = resultado;
        Numero2 = 0.0;

    }

    private boolean EsEntero(double decimal){
        int entero = (int)decimal;
        if(decimal - entero == 0){
            return true;
        }else{
            return false;
        }
    }

    public void Clear(View view){
        Numero1 = 0.0;
        Numero2 = 0.0;
        operacion = 0;
        TextView txt = findViewById(R.id.txt);
        txt.setText("0");
    }

    public void punto(View view){
        TextView txt = findViewById(R.id.txt);
        txt.setText(txt.getText() + ".");

        try {
            if (operacion == 0) {
                Numero1 = Double.parseDouble((String) txt.getText());
            } else {
                Numero2 = Double.parseDouble((String) txt.getText());
            }
        }catch(Exception e){
            txt.setText("Syntax error");
        }
    }

    public void Cero(View view){ numeroPreionado("0"); }
    public void Uno(View view){ numeroPreionado("1"); }
    public void Dos(View view){ numeroPreionado("2"); }
    public void Tres(View view){ numeroPreionado("3"); }
    public void Cuatro(View view){ numeroPreionado("4"); }
    public void Cinco(View view){ numeroPreionado("5"); }
    public void Seis(View view){ numeroPreionado("6"); }
    public void Siete(View view){ numeroPreionado("7"); }
    public void Ocho(View view){ numeroPreionado("8"); }
    public void Nueve(View view){ numeroPreionado("9"); }

    public void suma(View view){ operadorPresionada(1);}
    public void resta(View view){ operadorPresionada(2);}
    public void multi(View view){ operadorPresionada(3);}
    public void division(View view){ operadorPresionada(4);}
}