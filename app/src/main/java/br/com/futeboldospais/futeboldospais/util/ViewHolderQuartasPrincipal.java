package br.com.futeboldospais.futeboldospais.util;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pamela e Vinicius on 30/09/2017.
 * <p>
 * Alterado por Pamela Fidelis em 03/12/2017
 * Objetivo: Junção das lists views em uma única
 */

public class ViewHolderQuartasPrincipal {

    private TextView posicao;
    private ImageView escudo;
    private TextView equipe;
    private TextView pontosGanhos;
    private TextView jogos;
    private TextView vitorias;
    private TextView saldoGols;

    public ViewHolderQuartasPrincipal(
            TextView posicao, ImageView escudo, TextView equipe, TextView pontosGanhos,
            TextView jogos, TextView vitorias, TextView saldoGols) {

        this.posicao = posicao;
        this.escudo = escudo;
        this.equipe = equipe;
        this.pontosGanhos = pontosGanhos;
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.saldoGols = saldoGols;
    }

    public TextView getPosicao() {
        return posicao;
    }

    public void setPosicao(TextView posicao) {
        this.posicao = posicao;
    }

    public ImageView getEscudo() {
        return escudo;
    }

    public void setEscudo(ImageView escudo) {
        this.escudo = escudo;
    }

    public TextView getEquipe() {
        return equipe;
    }

    public void setEquipe(TextView equipe) {
        this.equipe = equipe;
    }

    public TextView getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(TextView pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public TextView getJogos() {
        return jogos;
    }

    public void setJogos(TextView jogos) {
        this.jogos = jogos;
    }

    public TextView getVitorias() {
        return vitorias;
    }

    public void setVitorias(TextView vitorias) {
        this.vitorias = vitorias;
    }

    public TextView getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(TextView saldoGols) {
        this.saldoGols = saldoGols;
    }

    @Override
    public String toString() {
        return "ViewHolderQuartasPrincipal{" +
                "posicao=" + posicao +
                ", escudo=" + escudo +
                ", equipe=" + equipe +
                ", pontosGanhos=" + pontosGanhos +
                ", jogos=" + jogos +
                ", vitorias=" + vitorias +
                ", saldoGols=" + saldoGols +
                '}';
    }
}