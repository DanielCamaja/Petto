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
import petto.com.petto.adaptadores.RecyclerViewAdapterEmail;
import petto.com.petto.entidades.Contact;

public class CorreoFragment extends Fragment {

    View v;
    private RecyclerView emailrecyclerview1;
    private List<Contact> sdCorreo;


    public CorreoFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.email_fragment,container,false);

        emailrecyclerview1 = (RecyclerView) v.findViewById(R.id.emailrecycler);
        RecyclerViewAdapterEmail recyclerAdapter = new RecyclerViewAdapterEmail(getContext(),sdCorreo,this);
        emailrecyclerview1.setLayoutManager(new LinearLayoutManager(getActivity()));
        emailrecyclerview1.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sdCorreo = new ArrayList<>();
        sdCorreo.add(new Contact("Fabio Lopez", "Coordinacion de encuentro","Buenas noches querido usuario                               Se le informa que la entrega del perro llamado Lucas sera a las 10AM en el parque central.",R.drawable.f,R.drawable.perrito));
        sdCorreo.add(new Contact("Gabriela Montez", "Consulta","Disculpe con una pregunta, se puede bajar el precio si entrego la comida que tengo",R.drawable.g,R.drawable.cliente4));

    }
}

