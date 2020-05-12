package petto.com.petto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilAsociaciones extends AppCompatActivity {

    ImageView perfil;
    TextView text1, text2;
    private DatabaseReference mdatareferencea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_asociaciones);

        perfil = (ImageView) findViewById(R.id.imagenaso);
        text1 = (TextView) findViewById(R.id.nombreasi);
        text2 = (TextView) findViewById(R.id.descasi);

        mdatareferencea = FirebaseDatabase.getInstance().getReference().child("news");

        Intent intent1 = getIntent();
        String key = intent1.getExtras().getString("key");


        mdatareferencea.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String title = (String) dataSnapshot.child("name").getValue();
                String desc = (String) dataSnapshot.child("desc").getValue();
                String imagen  = (String) dataSnapshot.child("image").getValue();

                text1.setText(""+title);
                text2.setText(desc);
                //perfilim.setImageResource(Integer.parseInt(imagen));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







    }
}
