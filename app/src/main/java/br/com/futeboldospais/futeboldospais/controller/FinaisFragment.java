package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.util.FinaisPageAdapter;

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
        FinaisPageAdapter finaisPageAdapter = new FinaisPageAdapter(getChildFragmentManager());
        viewPager.setAdapter(finaisPageAdapter);
        viewPager.setCurrentItem(0);

        return view;
    }

}
