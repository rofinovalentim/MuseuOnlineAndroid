package com.example.rofinochungajr.museuonline.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rofinochungajr.museuonline.R;
import com.example.rofinochungajr.museuonline.domain.model.Especie;


import java.util.List;

public class EspecieAdapter extends RecyclerView.Adapter<EspecieAdapter.ViewHolderEspecie> {


    private List<Especie> dataList;

    public EspecieAdapter(List<Especie> dataList){
        this.dataList = dataList;
    }

    @Override
    public EspecieAdapter.ViewHolderEspecie onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_clientes, parent, false);

        EspecieAdapter.ViewHolderEspecie holderTipoUtilizador = new EspecieAdapter.ViewHolderEspecie(view, parent.getContext());

        return holderTipoUtilizador;

    }
    @Override
    public void onBindViewHolder(EspecieAdapter.ViewHolderEspecie holder, int position) {

        if ( (dataList != null) && (dataList.size() > 0 ) ) {

            Especie especie = dataList.get(position);
            holder.txtNome.setText(especie.getNomeEspecie());
            holder.txtTelefone.setText(especie.getNomeComum());

        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolderEspecie extends RecyclerView.ViewHolder{

        public TextView txtNome;
        public TextView txtTelefone;

        public ViewHolderEspecie(View itemView, final Context context) {
            super(itemView);
            txtNome     = (TextView) itemView.findViewById(R.id.txtNome);
            txtTelefone = (TextView) itemView.findViewById(R.id.txtTelefone);


        /*    itemView.setOnClickListener(new View.OnClickListener() {

               @Override
                public void onClick(View v) {

                    if (dados.size() > 0) {

                        Cliente cliente = dados.get(getLayoutPosition());

                        Intent it = new Intent(context, ActCadCliente.class);
                        it.putExtra("CLIENTE", cliente);
                        ((AppCompatActivity) context).startActivityForResult(it, 0);

                    }
                }

            });
            */

        }

    }
}

