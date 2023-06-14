package com.quentzmq.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView rock,paper,scissors;
    private Button btnrock,btnscissors,btnpaper,backM;
    private int sPaper,sRock,sScissors,comScr,userScr;
    private boolean spaper,srock,sscissors;

    public MainActivity2() {
    }

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        rock=(TextView)findViewById(R.id.txtSRock);
        paper=(TextView)findViewById(R.id.txtSPaper);
        scissors=(TextView) findViewById(R.id.txtSScissors);
        btnrock=(Button)findViewById(R.id.rock1);
        btnpaper=(Button)findViewById(R.id.paper1);
        btnscissors=(Button)findViewById(R.id.scissors1);
        backM=(Button) findViewById(R.id.button4);
        btnscissors.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        btnrock.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        btnpaper.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        backM.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        Intent intent=getIntent();
        sPaper=intent.getIntExtra("key1",0);
        sRock=intent.getIntExtra("key2",0);
        sScissors=intent.getIntExtra("key3",0);
        spaper=intent.getBooleanExtra("key4",false);
        sscissors=intent.getBooleanExtra("key5",false);
        srock=intent.getBooleanExtra("key6",false);
        rock.setText("Super Rock:"+sScissors);
        paper.setText("Super Paper:"+sPaper);
        scissors.setText("Super Scissors:"+sRock);
        comScr=intent.getIntExtra("key7",0);
        userScr=intent.getIntExtra("key8",0);
    }
    public void aRock(View v){
        if (sScissors>0 && !srock){
            sScissors--;
            rock.setText("Super Rock:"+sScissors);
            srock=true;}
    }
    public void aScissors(View v){
        if (sRock>0 && !sscissors){
        sRock--;
        scissors.setText("Super Scissors:"+sRock);
        sscissors=true;}
    }

    public void aPaper(View v){
        if (sPaper>0 && !spaper){
        sPaper--;
        paper.setText("Super Paper:"+sPaper);
        spaper=true;}
    }

    public void bMenu(View v){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("key1",sPaper);
        intent.putExtra("key2",sScissors);
        intent.putExtra("key3",sRock);
        intent.putExtra("key4",spaper);
        intent.putExtra("key5",sscissors);
        intent.putExtra("key6",srock);
        intent.putExtra("key7",comScr);
        intent.putExtra("key8",userScr);
        startActivity(intent);
    }

}