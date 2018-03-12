package br.com.futeboldospais.futeboldospais.controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.InputStream;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.rest.FileDownloadHelper;

/**
 * Projeto:    FutebolPaisAndroid
 * Arquivo:    DocumentViewer.java
 * Autor:      Luis Andrade
 * Data:       22.09.2017
 * <p>
 * Activity de visualizador de documentos. A mesma é reutilizável, com o intuito
 * de permitir a visualização de súmulas (PDF/JPEG) e regulamentos (PDF).
 * <p>
 * O intent deverá trazer nos extras as seguintes strings:
 * - uri (o endereço/URI do documento a ser baixado)
 * - title (o título a ser exibido na janela)
 * Os mesmos nomes são utilizados pelas variáveis durante a classe.
 * <p>
 * Utiliza-se aqui uma Toolbar com o intuito de fornecer uma "barra de título" para a janela,
 * consistente com as User Interface Guidelines do Android. (Sem reinventar a roda aqui, folks!)
 * <p>
 * Dependências: com.github.barteksc:android-pdf-viewer:2.7.0 (adicionar ao build.gradle).
 * <p>
 * Histórico de modificações:
 * Data ______ Autor _________________ Resumo ___________________________________________________
 * 22.09.2017  Luis Andrade            Inicial
 * 03.11.2018  Daniel Almeida          Corrigir o funcionamento do codigo para carregar a súmula em
 * PDF na view
 * 16.11.2018  Daniel Almeida          Inserir lógica para tornar o visualizador de PDF multi uso,
 * podendo ser utilizado para abrir a súmula, o regulamento e as opções de sobre do aplicativo
 **/

public class DocumentViewer extends AppCompatActivity {

    private String url;
    private String erro;
    private PDFView pdfView;
    private TextView txtStatus;
    private InputStream pdfDocument;
    private LinearLayout divStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Obrigatório!
        setContentView(R.layout.activity_document_viewer); // Configura o layout

        Intent intent = getIntent(); // Traz o intent para o nosso contexto
        // Pega do intent as variáveis necessárias
        int tipo = intent.getIntExtra("tipo", 0);
        int subTipo = intent.getIntExtra("subTipo", 0);
        url = intent.getStringExtra("url");

        divStatus = (LinearLayout) findViewById(R.id.div_status);
        divStatus.setVisibility(View.INVISIBLE);
        txtStatus = (TextView) findViewById(R.id.txt_status);
        pdfView = (PDFView) findViewById(R.id.pdfView);

        if (tipo == 0) {

            if (subTipo == 0) {
                erro = getString(R.string.lbl_erro_sumula);
                txtStatus.setText(getString(R.string.lbl_caregando_sumula));
                divStatus.setVisibility(View.VISIBLE);
            } else if (subTipo == 1) {
                erro = getString(R.string.lbl_erro_regulamento);
                txtStatus.setText(getString(R.string.lbl_carregando_regulamento));
                divStatus.setVisibility(View.VISIBLE);
            }
            // Joga o contexto como variável final; precisaremos disso ao chamar o FileDownloadHelper.
            // Como vamos acessar ela a partir de uma inner class, ela tem que ser final. Java, né...
            // Aqui é que a onça bebe água. Instancia uma nova thread runnable...
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                // Baixa o PDF.
                                pdfDocument =
                                        FileDownloadHelper.downloadBinary(url);

                                // Pega o PDF baixado e o exibe na PDFView da activity.
                                runOnUiThread(
                                        new Runnable() {
                                            @Override
                                            public void run() {
                                                divStatus.setVisibility(View.INVISIBLE);
                                                // Exibe o PDF.
                                                pdfView.fromStream(pdfDocument)
                                                        .enableAnnotationRendering(true)
                                                        .spacing(0) // in dp
                                                        .load();
                                            }
                                        }
                                );
                            } catch (Exception e) {
                                runOnUiThread(
                                        new Runnable() {
                                            @Override
                                            public void run() {
                                                divStatus.setVisibility(View.INVISIBLE);
                                                Toast.makeText(getBaseContext(), erro, Toast.LENGTH_SHORT).show();
                                                finish();
                                            }
                                        }
                                );
                            }
                        }
                    }
            ).start();

        } else if (tipo == 1) {
            pdfView.fromAsset("termos/TermoDeUsoDoAplicativo.pdf")
                    .enableAnnotationRendering(true)
                    .spacing(0) // in dp
                    .load();
        } else if (tipo == 2) {
            pdfView.fromAsset("termos/PoliticaDePrivacidade.pdf")
                    .enableAnnotationRendering(true)
                    .spacing(0) // in dp
                    .load();
        } else if (tipo == 3) {
            pdfView.fromAsset("termos/Licencas.pdf")
                    .enableAnnotationRendering(true)
                    .spacing(0) // in dp
                    .load();

        } else if (tipo == 4) {
            pdfView.fromAsset("termos/Sobre.pdf")
                    .enableAnnotationRendering(true)
                    .spacing(0) // in dp
                    .load();

        }

    }

    public void voltar(View view) {
        finish();
    }
}
