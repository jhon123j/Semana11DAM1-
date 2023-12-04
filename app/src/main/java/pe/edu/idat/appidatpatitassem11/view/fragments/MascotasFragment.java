package pe.edu.idat.appidatpatitassem11.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.edu.idat.appidatpatitassem11.R;
import pe.edu.idat.appidatpatitassem11.databinding.FragmentMascotasBinding;
import pe.edu.idat.appidatpatitassem11.databinding.ItemMascotaBinding;
import pe.edu.idat.appidatpatitassem11.retrofit.response.MascotaResponse;
import pe.edu.idat.appidatpatitassem11.view.adapters.MascotaAdapter;
import pe.edu.idat.appidatpatitassem11.viewmodel.MascotaViewModel;

public class MascotasFragment extends Fragment {

    private FragmentMascotasBinding binding;
    private MascotaViewModel mascotaViewModel;
    private MascotaAdapter mascotaAdapter = new MascotaAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMascotasBinding.inflate(inflater,
                container,false);
        mascotaViewModel = new ViewModelProvider(requireActivity())
                .get(MascotaViewModel.class);
        binding.rvMascotas.setLayoutManager(
                new LinearLayoutManager(requireActivity())
        );
        binding.rvMascotas.setAdapter(mascotaAdapter);
        mascotaViewModel.listarmascotas();
        mascotaViewModel.listMutableLiveData.observe(
                getViewLifecycleOwner(),
                new Observer<List<MascotaResponse>>() {
                    @Override
                    public void onChanged(List<MascotaResponse> mascotaResponses) {
                        mascotaAdapter.setMascotas(mascotaResponses);
                    }
                }
        );
        return binding.getRoot();
    }
}