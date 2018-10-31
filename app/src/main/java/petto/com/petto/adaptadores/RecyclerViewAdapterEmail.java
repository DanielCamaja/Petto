package petto.com.petto.adaptadores;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import petto.com.petto.R;
import petto.com.petto.entidades.Contact;
import petto.com.petto.fragments.CorreoFragment;

public class RecyclerViewAdapterEmail extends RecyclerView.Adapter<RecyclerViewAdapterEmail.My1ViewHolder> {


    Context mContext1;
    List<Contact> mData1;
    Dialog mDialog;
    CorreoFragment mCorreo;

    public RecyclerViewAdapterEmail(Context mContex1, List<Contact> mData1, CorreoFragment mCorreo) {
        this.mContext1 = mContex1;
        this.mData1 = mData1;
        this.mCorreo = mCorreo;
    }
    @NonNull
    @Override
    public RecyclerViewAdapterEmail.My1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext1).inflate(R.layout.elemento_lista,parent,false);
        final My1ViewHolder v1Holder = new My1ViewHolder(v);

        mDialog = new Dialog(mContext1);
        mDialog.setContentView(R.layout.activity_perfil_correo);

        v1Holder.Lineal01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView dialog_name = (TextView) mDialog.findViewById(R.id.idnombrecorreo);
                TextView dialog_descripcion = (TextView) mDialog.findViewById(R.id.iddescripcioncorreo);
                ImageView dialog_img = (ImageView)mDialog.findViewById(R.id.idimagencorreo);

                dialog_name.setText(mData1.get(v1Holder.getAdapterPosition()).getName());
                dialog_descripcion.setText(mData1.get(v1Holder.getAdapterPosition()).getDescripcion());
                dialog_img.setImageResource(Integer.parseInt(mData1.get(v1Holder.getAdapterPosition()).getImagen()));


                mDialog.show();


            }
        });


        return v1Holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterEmail.My1ViewHolder holder, int position) {

        holder.Titulo01.setText(mData1.get(position).getName());
        holder.contenido01.setText((CharSequence) mData1.get(position).getDescripcion());
        holder.imagen01.setImageResource(Integer.parseInt(mData1.get(position).getImagen()));


    }

    @Override
    public int getItemCount() {
        return mData1.size();
    }

    public class My1ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout Lineal01;
        private TextView Titulo01;
        private TextView contenido01;
        private ImageView imagen01;


        public My1ViewHolder(View itemView) {
            super(itemView);

            Lineal01 = (LinearLayout) itemView.findViewById(R.id.lista_elemento);
            Titulo01 = (TextView) itemView.findViewById(R.id.texttitulo);
            contenido01 = (TextView) itemView.findViewById(R.id.textdesc);
            imagen01 = (ImageView) itemView.findViewById(R.id.imagen);

        }
    }
}