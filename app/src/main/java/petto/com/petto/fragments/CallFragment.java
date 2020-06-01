package petto.com.petto.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import petto.com.petto.Main3Activity;
import petto.com.petto.PerfilUsuario;
import petto.com.petto.R;
import petto.com.petto.entidades.Contact;

public class CallFragment extends Fragment {

    View v;
    private RecyclerView CallrecyclerView;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<Contact, CallFragment.NewsViewHolder> mPeopleRVAdapter;


    public CallFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.call_fragment, container, false);


        CallrecyclerView = (RecyclerView) v.findViewById(R.id.callrecyclerview);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("promociones");
        mDatabase.keepSynced(true);


        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("promociones");
        Query personsQuery = personsRef.orderByKey();


        CallrecyclerView.hasFixedSize();
        CallrecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<Contact>().setQuery(personsQuery, Contact.class).build();
        mPeopleRVAdapter = new FirebaseRecyclerAdapter<Contact, CallFragment.NewsViewHolder>(personsOptions) {
            @Override
            protected void onBindViewHolder(@NonNull NewsViewHolder holder, int position, @NonNull final Contact model) {

                final String key=getRef(position).getKey();
                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity().getApplicationContext(), PerfilUsuario.class);
                        intent.putExtra("key", key);

                        startActivity(intent);
                    }
                });


                holder.setTitle(model.getName());
                holder.setDesc(model.getDescripcion());
                holder.setImage(model.getImagen());


            }

            @NonNull
            @Override
            public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.elemento_lista, parent, false);

                return new CallFragment.NewsViewHolder(view);
                }
        };

        CallrecyclerView.setAdapter(mPeopleRVAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPeopleRVAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPeopleRVAdapter.stopListening();


    }


    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setTitle(String title) {
            TextView post_title = (TextView) mView.findViewById(R.id.texttitulo);
            post_title.setText(title);
        }

        public void setDesc(String desc) {
            TextView post_desc = (TextView) mView.findViewById(R.id.textdesc);
            post_desc.setText(desc);
        }

        public void setImage(String imagen) {
            ImageView post_image = (ImageView) mView.findViewById(R.id.imagen);
            Picasso.get().load(imagen).into(post_image);
        }
    }
}
