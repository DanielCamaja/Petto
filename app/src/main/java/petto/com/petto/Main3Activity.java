package petto.com.petto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

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

        titulop = findViewById(R.id.titulop);
        descripcionp =  findViewById(R.id.descripcionp);
        boton_publicar = findViewById(R.id.btn_publicar);
        mDatabasep = FirebaseDatabase.getInstance().getReference();

        boton_publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(intent);
                Toast.makeText(Main3Activity.this, "Datos enviados", Toast.LENGTH_SHORT).show();

                String name = titulop.getText().toString();
                String descripcion = descripcionp.getText().toString();


                Map<String, Object> contenido = new HashMap<>();
                contenido.put("name", name);
                contenido.put("descripcion", descripcion);


              mDatabasep.child("news").push().setValue(contenido);

            }
        });



    }


}
