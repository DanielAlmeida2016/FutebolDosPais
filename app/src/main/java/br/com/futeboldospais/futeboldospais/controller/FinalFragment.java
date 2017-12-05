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
public class FinalFragment extends Fragment {

    private ImageView imgMasterFinalista1;
    private TextView txtMasterFinalista1;
    private TextView golsMasterFinalista1;

    private ImageView imgMasterFinalista2;
    private TextView txtMasterFinalista2;
    private TextView golsMasterFinalista2;

    private ImageView imgMasterTerceiro1;
    private TextView txtMasterTerceiro1;
    private TextView golsMasterTerceiro1;

    private ImageView imgMasterTerceiro2;
    private TextView txtMasterTerceiro2;
    private TextView golsMasterTerceiro2;

    private ImageView imgSeniorFinalista1;
    private TextView txtSeniorFinalista1;
    private TextView golsSeniorFinalista1;

    private ImageView imgSeniorFinalista2;
    private TextView txtSeniorFinalista2;
    private TextView golsSeniorFinalista2;

    private ImageView imgSeniorTerceiro1;
    private TextView txtSeniorTerceiro1;
    private TextView golsSeniorTerceiro1;

    private ImageView imgSeniorTerceiro2;
    private TextView txtSeniorTerceiro2;
    private TextView golsSeniorTerceiro2;

    ClassificacaoQuartasService classificacaoQuartasService;
    ResultadoService resultadoService;
    DistintivoService distintivoService;

    private static FinalFragment fragment = null;

    public static FinalFragment newInstance() {
        if (fragment == null) {
            fragment = new FinalFragment();
        }
        return fragment;
    }
    /*
    public static FinalFragment newInstance() {
        FinalFragment finalFragment = new FinalFragment();
        return finalFragment;
    }*/


