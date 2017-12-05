package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;

import br.com.futeboldospais.futeboldospais.service.ConfiguracaoService;

/**
 * Created by ThirdSystem on 05/12/2017.
 */

public class FabricaDeUrl {

    private static String urlBase;
    private static ConfiguracaoService configuracaoService;

    public static String urlBase(int campeonatoAno){
        urlBase = "http://www.futeboldospais.com.br/campeonato" + String.valueOf(campeonatoAno) + "/json/";
        return urlBase;
    }

    public static String urlSumula(String data, String hora, String categoria, Context context){

        configuracaoService = new ConfiguracaoService();
        int ano = configuracaoService.getCampeonatoAnoLocal(context);

        String url = "" + data.charAt(6) + "" + data.charAt(7) + "" + data.charAt(8) + "" +
                data.charAt(9) + "" + data.charAt(3) + "" + data.charAt(4) + "" + data.charAt(0) + "" +
                data.charAt(1) + "_" + hora.charAt(0) + "" + hora.charAt(1) + "h" + hora.charAt(3) + "" +
                hora.charAt(4) + "_" + categoria + "_frente.pdf";

        urlBase = "http://www.futeboldospais.com.br/campeonato" + ano + "/sumulas/Jogo_" + url;
        return urlBase;
    }

    public static String urlRegulamento(Context context){

        configuracaoService = new ConfiguracaoService();
        int ano = configuracaoService.getCampeonatoAnoLocal(context);

        urlBase = "http://www.futeboldospais.com.br/campeonato" + ano + "/documentos/regulamento-" + ano + ".pdf";
        return urlBase;
    }

    public static String urlDistintivo(int ano){

        urlBase = "http://www.futeboldospais.com.br/campeonato" + ano + "/distintivos/";
        return urlBase;
    }
}
