package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.controller.QuartasFinaisMasterPrincipalFragment;
import br.com.futeboldospais.futeboldospais.controller.QuartasFinaisMasterRepescagemFragment;
import br.com.futeboldospais.futeboldospais.controller.QuartasFinaisSeniorPrincipalFragment;
import br.com.futeboldospais.futeboldospais.controller.QuartasFinaisSeniorRepescagemFragment;
import br.com.futeboldospais.futeboldospais.model.Resultado;

/**
 * Criado por Pamela Fidels em 15/11/17.
 * <p>
 * Auterado por Pamela Fidelis 03/12/17.
 * Objetivo: Separação de categoria e grupo
 */

public class QuartasFinaisPagerAdapter extends FragmentPagerAdapter {

    Context context;

    public QuartasFinaisPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment =  null;

        switch (position) {
            case 0:
                fragment = QuartasFinaisMasterPrincipalFragment.newInstance();

                break;

            case 1:
                fragment = QuartasFinaisMasterRepescagemFragment.newInstance();

                break;

            case 2:
                fragment = QuartasFinaisSeniorPrincipalFragment.newInstance();

                break;

            case 3:
                fragment = QuartasFinaisSeniorRepescagemFragment.newInstance();

                break;
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String tab = null;

        switch (position) {
            case 0:
                tab = context.getString(R.string.lbl_principal);
                break;

            case 1:
                tab = context.getString(R.string.lbl_repescagem);
                break;

            case 2:
                tab = context.getString(R.string.lbl_principal);
                break;

            case 3:
                tab = context.getString(R.string.lbl_repescagem);
                break;
        }

        return tab;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
