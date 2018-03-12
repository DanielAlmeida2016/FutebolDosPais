package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

import br.com.futeboldospais.futeboldospais.dao.ClassificacaoQuartasDAO;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.model.ClassificacaoQuartas;
import br.com.futeboldospais.futeboldospais.rest.ClassificacaoQuartasRest;
import br.com.futeboldospais.futeboldospais.util.FabricaDeUrl;

/**
 * Created by Daniel Almeida on 20/11/2017.
 */

public class ClassificacaoQuartasService {

    ClassificacaoQuartasDAO dao;
    ClassificacaoQuartasRest classificacaoQuartasRest;

    public ClassificacaoQuartasService() {
        dao = new ClassificacaoQuartasDAO();
        classificacaoQuartasRest =  new ClassificacaoQuartasRest();
    }

    /**
     * @author Denilson Araujo on 31/10/2017.
     */
    public List<ClassificacaoQuartas> getClassificacaoQuartas(int campeonatoAno) throws Exception {

        List<ClassificacaoQuartas> timesClassificados;

        String json = classificacaoQuartasRest.getQuartasFinais(FabricaDeUrl.urlBase(campeonatoAno));

        Gson gson = new Gson();
        JSONArray jsonArray = null;

        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Type listType = new TypeToken<List<ClassificacaoQuartas>>() {}.getType();
        timesClassificados = gson.fromJson(jsonArray.toString(), listType);

        return timesClassificados;
    }

    /**
     * @author Denilson Aráujo on 31/10/2017.
     **/
    public long inserirDados(SQLiteDatabase bd, List<ClassificacaoQuartas> lista) {
        return dao.inserirDados(bd, lista);
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     */
    public void deletarDados(SQLiteDatabase bd){
        dao.deletarDados(bd);
    }

    /**
     * @param context da aplicacao e tambem o nome daquipe
     * @return objeto tipo Classificacao com os dados da equipe
     * @author Pâmela Fidelis
     */

    public Classificacao[] listarQuartasPorCategoriaGrupo(Context context, String categoria, String grupo) {
        return dao.listarDadosPorCategoriaGrupo(context, categoria, grupo);
    }

    public String buscarEquipeNaPosicao(Context context, String categoria, String grupo, int posicao){
        return dao.buscarEquipeNaPosicao(context, categoria, grupo, posicao);
    }

}
