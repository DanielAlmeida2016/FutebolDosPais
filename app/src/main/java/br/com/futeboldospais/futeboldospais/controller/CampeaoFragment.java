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
public class CampeaoFragment extends Fragment {

    private ImageView imgCampeaoMaster;
    private TextView txtCampeaoMaster;

    private ImageView imgSegundoMaster;
    private TextView txtSegundoMaster;

    private ImageView imgTerceiroMaster;
    private TextView txtTerceiroMaster;

    private ImageView imgCampeaoSenior;
    private TextView txtCampeaoSenior;

    private ImageView imgSegundoSenior;
    private TextView txtSegundoSenior;

    private ImageView imgTerceiroSenior;
    private TextView txtTerceiroSenior;

    ClassificacaoQuartasService classificacaoQuartasService;
    ResultadoService resultadoService;
    DistintivoService distintivoService;

    private static CampeaoFragment fragment = null;

    public static CampeaoFragment newInstance() {
        if (fragment == null) {
            fragment = new CampeaoFragment();
        }
        return fragment;
    }


    public CampeaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_campeao, container, false);

        imgCampeaoMaster = (ImageView) view.findViewById(R.id.img_campeao_master);
        txtCampeaoMaster = (TextView) view.findViewById(R.id.txt_campeao_master);

        imgSegundoMaster = (ImageView) view.findViewById(R.id.img_segundo_master);
        txtSegundoMaster = (TextView) view.findViewById(R.id.txt_segundo_master);

        imgTerceiroMaster = (ImageView) view.findViewById(R.id.img_terceiro_master);
        txtTerceiroMaster = (TextView) view.findViewById(R.id.txt_terceiro_master);

        imgCampeaoSenior = (ImageView) view.findViewById(R.id.img_campeao_senior);
        txtCampeaoSenior = (TextView) view.findViewById(R.id.txt_campeao_senior);

        imgSegundoSenior = (ImageView) view.findViewById(R.id.img_segundo_senior);
        txtSegundoSenior = (TextView) view.findViewById(R.id.txt_segundo_senior);

        imgTerceiroSenior = (ImageView) view.findViewById(R.id.img_terceiro_senior);
        txtTerceiroSenior = (TextView) view.findViewById(R.id.txt_terceiro_senior);

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

                equipeI = equipe1;
                equipeII = equipe2;
            } else {

                equipeI = equipe2;
                equipeII = equipe1;
            }

            resultado = resultadoService.getEquipeVencedora(getActivity().getBaseContext(), equipe3, equipe4, "Master");
            if (resultado.getVencedor() == 1) {

            } else {

            }

            resultado = resultadoService.getEquipeVencedora(getActivity().getBaseContext(), equipe5, equipe6, "Senior");
            if (resultado.getVencedor() == 1) {

                equipeIII = equipe5;
                equipeIV = equipe6;
            } else {

                equipeIII = equipe6;
                equipeIV = equipe5;
            }

            resultado = resultadoService.getEquipeVencedora(getActivity().getBaseContext(), equipe7, equipe8, "Senior");
            if (resultado.getVencedor() == 1) {

            } else {

            }
            Log.d("teste", equipe1 + equipe2);

            //-----------------------------------------------------------------------------------------------------------------

            resultado = resultadoService.getVencedorPorEquipeUnica(getActivity().getBaseContext(), equipeI, "Master", 5);
            if (resultado.getVencedor() == 1) {
                imgCampeaoMaster.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe1()));
                txtCampeaoMaster.setText(resultado.getEquipe1());

                imgSegundoMaster.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe2()));
                txtSegundoMaster.setText(resultado.getEquipe2());
            } else {
                imgCampeaoMaster.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe2()));
                txtCampeaoMaster.setText(resultado.getEquipe2());

                imgSegundoMaster.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe1()));
                txtSegundoMaster.setText(resultado.getEquipe1());
            }

            resultado = resultadoService.getVencedorPorEquipeUnica(getActivity().getBaseContext(), equipeII, "Master", 5);
            if (resultado.getVencedor() == 1) {
                imgTerceiroMaster.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe1()));
                txtTerceiroMaster.setText(resultado.getEquipe1());
            } else {
                imgTerceiroMaster.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe2()));
                txtTerceiroMaster.setText(resultado.getEquipe2());
            }

            resultado = resultadoService.getVencedorPorEquipeUnica(getActivity().getBaseContext(), equipeIII, "Senior", 5);
            if (resultado.getVencedor() == 1) {
                imgCampeaoSenior.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe1()));
                txtCampeaoSenior.setText(resultado.getEquipe1());

                imgSegundoSenior.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe2()));
                txtSegundoSenior.setText(resultado.getEquipe2());
            } else {
                imgCampeaoSenior.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe2()));
                txtCampeaoSenior.setText(resultado.getEquipe2());

                imgSegundoSenior.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe1()));
                txtSegundoSenior.setText(resultado.getEquipe1());
            }

            resultado = resultadoService.getVencedorPorEquipeUnica(getActivity().getBaseContext(), equipeIV, "Senior", 5);
            if (resultado.getVencedor() == 1) {
                imgTerceiroSenior.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe1()));
                txtTerceiroSenior.setText(resultado.getEquipe1());
            } else {
                imgTerceiroSenior.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), resultado.getEquipe2()));
                txtTerceiroSenior.setText(resultado.getEquipe2());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return view;
    }

}
