package br.com.futeboldospais.futeboldospais.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.controller.DocumentViewer;

/**
 * Created by Daniel Almeida on 12/10/2017.
 */


public class ModalConfiguracao extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modal_configuracao);

        Button btnRegulamento = (Button) findViewById(R.id.btn_regulamento);
        Button btnTermos = (Button) findViewById(R.id.btn_termos);
        Button btnPolitica = (Button) findViewById(R.id.btn_politica);
        Button btnLicencas = (Button) findViewById(R.id.btn_licencas);
        Button btnSobre = (Button) findViewById(R.id.btn_sobre);

        btnRegulamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), DocumentViewer.class);
                if (GerenciadorDeConectividade.isConnected(getBaseContext())) {
                    intent.putExtra("url", FabricaDeUrl.urlRegulamento(getBaseContext()));
                    intent.putExtra("tipo", 0);
                    intent.putExtra("subTipo", 1);
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "Para visualizar o regulamento é necessário estar conectado à internet", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnTermos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), DocumentViewer.class);
                intent.putExtra("tipo", 1);
                startActivity(intent);
            }
        });

        btnPolitica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), DocumentViewer.class);
                intent.putExtra("tipo", 2);
                startActivity(intent);
            }
        });

        btnLicencas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), DocumentViewer.class);
                intent.putExtra("tipo", 3);
                startActivity(intent);
            }
        });

        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), DocumentViewer.class);
                intent.putExtra("tipo", 4);
                startActivity(intent);
            }
        });
    }
}
