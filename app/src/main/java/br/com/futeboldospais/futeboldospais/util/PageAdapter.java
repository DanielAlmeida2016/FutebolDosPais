package br.com.futeboldospais.futeboldospais.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.futeboldospais.futeboldospais.controller.CampeaoFragment;
import br.com.futeboldospais.futeboldospais.controller.FinalFragment;
import br.com.futeboldospais.futeboldospais.controller.SemifinalFragment;

/**
 * Created by ThirdSystem on 03/12/2017.
 */

public class PageAdapter extends FragmentPagerAdapter {

    private int num_itens = 3;

    public PageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment;

        switch (position) {
            case 0:
                fragment = SemifinalFragment.newInstance();
                break;
                //return SemifinalFragment.newInstance();
            case 1:
                fragment = FinalFragment.newInstance();
                break;
                //return FinalFragment.newInstance();
            case 2:
                fragment = CampeaoFragment.newInstance();
                break;
                //return CampeaoFragment.newInstance();
            default:
                fragment = null;
                break;
                //return null;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return num_itens;
    }
}
