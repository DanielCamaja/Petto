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
import petto.com.petto.adaptadores.RecyclerViewAdapterSer;
import petto.com.petto.entidades.Contact;

public class ServFragment extends Fragment {


    View v;
    private RecyclerView emailrecyclerview1;
    private List<Contact> sdContact;


    public ServFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.serv_fragment,container,false);

        emailrecyclerview1 = (RecyclerView) v.findViewById(R.id.recyclerserv);
        RecyclerViewAdapterSer recyclerAdapter = new RecyclerViewAdapterSer(getContext(),sdContact, this);
        emailrecyclerview1.setLayoutManager(new LinearLayoutManager(getActivity()));
        emailrecyclerview1.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sdContact = new ArrayList<>();
        sdContact.add(new Contact("Asociaciones", "Ama","Número de cel:                                             correo:ama.adopciones@gmail.com                               Facebook:facebook: Ama Asociacion de amigos por los animales.",R.drawable.ama,R.drawable.ama));
        sdContact.add(new Contact("Veterinaria", "El cuidado necesario para una mascota","Se atiende las 24hrs. del dia                               Numero de telefono:2220 4779",R.drawable.veterinaria,R.drawable.veterinaria));
        sdContact.add(new Contact("Grooming","Esteticas Para Mascotas","Se atiende toda clase de mascotas, el paquete incluye baño, corte de pelo y garras y una revision general.",R.drawable.grooming,R.drawable.grooming));
        sdContact.add(new Contact("Escuelas Para Mascotas", "Entrenamiento Para Mascotas","La escuela Entrenamiento Feliz se orgullese de 10 años de entrenamiento, adriestado de toda clase de mascotas,                               Se convierte el perro o gato mas revelde en el mas docil, a su vez de entrenar con trucos que todo dueño desearia ver con su mascota.",R.drawable.escuela,R.drawable.escuela));
        sdContact.add(new Contact("Entretenimiento y Curiosidades", "Revista PETmi","Una revista con suriosidades, Datos interesantes sobre tu mascotas, al igual que un pequeño directorio en caso de necesitar informacion sobre las necesitades de tu mascota.",R.drawable.petmi,R.drawable.petmi));


    }
}