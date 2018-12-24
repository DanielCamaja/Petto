package petto.com.petto.Inicio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import petto.com.petto.R;

public class MainActivity extends AppCompatActivity {

    private Button btn_registrar, btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get Firebase auth instance

        btn_registrar = (Button) findViewById(R.id.Registrar);
        btn_login = (Button) findViewById(R.id.Login);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent0);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent1);
            }
        });


    }

}
