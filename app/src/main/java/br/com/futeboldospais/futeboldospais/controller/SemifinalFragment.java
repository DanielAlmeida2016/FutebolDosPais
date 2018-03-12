package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.service.ClassificacaoQuartasService;
import br.com.futeboldospais.futeboldospais.service.DistintivoService;
import br.com.futeboldospais.futeboldospais.service.ResultadoService;

/**
 * A simple {@link Fragment} subclass.
 */
public class SemifinalFragment extends Fragment {

    private ImageView imgMasterPrincipal1;
    private TextView txtMasterPrincipal1;
    private TextView golsMasterPrincipal1;

    private ImageView imgMasterRepescagem1;
    private TextView txtMasterRepescagem1;
    private TextView golsMasterRepescagem1;

    private ImageView imgMasterPrincipal2;
    private TextView txtMasterPrincipal2;
    private TextView golsMasterPrincipal2;

    private ImageView imgMasterPrincipal3;
    private TextView txtMasterPrincipal3;
    private TextView golsMasterPrincipal3;

    private ImageView imgSeniorPrincipal1;
    private TextView txtSeniorPrincipal1;
    private TextView golsSeniorPrincipal1;

    private ImageView imgSeniorRepescagem1;
    private TextView txtSeniorRepescagem1;
    private TextView golsSeniorRepescagem1;

    private ImageView imgSeniorPrincipal2;
    private TextView txtSeniorPrincipal2;
    private TextView golsSeniorPrincipal2;

    private ImageView imgSeniorPrincipal3;
    private TextView txtSeniorPrincipal3;
    private TextView golsSeniorPrincipal3;

    ClassificacaoQuartasService classificacaoQuartasService;
    ResultadoService resultadoService;
    DistintivoService distintivoService;

    /**
     * Created by Daniel Almeida on 08/09/2017.
     **/
    private static SemifinalFragment fragment = null;

    public static SemifinalFragment newInstance() {
        if (fragment == null) {
            fragment = new SemifinalFragment();
        }
        return fragment;
    }

    /*
    public static SemifinalFragment newInstance() {
        SemifinalFragment semifinalFragment = new SemifinalFragment();
        return semifinalFragment;
    }*/


