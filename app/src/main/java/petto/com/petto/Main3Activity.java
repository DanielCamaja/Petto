package petto.com.petto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends AppCompatActivity {

     private Button boton_publicar;
     private DatabaseReference mDatabasep;

     private EditText titulop;
     private EditText preciop;
     private EditText descripcionp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        boton_publicar = findViewById(R.id.btn_publicar);
        mDatabasep = FirebaseDatabase.getInstance().getReference();

        boton_publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(intent);
                Toast.makeText(Main3Activity.this, "Datos enviados", Toast.LENGTH_SHORT).show();

            /*    String titulo = titulop.getText().toString();
                int precio = Integer.parseInt(preciop.getText().toString());
                String descripcion = descripcionp.getText().toString();

                Map<String, Object> hopperUpdates = new HashMap<>();
                hopperUpdates.put("titulo", titulo);
                hopperUpdates.put("precio", precio);
                hopperUpdates.put("descrpcion", descripcion);


              mDatabasep.child("ususarios").push().setValue(hopperUpdates);
               */
            }
        });



    }


}
