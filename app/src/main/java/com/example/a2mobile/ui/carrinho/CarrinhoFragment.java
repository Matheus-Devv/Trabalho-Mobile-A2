package com.example.a2mobile.ui.carrinho;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2mobile.R;
import com.example.a2mobile.model.Roupa;
import com.example.a2mobile.model.RoupasAdapter;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoFragment extends Fragment {

    private RoupasAdapter roupasAdapter;

    private List<Roupa> listaRoupasSelecionadas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_carrinho, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.carrinho_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Obter a lista de roupas selecionadas do Bundle de argumentos
        Bundle arguments = getArguments();
        if (arguments != null) {
            listaRoupasSelecionadas = arguments.getParcelableArrayList("listaRoupasSelecionadas");
        } else {
            listaRoupasSelecionadas = new ArrayList<>();
        }

        roupasAdapter = new RoupasAdapter(getActivity(), listaRoupasSelecionadas, recyclerView);
        recyclerView.setAdapter(roupasAdapter);

        return rootView;
    }

}
