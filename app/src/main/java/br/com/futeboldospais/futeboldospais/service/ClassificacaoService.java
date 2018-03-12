package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import br.com.futeboldospais.futeboldospais.dao.ClassificacaoDAO;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.rest.ClassificacaoRest;
import br.com.futeboldospais.futeboldospais.util.FabricaDeUrl;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Daniel Almeida on 17/09/2017.
 * Classe service padrão para esconder a lógica de acesso rest e banco de dados
 */

public class ClassificacaoService {

    private ClassificacaoDAO dao;
    private ClassificacaoRest classificacaoRest;

    /**
     * Contrutor padrão, instancia um objeto dao e um objeto rest ao ser chamado
     */
    public ClassificacaoService(){
        dao = new ClassificacaoDAO();
        classificacaoRest = new ClassificacaoRest();
    }

    /**
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     */
    public List<Classificacao> getClassificacao(int campeonatoAno) throws Exception{

        List<Classificacao> lista;

        String json = classificacaoRest.getClassificacao(FabricaDeUrl.urlBase(campeonatoAno));

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Classificacao>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     * @param lista ArrayList de Classificacao passado para a camada dao
     */
    public void inserirDados(SQLiteDatabase bd, List<Classificacao> lista){
        dao.inserirDados(bd, lista);
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
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e retornar um vetor de objetos
     * @param context Contexto da aplicação passado para a camada dao
     * @return Vetor de objeto do tipo Classificacao
     */
    public Classificacao[] listarDados(Context context){
        return dao.listarDados(context);
    }

    public List<Classificacao> listarEquipes(Context context){
        return dao.listarEquipes(context);
    }
}
