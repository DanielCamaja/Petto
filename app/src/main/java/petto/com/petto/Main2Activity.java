package petto.com.petto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

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

        tabb1 = (TabLayout) findViewById(R.id.tab1id);
        viewPager = (ViewPager) findViewById(R.id.viewpaperid);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new CallFragment(),"");
        adapter.AddFragment(new ServFragment(),"");
        adapter.AddFragment(new CorreoFragment(),"");
        adapter.AddFragment(new PerfilFragment(),"");
        viewPager.setAdapter(adapter);
        tabb1.setupWithViewPager(viewPager);


        tabb1.getTabAt(0).setIcon(R.drawable.mascota);
        tabb1.getTabAt(1).setIcon(R.drawable.buscar);
        tabb1.getTabAt(2).setIcon(R.drawable.ic_chat_bubble_outline_black_24dp);
        tabb1.getTabAt(3).setIcon(R.drawable.usuario);




    }

}

