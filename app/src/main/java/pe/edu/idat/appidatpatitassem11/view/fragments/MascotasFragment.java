package pe.edu.idat.appidatpatitassem11.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.idat.appidatpatitassem11.R;
import pe.edu.idat.appidatpatitassem11.databinding.FragmentMascotasBinding;
import pe.edu.idat.appidatpatitassem11.databinding.ItemMascotaBinding;

public class MascotasFragment extends Fragment {

    private FragmentMascotasBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMascotasBinding.inflate(inflater,
                container,false);
        return binding.getRoot();
    }
}