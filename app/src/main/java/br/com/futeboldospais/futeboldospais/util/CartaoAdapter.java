package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Cartao;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.service.DistintivoService;

/**
 * Created by Bruno e Solange on 28/10/2017.
 */

public class CartaoAdapter extends BaseAdapter{

    private DistintivoService distintivoService;
    private Cartao[] listaCartao;
    private Context context;

    public CartaoAdapter(Cartao[] cartao, Context context){
        this.listaCartao = cartao;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaCartao.length;
    }

    @Override
    public Object getItem(int position) {
        return listaCartao[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_cartao, parent, false);

            TextView jogador = (TextView) view.findViewById(R.id.jogador);
            ImageView equipe = (ImageView) view.findViewById(R.id.equipe);
            TextView data = (TextView) view.findViewById(R.id.data);
            ImageView adversario = (ImageView) view.findViewById(R.id.adversario);
            TextView tempo = (TextView) view.findViewById(R.id.tempo);
            TextView numero = (TextView) view.findViewById(R.id.numero);

            ViewHolderCartao viewHolderCartao = new ViewHolderCartao(jogador, equipe, data, /*juiz,*/ adversario, tempo, numero);

            view.setTag(viewHolderCartao);
        }

        distintivoService = new DistintivoService();

        ViewHolderCartao viewHolderCartao = (ViewHolderCartao) view.getTag();
        viewHolderCartao.getJogador().setText(listaCartao[position].getJogador());
        try {
            viewHolderCartao.getAdversario().setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), listaCartao[position].getAdversario()));
            viewHolderCartao.getEquipe().setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), listaCartao[position].getEquipe()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolderCartao.getData().setText(listaCartao[position].getData());
        if(listaCartao[position].getTempo().length() > 1) {
            viewHolderCartao.getTempo().setText("" + listaCartao[position].getTempo().charAt(0) + "" + listaCartao[position].getTempo().charAt(1) + "\"");
        }
        else{
            viewHolderCartao.getTempo().setText("" + listaCartao[position].getTempo().charAt(0) + "\"");
        }
        viewHolderCartao.getNumero().setText(String.valueOf(listaCartao[position].getNumero()));

        return view;
    }
}
