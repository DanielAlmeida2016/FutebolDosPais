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
public class SetimaRodadaFragment extends Fragment {

    /**
     * * Created by Solange Carlos on 28/10/2017.
     * Cria um singleton da classe
     */
    private static SetimaRodadaFragment fragment = null;

    public static SetimaRodadaFragment newInstance() {
        if (fragment == null) {
            fragment = new SetimaRodadaFragment();
        }
        return fragment;
    }

    public static SetimaRodadaFragment getInstance() {
        return fragment;
    }

    private ListView tabelaResultado;
    private Resultado[] listaResultado;

    public SetimaRodadaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setima_rodada, container, false);

        tabelaResultado = (ListView) view.findViewById(R.id.setima_rodada_tabela);
        listaResultado = NavegacaoRodadasHelper.carregarAdapter(tabelaResultado, listaResultado, 7, 1, getActivity());

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

