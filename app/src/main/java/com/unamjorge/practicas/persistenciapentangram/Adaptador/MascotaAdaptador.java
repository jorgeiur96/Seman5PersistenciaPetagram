package com.unamjorge.practicas.persistenciapentangram.Adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.unamjorge.practicas.persistenciapentangram.DB.ConstructorMascotas;
import com.unamjorge.practicas.persistenciapentangram.Pojo.PojoMascota;
import com.unamjorge.practicas.persistenciapentangram.R;

import java.util.ArrayList;

/**
 * Created by Jorge Urueta on 15/12/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {


    ArrayList<PojoMascota> pojoMascotas;
    Activity activity;


    public MascotaAdaptador(ArrayList<PojoMascota> pojoMascotas, Activity activity){
        this.pojoMascotas = pojoMascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {


        final PojoMascota pojoMascota = pojoMascotas.get(position);
        holder.imgFoto.setImageResource(pojoMascota.getFoto());
        holder.tvNombreMascotaCV.setText(pojoMascota.getNombre());
        holder.tvLikeMascotaCV.setText(pojoMascota.getNumLike() + " Likes");

        holder.btnLike.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascotas(pojoMascota);
                holder.tvLikeMascotaCV.setText(constructorMascotas.obtenerLikesMascota(pojoMascota)+" Likes");
            }
        });

    }


    @Override
    public int getItemCount() {
        return this.pojoMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreMascotaCV;
        private TextView tvLikeMascotaCV;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            this.imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            this.imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            this.tvNombreMascotaCV = (TextView)itemView.findViewById(R.id.tvNombreMascotaCV);
            this.tvLikeMascotaCV = (TextView)itemView.findViewById(R.id.tvLikeMascotaCV);
            this.btnLike = (ImageButton)itemView.findViewById(R.id.btnLike);

/*
          */
        }
    }
}
