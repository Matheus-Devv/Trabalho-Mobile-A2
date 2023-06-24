package com.example.a2mobile.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2mobile.R;
import com.example.a2mobile.model.Roupa;
import com.example.a2mobile.model.RoupasAdapter;
import com.example.a2mobile.ui.carrinho.CarrinhoFragment;

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

        // Configurar a lista de roupas
        listaRoupas = new ArrayList<>();
        // Adicionar roupas à lista
        listaRoupas.add(new Roupa("Casaco", "GG", 50.00, R.drawable.casaco));
        listaRoupas.add(new Roupa("Camisa", "M", 50.00, R.drawable.camisa));
        listaRoupas.add(new Roupa("Calça", "G", 50.00, R.drawable.calca));
        listaRoupas.add(new Roupa("Calça", "G", 50.00, R.drawable.calca));
        listaRoupas.add(new Roupa("Calça", "G", 50.00, R.drawable.calca));
        listaRoupas.add(new Roupa("Calça", "G", 50.00, R.drawable.calca));

        // Configurar o RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.roupasAdapter = new RoupasAdapter(getActivity(), listaRoupas, recyclerView);
        recyclerView.setAdapter(roupasAdapter);

        // Configurar o botão para abrir o CarrinhoFragment
        Button carrinhoButton = rootView.findViewById(R.id.buttonCarrinho);
        carrinhoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCarrinhoFragment();
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


    private void openCarrinhoFragment() {
        // Obter a lista de roupas selecionadas do adaptador
        List<Roupa> roupasSelecionadas = roupasAdapter.getListaRoupasSelecionadas();

        // Criar uma instância do CarrinhoFragment
        CarrinhoFragment carrinhoFragment = new CarrinhoFragment();

        // Passar a lista de roupas selecionadas como argumento para o CarrinhoFragment
        Bundle bundle = new Bundle();
        bundle.putParcelable("listaRoupasSelecionadas", Parcels.wrap(roupasSelecionadas));
        carrinhoFragment.setArguments(bundle);

        // Abrir o CarrinhoFragment
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, carrinhoFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public interface OnRoupasSelecionadasListener {
        void onRoupasSelecionadas(List<Roupa> roupasSelecionadas);
    }

}
