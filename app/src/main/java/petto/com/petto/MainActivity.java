package petto.com.petto;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textp;
    private BottomNavigationView navegador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textp = (TextView) findViewById(R.id.textp);
        navegador = (BottomNavigationView) findViewById(R.id.navegation);

        navegador.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.cuidadores){
                    textp.setText(R.string.inicio);
                }else if (item.getItemId()== R.id.ftrab){
                    textp.setText(R.string.email);
                }else if (item.getItemId()== R.id.cuidador){

                }


                return;
            }
        });
    }

}