    public FinalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_final, container, false);

        imgMasterFinalista1 = (ImageView) view.findViewById(R.id.img_master_finalista_1);
        txtMasterFinalista1 = (TextView) view.findViewById(R.id.txt_master_finalista_1);
        golsMasterFinalista1 = (TextView) view.findViewById(R.id.gols_master_finalista_1);

        imgMasterFinalista2 = (ImageView) view.findViewById(R.id.img_master_finalista_2);
        txtMasterFinalista2 = (TextView) view.findViewById(R.id.txt_master_finalista_2);
        golsMasterFinalista2 = (TextView) view.findViewById(R.id.gols_master_finalista_2);

        imgMasterTerceiro1 = (ImageView) view.findViewById(R.id.img_master_terceiro_1);
        txtMasterTerceiro1 = (TextView) view.findViewById(R.id.txt_master_terceiro_1);
        golsMasterTerceiro1 = (TextView) view.findViewById(R.id.gols_master_terceiro_1);

        imgMasterTerceiro2 = (ImageView) view.findViewById(R.id.img_master_terceiro_2);
        txtMasterTerceiro2 = (TextView) view.findViewById(R.id.txt_master_terceiro_2);
        golsMasterTerceiro2 = (TextView) view.findViewById(R.id.gols_master_terceiro_2);

        imgSeniorFinalista1 = (ImageView) view.findViewById(R.id.img_senior_finalista_1);
        txtSeniorFinalista1 = (TextView) view.findViewById(R.id.txt_senior_finalista_1);
        golsSeniorFinalista1 = (TextView) view.findViewById(R.id.gols_senior_finalista_1);

        imgSeniorFinalista2 = (ImageView) view.findViewById(R.id.img_senior_finalista_2);
        txtSeniorFinalista2 = (TextView) view.findViewById(R.id.txt_senior_finalista_2);
        golsSeniorFinalista2 = (TextView) view.findViewById(R.id.gols_senior_finalista_2);

        imgSeniorTerceiro1 = (ImageView) view.findViewById(R.id.img_senior_terceiro_1);
        txtSeniorTerceiro1 = (TextView) view.findViewById(R.id.txt_senior_terceiro_1);
        golsSeniorTerceiro1 = (TextView) view.findViewById(R.id.gols_senior_terceiro_1);

        imgSeniorTerceiro2 = (ImageView) view.findViewById(R.id.img_senior_terceiro_2);
        txtSeniorTerceiro2 = (TextView) view.findViewById(R.id.txt_senior_terceiro_2);
        golsSeniorTerceiro2 = (TextView) view.findViewById(R.id.gols_senior_terceiro_2);

        if (4/*resultadoService.getTurnoJogado(getActivity().getBaseContext(), 4)*/ > 0) {

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

            String equipeI;
            String equipeII;
            String equipeIII;
            String equipeIV;

            try {
                equipe1 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "master", "principal", 1);
                equipe2 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "master", "repescagem", 1);
                equipe3 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "master", "principal", 2);
                equipe4 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "master", "principal", 3);
                equipe5 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "senior", "principal", 1);
                equipe6 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "senior", "repescagem", 1);
                equipe7 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "senior", "principal", 2);
                equipe8 = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "senior", "principal", 3);

                Resultado resultado;

                resultado = resultadoService.getEquipeVencedora(getActivity().getBaseContext(), equipe1, equipe2, "Master");
                if (resultado.getVencedor() == 1) {
                    imgMasterFinalista1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe1));
                    txtMasterFinalista1.setText(resultado.getEquipe1());

                    imgMasterTerceiro1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe2));
                    txtMasterTerceiro1.setText(resultado.getEquipe2());

                    equipeI = equipe1;
                    equipeII = equipe2;
                } else {
                    imgMasterFinalista1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe2));
                    txtMasterFinalista1.setText(resultado.getEquipe2());

                    imgMasterTerceiro1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe1));
                    txtMasterTerceiro1.setText(resultado.getEquipe1());

                    equipeI = equipe2;
                    equipeII = equipe1;
                }

                resultado = resultadoService.getEquipeVencedora(getActivity().getBaseContext(), equipe3, equipe4, "Master");
                if (resultado.getVencedor() == 1) {
                    imgMasterFinalista2.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe3));
                    txtMasterFinalista2.setText(resultado.getEquipe1());

                    imgMasterTerceiro2.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe4));
                    txtMasterTerceiro2.setText(resultado.getEquipe2());

                } else {
                    imgMasterFinalista1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe4));
                    txtMasterFinalista1.setText(resultado.getEquipe2());

                    imgMasterTerceiro2.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe3));
                    txtMasterTerceiro2.setText(resultado.getEquipe1());

                }


                resultado = resultadoService.getEquipeVencedora(getActivity().getBaseContext(), equipe5, equipe6, "Senior");
                if (resultado.getVencedor() == 1) {
                    imgSeniorFinalista1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe5));
                    txtSeniorFinalista1.setText(resultado.getEquipe1());

                    imgSeniorTerceiro1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe6));
                    txtSeniorTerceiro1.setText(resultado.getEquipe2());

                    equipeIII = equipe5;
                    equipeIV = equipe6;
                } else {
                    imgSeniorFinalista1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe6));
                    txtSeniorFinalista1.setText(resultado.getEquipe2());

                    imgSeniorTerceiro1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe5));
                    txtSeniorTerceiro1.setText(resultado.getEquipe1());

                    equipeIII = equipe6;
                    equipeIV = equipe5;
                }

                resultado = resultadoService.getEquipeVencedora(getActivity().getBaseContext(), equipe7, equipe8, "Senior");
                if (resultado.getVencedor() == 1) {
                    imgSeniorFinalista2.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe7));
                    txtSeniorFinalista2.setText(resultado.getEquipe1());

                    imgSeniorTerceiro2.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe8));
                    txtSeniorTerceiro2.setText(resultado.getEquipe2());


                } else {
                    imgSeniorFinalista2.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe8));
                    txtSeniorFinalista2.setText(resultado.getEquipe2());

                    imgSeniorTerceiro2.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe7));
                    txtSeniorTerceiro2.setText(resultado.getEquipe1());


                }

                Log.d("teste", equipe1 + equipe2);

                if (4/*resultadoService.getTurnoJogado(getActivity().getBaseContext(), 5)*/ > 0) {

                    resultado = resultadoService.getGolsPorEquipeUnica(getActivity().getBaseContext(), equipeI, "Master", 5);
                    Log.d("teste", resultado.toString());
                    Log.d("teste", "Equipe I: " + equipeI);
                    if (equipeI.equals(resultado.getEquipe1())) {
                        golsMasterFinalista1.setText(String.valueOf(resultado.getGolsEquipe1()));
                        golsMasterFinalista2.setText(String.valueOf(resultado.getGolsEquipe2()));
                    } else {
                        golsMasterFinalista1.setText(String.valueOf(resultado.getGolsEquipe2()));
                        golsMasterFinalista2.setText(String.valueOf(resultado.getGolsEquipe1()));
                    }

                    resultado = resultadoService.getGolsPorEquipeUnica(getActivity().getBaseContext(), equipeII, "Master", 5);
                    Log.d("teste", resultado.toString());
                    Log.d("teste", "Equipe II: " + equipeII);
                    if (equipeII.equals(resultado.getEquipe1())) {
                        golsMasterTerceiro1.setText(String.valueOf(resultado.getGolsEquipe1()));
                        golsMasterTerceiro2.setText(String.valueOf(resultado.getGolsEquipe2()));
                    } else {
                        golsMasterTerceiro1.setText(String.valueOf(resultado.getGolsEquipe2()));
                        golsMasterTerceiro2.setText(String.valueOf(resultado.getGolsEquipe1()));
                    }

                    resultado = resultadoService.getGolsPorEquipeUnica(getActivity().getBaseContext(), equipeIII, "Senior", 5);
                    Log.d("teste", resultado.toString());
                    Log.d("teste", "Equipe III: " + equipeIII);
                    if (equipeIII.equals(resultado.getEquipe1())) {
                        golsSeniorFinalista1.setText(String.valueOf(resultado.getGolsEquipe1()));
                        golsSeniorFinalista2.setText(String.valueOf(resultado.getGolsEquipe2()));
                    } else {
                        golsSeniorFinalista1.setText(String.valueOf(resultado.getGolsEquipe2()));
                        golsSeniorFinalista2.setText(String.valueOf(resultado.getGolsEquipe1()));
                    }

                    resultado = resultadoService.getGolsPorEquipeUnica(getActivity().getBaseContext(), equipeIV, "Senior", 5);
                    Log.d("teste", resultado.toString());
                    Log.d("teste", "Equipe IV: " + equipeIV);
                    if (equipeIV.equals(resultado.getEquipe1())) {
                        golsSeniorTerceiro1.setText(String.valueOf(resultado.getGolsEquipe1()));
                        golsSeniorTerceiro2.setText(String.valueOf(resultado.getGolsEquipe2()));
                    } else {
                        golsSeniorTerceiro1.setText(String.valueOf(resultado.getGolsEquipe2()));
                        golsSeniorTerceiro2.setText(String.valueOf(resultado.getGolsEquipe1()));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return view;
    }

}
