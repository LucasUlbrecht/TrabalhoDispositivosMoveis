package layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import com.example.grandeatividade.R;

import LogicaDeNegocio.UseCaseLogin;

public class LoginController extends AppCompatActivity {

    Boolean cadastrado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume(){
        super.onResume();
        UseCaseLogin.verificaLogin(this);
    }


    public void cadastroPage(View view){


        Intent intent = new Intent(this, CadastroController.class);
        startActivity(intent);
    }
}