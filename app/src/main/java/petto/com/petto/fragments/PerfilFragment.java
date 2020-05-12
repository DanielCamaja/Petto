package petto.com.petto.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import petto.com.petto.Inicio.MainActivity;
import petto.com.petto.R;

public class PerfilFragment extends Fragment {

    private Button btnsal;
    private FirebaseAuth mAuth;
    View v;
    public PerfilFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.perfil_fragment,container,false);



        return v;
    }
}
