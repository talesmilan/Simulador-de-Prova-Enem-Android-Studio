package projetos.simuladordeprovaenem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Declarando as variáveis necessárias
    private Intent passar;
    private String codigo = "0";
    private boolean inglesAtivado = true;
    private Button rapido, normal, demorado, ingles, espanhol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando os botões
        rapido = (Button)findViewById(R.id.rapido);
        normal = (Button)findViewById(R.id.normal);
        demorado = (Button)findViewById(R.id.demorado);
        ingles = (Button)findViewById(R.id.ingles);
        espanhol = (Button)findViewById(R.id.espanhol);

        rapido.setBackgroundColor(Color.parseColor("#245F85"));
        ingles.setBackgroundColor(Color.parseColor("#005400"));

    }
    // Programando o botão iniciar
    public void iniciar(View view) {
        passar = new Intent(this, Tela.class);
        passar.putExtra("Informacao", codigo);
        startActivity(passar);
    }
    // Programando o botão da opção de prova rápida
    public void rapido(View view) {
        rapido.setBackgroundColor(Color.parseColor("#245F85"));
        normal.setBackgroundColor(Color.parseColor("#0AA7C8"));
        demorado.setBackgroundColor(Color.parseColor("#0AA7C8"));
        if (inglesAtivado) {
            codigo = "0";
        } else {
            codigo = "3";
        }
    }
    // Programando o botão da opção de prova normal
    public void normal(View view) {
        normal.setBackgroundColor(Color.parseColor("#245F85"));
        demorado.setBackgroundColor(Color.parseColor("#0AA7C8"));
        rapido.setBackgroundColor(Color.parseColor("#0AA7C8"));
        if (inglesAtivado) {
            codigo = "1";
        } else {
            codigo = "4";
        }
    }
    // Programando o botão da opção de prova demorada
    public void demorado(View view) {
        demorado.setBackgroundColor(Color.parseColor("#245F85"));
        rapido.setBackgroundColor(Color.parseColor("#0AA7C8"));
        normal.setBackgroundColor(Color.parseColor("#0AA7C8"));
        if (inglesAtivado) {
            codigo = "2";
        } else {
            codigo = "5";
        }
    }
    // Programando o botão da opção de inglês
    public void ingles(View view) {
        ingles.setBackgroundColor(Color.parseColor("#005400"));
        espanhol.setBackgroundColor(Color.parseColor("#009400"));
        inglesAtivado = true;
        if (codigo.equals("3") ) {
            codigo = "0";
        } else if (codigo.equals("4") ) {
            codigo = "1";
        } else if (codigo.equals("5") ) {
            codigo = "2";
        }
    }
    // Programando o botão da opção de espanhol
    public void espanhol(View view) {
        ingles.setBackgroundColor(Color.parseColor("#009400"));
        espanhol.setBackgroundColor(Color.parseColor("#005400"));
        inglesAtivado = false;
        if (codigo.equals("0") ) {
            codigo = "3";
        } else if (codigo.equals("1") ) {
            codigo = "4";
        } else if (codigo.equals("2") ) {
            codigo = "5";
        }
    }
    // Programando o botão de sair
    public void sairApp(View view) {this.finishAffinity();}
}