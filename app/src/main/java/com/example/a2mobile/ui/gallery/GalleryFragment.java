package com.example.a2mobile.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2mobile.R;
import com.example.a2mobile.databinding.FragmentGalleryBinding;
import com.example.a2mobile.model.Roupa;
import com.example.a2mobile.model.RoupasAdapter;
import com.example.a2mobile.ui.carrinho.CarrinhoFragment;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private List<Roupa> listaRoupas;
    private RoupasAdapter roupasAdapter;

//    private List<Roupa> listaRoupasSelecionadas = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Configurar a lista de roupas
        listaRoupas = new ArrayList<>();
        // Adicionar roupas à lista
        listaRoupas.add(new Roupa("Casaco", "GG", 50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.casaco, null)));
        listaRoupas.add(new Roupa("Camisa", "M", 50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.camisa, null)));
        listaRoupas.add(new Roupa("Calça", "G", 50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.calca, null)));
        listaRoupas.add(new Roupa("Calça", "G", 50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.calca, null)));
        listaRoupas.add(new Roupa("Calça", "G", 50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.calca, null)));
        listaRoupas.add(new Roupa("Calça", "G", 50.00, ResourcesCompat.getDrawable(getResources(), R.drawable.calca, null)));

        // Configurar o RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.roupasAdapter = new RoupasAdapter(getActivity(), listaRoupas,recyclerView);
        recyclerView.setAdapter(roupasAdapter);

        return rootView;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        FloatingActionButton fab = view.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                exibirRoupasSelecionadas();
//            }
//        });
//    }

//    private void exibirRoupasSelecionadas() {
//        List<Roupa> roupasSelecionadas = roupasAdapter.getListaRoupasSelecionadas();
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Roupa roupa : roupasSelecionadas) {
//            stringBuilder.append(roupa.getNome()).append(", ");
//        }
//        String mensagem;
//        if (stringBuilder.length() > 0) {
//            mensagem = "Roupas selecionadas: " + stringBuilder.toString().substring(0, stringBuilder.length() - 2);
//        } else {
//            mensagem = "Nenhuma roupa selecionada";
//        }
//        Snackbar.make(requireView(), mensagem, Snackbar.LENGTH_LONG).show();
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void openCarrinhoFragment() {
        // Obter a lista de roupas selecionadas do adaptador
        List<Roupa> roupasSelecionadas = roupasAdapter.getListaRoupasSelecionadas();

        // Criar uma instância do CarrinhoFragment
        CarrinhoFragment carrinhoFragment = new CarrinhoFragment();

        // Passar a lista de roupas selecionadas como argumento para o CarrinhoFragment
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("listaRoupasSelecionadas", new ArrayList<>(roupasSelecionadas));
        carrinhoFragment.setArguments(bundle);

        // Abrir o CarrinhoFragment
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, carrinhoFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


//    private void openCarrinhoFragment() {
//        // Criar uma lista para armazenar as roupas selecionadas
//        List<Roupa> roupasSelecionadas = new ArrayList<>();
//
//        // Percorrer a lista de roupas e adicionar as selecionadas à lista roupasSelecionadas
//        for (Roupa roupa : listaRoupas) {
//            if (this.listaRoupasSelecionadas.contains(roupa)) {
//                roupasSelecionadas.add(roupa);
//            }
//        }
//
//        // Navegar para o fragmento CarrinhoFragment passando as roupas selecionadas como argumento
//        CarrinhoFragment carrinhoFragment = CarrinhoFragment.newInstance(listaRoupasSelecionadas);
//        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, carrinhoFragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }
}