package com.example.cotizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cotizacion bol = new Cotizacion();
        EditText numeroCotEdit = (EditText) findViewById(R.id.numeroCotEdit);
        EditText describirEdit = (EditText) findViewById(R.id.describirEdit);
        EditText precioEdit = (EditText) findViewById(R.id.precioEdit);
        EditText porcentajeEdit = (EditText) findViewById(R.id.porcentajeEdit);
        Spinner spnPlazos = (Spinner)  findViewById(R.id.plazos);
        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        Button btnRegresar = (Button) findViewById(R.id.btnRegresar);

        TextView numeroCot = (TextView) findViewById(R.id.numeroCot);
        TextView describir = (TextView) findViewById(R.id.describir);
        TextView precioT = (TextView) findViewById(R.id.precioT);
        TextView porcentajeT = (TextView) findViewById(R.id.porcentajeT);
        TextView plazoT = (TextView) findViewById(R.id.plazoT);
        TextView pagoI = (TextView) findViewById(R.id.pagoI);
        TextView totalF = (TextView) findViewById(R.id.totalF);
        TextView pagoM = (TextView) findViewById(R.id.pagoM);
        btnRegresar.setVisibility(View.INVISIBLE);
        pagoI.setVisibility(View.INVISIBLE);
        totalF.setVisibility(View.INVISIBLE);
        pagoM.setVisibility(View.INVISIBLE);
        ArrayAdapter<String> Adaptador=new
                ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.plazos));
        spnPlazos.setAdapter(Adaptador);
        spnPlazos.setOnItemSelectedListener(new
                                                    AdapterView.OnItemSelectedListener() {
                                                        @Override
                                                        public void onItemSelected(AdapterView<?> adapterView, View view,
                                                                                   int i, long l) {
                                                            Toast.makeText(MainActivity.this,"Plazo " +
                                                                            adapterView.getItemAtPosition(i).toString() + " meses",
                                                                    Toast.LENGTH_SHORT).show();
                                                        }
                                                        @Override
                                                        public void onNothingSelected(AdapterView<?> adapterView) {
                                                        }});
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(numeroCotEdit.getText().toString().matches("") || describirEdit.getText().toString().matches("") ||
                        precioEdit.getText().toString().matches("") || porcentajeEdit.getText().toString().matches("") ||
                        spnPlazos.getTag().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de rellenar todos los espacios",Toast.LENGTH_SHORT).show();
                }else{

                    bol.setDescripcion(describirEdit.getTag().toString());
                    bol.setPorcentaje(Integer.parseInt(porcentajeEdit.getTag().toString()));
                    bol.setPlazo(Integer.parseInt(spnPlazos.getTag().toString()));
                    bol.setNumeroCotizacion(Integer.parseInt(numeroCotEdit.getTag().toString()));
                    bol.setPrecio(Double.parseDouble(precioEdit.getTag().toString()));

                    describirEdit.setVisibility(View.INVISIBLE);
                    porcentajeEdit.setVisibility(View.INVISIBLE);
                    spnPlazos.setVisibility(View.INVISIBLE);
                    numeroCotEdit.setVisibility(View.INVISIBLE);
                    precioEdit.setVisibility(View.INVISIBLE);

                    btnRegresar.setVisibility(View.VISIBLE);
                    pagoI.setVisibility(View.VISIBLE);
                    totalF.setVisibility(View.VISIBLE);
                    pagoM.setVisibility(View.VISIBLE);



                    numeroCot.setText("Numero de cotizacion: "+bol.getNumeroCotizacion());
                    describir.setText("Descripcion: "+ bol.getDescripcion());
                    precioT.setText("Precio: "+bol.getPrecio());
                    porcentajeT.setText("Porcentaje: "+bol.getPorcentaje()+"%");
                    plazoT.setText("Plazo: "+bol.getPlazo());
                    pagoI.setText("Pago inicial: "+bol.pagoInicial());
                    totalF.setText("Total a fin: "+bol.totalFinanciar());
                    pagoM.setText("Pago mensual: "+bol.pagoMensual());

                    describir.setTranslationY(-140);
                    precioT.setTranslationY(-275);
                    porcentajeT.setTranslationY(-415);
                    plazoT.setTranslationY(-555);
                    pagoI.setTranslationY(-690);
                    totalF.setTranslationY(-690);
                    pagoM.setTranslationY(-690);



                    btnCalcular.setVisibility(View.INVISIBLE);
                    numeroCotEdit.setText("");
                    describirEdit.setText("");
                    precioEdit.setText("");
                    porcentajeEdit.setText("");
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                describir.setTranslationY(0);
                precioT.setTranslationY(0);
                porcentajeT.setTranslationY(0);
                plazoT.setTranslationY(0);
                pagoI.setTranslationY(0);
                totalF.setTranslationY(0);
                pagoM.setTranslationY(0);

                numeroCot.setText("Numero de cotizacion: ");
                describir.setText("Descripcion: ");
                precioT.setText("Precio: ");
                porcentajeT.setText("Porcentaje: ");
                plazoT.setText("Plazo: ");
                pagoI.setText("");
                totalF.setText("");
                pagoM.setText("");

                describirEdit.setVisibility(View.VISIBLE);
                porcentajeEdit.setVisibility(View.VISIBLE);
                spnPlazos.setVisibility(View.VISIBLE);
                numeroCotEdit.setVisibility(View.VISIBLE);
                precioEdit.setVisibility(View.VISIBLE);
                btnCalcular.setVisibility(View.VISIBLE);

                btnRegresar.setVisibility(View.INVISIBLE);
                pagoI.setVisibility(View.INVISIBLE);
                totalF.setVisibility(View.INVISIBLE);
                pagoM.setVisibility(View.INVISIBLE);
            }
        });
    }
}