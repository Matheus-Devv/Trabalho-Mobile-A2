package com.example.a2mobile.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2mobile.CarrinhoActivity;
import com.example.a2mobile.R;
import com.example.a2mobile.model.Roupa;
import com.example.a2mobile.model.RoupasAdapter;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private List<Roupa> listaRoupas;
    private RoupasAdapter roupasAdapter;
    private OnRoupasSelecionadasListener roupasSelecionadasListener;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        listaRoupas = new ArrayList<>();
        // Adicionar roupas à lista
        listaRoupas.add(new Roupa("Casaco", "GG", 50.00, R.drawable.casaco));
        listaRoupas.add(new Roupa("Camisa", "M", 50.00, R.drawable.camisa));
        listaRoupas.add(new Roupa("Calça", "G", 50.00, R.drawable.calca));
        listaRoupas.add(new Roupa("Casaco", "P", 50.00, R.drawable.casaco2));
        listaRoupas.add(new Roupa("Camisa", "G", 50.00, R.drawable.camisa2));
        listaRoupas.add(new Roupa("Bone", "M", 50.00, R.drawable.hat));
        listaRoupas.add(new Roupa("Tenis", "43", 50.00, R.drawable.tenis));
        listaRoupas.add(new Roupa("Shorts", "GG", 50.00, R.drawable.shortss));
        listaRoupas.add(new Roupa("Casaco", "P", 50.00, R.drawable.casaco3));
        listaRoupas.add(new Roupa("Tenis", "41", 50.00, R.drawable.tenis2));

        // Configurar o RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.roupasAdapter = new RoupasAdapter(getActivity(), listaRoupas, recyclerView);
        recyclerView.setAdapter(roupasAdapter);

        // Configurar o botão para abrir a CarrinhoActivity
        Button abrirCarrinhoButton = rootView.findViewById(R.id.buttonCarrinho);
        abrirCarrinhoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Roupa> roupasSelecionadas = roupasAdapter.getListaRoupasSelecionadas();
                if (!roupasSelecionadas.isEmpty()) {
                    abrirCarrinhoActivity(roupasSelecionadas);
                } else {
                    Toast.makeText(getActivity(), "Nenhuma roupa selecionada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnRoupasSelecionadasListener) {
            roupasSelecionadasListener = (OnRoupasSelecionadasListener) context;
        } else {
            throw new IllegalStateException("A activity deve implementar OnRoupasSelecionadasListener");
        }
    }

    private void abrirCarrinhoActivity(List<Roupa> roupasSelecionadas) {
        Intent intent = new Intent(getActivity(), CarrinhoActivity.class);
        intent.putExtra("listaRoupasSelecionadas", Parcels.wrap(roupasSelecionadas));
        startActivity(intent);
    }

    public interface OnRoupasSelecionadasListener {
        void onRoupasSelecionadas(List<Roupa> roupasSelecionadas);
    }
}
