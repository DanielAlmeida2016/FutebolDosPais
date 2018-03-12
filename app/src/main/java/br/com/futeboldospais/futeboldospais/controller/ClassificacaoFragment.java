package br.com.futeboldospais.futeboldospais.controller;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.model.ClassificacaoQuartas;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.service.ClassificacaoService;
import br.com.futeboldospais.futeboldospais.service.ResultadoService;
import br.com.futeboldospais.futeboldospais.util.ClassificacaoAdapterDireita;
import br.com.futeboldospais.futeboldospais.util.ClassificacaoAdapterEsquerda;
import br.com.futeboldospais.futeboldospais.util.ModalClassificacao;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClassificacaoFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static ClassificacaoFragment fragment = null;

    public static ClassificacaoFragment newInstance() {
        if (fragment == null) {
            fragment = new ClassificacaoFragment();
        }
        return fragment;
    }

    private RadioButton rbtGeral;
    private RadioButton rbtQuartas;
    private RadioButton rbtFinais;
    private RadioButton rbtQuartas2;
    private RadioButton rbtGeral2;
    private ResultadoService resultadoService;

    public ClassificacaoFragment() {
        // Required empty public constructor
    }

    /** Alterado por: Pâmela Fidelis
     * Objetivo: Remoção de string "chumbada" no código, código comentado e logs
     * Dt. alteração: 24/11/2017
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_classificacao, container, false);

        resultadoService = new ResultadoService();

        RadioGroup toggle = (RadioGroup) view.findViewById(R.id.toggle);
        RadioGroup toggle2 = (RadioGroup) view.findViewById(R.id.toggle2);

        toggle.setVisibility(View.INVISIBLE);
        toggle2.setVisibility(View.INVISIBLE);

        if(resultadoService.listarDadosRodadaAtual(getContext()) >= 20 && resultadoService.listarDadosRodadaAtual(getContext()) < 26){
            toggle2.setVisibility(View.VISIBLE);

        }else if(resultadoService.listarDadosRodadaAtual(getContext()) >= 26){
            toggle.setVisibility(View.VISIBLE);
        }

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_classificacao, ClassificacaoGeralFragment.newInstance());
        transaction.commit();

        rbtGeral = (RadioButton) view.findViewById(R.id.rbt_geral);
        rbtGeral.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        rbtGeral.setBackground(ContextCompat.getDrawable(getContext(),
                R.drawable.arredondar_borda_esq_cinza));

        rbtQuartas = (RadioButton) view.findViewById(R.id.rbt_quartas);
        rbtFinais = (RadioButton) view.findViewById(R.id.rbt_finais);

        rbtQuartas2 = (RadioButton) view.findViewById(R.id.rbt_quartas2);
        rbtGeral2 = (RadioButton) view.findViewById(R.id.rbt_geral2);
        rbtGeral2.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        rbtGeral2.setBackground(ContextCompat.getDrawable(getContext(),
                R.drawable.arredondar_borda_esq_cinza));

        rbtGeral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbtGeral.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtGeral.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_esq_cinza));

                rbtQuartas.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtQuartas.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.meio_branco));

                rbtFinais.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtFinais.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_dir_branco));

                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_classificacao, ClassificacaoGeralFragment.newInstance());
                transaction.commit();
            }
        });

        rbtQuartas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbtGeral.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtGeral.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_esq_branco));

                rbtQuartas.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtQuartas.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.meio_cinza));

                rbtFinais.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtFinais.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_dir_branco));

                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_classificacao, new ClassificacaoQuartasFragment());
                transaction.commit();
            }
        });

        rbtFinais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbtGeral.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtGeral.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_esq_branco));

                rbtQuartas.setTextColor(ContextCompat.getColor(getContext(),
                        R.color.black));
                rbtQuartas.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.meio_branco));

                rbtFinais.setTextColor(ContextCompat.getColor(getContext(),
                        R.color.white));
                rbtFinais.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_dir_cinza));

                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_classificacao, FinaisFragment.newInstance());
                transaction.commit();
            }
        });

        Button btnTipClassificacao = (Button) view.findViewById(R.id.btn_tip_classificacao);

        btnTipClassificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ModalClassificacao.class);
                startActivity(intent);
            }
        });


        rbtGeral2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbtGeral2.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtGeral2.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_esq_cinza));

                rbtQuartas2.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtQuartas2.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_dir_branco));

                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_classificacao, ClassificacaoGeralFragment.newInstance());
                transaction.commit();
            }
        });

        rbtQuartas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbtGeral2.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtGeral2.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_esq_branco));

                rbtQuartas2.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtQuartas2.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_dir_cinza));

                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_classificacao, new ClassificacaoQuartasFragment());
                transaction.commit();
            }
        });

        return view;
    }
}
