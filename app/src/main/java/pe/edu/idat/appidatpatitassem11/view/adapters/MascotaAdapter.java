package pe.edu.idat.appidatpatitassem11.view.adapters;

import android.media.RouteListingPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pe.edu.idat.appidatpatitassem11.databinding.ItemMascotaBinding;
import pe.edu.idat.appidatpatitassem11.retrofit.response.MascotaResponse;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.ViewHolder> {

    List<MascotaResponse> mascotaResponseList = new ArrayList<>();
    List<MascotaResponse> mascotaResponseListOriginal = new ArrayList<>();

    @NonNull
    @Override
    public MascotaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemMascotaBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaAdapter.ViewHolder holder, int position) {
        final MascotaResponse mascotaResponse = mascotaResponseList
                .get(position);
        holder.binding.tvNombre.setText(mascotaResponse.getNommascota());
        holder.binding.tvContacto.setText(mascotaResponse.getContacto());
        holder.binding.tvFecha.setText(mascotaResponse.getFechaperdida());
        holder.binding.tvLugar.setText(mascotaResponse.getLugar());
        Glide.with(holder.binding.getRoot())
                .load(mascotaResponse.getUrlimagen())
                .into(holder.binding.ivMascotas);
    }

    @Override
    public int getItemCount() {
        return mascotaResponseList.size();
    }

    public void setMascotas(List<MascotaResponse> mascotas){
        mascotaResponseList.addAll(mascotas);
        mascotaResponseListOriginal.addAll(mascotas);
    }

    public void filtrarMascotas(String filtro){
        if(filtro.isEmpty()){
            mascotaResponseList.clear();
            mascotaResponseList.addAll(mascotaResponseListOriginal);
        } else{
            List<MascotaResponse> busquedaMascota =
                    mascotaResponseList.stream()
                            .filter(m -> m.getNommascota().contains(filtro))
                            .collect(Collectors.toList());
            mascotaResponseList.clear();
            mascotaResponseList.addAll(busquedaMascota);

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemMascotaBinding binding;
        public ViewHolder(ItemMascotaBinding itemView) {
            super(itemView.getRoot());
            binding= itemView;
        }
    }

}
