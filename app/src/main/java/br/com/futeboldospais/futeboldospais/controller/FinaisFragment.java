package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.service.ClassificacaoQuartasService;
import br.com.futeboldospais.futeboldospais.service.DistintivoService;
import br.com.futeboldospais.futeboldospais.util.PageAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinaisFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static FinaisFragment fragment = null;

    public static FinaisFragment newInstance() {
        if (fragment == null) {
            fragment = new FinaisFragment();
        }
        return fragment;
    }


    public FinaisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_finais, container, false);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.page_adapter);
        PageAdapter pageAdapter = new PageAdapter(getChildFragmentManager());
        viewPager.setAdapter(pageAdapter);
        viewPager.setCurrentItem(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }

}
