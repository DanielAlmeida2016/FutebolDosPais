package br.com.futeboldospais.futeboldospais.util;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.futeboldospais.futeboldospais.R;

/**
 * Created by Daniel Almeida on 12/10/2017.
 */


public class ModalJogos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modal_jogos);
        this.setFinishOnTouchOutside(true);
    }
}