    public SemifinalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_semifinal, container, false);

        imgMasterPrincipal1 = (ImageView) view.findViewById(R.id.img_master_principal_1);
        txtMasterPrincipal1 = (TextView) view.findViewById(R.id.txt_master_principal_1);
        golsMasterPrincipal1 = (TextView) view.findViewById(R.id.gols_master_principal_1);

        imgMasterRepescagem1 = (ImageView) view.findViewById(R.id.img_master_repescagem_1);
        txtMasterRepescagem1 = (TextView) view.findViewById(R.id.txt_master_repescagem_1);
        golsMasterRepescagem1 = (TextView) view.findViewById(R.id.gols_master_repescagem_1);

        imgMasterPrincipal2 = (ImageView) view.findViewById(R.id.img_master_principal_2);
        txtMasterPrincipal2 = (TextView) view.findViewById(R.id.txt_master_principal_2);
        golsMasterPrincipal2 = (TextView) view.findViewById(R.id.gols_master_principal_2);

        imgMasterPrincipal3 = (ImageView) view.findViewById(R.id.img_master_principal_3);
        txtMasterPrincipal3 = (TextView) view.findViewById(R.id.txt_master_principal_3);
        golsMasterPrincipal3 = (TextView) view.findViewById(R.id.gols_master_principal_3);

        imgSeniorPrincipal1 = (ImageView) view.findViewById(R.id.img_senior_principal_1);
        txtSeniorPrincipal1 = (TextView) view.findViewById(R.id.txt_senior_principal_1);
        golsSeniorPrincipal1 = (TextView) view.findViewById(R.id.gols_senior_principal_1);

        imgSeniorRepescagem1 = (ImageView) view.findViewById(R.id.img_senior_repescagem_1);
        txtSeniorRepescagem1 = (TextView) view.findViewById(R.id.txt_senior_repescagem_1);
        golsSeniorRepescagem1 = (TextView) view.findViewById(R.id.gols_senior_repescagem_1);

        imgSeniorPrincipal2 = (ImageView) view.findViewById(R.id.img_senior_principal_2);
        txtSeniorPrincipal2 = (TextView) view.findViewById(R.id.txt_senior_principal_2);
        golsSeniorPrincipal2 = (TextView) view.findViewById(R.id.gols_senior_principal_2);

        imgSeniorPrincipal3 = (ImageView) view.findViewById(R.id.img_senior_principal_3);
        txtSeniorPrincipal3 = (TextView) view.findViewById(R.id.txt_senior_principal_3);
        golsSeniorPrincipal3 = (TextView) view.findViewById(R.id.gols_senior_principal_3);

        classificacaoQuartasService = new ClassificacaoQuartasService();
        resultadoService = new ResultadoService();
        distintivoService = new DistintivoService();

        String equipe1;
        String equipe2;
        String equipe3;
        String equipe4;
        String equipe5;
        String equipe6;
        String equipe7;
        String equipe8;

        try {
            equipe1 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "master", "principal", 1);
            imgMasterPrincipal1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe1));
            txtMasterPrincipal1.setText(equipe1);

            equipe2 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "master", "repescagem", 1);
            imgMasterRepescagem1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe2));
            txtMasterRepescagem1.setText(equipe2);

            equipe3 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "master", "principal", 2);
            imgMasterPrincipal2.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe3));
            txtMasterPrincipal2.setText(equipe3);

            equipe4 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "master", "principal", 3);
            imgMasterPrincipal3.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe4));
            txtMasterPrincipal3.setText(equipe4);

            equipe5 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "senior", "principal", 1);
            imgSeniorPrincipal1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe5));
            txtSeniorPrincipal1.setText(equipe5);

            equipe6 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "senior", "repescagem", 1);
            imgSeniorRepescagem1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe6));
            txtSeniorRepescagem1.setText(equipe6);

            equipe7 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "senior", "principal", 2);
            imgSeniorPrincipal2.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe7));
            txtSeniorPrincipal2.setText(equipe7);

            equipe8 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "senior", "principal", 3);
            imgSeniorPrincipal3.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe8));
            txtSeniorPrincipal3.setText(equipe8);



            if (resultadoService.getTurnoJogado(getActivity().getBaseContext(), 4) == 4) {

                Resultado resultado;

                resultado = resultadoService.getGolsPorEquipe(getActivity().getBaseContext(), equipe1, equipe2, "Master", 4);

                golsMasterPrincipal1.setText(String.valueOf(resultado.getGolsEquipe1()));
                golsMasterRepescagem1.setText(String.valueOf(resultado.getGolsEquipe2()));

                resultado = resultadoService.getGolsPorEquipe(getActivity().getBaseContext(), equipe3, equipe4, "Master", 4);
                golsMasterPrincipal2.setText(String.valueOf(resultado.getGolsEquipe1()));
                golsMasterPrincipal3.setText(String.valueOf(resultado.getGolsEquipe2()));

                resultado = resultadoService.getGolsPorEquipe(getActivity().getBaseContext(), equipe5, equipe6, "Senior", 4);
                golsSeniorPrincipal1.setText(String.valueOf(resultado.getGolsEquipe1()));
                golsSeniorRepescagem1.setText(String.valueOf(resultado.getGolsEquipe2()));

                resultado = resultadoService.getGolsPorEquipe(getActivity().getBaseContext(), equipe7, equipe8, "Senior", 4);
                golsSeniorPrincipal2.setText(String.valueOf(resultado.getGolsEquipe1()));
                golsSeniorPrincipal3.setText(String.valueOf(resultado.getGolsEquipe2()));
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

}
