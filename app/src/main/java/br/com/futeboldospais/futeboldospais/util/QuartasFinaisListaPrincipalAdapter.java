package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
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
 * Created by Pamela Fidelis on 03/12/17.
 */

public class QuartasFinaisListaPrincipalAdapter extends BaseAdapter {


    private DistintivoService distintivoService;
    private Classificacao[] listaClassificacao;
    private Context context;
    TextView posicao;

    public QuartasFinaisListaPrincipalAdapter(Classificacao[] classificacaos, Context context) {
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
        if (view == null) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(R.layout.linha_quartas_finais_principal, parent, false);

        posicao = (TextView) view.findViewById(R.id.posicao_m);
        ImageView escudo = (ImageView) view.findViewById(R.id.escudo_m);
        TextView equipe = (TextView) view.findViewById(R.id.equipe_m);
        TextView pontos = (TextView) view.findViewById(R.id.pontos_ganhos_m);
        TextView jogos = (TextView) view.findViewById(R.id.jogos_m);
        TextView vitorias = (TextView) view.findViewById(R.id.vitorias_m);
        TextView saldo_gols = (TextView) view.findViewById(R.id.saldo_gols_m);


        distintivoService = new DistintivoService();

         ViewHolderQuartasPrincipal viewHolderQuartas = new ViewHolderQuartasPrincipal(posicao, escudo, equipe, pontos,
                    jogos, vitorias, saldo_gols);

            view.setTag(viewHolderQuartas);


        }

        ViewHolderQuartasPrincipal viewHolderQuartas
                = (ViewHolderQuartasPrincipal) view.getTag();

        viewHolderQuartas.getPosicao().setText(String.valueOf(position + 1));

        //posicao.setText(String.valueOf(position + 1) + "º");

        try {
            viewHolderQuartas.getEscudo().setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), listaClassificacao[position].getEquipe()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        viewHolderQuartas.getEquipe().setText(listaClassificacao[position].getEquipe());

        viewHolderQuartas.getPontosGanhos().setText(String.valueOf(listaClassificacao[position].getPontosGanhos()));
        viewHolderQuartas.getJogos().setText(String.valueOf(listaClassificacao[position].getJogos()));
        viewHolderQuartas.getVitorias().setText(String.valueOf(listaClassificacao[position].getVitorias()));
        viewHolderQuartas.getSaldoGols().setText(String.valueOf(listaClassificacao[position].getSaldoGols()));
        return view;
    }

}