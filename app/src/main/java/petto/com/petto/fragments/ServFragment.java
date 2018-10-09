package petto.com.petto.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import petto.com.petto.R;
import petto.com.petto.entidades.Contact;

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

        mDatabase3 = FirebaseDatabase.getInstance().getReference().child("directorio");
        mDatabase3.keepSynced(true);


        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("directorio");
        Query personsQuery = personsRef.orderByKey();


        ServrecyclerView.hasFixedSize();
        ServrecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<Contact>().setQuery(personsQuery, Contact.class).build();

        mPeopleRVAdapter3 = new FirebaseRecyclerAdapter<Contact, ServFragment.NewsViewHolder>(personsOptions) {
            @Override
            protected void onBindViewHolder(@NonNull NewsViewHolder holder, int position, @NonNull Contact model) {
                holder.setTitle(model.getName());
                holder.setDesc(model.getDescripcion());
                holder.setImage(getActivity().getApplicationContext(),model.getImagen());
                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity().getApplicationContext(), PerfilDirectorio.class);
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_menu, parent, false);

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
            TextView post_title = (TextView) mView.findViewById(R.id.asociaciontitulo);
            post_title.setText(title);
        }

        public void setDesc(String desc) {
            TextView post_desc = (TextView) mView.findViewById(R.id.asociaciondesc);
            post_desc.setText(desc);
        }

        public void setImage(Context ctx, String image) {
            ImageView post_image = (ImageView) mView.findViewById(R.id.asociacionimagen);
            Picasso.get().load(image).into(post_image);
        }
    }
}
