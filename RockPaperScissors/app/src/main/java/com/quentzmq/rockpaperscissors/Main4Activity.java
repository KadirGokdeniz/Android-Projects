package com.quentzmq.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    private TextView txt;
    private Button btn1,btn2,btn3,bmenu1;
    private int combo,spaper,sscissors,srock,comScr,userScr;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        txt=(TextView) findViewById(R.id.combo);
        btn1=(Button)findViewById(R.id.paper1);
        btn2=(Button)findViewById(R.id.rock1);
        btn3=(Button)findViewById(R.id.scissors1);
        bmenu1=(Button)findViewById(R.id.bMenu1);
        btn1.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        btn2.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        btn3.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        bmenu1.setBackgroundColor(ContextCompat.getColor(this,R.color.defaultColor));
        Intent intent=getIntent();
        combo=intent.getIntExtra("key1",0);
        spaper=intent.getIntExtra("key2",0);
        sscissors=intent.getIntExtra("key3",0);
        srock=intent.getIntExtra("key4",0);
        comScr=intent.getIntExtra("key5",0);
        userScr=intent.getIntExtra("key6",0);
        txt.setText("Combo: "+combo);
    }
    public void paper(View v){
        if (combo>1){
        combo-=2;
        txt.setText("Combo: "+combo);
        spaper++;}
    }
    public void scissors(View v){
        if (combo>2){
        combo-=3;
        txt.setText("Combo: "+combo);
        sscissors++;}
    }
    public void rock(View v){
        if (combo>4){
        combo-=5;
        txt.setText("Combo: "+combo);
        srock++;}
    }
    public void bMenu(View v){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("key1",combo);
        intent.putExtra("key2",spaper);
        intent.putExtra("key3",sscissors);
        intent.putExtra("key4",srock);
        intent.putExtra("key5",comScr);
        intent.putExtra("key6",userScr);
        startActivity(intent);
    }
}