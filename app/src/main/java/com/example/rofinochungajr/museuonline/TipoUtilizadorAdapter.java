package com.example.rofinochungajr.museuonline;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rofinochungajr.museuonline.domain.model.TipoUtilizador;

import java.util.List;

public class TipoUtilizadorAdapter extends RecyclerView.Adapter<TipoUtilizadorAdapter.ViewHolderTipoUtilizador> {


    private List<TipoUtilizador> dados;

    public TipoUtilizadorAdapter(List<TipoUtilizador> dados){
        this.dados = dados;
    }

    @Override
    public TipoUtilizadorAdapter.ViewHolderTipoUtilizador onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_clientes, parent, false);

        ViewHolderTipoUtilizador holderTipoUtilizador = new ViewHolderTipoUtilizador(view, parent.getContext());

        return holderTipoUtilizador;

    }
    @Override
    public void onBindViewHolder(TipoUtilizadorAdapter.ViewHolderTipoUtilizador holder, int position) {

        if ( (dados != null) && (dados.size() > 0 ) ) {

             TipoUtilizador tipoUtilizador = dados.get(position);
             holder.txtNome.setText(tipoUtilizador.getIdTipoUtilizador());
             holder.txtTelefone.setText(tipoUtilizador.getTipoUtilizador());

        }

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolderTipoUtilizador extends RecyclerView.ViewHolder{

        public TextView txtNome;
        public TextView txtTelefone;

        public ViewHolderTipoUtilizador(View itemView, final Context context) {
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
