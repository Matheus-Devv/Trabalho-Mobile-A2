package com.example.a2mobile.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2mobile.R;
import com.example.a2mobile.databinding.FragmentGalleryBinding;
import com.example.a2mobile.model.Roupa;
import com.example.a2mobile.model.RoupasAdapter;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private List<Roupa> listaRoupas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Configurar a lista de roupas
        listaRoupas = new ArrayList<>();
        // Adicionar roupas à lista
        listaRoupas.add(new Roupa("Casaco", "GG",50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.casaco, null)));
        listaRoupas.add(new Roupa("Camisa", "M",50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.camisa, null)));
        listaRoupas.add(new Roupa("Calça", "G",50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.calca, null)));
        listaRoupas.add(new Roupa("Calça", "G",50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.calca, null)));
        listaRoupas.add(new Roupa("Calça", "G",50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.calca, null)));
        listaRoupas.add(new Roupa("Calça", "G",50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.calca, null)));
        listaRoupas.add(new Roupa("Calça", "G",50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.calca, null)));
        listaRoupas.add(new Roupa("Calça", "G",50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.calca, null)));

        // Configurar o RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RoupasAdapter roupasAdapter = new RoupasAdapter(getActivity(), listaRoupas);
        recyclerView.setAdapter(roupasAdapter);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}