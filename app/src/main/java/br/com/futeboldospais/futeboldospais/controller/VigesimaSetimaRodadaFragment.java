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

public class VigesimaSetimaRodadaFragment extends Fragment {

    /**
     * Created by Bruno on 28/10/2017.
     * Cria um singleton da classe
     */
    private static VigesimaSetimaRodadaFragment fragment = null;

    public static VigesimaSetimaRodadaFragment newInstance() {
        if (fragment == null) {
            fragment = new VigesimaSetimaRodadaFragment();
        }
        return fragment;
    }

    public static VigesimaSetimaRodadaFragment getInstance(){
        return fragment;
    }

    private ListView tabelaResultado;
    private Resultado[] listaResultado;
    private ResultadoService resultadoService;
    private ResultadoAdapter resultadoAdapter;

    public VigesimaSetimaRodadaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vigesimasetima_rodada, container, false);

        tabelaResultado = (ListView) view.findViewById(R.id.vigesimasetima_rodada_tabela);
        Log.d("teste", "adapter fragment");

        resultadoService = new ResultadoService();
        listaResultado = resultadoService.listarDadosPorRodadaETurno(getActivity().getBaseContext(), 27, 4);

        if (listaResultado.length != 0) {
            Log.d("teste", "lista resultado nao é nulo");
            resultadoAdapter = new ResultadoAdapter(listaResultado, getActivity().getBaseContext());
            tabelaResultado.setAdapter(resultadoAdapter);
        } else {
            AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity().getBaseContext(), getString(R.string.lbl_rodada_nao_alcancada));
            tabelaResultado.setAdapter(adapterPadrao);
        }

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


