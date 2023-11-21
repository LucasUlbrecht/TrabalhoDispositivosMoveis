package com.example.grandeatividade.PaginaAcessoPessoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import com.example.grandeatividade.PaginaAcessoPessoa.cadastroPage;
import com.example.grandeatividade.R;

public class MainActivity extends AppCompatActivity {

    Boolean cadastrado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume(){
        super.onResume();


        Resources res = getResources();
        cadastrado = Boolean.parseBoolean(res.getString(R.string.cadastrado));



    }


    public void cadastroPage(View view){


        Intent intent = new Intent(this, cadastroPage.class);
        startActivity(intent);
    }
}