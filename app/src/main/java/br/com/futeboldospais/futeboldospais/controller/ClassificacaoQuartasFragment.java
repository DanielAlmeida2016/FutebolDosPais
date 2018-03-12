package br.com.futeboldospais.futeboldospais.controller;


import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.util.QuartasFinaisPagerAdapter;


/**
 * Created by Pamela Fidelis on 10/11/2017
 * Objetivo: Inclusão da classe
 * <p>
 * Modifield: Pâmela Fidelis on 11/11/2017.
 * Incluido navegação por ViewPager.
 * <p>
 * Alterado por: Pâmela Fidelis
 * Objetivo: Remoção de string "chumbada" no código, código comentado e logs
 * Dt. alteração: 24/11/2017
 * <p>
 * Alterado por: Pamela Fidelis
 * Objetivo: Inclusão de Evento no View Pager
 * </p>
 */
public class ClassificacaoQuartasFragment extends Fragment {

    private static ClassificacaoQuartasFragment fragment = null;

    private LinearLayout div1;
    private TabLayout tabs;

    private RadioButton btn_master;
    private RadioButton btn_senior;
    private ViewPager pager;

    private QuartasFinaisPagerAdapter adapter;

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    public static ClassificacaoQuartasFragment newInstance() {
        if (fragment == null) {
            fragment = new ClassificacaoQuartasFragment();
        }
        return fragment;
    }

    public ClassificacaoQuartasFragment() {
        // Required empty public constructor
    }

    /**
     * @author Pâmela Fidelis on 11/11/2017
     * @return um viewPager
     * <p>
     * Modificado por: Pâmela Fidelis
     * Objetivo: Inclusão de evento para o pager
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classificacao_quartas, container, false);

        div1 = (LinearLayout) view.findViewById(R.id.div1);
        tabs = (TabLayout) view.findViewById(R.id.tabs);

        Configuration configuration = getResources().getConfiguration();

        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){

            int f =  (int) getResources().getDisplayMetrics().density * 30;
            div1.getLayoutParams().height = f;
            tabs.getLayoutParams().height = f;

        }else{
            int f =  (int) getResources().getDisplayMetrics().density * 50;
            div1.getLayoutParams().height = f;
            tabs.getLayoutParams().height = f;
        }


        pager = (ViewPager) view.findViewById(R.id.pager);

        btn_master = (RadioButton) view.findViewById(R.id.rbt_master);
        btn_senior = (RadioButton) view.findViewById(R.id.rbt_senior);

        tabs.setTabTextColors(
                ContextCompat.getColor(getContext(), R.color.gray_light),
                ContextCompat.getColor(getContext(), R.color.black)
        );

        adapter = new QuartasFinaisPagerAdapter(getChildFragmentManager(), getActivity().getBaseContext());
        pager.setAdapter(adapter);
        //pager.setActivated(true);

        //pager.setOffscreenPageLimit(4);


        //btn_master.setChecked(true);
        pager.setCurrentItem(0);

        /**
         * Autor: Pamela Fidelis em 03.11.2017
         * Objetivo: customizar o botão e o tírulo quando página scrollada
         */
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //pager.onSaveInstanceState();
                if (position == 0 || position == 1) {

                    btn_senior.setBackground(null);
                    btn_master.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.efeito_filter));

                    btn_master.setTextColor(Color.BLACK);
                    btn_senior.setTextColor(Color.LTGRAY);

                }else if(position == 2 || position == 3) {
                    btn_master.setBackground(null);
                    btn_senior.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.efeito_filter));

                    btn_senior.setTextColor(Color.BLACK);
                    btn_master.setTextColor(ContextCompat.getColor(getContext(), R.color.gray_light));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        /**
         * @author Denilson Araújo
         * <p>
         * Modificado por Pamela Fidelis em 03/12/17
         */
        // acao de mudar a tabela
        btn_master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //btn_master.setChecked(true);
                //btn_senior.setChecked(false);
                pager.setCurrentItem(0);
            }
        });

        //acao de mudar a tabela
        btn_senior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //btn_senior.setChecked(true);
                //btn_master.setChecked(false);
                pager.setCurrentItem(2);
            }
        });
        return view;
    }

}
