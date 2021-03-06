package br.com.futeboldospais.futeboldospais.controller;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.service.ResultadoService;
import br.com.futeboldospais.futeboldospais.util.AdapterPadrao;
import br.com.futeboldospais.futeboldospais.util.NavegacaoRodadasHelper;
import br.com.futeboldospais.futeboldospais.util.ResultadoAdapter;


/**
 * A simple {@link Fragment} subclass.
 */

public class VigesimaSextaRodadaFragment extends Fragment {

    /**
     * Created by Bruno on 28/10/2017.
     * Cria um singleton da classe
     */
    private static VigesimaSextaRodadaFragment fragment = null;

    public static VigesimaSextaRodadaFragment newInstance() {
        if (fragment == null) {
            fragment = new VigesimaSextaRodadaFragment();
        }
        return fragment;
    }

    public static VigesimaSextaRodadaFragment getInstance() {
        return fragment;
    }

    private Resultado[] listaResultado;

    public VigesimaSextaRodadaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vigesimasexta_rodada, container, false);

        ListView tabelaResultado = (ListView) view.findViewById(R.id.vigesimasexta_rodada_tabela);
        listaResultado = NavegacaoRodadasHelper.carregarAdapter(tabelaResultado, listaResultado, 26, 3, getActivity());

        tabelaResultado.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (listaResultado[position].getGolsEquipe1() != -1 && listaResultado[position].getGolsEquipe2() != -1) {
                    NavegacaoRodadasHelper.abrirSumula(listaResultado, position, getActivity());
                }
            }

        });

        return view;
    }

}


