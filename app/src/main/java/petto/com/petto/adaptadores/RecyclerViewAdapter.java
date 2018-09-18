package petto.com.petto.adaptadores;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import petto.com.petto.PerfilUsuario;
import petto.com.petto.R;
import petto.com.petto.entidades.Contact;
import petto.com.petto.fragments.CallFragment;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  implements View.OnClickListener{

    Context mContext;
    List<Contact> mData;
    Dialog myDialog;
    CallFragment mFragment;

    public RecyclerViewAdapter(Context mContex, List<Contact> mData, CallFragment mFragment) {
        this.mContext = mContex;
        this.mData = mData;
        this.mFragment = mFragment;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.elemento_lista,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.activity_perfil_usuarios);



        vHolder.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView dialog_name = (TextView) myDialog.findViewById(R.id.idnombretrabajador);
                TextView dialog_descripcion = (TextView) myDialog.findViewById(R.id.iddescripciontrabajador);
                ImageView dialog_img = (ImageView)myDialog.findViewById(R.id.idimagentrabajador);
                Button btnTrabajo = (Button)myDialog.findViewById(R.id.btnTrabajo);

                btnTrabajo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mFragment.getActivity(), PerfilUsuario.class);
                        mFragment.getActivity().startActivity(intent);
                    }
                });

                dialog_name.setText(mData.get(vHolder.getAdapterPosition()).getName());
                dialog_descripcion.setText(mData.get(vHolder.getAdapterPosition()).getDescripcion());
                dialog_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getImagenId());


                myDialog.show();


            }
        });


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.titulo1.setText(mData.get(position).getName());
        holder.contenido1.setText((CharSequence) mData.get(position).getInfo());
        holder.img.setImageResource(mData.get(position).getImagenId());




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {

    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout contact;
        private TextView titulo1;
        private TextView contenido1;
        private ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);

            contact = (LinearLayout) itemView.findViewById(R.id.lista_elemento);
            titulo1 = (TextView) itemView.findViewById(R.id.texttitulo);
            contenido1 = (TextView) itemView.findViewById(R.id.textdesc);
            img = (ImageView) itemView.findViewById(R.id.imagen);

        }
    }
}
