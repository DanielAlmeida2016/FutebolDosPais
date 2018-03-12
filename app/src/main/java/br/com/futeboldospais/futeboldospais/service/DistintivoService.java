package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.List;

import br.com.futeboldospais.futeboldospais.dao.DistintivoDAO;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.rest.DistintivoRest;
import br.com.futeboldospais.futeboldospais.util.FabricaDeUrl;

/**
 * Created by Daniel Almeida on 22/10/2017.
 * Não é bem um service, que chama um DAO que não é bem DAO e um REST que não tem nada de REST
 */

public class DistintivoService {

    DistintivoDAO dao;
    DistintivoRest distintivoRest;
    ClassificacaoService classificacaoService;

    public void atualizarDistintivos(Context context, int campeonatoAnoServidor, int campeonatoAnoLocal, List<Classificacao> lista) throws Exception {

        String urlBase = FabricaDeUrl.urlDistintivo(campeonatoAnoServidor);
        String extensao = ".png";

        Bitmap b;

        try {
            dao = new DistintivoDAO();
            distintivoRest = new DistintivoRest();
            classificacaoService = new ClassificacaoService();

            if (lista != null) {
                if (campeonatoAnoLocal == -1) {
                    for (Classificacao classificacao : lista) {
                        b = distintivoRest.getDistintivo(context, urlBase + classificacao.getEquipe() + extensao);
                        dao.salvarImagemNoArmazenamentoInterno(b, context, classificacao.getEquipe());
                    }
                } else if (campeonatoAnoLocal != campeonatoAnoServidor) {
                    for (Classificacao classificacao : lista) {
                        b = distintivoRest.getDistintivo(context, urlBase + classificacao.getEquipe() + extensao);
                        dao.salvarImagemNoArmazenamentoInterno(b, context, classificacao.getEquipe());
                    }
                    excluirImagemNoArmazenamentoInterno(getDiretorio(), classificacaoService.listarEquipes(context));
                }
            }
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public Bitmap carregarImagemDoArmazenamentoInterno(String diretorio, String nome) throws Exception {
        dao = new DistintivoDAO();
        return dao.carregarImagemDoArmazenamentoInterno(diretorio, nome);
    }

    public boolean excluirImagemNoArmazenamentoInterno(String diretorio, List<Classificacao> lista) throws Exception {
        dao = new DistintivoDAO();
        boolean todosExcluidos = false;

        if (lista != null) {
            for (Classificacao classificacao : lista) {
                todosExcluidos = dao.excluirImagemNoArmazenamentoInterno(diretorio, classificacao.getEquipe());
            }
        }
        return todosExcluidos;
    }

    public String getDiretorio() {
        String diretorio = "/data/data/br.com.futeboldospais.futeboldospais/app_distintivos";
        return diretorio;
    }
}
