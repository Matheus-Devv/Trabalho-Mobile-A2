package com.example.a2mobile.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2mobile.R;

import java.util.ArrayList;
import java.util.List;

public class RoupasAdapter extends RecyclerView.Adapter<RoupasAdapter.RoupaViewHolder> {

    private Context context;
    private  List<Roupa> listaRoupas;
    public  List<Roupa> listaRoupasSelecionadas;
    private RecyclerView recyclerView;

    public RoupasAdapter() {
    }

    public RoupasAdapter(Context context, List<Roupa> listaRoupas, RecyclerView recyclerView) {
        this.context = context;
        this.listaRoupas = listaRoupas;
        this.listaRoupasSelecionadas = new ArrayList<>();
        this.recyclerView = recyclerView; // Atribua a referência do RecyclerView
    }

    @NonNull
    @Override
    public RoupaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_roupa, parent, false);
        return new RoupaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoupaViewHolder holder, int position) {
        final int adapterPosition = position;
        Roupa roupa = listaRoupas.get(adapterPosition);
        holder.bind(roupa);

        holder.itemView.setSelected(listaRoupasSelecionadas.contains(roupa));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSelecao(adapterPosition);
            }
        });
    }


    @Override
    public int getItemCount() {
        if (listaRoupas == null) {
            return 0;
        }
        return listaRoupas.size();
    }

    public class RoupaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textViewNome;
        private TextView textViewTamanho;
        private TextView textViewPreco;

        public RoupaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.roupa_imagem);
            textViewNome = itemView.findViewById(R.id.roupa_nome);
            textViewTamanho = itemView.findViewById(R.id.roupa_tamanho);
            textViewPreco = itemView.findViewById(R.id.roupa_preco);
        }

        public void bind(Roupa roupa) {
            imageView.setImageDrawable(roupa.getDrawable());
            textViewNome.setText(roupa.getNome());
            textViewTamanho.setText(roupa.getTamanho());
            textViewPreco.setText(roupa.getPreco().toString());
        }

    }

    public void toggleSelecao(int position) {
        Roupa roupa = listaRoupas.get(position);
        if (listaRoupasSelecionadas.contains(roupa)) {
            listaRoupasSelecionadas.remove(roupa);
        } else {
            listaRoupasSelecionadas.add(roupa);
        }
        notifyItemChanged(position);
    }


    public List<Roupa> getListaRoupasSelecionadas() {
        return listaRoupasSelecionadas;
    }

}
