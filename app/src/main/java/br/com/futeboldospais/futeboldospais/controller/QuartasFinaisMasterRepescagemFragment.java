package br.com.futeboldospais.futeboldospais.controller;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.service.ClassificacaoQuartasService;
import br.com.futeboldospais.futeboldospais.util.QuartasFinaisListaPrincipalAdapter;

/**
 * Created by Pâmela Fidelis on 11/11/17.
 * Alterado por: Pâmela Fidelis em 04/12/17.
 * Objetivo: Junção das Lists Views
 */

public class QuartasFinaisMasterRepescagemFragment extends Fragment{


    private ListView tabela;
    private RelativeLayout relativeLayout;

    private Classificacao[] lista_quartas;
    private ClassificacaoQuartasService quartasFinaisService;

    private QuartasFinaisListaPrincipalAdapter listaAdapter;


    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe e pega a categoria e grupo
     */
    private static QuartasFinaisMasterRepescagemFragment fragment = null;

    public static QuartasFinaisMasterRepescagemFragment newInstance() {
        if (fragment == null) {
            fragment = new QuartasFinaisMasterRepescagemFragment();
        }

        return fragment;
    }

    public QuartasFinaisMasterRepescagemFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_quartas_finais_master_repescagem, container, false);

        relativeLayout = (RelativeLayout) view.findViewById(R.id.titulo_tabela);

        Configuration configuration = getResources().getConfiguration();

        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){

            int f =  (int) getResources().getDisplayMetrics().density * 30;
            relativeLayout.getLayoutParams().height = f;

        }else{
            int f =  (int) getResources().getDisplayMetrics().density * 50;
            relativeLayout.getLayoutParams().height = f;
        }

        quartasFinaisService = new ClassificacaoQuartasService();

        tabela = (ListView) view.findViewById(R.id.quartas_tabela_master_repescagem);

        lista_quartas = quartasFinaisService.listarQuartasPorCategoriaGrupo(getActivity()
                .getBaseContext(), getString(R.string.str_master_minuscula), getString(R.string.str_repescagem_minuscula));


        listaAdapter = new QuartasFinaisListaPrincipalAdapter(lista_quartas, getActivity().getBaseContext());
        tabela.setAdapter(listaAdapter);

        return view;
    }
}