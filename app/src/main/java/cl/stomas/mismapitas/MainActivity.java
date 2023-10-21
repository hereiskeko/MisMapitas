package cl.stomas.mismapitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //DECLARACIÓN DE VARIABLES
    EditText lat1, lat2, lat3, lng1, lng2, lng3;
    Button btnAgregarMarcadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        lat1 = (EditText) findViewById(R.id.etLat1);
        lat2 = (EditText) findViewById(R.id.etLat2);
        lat3 = (EditText) findViewById(R.id.etLat3);

        lng1 = (EditText) findViewById(R.id.etLng1);
        lng2 = (EditText) findViewById(R.id.etLng2);
        lng3 = (EditText) findViewById(R.id.etLng3);

        btnAgregarMarcadores = (Button) findViewById(R.id.btnAgregarMarcador);

        //BOTÓN PARA AGREGAR MARCADORES

        btnAgregarMarcadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String latDir1 = lat1.getText().toString().trim();
                String latDir2 = lat2.getText().toString().trim();
                String latDir3 = lat3.getText().toString().trim();

                String lngDir1 = lng1.getText().toString().trim();
                String lngDir2 = lng2.getText().toString().trim();
                String lngDir3 = lng3.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this, MainActivity_Mapa.class);
                if(!latDir1.isEmpty() && !lngDir1.isEmpty()){
                    if(!latDir2.isEmpty() && !lngDir2.isEmpty()){
                        if(!latDir3.isEmpty() && !lngDir3.isEmpty()){
                            double lati3 = Double.parseDouble(latDir3);
                            double lngi3 = Double.parseDouble(lngDir3);
                            intent.putExtra("Latitud 3", lati3);
                            intent.putExtra("Longitud 3", lngi3);
                        }
                        double lati2 = Double.parseDouble(latDir2);
                        double lngi2 = Double.parseDouble(lngDir2);
                        intent.putExtra("Latitud 2", lati2);
                        intent.putExtra("Longitud 2", lngi2);
                    }
                    double lati1 = Double.parseDouble(latDir1);
                    double lngi1 = Double.parseDouble(lngDir1);
                    intent.putExtra("Latitud 1", lati1);
                    intent.putExtra("Longitud 1", lngi1);

                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Ingresa al menos una dirección",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //
    }
}