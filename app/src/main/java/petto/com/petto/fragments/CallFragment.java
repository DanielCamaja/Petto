package petto.com.petto.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import petto.com.petto.R;
import petto.com.petto.adaptadores.RecyclerViewAdapter;
import petto.com.petto.entidades.Contact;

public class CallFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Contact> prContact;



    public CallFragment() {



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.call_fragment,container,false);

        myrecyclerview = (RecyclerView) v.findViewById(R.id.callrecycler);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),prContact, this);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prContact = new ArrayList<>();
        prContact.add(new Contact("Amelia Margaret", "cuidamos perros","Me encantan los perros de todos los tamaños, mi esposo y yo estamos conprometidos para darles el mejor cuidado que se le pueda dar a su cascota",R.drawable.cliente1,R.drawable.cliente1));
        prContact.add(new Contact("Jose Perez", "El mejor cuidador de perros","Se cuidan perros de todas las razas y tamaños que exitan, se incluye baños, comida, y una maca en donde pueda dormir.",R.drawable.cleinte2,R.drawable.cleinte2));
        prContact.add(new Contact("Familia Scott", "Se cuidan Mascotas de todo tipo","Nos encargamos de todas las mascotas, incluyendo mascotas exoticas con su respectivo papeleo en ordem, ambiente amigable para mascotas grandes, pequeñas incluyendo reptiles.",R.drawable.cliente3,R.drawable.cliente3));
        prContact.add(new Contact("Ximena Soto","Se cuidan Gatos de casa", "Cuido gatos de todo tipo de pelo, el servicio incluye jugutes alimentacion, cepillados y ejercicio para los gatos",R.drawable.cliente4,R.drawable.cliente4));
        prContact.add(new Contact("Juanito Alcachofa","Se entrenan perros de todo tipo de raza", "Se entrenan perros de todas las razas, los entrenamientos son de 1-3 horas, descansos cada 25 minbutos, los perros son entrenados personalmente por una persona.",R.drawable.cliente5,R.drawable.cliente5));
        prContact.add(new Contact("Matias y Megan","Se cuidan mascotas por lasgas jornadas", "Nos encargamos del cuidado de su mascota, incluyendo dias feriados, vacaciones largas o dias festivos.",R.drawable.cliente6,R.drawable.cliente6));
        prContact.add(new Contact("Buscamos Cuidador","Se busca cuidador de tamaño mediano", "Buscamos cuidador para nuestro perro, el es cariñoso con todo tipo de personas, que lo cuide durante una semana",R.drawable.cliente7,R.drawable.cliente7));

    }



}