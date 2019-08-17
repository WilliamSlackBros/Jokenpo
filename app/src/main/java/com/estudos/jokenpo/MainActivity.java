package com.estudos.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static int ptsRobor=0;
    private static int ptsHumano=0;
    private static String[] opcoes = {"pedra","papel","tesoura_jogador"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPedra = findViewById(R.id.btnPedra);
        Button btnPapel = findViewById(R.id.btnPapel);
        Button btnTesoura = findViewById(R.id.btnTesoura);

        btnPedra.setOnClickListener(this);
        btnPapel.setOnClickListener(this);
        btnTesoura.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnPedra:
                    System.out.println(this.playRobor());
                    this.validRegra("pedra",this.playRobor());
                    break;
                case R.id.btnPapel:
                    this.validRegra("papel",this.playRobor());
                    break;
                case R.id.btnTesoura:
                    this.validRegra("tesoura",this.playRobor());
                    break;
            }
    }

    public void addPlacar(String vencendor){
        if (vencendor=="robor"){
            this.ptsRobor +=1;
        }else if(vencendor=="humano"){
            this.ptsHumano+=1;
        }else{
            Toast.makeText(this,"Empate",Toast.LENGTH_SHORT).show();
        }
        TextView txtPlacar = (TextView) findViewById(R.id.txtPlacar);
        txtPlacar.setText(this.ptsRobor+" X "+this.ptsHumano);
    }
    public String playRobor(){
        int randOpcao = new Random().nextInt(this.opcoes.length);
        return opcoes[randOpcao];
    }
    public void alterarImagem(String esquedo,String direito){
        //atributos
        ImageView imgRoborRight = findViewById(R.id.imgHumanoRight);
        imgRoborRight.setScaleX(1);
        imgRoborRight.setScaleY(1);
        imgRoborRight.getLayoutParams().width=170;
        imgRoborRight.getLayoutParams().height=170;
        ImageView imgRoborLeft = findViewById(R.id.imgRoborLeft);
        imgRoborLeft.setScaleX(1);
        imgRoborLeft.setScaleY(1);
        imgRoborLeft.getLayoutParams().width=170;
        imgRoborLeft.getLayoutParams().height=170;

        //select imagem

            switch (esquedo){//robor
                case "pedra":
                    imgRoborLeft.setImageResource(R.drawable.pedra_jogador);
                    break;
                case "papel":
                    imgRoborLeft.setImageResource(R.drawable.papel_jogador);
                    break;
                case "tesoura":
                    imgRoborLeft.setImageResource(R.drawable.tesoura_jogador);
                    break;
            }


            switch (direito){//humano
                case "pedra":
                    imgRoborRight.setImageResource(R.drawable.pedra_jogador);
                    break;
                case "papel":
                    imgRoborRight.setImageResource(R.drawable.papel_jogador);
                    break;
                case "tesoura":
                    imgRoborRight.setImageResource(R.drawable.tesoura_jogador);
                    break;
            }



    }
    public void validRegra(String rspHumano, String rspRobor){
        //regras parte 1
        if (rspHumano=="pedra" && rspRobor == "tesoura"){
            this.alterarImagem(rspRobor,rspHumano);
            this.addPlacar("humano");
        }
        if (rspHumano=="papel" && rspRobor == "pedra"){
            this.alterarImagem(rspRobor,rspHumano);
            this.addPlacar("humano");
        }
        if (rspHumano=="tesoura" && rspRobor == "papel"){
            this.alterarImagem(rspRobor,rspHumano);
            this.addPlacar("humano");
        }
        //regras parte 2
        if (rspHumano=="pedra" && rspRobor == "pedra"){
            this.alterarImagem(rspRobor,rspHumano);
            this.addPlacar("empate");
        }
        if (rspHumano=="papel" && rspRobor == "papel"){
            this.alterarImagem(rspRobor,rspHumano);
            this.addPlacar("empate");
        }
        if (rspHumano=="tesoura" && rspRobor == "tesoura"){
            this.alterarImagem(rspRobor,rspHumano);
            this.addPlacar("empate");
        }
        //regras parte 3
        if (rspRobor=="pedra" && rspHumano == "tesoura"){
            this.alterarImagem(rspRobor,rspHumano);
            this.addPlacar("robor");
        }
        if (rspRobor=="papel" && rspHumano == "pedra"){
            this.alterarImagem(rspRobor,rspHumano);
            this.addPlacar("robor");
        }
        if (rspRobor=="tesoura" && rspHumano == "papel"){
            this.alterarImagem(rspRobor,rspHumano);
            this.addPlacar("robor");
        }
    }
}
