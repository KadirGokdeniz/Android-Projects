package com.quentzmq.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected Button rock,paper,scissors,market,txtInventory;
    protected TextView comScore,userScore,result,comC,comboTxt;
    protected int comScr=0,userScr=0,comChoice,combo=0,superPaper=0,superScissors=0,superRock=0;
    protected boolean activeSPaper=false,activeSScissors=false,activeSRock=false;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rock=(Button) findViewById(R.id.mainBtnRock);
        paper=(Button)findViewById(R.id.mainBtnPaper);
        scissors=(Button) findViewById(R.id.mainBtnScissors);
        txtInventory=(Button)findViewById(R.id.mainBtnInventory);
        market=(Button)findViewById(R.id.mainBtnMarket);
        comScore=(TextView) findViewById(R.id.mainTxtComScore);
        userScore=(TextView) findViewById(R.id.mainTxtUserScore);
        result=(TextView) findViewById(R.id.mainTxtSonuc);
        comC=(TextView)findViewById(R.id.mainComChoice);
        comboTxt=(TextView)findViewById(R.id.mainTxtCombo);
        comC.setText(" ");
        Intent intent1=getIntent();
        superPaper=intent1.getIntExtra("key1",0);
        superScissors=intent1.getIntExtra("key2",0);
        superRock=intent1.getIntExtra("key3",0);
        activeSPaper=intent1.getBooleanExtra("key4",false);
        activeSScissors=intent1.getBooleanExtra("key5",false);
        activeSRock=intent1.getBooleanExtra("key6",false);
        comScr=intent1.getIntExtra("key7",comScr);
        userScr=intent1.getIntExtra("key8",userScr);
        Intent intent2=getIntent();
        combo=intent2.getIntExtra("key1",0);
        superPaper=intent2.getIntExtra("key2",0);
        superScissors=intent2.getIntExtra("key3",0);
        superRock=intent2.getIntExtra("key4",0);
        comScr=intent2.getIntExtra("key5",comScr);
        userScr=intent2.getIntExtra("key6",userScr);
        comboTxt.setText("Combo: "+combo);
        comScore.setText(" "+(comScr)+"/50");
        userScore.setText(" "+(userScr)+"/50");
        if (!activeSPaper)
            paper.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        if(activeSPaper)
            paper.setBackgroundColor(ContextCompat.getColor(this,R.color.superColor));
        if(!activeSScissors)
            scissors.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        if(activeSScissors)
            scissors.setBackgroundColor(ContextCompat.getColor(this,R.color.superColor));
        if(!activeSRock)
            rock.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        if(activeSRock)
            rock.setBackgroundColor(ContextCompat.getColor(this,R.color.superColor));
        txtInventory.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        market.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
    }
    public void clickRock(View v){
        if (activeSRock){
            userScr+=5;
            activeSRock=false;
        }
        if (!activeSRock){
            rock.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        }
        if (userScr>=50 ||comScr>=50){
            comScore.setText(" "+(comScr)+"/50");
            userScore.setText(" "+(userScr)+"/50");
            rock.setEnabled(false);
            paper.setEnabled(false);
            scissors.setEnabled(false);
            market.setEnabled(false);
            txtInventory.setEnabled(false);
        }
        else
            comChoiceMethod(1);
    }
    public void clickPaper(View v){
        if (!activeSPaper){
            paper.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        }
        if (activeSPaper) {
            if (userScr<=50)
                userScr++;
            activeSPaper = false;
        }
        if (!activeSPaper){
            paper.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        }
        if (userScr>=50 ||comScr>=50){
            comScore.setText(" "+(comScr)+"/50");
            userScore.setText(" "+(userScr)+"/50");
            rock.setEnabled(false);
            paper.setEnabled(false);
            scissors.setEnabled(false);
            market.setEnabled(false);
            txtInventory.setEnabled(false);
        }
        else
            comChoiceMethod(2);
    }

    public void clickScissors(View v){
        comChoiceMethod(3);
        if (!activeSScissors){
            scissors.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        }
        if (userScr>=50 ||comScr>=50){
            comScore.setText(" "+(comScr)+"/50");
            userScore.setText(" "+(userScr)+"/50");
            rock.setEnabled(false);
            paper.setEnabled(false);
            scissors.setEnabled(false);
            market.setEnabled(false);
            txtInventory.setEnabled(false);
        }
    }
    public void clickInventory(View v){
        if (activeSPaper){
            paper.setBackgroundColor(ContextCompat.getColor(this,R.color.superColor));
        }
        if(activeSRock){
            rock.setBackgroundColor(ContextCompat.getColor(this,R.color.superColor));
        }
        if(activeSScissors){
            scissors.setBackgroundColor(ContextCompat.getColor(this,R.color.superColor));
        }
        Intent intent=new Intent(this,MainActivity2.class);
        intent.putExtra("key1",superPaper);
        intent.putExtra("key2",superScissors);
        intent.putExtra("key3",superRock);
        intent.putExtra("key4",activeSPaper);
        intent.putExtra("key5",activeSScissors);
        intent.putExtra("key6",activeSRock);
        intent.putExtra("key7",comScr);
        intent.putExtra("key8",userScr);
        startActivity(intent);
    }

    public void clickMarket(View v){
        Intent intent=new Intent(this,Main4Activity.class);
        intent.putExtra("key1",combo);
        intent.putExtra("key2",superPaper);
        intent.putExtra("key3",superScissors);
        intent.putExtra("key4",superRock);
        intent.putExtra("key5",comScr);
        intent.putExtra("key6",userScr);
        startActivity(intent);
    }
    public void comChoiceMethod(int userChoice){
        comChoice= (int) (Math.random()*3+1);
        if (comChoice==1)
            comC.setText("The Choice of Computer: Rock");
        if (comChoice==2)
            comC.setText("The Choice of Computer: Paper");
        if (comChoice==3)
            comC.setText("The Choice of Computer: Scissors");
        if (((comChoice == 1) && (userChoice == 1))||((comChoice==2)&&(userChoice==2))||((comChoice==3)&&(userChoice==3))){
            result.setText("Tied");
            if (activeSScissors && userChoice==3){
                activeSScissors=false;
            }
        }
        if(((comChoice==1)&&(userChoice==3))||((comChoice==2)&&(userChoice==1))||((comChoice==3)&&(userChoice==2))){
            result.setText("Computer Wins");
            comScr += 1;
            combo=0;
            comboTxt.setText("Combo: "+combo);
            if (activeSScissors && userChoice==3){
                activeSScissors=false;
            }
            if (comScr>=50){
                result.setText("Game Over!");
            }
            comScore.setText(String.valueOf(comScr)+"/50");
        }
        if(((comChoice==3)&&(userChoice==1))||((comChoice==1)&&(userChoice==2))||((comChoice==2)&&(userChoice==3))){
            result.setText("User Wins");
            userScr+=1;
            combo+=1;
            if (activeSScissors && userChoice==3){
                activeSScissors=false;
                if (comScr>=5){
                comScr-=5;}
                else{
                    comScr=0;
                }
            }
            comboTxt.setText("Combo: "+combo);
            userScore.setText(String.valueOf(userScr)+"/50");
        }
    }
}