package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.futeboldospais.futeboldospais.dao.BancoDadosHelper;
import br.com.futeboldospais.futeboldospais.dao.ResultadoDAO;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.rest.ResultadoRest;
import br.com.futeboldospais.futeboldospais.util.FabricaDeUrl;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Daniel Almeida on 17/10/2017.
 * Classe service padrão para esconder a lógica de acesso rest e banco de dados
 */

public class ResultadoService {

    private ResultadoDAO dao;
    private ResultadoRest resultadoRest;

    /**
     * Contrutor padrão, instancia um objeto dao e um objeto rest ao ser chamado
     */
    public ResultadoService() {
        dao = new ResultadoDAO();
        resultadoRest = new ResultadoRest();
    }

    /**
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     */
    public List<Resultado> getResultado(int campeonatoAno) throws Exception {

        List<Resultado> lista;

        String json = resultadoRest.getResultado(FabricaDeUrl.urlBase(campeonatoAno));

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Resultado>>() {
        }.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    /**
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     */
    public List<Resultado> getJogo(int campeonatoAno) throws Exception {

        List<Resultado> lista;

        String json = resultadoRest.getJogo(FabricaDeUrl.urlBase(campeonatoAno));

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Resultado>>() {
        }.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        for (Resultado resultado : lista) {
            Log.d("teste", "" + resultado.getRodada() + " - " + resultado.getTurno() + " - " + resultado.getData() + " - " +
                    resultado.getHorario() + " - " + resultado.getEquipe1() + " - " + resultado.getEquipe2() + " - " +
                    resultado.getCategoria());
        }

        return lista;
    }

    /**
     * @param bd             Conexão de gravação passada para a camada dao
     * @param listaResultado ArrayList de Resultado passado para a camada dao
     * @param listaJogo      ArrayList de Jogo passado para a camada dao
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     */
    public void inserirDados(SQLiteDatabase bd, List<Resultado> listaResultado, List<Resultado> listaJogo) {
        dao.inserirDadosResultado(bd, listaResultado);
        dao.inserirDadosJogo(bd, listaJogo);
    }

    /**
     * @param bd Conexão de gravação passada para a camada dao
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     */
    public void deletarDados(SQLiteDatabase bd) {
        dao.deletarDados(bd);
    }

    public int listarDadosRodadaAtual(Context context) {
        return dao.listarDadosRodadaAtual(context);
    }

    /**
     * @param context Contexto da aplicação passado para a camada dao
     * @return Vetor de objeto do tipo Resultado
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e retornar um vetor de objetos
     */
    public Resultado[] listarDadosPorRodadaETurno(Context context, int rodada, int turno) {
        return dao.listarDadosPorRodadaETurno(context, rodada, turno);
    }

    public Resultado getGolsPorEquipe(Context context, String equipe1, String equipe2, String categoria, int turno){
        return dao.getGolsPorEquipe(context, equipe1, equipe2, categoria, turno);
    }

    public Resultado getGolsPorEquipeUnica(Context context, String equipe, String categoria, int turno){
        return dao.getGolsPorEquipeUnica(context, equipe, categoria, turno);
    }

    public Resultado getEquipeVencedora(Context context, String equipe1, String equipe2, String categoria) {
        return dao.getEquipeVencedora(context, equipe1, equipe2, categoria);
    }

    public Resultado getVencedorPorEquipeUnica(Context context, String equipe, String categoria, int turno) {
        return dao.getVencedorPorEquipeUnica(context, equipe, categoria, turno);
    }

    public int getTurnoJogado(Context context, int turno) {
        return dao.getTurnoJogado(context, turno);
    }
}
