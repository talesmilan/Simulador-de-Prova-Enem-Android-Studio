package projetos.simuladordeprovaenem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;

public class Tela extends AppCompatActivity {
    // Declaração de variáveis
    private int contagemQuestao = 0;
    private ArrayList<Integer> numeroQuestao;
    private int respostasCertas = 0, acertosIngles = 0, acertosEspanhol = 0, acertosLinguagens = 0;
    private int acertosHumanas = 0, acertosNatureza = 0, acertosMatematica = 0;
    private boolean acabou = false;
    private String stringAcertos;
    private String[] questoes;
    private String[] opcoesA;
    private String[] opcoesB;
    private String[] opcoesC;
    private String[] opcoesD;
    private String[] opcoesE;
    private String[] respostas;
    private TextView texto, titulo;
    private Button botaoA, botaoB, botaoC, botaoD, botaoE, botaoProximo;
    private String codigo;
    private ArrayList<Integer> arrayIngles, arrayEspanhol, arrayLinguagens, arrayHumanas, arrayNatureza, arrayMatematica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tela);

        //Pega a informação
        Intent passar = getIntent();

        //Recuperei a string da outra activity
        String informacao = passar.getStringExtra("Informacao");

        Log.i("Informacao: ", informacao);

        codigo = informacao;

        // Listas separadas por tipos
        arrayIngles = new ArrayList();
        arrayEspanhol = new ArrayList();
        arrayLinguagens = new ArrayList();
        arrayHumanas = new ArrayList();
        arrayNatureza = new ArrayList();
        arrayMatematica = new ArrayList();

        // Adiciona as questões no array separado por tipos
        for (int i = 0; i < 4; i++) {
            arrayIngles.add(44 + i);
            arrayEspanhol.add(48 + i);
        }

        for(int i = 0; i < 11; i++) {
            arrayLinguagens.add(i);
            arrayHumanas.add(11 + i);
            arrayNatureza.add(22 + i);
            arrayMatematica.add(33 + i);
        }

        // Embaralha as questões
        Collections.shuffle(arrayIngles);
        Collections.shuffle(arrayEspanhol);
        Collections.shuffle(arrayLinguagens);
        Collections.shuffle(arrayHumanas);
        Collections.shuffle(arrayNatureza);
        Collections.shuffle(arrayMatematica);

        numeroQuestao = new ArrayList();

        // Adiciona as questões no array de números
        if (codigo.equals("0") || codigo.equals("3")) {
            if (codigo.equals("0")) {
                for (int i = 0; i < 2; i++) {
                    numeroQuestao.add(arrayIngles.get(i));
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    numeroQuestao.add(arrayEspanhol.get(i));
                }
            }
            for (int i = 0; i < 2; i++) {
                numeroQuestao.add(arrayLinguagens.get(i));
            }
            for (int i = 0; i < 2; i++) {
                numeroQuestao.add(arrayHumanas.get(i));
            }
            for (int i = 0; i < 2; i++) {
                numeroQuestao.add(arrayNatureza.get(i));
            }
            for (int i = 0; i < 2; i++) {
                numeroQuestao.add(arrayMatematica.get(i));
            }
        } else if (codigo.equals("1") || codigo.equals("4")) {
            if (codigo.equals("1")) {
                for (int i = 0; i < 4; i++) {
                    numeroQuestao.add(arrayIngles.get(i));
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    numeroQuestao.add(arrayEspanhol.get(i));
                }
            }
            for (int i = 0; i < 4; i++) {
                numeroQuestao.add(arrayLinguagens.get(i));
            }
            for (int i = 0; i < 4; i++) {
                numeroQuestao.add(arrayHumanas.get(i));
            }
            for (int i = 0; i < 4; i++) {
                numeroQuestao.add(arrayNatureza.get(i));
            }
            for (int i = 0; i < 4; i++) {
                numeroQuestao.add(arrayMatematica.get(i));
            }
        } else if (codigo.equals("2") || codigo.equals("5")) {
            if (codigo.equals("2")) {
                for (int i = 0; i < 4; i++) {
                    numeroQuestao.add(arrayIngles.get(i));
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    numeroQuestao.add(arrayEspanhol.get(i));
                }
            }
            for (int i = 0; i < 7; i++) {
                numeroQuestao.add(arrayLinguagens.get(i));
            }
            for (int i = 0; i < 7; i++) {
                numeroQuestao.add(arrayHumanas.get(i));
            }
            for (int i = 0; i < 7; i++) {
                numeroQuestao.add(arrayNatureza.get(i));
            }
            for (int i = 0; i < 7; i++) {
                numeroQuestao.add(arrayMatematica.get(i));
            }
        }

        //Puxa as questão do xml pro array
        questoes = new String[52];
        questoes[0] = getString(R.string.questao0);
        questoes[1] = getString(R.string.questao1);
        questoes[2] = getString(R.string.questao2);
        questoes[3] = getString(R.string.questao3);
        questoes[4] = getString(R.string.questao4);
        questoes[5] = getString(R.string.questao5);
        questoes[6] = getString(R.string.questao6);
        questoes[7] = getString(R.string.questao7);
        questoes[8] = getString(R.string.questao8);
        questoes[9] = getString(R.string.questao9);
        questoes[10] = getString(R.string.questao10);
        questoes[11] = getString(R.string.questao11);
        questoes[12] = getString(R.string.questao12);
        questoes[13] = getString(R.string.questao13);
        questoes[14] = getString(R.string.questao14);
        questoes[15] = getString(R.string.questao15);
        questoes[16] = getString(R.string.questao16);
        questoes[17] = getString(R.string.questao17);
        questoes[18] = getString(R.string.questao18);
        questoes[19] = getString(R.string.questao19);
        questoes[20] = getString(R.string.questao20);
        questoes[21] = getString(R.string.questao21);
        questoes[22] = getString(R.string.questao22);
        questoes[23] = getString(R.string.questao23);
        questoes[24] = getString(R.string.questao24);
        questoes[25] = getString(R.string.questao25);
        questoes[26] = getString(R.string.questao26);
        questoes[27] = getString(R.string.questao27);
        questoes[28] = getString(R.string.questao28);
        questoes[29] = getString(R.string.questao29);
        questoes[30] = getString(R.string.questao30);
        questoes[31] = getString(R.string.questao31);
        questoes[32] = getString(R.string.questao32);
        questoes[33] = getString(R.string.questao33);
        questoes[34] = getString(R.string.questao34);
        questoes[35] = getString(R.string.questao35);
        questoes[36] = getString(R.string.questao36);
        questoes[37] = getString(R.string.questao37);
        questoes[38] = getString(R.string.questao38);
        questoes[39] = getString(R.string.questao39);
        questoes[40] = getString(R.string.questao40);
        questoes[41] = getString(R.string.questao41);
        questoes[42] = getString(R.string.questao42);
        questoes[43] = getString(R.string.questao43);
        questoes[44] = getString(R.string.questao44);
        questoes[45] = getString(R.string.questao45);
        questoes[46] = getString(R.string.questao46);
        questoes[47] = getString(R.string.questao47);
        questoes[48] = getString(R.string.questao48);
        questoes[49] = getString(R.string.questao49);
        questoes[50] = getString(R.string.questao50);
        questoes[51] = getString(R.string.questao51);

        // Puxa as opções A da prova do xml pro array
        opcoesA = new String[52];
        opcoesA[0] = getString(R.string.questao0A);
        opcoesA[1] = getString(R.string.questao1A);
        opcoesA[2] = getString(R.string.questao2A);
        opcoesA[3] = getString(R.string.questao3A);
        opcoesA[4] = getString(R.string.questao4A);
        opcoesA[5] = getString(R.string.questao5A);
        opcoesA[6] = getString(R.string.questao6A);
        opcoesA[7] = getString(R.string.questao7A);
        opcoesA[8] = getString(R.string.questao8A);
        opcoesA[9] = getString(R.string.questao9A);
        opcoesA[10] = getString(R.string.questao10A);
        opcoesA[11] = getString(R.string.questao11A);
        opcoesA[12] = getString(R.string.questao12A);
        opcoesA[13] = getString(R.string.questao13A);
        opcoesA[14] = getString(R.string.questao14A);
        opcoesA[15] = getString(R.string.questao15A);
        opcoesA[16] = getString(R.string.questao16A);
        opcoesA[17] = getString(R.string.questao17A);
        opcoesA[18] = getString(R.string.questao18A);
        opcoesA[19] = getString(R.string.questao19A);
        opcoesA[20] = getString(R.string.questao20A);
        opcoesA[21] = getString(R.string.questao21A);
        opcoesA[22] = getString(R.string.questao22A);
        opcoesA[23] = getString(R.string.questao23A);
        opcoesA[24] = getString(R.string.questao24A);
        opcoesA[25] = getString(R.string.questao25A);
        opcoesA[26] = getString(R.string.questao26A);
        opcoesA[27] = getString(R.string.questao27A);
        opcoesA[28] = getString(R.string.questao28A);
        opcoesA[29] = getString(R.string.questao29A);
        opcoesA[30] = getString(R.string.questao30A);
        opcoesA[31] = getString(R.string.questao31A);
        opcoesA[32] = getString(R.string.questao32A);
        opcoesA[33] = getString(R.string.questao33A);
        opcoesA[34] = getString(R.string.questao34A);
        opcoesA[35] = getString(R.string.questao35A);
        opcoesA[36] = getString(R.string.questao36A);
        opcoesA[37] = getString(R.string.questao37A);
        opcoesA[38] = getString(R.string.questao38A);
        opcoesA[39] = getString(R.string.questao39A);
        opcoesA[40] = getString(R.string.questao40A);
        opcoesA[41] = getString(R.string.questao41A);
        opcoesA[42] = getString(R.string.questao42A);
        opcoesA[43] = getString(R.string.questao43A);
        opcoesA[44] = getString(R.string.questao44A);
        opcoesA[45] = getString(R.string.questao45A);
        opcoesA[46] = getString(R.string.questao46A);
        opcoesA[47] = getString(R.string.questao47A);
        opcoesA[48] = getString(R.string.questao48A);
        opcoesA[49] = getString(R.string.questao49A);
        opcoesA[50] = getString(R.string.questao50A);
        opcoesA[51] = getString(R.string.questao51A);
        // Puxa as opções B da prova do xml pro array
        opcoesB = new String[52];
        opcoesB[0] = getString(R.string.questao0B);
        opcoesB[1] = getString(R.string.questao1B);
        opcoesB[2] = getString(R.string.questao2B);
        opcoesB[3] = getString(R.string.questao3B);
        opcoesB[4] = getString(R.string.questao4B);
        opcoesB[5] = getString(R.string.questao5B);
        opcoesB[6] = getString(R.string.questao6B);
        opcoesB[7] = getString(R.string.questao7B);
        opcoesB[8] = getString(R.string.questao8B);
        opcoesB[9] = getString(R.string.questao9B);
        opcoesB[10] = getString(R.string.questao10B);
        opcoesB[11] = getString(R.string.questao11B);
        opcoesB[12] = getString(R.string.questao12B);
        opcoesB[13] = getString(R.string.questao13B);
        opcoesB[14] = getString(R.string.questao14B);
        opcoesB[15] = getString(R.string.questao15B);
        opcoesB[16] = getString(R.string.questao16B);
        opcoesB[17] = getString(R.string.questao17B);
        opcoesB[18] = getString(R.string.questao18B);
        opcoesB[19] = getString(R.string.questao19B);
        opcoesB[20] = getString(R.string.questao20B);
        opcoesB[21] = getString(R.string.questao21B);
        opcoesB[22] = getString(R.string.questao22B);
        opcoesB[23] = getString(R.string.questao23B);
        opcoesB[24] = getString(R.string.questao24B);
        opcoesB[25] = getString(R.string.questao25B);
        opcoesB[26] = getString(R.string.questao26B);
        opcoesB[27] = getString(R.string.questao27B);
        opcoesB[28] = getString(R.string.questao28B);
        opcoesB[29] = getString(R.string.questao29B);
        opcoesB[30] = getString(R.string.questao30B);
        opcoesB[31] = getString(R.string.questao31B);
        opcoesB[32] = getString(R.string.questao32B);
        opcoesB[33] = getString(R.string.questao33B);
        opcoesB[34] = getString(R.string.questao34B);
        opcoesB[35] = getString(R.string.questao35B);
        opcoesB[36] = getString(R.string.questao36B);
        opcoesB[37] = getString(R.string.questao37B);
        opcoesB[38] = getString(R.string.questao38B);
        opcoesB[39] = getString(R.string.questao39B);
        opcoesB[40] = getString(R.string.questao40B);
        opcoesB[41] = getString(R.string.questao41B);
        opcoesB[42] = getString(R.string.questao42B);
        opcoesB[43] = getString(R.string.questao43B);
        opcoesB[44] = getString(R.string.questao44B);
        opcoesB[45] = getString(R.string.questao45B);
        opcoesB[46] = getString(R.string.questao46B);
        opcoesB[47] = getString(R.string.questao47B);
        opcoesB[48] = getString(R.string.questao48B);
        opcoesB[49] = getString(R.string.questao49B);
        opcoesB[50] = getString(R.string.questao50B);
        opcoesB[51] = getString(R.string.questao51B);
        // Puxa as opções C da prova do xml pro array
        opcoesC = new String[52];
        opcoesC[0] = getString(R.string.questao0C);
        opcoesC[1] = getString(R.string.questao1C);
        opcoesC[2] = getString(R.string.questao2C);
        opcoesC[3] = getString(R.string.questao3C);
        opcoesC[4] = getString(R.string.questao4C);
        opcoesC[5] = getString(R.string.questao5C);
        opcoesC[6] = getString(R.string.questao6C);
        opcoesC[7] = getString(R.string.questao7C);
        opcoesC[8] = getString(R.string.questao8C);
        opcoesC[9] = getString(R.string.questao9C);
        opcoesC[10] = getString(R.string.questao10C);
        opcoesC[11] = getString(R.string.questao11C);
        opcoesC[12] = getString(R.string.questao12C);
        opcoesC[13] = getString(R.string.questao13C);
        opcoesC[14] = getString(R.string.questao14C);
        opcoesC[15] = getString(R.string.questao15C);
        opcoesC[16] = getString(R.string.questao16C);
        opcoesC[17] = getString(R.string.questao17C);
        opcoesC[18] = getString(R.string.questao18C);
        opcoesC[19] = getString(R.string.questao19C);
        opcoesC[20] = getString(R.string.questao20C);
        opcoesC[21] = getString(R.string.questao21C);
        opcoesC[22] = getString(R.string.questao22C);
        opcoesC[23] = getString(R.string.questao23C);
        opcoesC[24] = getString(R.string.questao24C);
        opcoesC[25] = getString(R.string.questao25C);
        opcoesC[26] = getString(R.string.questao26C);
        opcoesC[27] = getString(R.string.questao27C);
        opcoesC[28] = getString(R.string.questao28C);
        opcoesC[29] = getString(R.string.questao29C);
        opcoesC[30] = getString(R.string.questao30C);
        opcoesC[31] = getString(R.string.questao31C);
        opcoesC[32] = getString(R.string.questao32C);
        opcoesC[33] = getString(R.string.questao33C);
        opcoesC[34] = getString(R.string.questao34C);
        opcoesC[35] = getString(R.string.questao35C);
        opcoesC[36] = getString(R.string.questao36C);
        opcoesC[37] = getString(R.string.questao37C);
        opcoesC[38] = getString(R.string.questao38C);
        opcoesC[39] = getString(R.string.questao39C);
        opcoesC[40] = getString(R.string.questao40C);
        opcoesC[41] = getString(R.string.questao41C);
        opcoesC[42] = getString(R.string.questao42C);
        opcoesC[43] = getString(R.string.questao43C);
        opcoesC[44] = getString(R.string.questao44C);
        opcoesC[45] = getString(R.string.questao45C);
        opcoesC[46] = getString(R.string.questao46C);
        opcoesC[47] = getString(R.string.questao47C);
        opcoesC[48] = getString(R.string.questao48C);
        opcoesC[49] = getString(R.string.questao49C);
        opcoesC[50] = getString(R.string.questao50C);
        opcoesC[51] = getString(R.string.questao51C);
        // Puxa as opções D da prova do xml pro array
        opcoesD = new String[52];
        opcoesD[0] = getString(R.string.questao0D);
        opcoesD[1] = getString(R.string.questao1D);
        opcoesD[2] = getString(R.string.questao2D);
        opcoesD[3] = getString(R.string.questao3D);
        opcoesD[4] = getString(R.string.questao4D);
        opcoesD[5] = getString(R.string.questao5D);
        opcoesD[6] = getString(R.string.questao6D);
        opcoesD[7] = getString(R.string.questao7D);
        opcoesD[8] = getString(R.string.questao8D);
        opcoesD[9] = getString(R.string.questao9D);
        opcoesD[10] = getString(R.string.questao10D);
        opcoesD[11] = getString(R.string.questao11D);
        opcoesD[12] = getString(R.string.questao12D);
        opcoesD[13] = getString(R.string.questao13D);
        opcoesD[14] = getString(R.string.questao14D);
        opcoesD[15] = getString(R.string.questao15D);
        opcoesD[16] = getString(R.string.questao16D);
        opcoesD[17] = getString(R.string.questao17D);
        opcoesD[18] = getString(R.string.questao18D);
        opcoesD[19] = getString(R.string.questao19D);
        opcoesD[20] = getString(R.string.questao20D);
        opcoesD[21] = getString(R.string.questao21D);
        opcoesD[22] = getString(R.string.questao22D);
        opcoesD[23] = getString(R.string.questao23D);
        opcoesD[24] = getString(R.string.questao24D);
        opcoesD[25] = getString(R.string.questao25D);
        opcoesD[26] = getString(R.string.questao26D);
        opcoesD[27] = getString(R.string.questao27D);
        opcoesD[28] = getString(R.string.questao28D);
        opcoesD[29] = getString(R.string.questao29D);
        opcoesD[30] = getString(R.string.questao30D);
        opcoesD[31] = getString(R.string.questao31D);
        opcoesD[32] = getString(R.string.questao32D);
        opcoesD[33] = getString(R.string.questao33D);
        opcoesD[34] = getString(R.string.questao34D);
        opcoesD[35] = getString(R.string.questao35D);
        opcoesD[36] = getString(R.string.questao36D);
        opcoesD[37] = getString(R.string.questao37D);
        opcoesD[38] = getString(R.string.questao38D);
        opcoesD[39] = getString(R.string.questao39D);
        opcoesD[40] = getString(R.string.questao40D);
        opcoesD[41] = getString(R.string.questao41D);
        opcoesD[42] = getString(R.string.questao42D);
        opcoesD[43] = getString(R.string.questao43D);
        opcoesD[44] = getString(R.string.questao44D);
        opcoesD[45] = getString(R.string.questao45D);
        opcoesD[46] = getString(R.string.questao46D);
        opcoesD[47] = getString(R.string.questao47D);
        opcoesD[48] = getString(R.string.questao48D);
        opcoesD[49] = getString(R.string.questao49D);
        opcoesD[50] = getString(R.string.questao50D);
        opcoesD[51] = getString(R.string.questao51D);
        // Puxa as opções E da prova do xml pro array
        opcoesE = new String[52];
        opcoesE[0] = getString(R.string.questao0E);
        opcoesE[1] = getString(R.string.questao1E);
        opcoesE[2] = getString(R.string.questao2E);
        opcoesE[3] = getString(R.string.questao3E);
        opcoesE[4] = getString(R.string.questao4E);
        opcoesE[5] = getString(R.string.questao5E);
        opcoesE[6] = getString(R.string.questao6E);
        opcoesE[7] = getString(R.string.questao7E);
        opcoesE[8] = getString(R.string.questao8E);
        opcoesE[9] = getString(R.string.questao9E);
        opcoesE[10] = getString(R.string.questao10E);
        opcoesE[11] = getString(R.string.questao11E);
        opcoesE[12] = getString(R.string.questao12E);
        opcoesE[13] = getString(R.string.questao13E);
        opcoesE[14] = getString(R.string.questao14E);
        opcoesE[15] = getString(R.string.questao15E);
        opcoesE[16] = getString(R.string.questao16E);
        opcoesE[17] = getString(R.string.questao17E);
        opcoesE[18] = getString(R.string.questao18E);
        opcoesE[19] = getString(R.string.questao19E);
        opcoesE[20] = getString(R.string.questao20E);
        opcoesE[21] = getString(R.string.questao21E);
        opcoesE[22] = getString(R.string.questao22E);
        opcoesE[23] = getString(R.string.questao23E);
        opcoesE[24] = getString(R.string.questao24E);
        opcoesE[25] = getString(R.string.questao25E);
        opcoesE[26] = getString(R.string.questao26E);
        opcoesE[27] = getString(R.string.questao27E);
        opcoesE[28] = getString(R.string.questao28E);
        opcoesE[29] = getString(R.string.questao29E);
        opcoesE[30] = getString(R.string.questao30E);
        opcoesE[31] = getString(R.string.questao31E);
        opcoesE[32] = getString(R.string.questao32E);
        opcoesE[33] = getString(R.string.questao33E);
        opcoesE[34] = getString(R.string.questao34E);
        opcoesE[35] = getString(R.string.questao35E);
        opcoesE[36] = getString(R.string.questao36E);
        opcoesE[37] = getString(R.string.questao37E);
        opcoesE[38] = getString(R.string.questao38E);
        opcoesE[39] = getString(R.string.questao39E);
        opcoesE[40] = getString(R.string.questao40E);
        opcoesE[41] = getString(R.string.questao41E);
        opcoesE[42] = getString(R.string.questao42E);
        opcoesE[43] = getString(R.string.questao43E);
        opcoesE[44] = getString(R.string.questao44E);
        opcoesE[45] = getString(R.string.questao45E);
        opcoesE[46] = getString(R.string.questao46E);
        opcoesE[47] = getString(R.string.questao47E);
        opcoesE[48] = getString(R.string.questao48E);
        opcoesE[49] = getString(R.string.questao49E);
        opcoesE[50] = getString(R.string.questao50E);
        opcoesE[51] = getString(R.string.questao51E);

        // Cria o array de respostas
        respostas = new String[52];
        for (int i = 0; i < 52; i++) {
            respostas[i] = "";
        }
        //Inicializa as varáveis de texto e botões
        texto = (TextView)findViewById(R.id.texto);
        titulo = (TextView)findViewById(R.id.titulo);
        botaoA = (Button)findViewById(R.id.opcaoA);
        botaoB = (Button)findViewById(R.id.opcaoB);
        botaoC = (Button)findViewById(R.id.opcaoC);
        botaoD = (Button)findViewById(R.id.opcaoD);
        botaoE = (Button)findViewById(R.id.opcaoE);
        botaoProximo = (Button)findViewById(R.id.proximo);
        //Muda a tela para primeira questão
        mudarTela();
    }
    // Programa o botão próxima questão e concluir
    public void proximo(View view) {
        if (!acabou) {
            if (respostas[numeroQuestao.get(contagemQuestao)].equals("") ) {
                Snackbar mensagem = Snackbar.make(view, "Você deve selecionar uma das alternativas antes de avançar.", 2000);
                mensagem.show();
            } else {
                contagemQuestao++;
                if (contagemQuestao > 9 && codigo.equals("0")) {
                    acabou = true;
                    telaFinal();
                } else if (contagemQuestao > 19 && codigo.equals("1")){
                    acabou = true;
                    telaFinal();
                } else if (contagemQuestao > 31 && codigo.equals("2")) {
                    acabou = true;
                    telaFinal();
                } else if (contagemQuestao > 9 && codigo.equals("3")) {
                    acabou = true;
                    telaFinal();
                } else if (contagemQuestao > 19 && codigo.equals("4")) {
                    acabou = true;
                    telaFinal();
                } else if (contagemQuestao > 31 && codigo.equals("5")) {
                    acabou = true;
                    telaFinal();
                } else {
                    mudarTela();
                }
            }
        } else {
            finish();
        }
    }
    // Programa o botão da opção A
    public void opcaoA(View view) {
        botaoA.setBackgroundColor(Color.parseColor("#245F85"));
        botaoB.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoC.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoD.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoE.setBackgroundColor(Color.parseColor("#0AA7C8"));
        respostas[numeroQuestao.get(contagemQuestao)] = "A";
    }
    // Programa o botão da opção B
    public void opcaoB(View view) {
        botaoA.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoB.setBackgroundColor(Color.parseColor("#245F85"));
        botaoC.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoD.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoE.setBackgroundColor(Color.parseColor("#0AA7C8"));
        respostas[numeroQuestao.get(contagemQuestao)] = "B";
    }
    // Programa o botão da opção C
    public void opcaoC(View view) {
        botaoA.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoB.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoC.setBackgroundColor(Color.parseColor("#245F85"));
        botaoD.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoE.setBackgroundColor(Color.parseColor("#0AA7C8"));
        respostas[numeroQuestao.get(contagemQuestao)] = "C";
    }
    // Programa o botão da opção D
    public void opcaoD(View view) {
        botaoA.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoB.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoC.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoD.setBackgroundColor(Color.parseColor("#245F85"));
        botaoE.setBackgroundColor(Color.parseColor("#0AA7C8"));
        respostas[numeroQuestao.get(contagemQuestao)] = "D";
    }
    // Programa o botão da opção E
    public void opcaoE(View view) {
        botaoA.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoB.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoC.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoD.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoE.setBackgroundColor(Color.parseColor("#245F85"));
        respostas[numeroQuestao.get(contagemQuestao)] = "E";
    }
    // Função que muda a tela para próxima pergunta
    public void mudarTela() {
        if (contagemQuestao < 9) {
            titulo.setText("Questão 0" + (contagemQuestao + 1));
        } else {
            titulo.setText("Questão " + (contagemQuestao + 1));
        }
        texto.setText(questoes[numeroQuestao.get(contagemQuestao)]);
        botaoA.setText(opcoesA[numeroQuestao.get(contagemQuestao)]);
        botaoB.setText(opcoesB[numeroQuestao.get(contagemQuestao)]);
        botaoC.setText(opcoesC[numeroQuestao.get(contagemQuestao)]);
        botaoD.setText(opcoesD[numeroQuestao.get(contagemQuestao)]);
        botaoE.setText(opcoesE[numeroQuestao.get(contagemQuestao)]);

        botaoA.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoB.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoC.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoD.setBackgroundColor(Color.parseColor("#0AA7C8"));
        botaoE.setBackgroundColor(Color.parseColor("#0AA7C8"));
    }
    // Função que muda a tela para a tela de conclusão
    public void telaFinal() {
        int totalIdiomas = 0, totalPerguntas = 0;
        corrigirProva();
        if (codigo.equals("0")) {
            stringAcertos = "Inglês: " + acertosIngles;
            totalIdiomas = 2;
            totalPerguntas = 2;
        } else if (codigo.equals("1")) {
            stringAcertos = "Inglês: " + acertosIngles;
            totalIdiomas = 4;
            totalPerguntas = 4;
        } else if (codigo.equals("2")) {
            stringAcertos = "Inglês: " + acertosIngles;
            totalIdiomas = 4;
            totalPerguntas = 7;
        } else if (codigo.equals("3")) {
            stringAcertos = "Espanhol: " + acertosEspanhol;
            totalIdiomas = 2;
            totalPerguntas = 2;
        } else if (codigo.equals("4")) {
            stringAcertos = "Espanhol: " + acertosEspanhol;
            totalIdiomas = 4;
            totalPerguntas = 4;
        }  else if (codigo.equals("5")) {
            stringAcertos = "Espanhol: " + acertosEspanhol;
            totalIdiomas = 4;
            totalPerguntas = 7;
        }
        texto.setText( "Você acertou: " + respostasCertas + "/" + numeroQuestao.size()
                + System.getProperty ("line.separator")
                + stringAcertos + "/" + totalIdiomas
                + System.getProperty ("line.separator")
                + "Linguagens: " + acertosLinguagens + "/" + totalPerguntas
                + System.getProperty ("line.separator")
                + "Ciências Humanas: " + acertosHumanas + "/" + totalPerguntas
                + System.getProperty ("line.separator")
                + "Ciências da Natureza: " + acertosNatureza + "/" + totalPerguntas
                + System.getProperty ("line.separator")
                + "Matematica: " + acertosMatematica + "/" + totalPerguntas
                + System.getProperty ("line.separator")
                + System.getProperty ("line.separator")
                + System.getProperty ("line.separator"));
        botaoProximo.setText("Concluir");
        texto.setTextSize(20);
        titulo.setText("Resultado Final");
        botaoA.setVisibility(View.GONE);
        botaoB.setVisibility(View.GONE);
        botaoC.setVisibility(View.GONE);
        botaoD.setVisibility(View.GONE);
        botaoE.setVisibility(View.GONE);
    }

    // Função que corrige a prova
    public void corrigirProva() {
        if (respostas[0].equals("B") ) {
            respostasCertas++;
            acertosLinguagens++;
        }
        if (respostas[1].equals("D") ) {
            respostasCertas++;
            acertosLinguagens++;
        }
        if (respostas[2].equals("C") ) {
            respostasCertas++;
            acertosLinguagens++;
        }
        if (respostas[3].equals("D") ) {
            respostasCertas++;
            acertosLinguagens++;
        }
        if (respostas[4].equals("E") ) {
            respostasCertas++;
            acertosLinguagens++;
        }
        if (respostas[5].equals("A") ) {
            respostasCertas++;
            acertosLinguagens++;
        }
        if (respostas[6].equals("D") ) {
            respostasCertas++;
            acertosLinguagens++;
        }
        if (respostas[7].equals("B") ) {
            respostasCertas++;
            acertosLinguagens++;
        }
        if (respostas[8].equals("B") ) {
            respostasCertas++;
            acertosLinguagens++;
        }
        if (respostas[9].equals("B") ) {
            respostasCertas++;
            acertosLinguagens++;
        }
        if (respostas[10].equals("A") ) {
            respostasCertas++;
            acertosLinguagens++;
        }
        if (respostas[11].equals("B") ) {
            respostasCertas++;
            acertosHumanas++;
        }
        if (respostas[12].equals("A") ) {
            respostasCertas++;
            acertosHumanas++;
        }
        if (respostas[13].equals("A") ) {
            respostasCertas++;
            acertosHumanas++;
        }
        if (respostas[14].equals("D") ) {
            respostasCertas++;
            acertosHumanas++;
        }
        if (respostas[15].equals("B") ) {
            respostasCertas++;
            acertosHumanas++;
        }
        if (respostas[16].equals("C") ) {
            respostasCertas++;
            acertosHumanas++;
        }
        if (respostas[17].equals("E") ) {
            respostasCertas++;
            acertosHumanas++;
        }
        if (respostas[18].equals("D") ) {
            respostasCertas++;
            acertosHumanas++;
        }
        if (respostas[19].equals("D") ) {
            respostasCertas++;
            acertosHumanas++;
        }
        if (respostas[20].equals("E") ) {
            respostasCertas++;
            acertosHumanas++;
        }
        if (respostas[21].equals("B") ) {
            respostasCertas++;
            acertosHumanas++;
        }
        if (respostas[22].equals("A") ) {
            respostasCertas++;
            acertosNatureza++;
        }
        if (respostas[23].equals("E") ) {
            respostasCertas++;
            acertosNatureza++;
        }
        if (respostas[24].equals("D") ) {
            respostasCertas++;
            acertosNatureza++;
        }
        if (respostas[25].equals("B") ) {
            respostasCertas++;
            acertosNatureza++;
        }
        if (respostas[26].equals("B") ) {
            respostasCertas++;
            acertosNatureza++;
        }
        if (respostas[27].equals("E") ) {
            respostasCertas++;
            acertosNatureza++;
        }
        if (respostas[28].equals("B") ) {
            respostasCertas++;
            acertosNatureza++;
        }
        if (respostas[29].equals("B") ) {
            respostasCertas++;
            acertosNatureza++;
        }
        if (respostas[30].equals("D") ) {
            respostasCertas++;
            acertosNatureza++;
        }
        if (respostas[31].equals("E") ) {
            respostasCertas++;
            acertosNatureza++;
        }
        if (respostas[32].equals("D") ) {
            respostasCertas++;
            acertosNatureza++;
        }
        if (respostas[33].equals("B") ) {
            respostasCertas++;
            acertosMatematica++;
        }
        if (respostas[34].equals("A") ) {
            respostasCertas++;
            acertosMatematica++;
        }
        if (respostas[35].equals("D") ) {
            respostasCertas++;
            acertosMatematica++;
        }
        if (respostas[36].equals("D") ) {
            respostasCertas++;
            acertosMatematica++;
        }
        if (respostas[37].equals("C") ) {
            respostasCertas++;
            acertosMatematica++;
        }
        if (respostas[38].equals("B") ) {
            respostasCertas++;
            acertosMatematica++;
        }
        if (respostas[39].equals("B") ) {
            respostasCertas++;
            acertosMatematica++;
        }
        if (respostas[40].equals("C") ) {
            respostasCertas++;
            acertosMatematica++;
        }
        if (respostas[41].equals("D") ) {
            respostasCertas++;
            acertosMatematica++;
        }
        if (respostas[42].equals("B") ) {
            respostasCertas++;
            acertosMatematica++;
        }
        if (respostas[43].equals("D") ) {
            respostasCertas++;
            acertosMatematica++;
        }
        if (respostas[44].equals("C") ) {
            respostasCertas++;
            acertosIngles++;
        }
        if (respostas[45].equals("A") ) {
            respostasCertas++;
            acertosIngles++;
        }
        if (respostas[46].equals("A") ) {
            respostasCertas++;
            acertosIngles++;
        }
        if (respostas[47].equals("B") ) {
            respostasCertas++;
            acertosIngles++;
        }
        if (respostas[48].equals("C") ) {
            respostasCertas++;
            acertosEspanhol++;
        }
        if (respostas[49].equals("A") ) {
            respostasCertas++;
            acertosEspanhol++;
        }
        if (respostas[50].equals("E") ) {
            respostasCertas++;
            acertosEspanhol++;
        }
        if (respostas[51].equals("A") ) {
            respostasCertas++;
            acertosEspanhol++;
        }
    }

}