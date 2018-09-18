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

import petto.com.petto.PerfilAsociaciones;
import petto.com.petto.R;
import petto.com.petto.entidades.Contact;
import petto.com.petto.fragments.ServFragment;

public class RecyclerViewAdapterSer extends RecyclerView.Adapter<RecyclerViewAdapterSer.My2ViewHolder> {

    Context mContext;
    List<Contact> mData2;
    Dialog mDialog2;
    ServFragment mServicio;

    public RecyclerViewAdapterSer(Context mContex, List<Contact> mData2, ServFragment mServicio) {
        this.mContext = mContex;
        this.mData2 = mData2;
        this.mServicio = mServicio;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterSer.My2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.list_menu,parent,false);
        final My2ViewHolder v2Holder = new My2ViewHolder(v);

        mDialog2 = new Dialog(mContext);
        mDialog2.setContentView(R.layout.activity_perfil_asociaciones);


        v2Holder.listamenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView dialog_name1 = (TextView) mDialog2.findViewById(R.id.idnombreasociaciones);
                TextView dialog_descripcion1 = (TextView) mDialog2.findViewById(R.id.iddescripcionasociaciones);
                ImageView dialog_img1 = (ImageView) mDialog2.findViewById(R.id.idimagenasociaciones);
                Button btnAsociaciones = (Button) mDialog2.findViewById(R.id.btnasociaciones);

                btnAsociaciones.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mServicio.getActivity(), PerfilAsociaciones.class);
                        mServicio.getActivity().startActivity(intent);
                    }
                });

                dialog_name1.setText(mData2.get(v2Holder.getAdapterPosition()).getName());
                dialog_descripcion1.setText(mData2.get(v2Holder.getAdapterPosition()).getDescripcion());
                dialog_img1.setImageResource(mData2.get(v2Holder.getAdapterPosition()).getImagenId());


                mDialog2.show();


            }
        });


        return v2Holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterSer.My2ViewHolder holder, int position) {

        holder.nombre.setText(mData2.get(position).getName());
        holder.desc.setText(mData2.get(position).getInfo());
        holder.compania.setImageResource(mData2.get(position).getImagenId());
    }

    @Override
    public int getItemCount() {
        return mData2.size();
    }

    public class My2ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout listamenu;
        private TextView nombre;
        private TextView desc;
        private ImageView compania;

        public My2ViewHolder(View itemView) {
            super(itemView);

            listamenu = (LinearLayout) itemView.findViewById(R.id.idlistamenu);
            nombre =(TextView) itemView.findViewById(R.id.idtitulo);
            desc = (TextView) itemView.findViewById(R.id.textoc);
            compania =(ImageView) itemView.findViewById(R.id.idimagen1);


        }
    }
}
