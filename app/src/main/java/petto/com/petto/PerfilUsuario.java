package petto.com.petto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import petto.com.petto.entidades.Contact;

public class PerfilUsuario extends AppCompatActivity {

    ImageView perfilim;
    TextView text1, text2;
    private DatabaseReference mdatareferenceu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuarios);

        perfilim = (ImageView) findViewById(R.id.idimagentrabajador);
        text1 = (TextView) findViewById(R.id.idnombretrabajador);
        text2 = (TextView) findViewById(R.id.iddescripciontrabajador);

        mdatareferenceu = FirebaseDatabase.getInstance().getReference().child("promociones");

        Intent intent = getIntent();
        String key = intent.getExtras().getString("key");




        mdatareferenceu.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String title = (String) dataSnapshot.child("name").getValue();
                String desc = (String) dataSnapshot.child("desc").getValue();
                String imagen  = (String) dataSnapshot.child("imagen").getValue();
                Picasso.get().load(imagen).into(perfilim);


                text1.setText(""+title);
                text2.setText(desc);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //solicitarDatosFirebase();
    }
/*
    private void solicitarDatosFirebase() {
        mdatareferenceu.child("news").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    mdatareferenceu.child("news").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Contact user = snapshot.getValue(Contact.class);
                            String nombre = user.getName();
                            String apellido = user.getDescripcion();
                            String iamgen = user.getImagen();


                            Log.e("name:", "" + nombre);
                            Log.e("descripcion:", "" + apellido);
                            Log.e("imagen:", "" + iamgen);

                            text1.setText(nombre);
                            text2.setText(apellido);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void cargarDatosFirebase(String nombre, String descripcion, String imagen) {

        Map<String, Object> datosUsuario = new HashMap<>();
        datosUsuario.put("name", nombre);
        datosUsuario.put("descripcion", descripcion);
        datosUsuario.put("imagen", imagen);

        mdatareferenceu.child("news").push().setValue(datosUsuario);
    }

    */

}
