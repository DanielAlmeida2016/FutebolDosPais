package br.com.futeboldospais.futeboldospais.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.controller.DecimaNonaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaOitavaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaPrimeiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaQuartaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaQuintaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaSegundaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaSetimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaSextaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaTerceiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DocumentViewer;
import br.com.futeboldospais.futeboldospais.controller.NonaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.OitavaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.PrimeiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.QuartaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.QuintaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.SegundaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.SetimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.SextaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.TerceiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaOitavaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaPrimeiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaQuartaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaQuintaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaSegundaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaSetimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaSextaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaTerceiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.service.ResultadoService;

import static java.security.AccessController.getContext;

/**
 * Created by Daniel Almeida on 15/09/2017.
 */

public class NavegacaoRodadasHelper {

    public static int PROXIMO = 1;
    public static int ANTERIOR = 0;

    private static NavegacaoRodadas navegacaoRodadas;

    public NavegacaoRodadasHelper() {
        //Construtor padrão
    }

    /**
     * Created by Daniel Almeida on 15/09/2017.
     * Recebe uma direção, verifica qual a rodada atual e instacia a proxima rodada
     * de acordo com a direção recebida
     *
     * @param direcao
     * @param fragment
     * @return uma instancia da classe NavegacaoRodadas
     */
    public static NavegacaoRodadas selecionaRodada(int direcao, Fragment fragment) {

        navegacaoRodadas = new NavegacaoRodadas();

        if (direcao == 1) {
            if (fragment.equals(PrimeiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 2º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(SegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(TerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 3º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(TerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(QuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 4º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(QuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(QuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 5º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(QuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 6º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(SextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 7º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(SetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(OitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 8º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(OitavaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(NonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 9º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(NonaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 10º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 1º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaPrimeiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 2º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaSegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 3º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaTerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 4º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaQuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 5º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaQuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 6º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaSextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 7º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaSetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaOitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 8º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaOitavaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaNonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 9º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaNonaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 10º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 1º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaPrimeiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 2º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaSegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 3º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaTerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 4º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaQuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 5º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaQuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 6º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaSextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_semifinais_maiuscula));
            } else if (fragment.equals(VigesimaSetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaOitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_finais));
            }

        } else if (direcao == 0) {
            if (fragment.equals(VigesimaOitavaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_semifinais_maiuscula));
            } else if (fragment.equals(VigesimaSetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 6º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaSextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 5º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaQuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 4º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaQuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 3º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaTerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 2º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaSegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(fragment.getString(R.string.lbl_quartas_maiuscula) + " - 1º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaPrimeiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 10º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(VigesimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaNonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 9º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaNonaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaOitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 8º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaOitavaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 7º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaSetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 6º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaSextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 5º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaQuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 4º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaQuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 3º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaTerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 2º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaSegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + fragment.getString(R.string.lbl_turno) + " - 1º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaPrimeiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 10º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(DecimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(NonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 9º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(NonaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(OitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 8º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(OitavaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 7º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(SetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 6º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(SextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(QuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 5º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(QuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(QuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 4º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(QuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(TerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 3º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(TerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 2º  " +  fragment.getString(R.string.lbl_rodada));
            } else if (fragment.equals(SegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(PrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + fragment.getString(R.string.lbl_turno) + " - 1º  " +  fragment.getString(R.string.lbl_rodada));
            }
        }

        return navegacaoRodadas;
    }

    public static NavegacaoRodadas rodadaAtual(Context context, int rodada) {

        navegacaoRodadas = new NavegacaoRodadas();

        switch (rodada) {
            case 1:
                navegacaoRodadas.setFragmentoSelecionado(PrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + context.getString(R.string.lbl_turno) + " - 1º  " +  context.getString(R.string.lbl_rodada));
                break;
            case 2:
                navegacaoRodadas.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + context.getString(R.string.lbl_turno) + " - 2º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 3:
                navegacaoRodadas.setFragmentoSelecionado(TerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + context.getString(R.string.lbl_turno) + " - 3º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 4:
                navegacaoRodadas.setFragmentoSelecionado(QuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + context.getString(R.string.lbl_turno) + " - 4º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 5:
                navegacaoRodadas.setFragmentoSelecionado(QuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + context.getString(R.string.lbl_turno) + " - 5º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 6:
                navegacaoRodadas.setFragmentoSelecionado(SextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + context.getString(R.string.lbl_turno) + " - 6º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 7:
                navegacaoRodadas.setFragmentoSelecionado(SetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + context.getString(R.string.lbl_turno) + " - 7º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 8:
                navegacaoRodadas.setFragmentoSelecionado(OitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + context.getString(R.string.lbl_turno) + " - 8º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 9:
                navegacaoRodadas.setFragmentoSelecionado(NonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + context.getString(R.string.lbl_turno) + " - 9º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 10:
                navegacaoRodadas.setFragmentoSelecionado(DecimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º " + context.getString(R.string.lbl_turno) + " - 10º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 11:
                navegacaoRodadas.setFragmentoSelecionado(DecimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + context.getString(R.string.lbl_turno) + " - 1º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 12:
                navegacaoRodadas.setFragmentoSelecionado(DecimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + context.getString(R.string.lbl_turno) + " - 2º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 13:
                navegacaoRodadas.setFragmentoSelecionado(DecimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + context.getString(R.string.lbl_turno) + " - 3º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 14:
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + context.getString(R.string.lbl_turno) + " - 4º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 15:
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + context.getString(R.string.lbl_turno) + " - 5º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 16:
                navegacaoRodadas.setFragmentoSelecionado(DecimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + context.getString(R.string.lbl_turno) + " - 6º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 17:
                navegacaoRodadas.setFragmentoSelecionado(DecimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + context.getString(R.string.lbl_turno) + " - 7º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 18:
                navegacaoRodadas.setFragmentoSelecionado(DecimaOitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + context.getString(R.string.lbl_turno) + " - 8º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 19:
                navegacaoRodadas.setFragmentoSelecionado(DecimaNonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + context.getString(R.string.lbl_turno) + " - 9º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 20:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + context.getString(R.string.lbl_turno) + " - 10º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 21:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(context.getString(R.string.lbl_quartas_maiuscula) + " - 1º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 22:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(context.getString(R.string.lbl_quartas_maiuscula) + " - 2º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 23:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(context.getString(R.string.lbl_quartas_maiuscula) + " - 3º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 24:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(context.getString(R.string.lbl_quartas_maiuscula) + " - 4º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 25:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(context.getString(R.string.lbl_quartas_maiuscula) + " - 5º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 26:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(context.getString(R.string.lbl_quartas_maiuscula) + " - 6º  " +  context.getString(R.string.lbl_rodada));
                break;

            case 27:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(context.getString(R.string.lbl_semifinais_maiuscula));
                break;

            case 28:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaOitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo(context.getString(R.string.lbl_finais));
                break;

            default:
                navegacaoRodadas.setFragmentoSelecionado(PrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º " + context.getString(R.string.lbl_turno) + " - 1º  " +  context.getString(R.string.lbl_rodada));
                break;
        }

        return navegacaoRodadas;
    }

    public static Resultado[] carregarAdapter(ListView tabelaResultado, Resultado[] listaResultado, int rodada, int turno, Activity activity) {
        ResultadoService resultadoService = new ResultadoService();
        listaResultado = resultadoService.listarDadosPorRodadaETurno(activity.getBaseContext(), rodada, turno);

        if (listaResultado.length != 0) {
            ResultadoAdapter resultadoAdapter = new ResultadoAdapter(listaResultado, activity.getBaseContext());
            tabelaResultado.setAdapter(resultadoAdapter);
        } else {
            AdapterPadrao adapterPadrao = new AdapterPadrao(activity.getBaseContext(), activity.getString(R.string.lbl_erro_rodada));
            tabelaResultado.setAdapter(adapterPadrao);
        }
        return listaResultado;
    }

    public static void abrirSumula(Resultado[] listaResultado, int position, Activity activity) {
        if(GerenciadorDeConectividade.isConnected(activity.getBaseContext())) {
            String data = listaResultado[position].getData();
            String hora = listaResultado[position].getHorario();
            String categoria = listaResultado[position].getCategoria();
            String dados = listaResultado[position].getEquipe1() + " x " + listaResultado[position].getEquipe2() +
                    " " + listaResultado[position].getData() + " " + listaResultado[position].getHorario();

            Intent intent = new Intent(activity.getBaseContext(), DocumentViewer.class);
            intent.putExtra("dados", dados);
            intent.putExtra("url", FabricaDeUrl.urlSumula(data, hora, categoria, activity.getBaseContext()));

            activity.startActivity(intent);
        }
        else{
            Toast.makeText(activity.getBaseContext(), R.string.lbl_erro_conexao_sumula, Toast.LENGTH_SHORT).show();
        }
    }
}
