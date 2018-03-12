package br.com.futeboldospais.futeboldospais.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.futeboldospais.futeboldospais.controller.CampeaoFragment;
import br.com.futeboldospais.futeboldospais.controller.FinalFragment;
import br.com.futeboldospais.futeboldospais.controller.SemifinalFragment;

/**
 * Created by Daniel Almeidaon 03/12/2017.
 */

public class FinaisPageAdapter extends FragmentPagerAdapter {

    private int num_itens = 3;

    public FinaisPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment;

        switch (position) {
            case 0:
                fragment = SemifinalFragment.newInstance();
                break;
            case 1:
                fragment = FinalFragment.newInstance();
                break;
            case 2:
                fragment = CampeaoFragment.newInstance();
                break;
            default:
                fragment = null;
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return num_itens;
    }
}
