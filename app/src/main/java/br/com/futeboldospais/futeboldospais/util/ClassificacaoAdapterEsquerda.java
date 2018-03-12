package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.service.DistintivoService;

/**
 * Created by danieldea on 28/09/2017.
 */

public class ClassificacaoAdapterEsquerda extends BaseAdapter{

    private DistintivoService distintivoService;
    private Classificacao[] listaClassificacao;
    private Context context;
    private int count;

    public ClassificacaoAdapterEsquerda(Classificacao[] classificacaos, Context context){
        this.listaClassificacao = classificacaos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaClassificacao.length;
    }

    @Override
    public Object getItem(int position) {
        return listaClassificacao[position];
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

            view = inflater.inflate(R.layout.linha_classificacao_esq, parent, false);

            TextView posicao = (TextView) view.findViewById(R.id.posicao);
            ImageView escudo = (ImageView) view.findViewById(R.id.escudo);
            TextView equipe = (TextView) view.findViewById(R.id.equipe);

            ViewHolderClassificacaoEsquerda viewHolderClassificacaoEsquerda = new ViewHolderClassificacaoEsquerda(posicao, escudo, equipe);
            view.setTag(viewHolderClassificacaoEsquerda);

            distintivoService = new DistintivoService();
        }

        count = count + 1;
        ViewHolderClassificacaoEsquerda viewHolderClassificacaoEsquerda = (ViewHolderClassificacaoEsquerda)view.getTag();

        viewHolderClassificacaoEsquerda.getPosicao().setText(String.valueOf(position + 1));

        try {
            viewHolderClassificacaoEsquerda.getEscudo().setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), listaClassificacao[position].getEquipe()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolderClassificacaoEsquerda.getEquipe().setText(listaClassificacao[position].getEquipe());

        return view;
    }
}
