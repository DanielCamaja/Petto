package petto.com.petto;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import petto.com.petto.adaptadores.ViewPagerAdapter;
import petto.com.petto.fragments.CallFragment;
import petto.com.petto.fragments.CorreoFragment;
import petto.com.petto.fragments.PerfilFragment;
import petto.com.petto.fragments.ServFragment;

public class Main2Activity extends AppCompatActivity {

    private TabLayout tabb1;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FloatingActionButton floting = findViewById(R.id.floatingb);
        tabb1 = (TabLayout) findViewById(R.id.tab1id);
        viewPager = (ViewPager) findViewById(R.id.viewpaperid);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new CallFragment(),"");
        adapter.AddFragment(new CorreoFragment(),"");
        adapter.AddFragment(new ServFragment(),"");
        adapter.AddFragment(new PerfilFragment(),"");
        viewPager.setAdapter(adapter);
        tabb1.setupWithViewPager(viewPager);


        tabb1.getTabAt(0).setIcon(R.drawable.mascota);
        tabb1.getTabAt(1).setIcon(R.drawable.email);
        tabb1.getTabAt(2).setIcon(R.drawable.hacer);
        tabb1.getTabAt(3).setIcon(R.drawable.person);


        floting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });


    }

}

