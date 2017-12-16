package com.unamjorge.practicas.persistenciapentangram.Adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.unamjorge.practicas.persistenciapentangram.Pojo.PojoMascota;
import com.unamjorge.practicas.persistenciapentangram.R;

import java.util.ArrayList;

/**
 * Created by Jorge Urueta on 15/12/2017.
 */

public class MascotaAdaptadorPerfil extends RecyclerView.Adapter<MascotaAdaptadorPerfil.MascotaAdaptadorPerfilViewHolder> {

    ArrayList<PojoMascota> pojoMascotas;
    Activity activity;


    public MascotaAdaptadorPerfil(ArrayList<PojoMascota> pojoMascotas, Activity activity){
        this.pojoMascotas = pojoMascotas;
        this.activity = activity;
    }

    @Override
    public MascotaAdaptadorPerfil.MascotaAdaptadorPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_perfil, parent, false);
        return new MascotaAdaptadorPerfil.MascotaAdaptadorPerfilViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final MascotaAdaptadorPerfil.MascotaAdaptadorPerfilViewHolder holder, int position) {

        final PojoMascota pojoMascota = pojoMascotas.get(position);
        holder.imgFotoPerfil.setImageResource(pojoMascota.getFoto());

        holder.tvLikeMascotaCVPerfil.setText(pojoMascota.getNumLike() + " Likes");
    }


    @Override
    public int getItemCount() {
        return this.pojoMascotas.size();
    }

    public static class MascotaAdaptadorPerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoPerfil;
        private TextView tvLikeMascotaCVPerfil;
        private ImageButton btnCantLikePerfil;

        public MascotaAdaptadorPerfilViewHolder(View itemView) {
            super(itemView);

            this.imgFotoPerfil = (ImageView)itemView.findViewById(R.id.imgFotoPerfil);
            this.tvLikeMascotaCVPerfil = (TextView)itemView.findViewById(R.id.tvLikeMascotaCVPerfil);
            this.btnCantLikePerfil = (ImageButton)itemView.findViewById(R.id.btnCantLikePerfil);
        }
    }
}
