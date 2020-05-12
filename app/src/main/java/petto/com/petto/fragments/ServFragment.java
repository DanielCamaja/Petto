package petto.com.petto.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import petto.com.petto.PerfilAsociaciones;
import petto.com.petto.PerfilUsuario;
import petto.com.petto.R;
import petto.com.petto.entidades.Contact;

import static java.security.AccessController.getContext;

public class ServFragment extends Fragment {


    View v;
    private RecyclerView ServrecyclerView;
    private DatabaseReference mDatabase3;
    private FirebaseRecyclerAdapter<Contact, ServFragment.NewsViewHolder> mPeopleRVAdapter3;

    public ServFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.serv_fragment, container, false);
        ServrecyclerView = (RecyclerView) v.findViewById(R.id.recyclerserv);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDatabase3 = FirebaseDatabase.getInstance().getReference().child("news");
        mDatabase3.keepSynced(true);


        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("news");
        Query personsQuery = personsRef.orderByKey();


        ServrecyclerView.hasFixedSize();
        ServrecyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<Contact>().setQuery(personsQuery, Contact.class).build();

        mPeopleRVAdapter3 = new FirebaseRecyclerAdapter<Contact, ServFragment.NewsViewHolder>(personsOptions) {
            @Override
            protected void onBindViewHolder(@NonNull NewsViewHolder holder, int position, @NonNull Contact model) {

                final String key=getRef(position).getKey();
                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent(getActivity().getApplicationContext(), PerfilAsociaciones.class);
                        intent1.putExtra("key", key);

                        startActivity(intent1);
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
                        .inflate(R.layout.news_row, parent, false);

                return new ServFragment.NewsViewHolder(view);
            }
        };

        ServrecyclerView.setAdapter(mPeopleRVAdapter3);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPeopleRVAdapter3.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPeopleRVAdapter3.stopListening();


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


        public void setImage(int image) {
            ImageView post_image = (ImageView) mView.findViewById(R.id.imagen);
            Picasso.get().load(image).into(post_image);
        }

        public void setImage(String imagen) {
        }
    }
}
