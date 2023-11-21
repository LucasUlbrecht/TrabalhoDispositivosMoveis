package layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.grandeatividade.R;

import LogicaDeNegocio.UseCaseLogin;
import Pacote_de_Dados.DB;
import Pacote_de_Dados.ORM.PessoaData;
import ProteceoDados.Security;

public class CadastroController extends AppCompatActivity {
    EditText login;
    EditText senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_page);
        senha=findViewById(R.id.passwordField);
        login=findViewById(R.id.loginField);

    }
    public void cadastrar(View view) {
        String loginTmp = login.getText().toString();
        String senhaTmp = senha.getText().toString();
        boolean resposta= UseCaseLogin.verificaCadastro(this,loginTmp,senhaTmp);
        if(resposta){
            Intent intent = new Intent(this, LoginController.class);
            startActivity(intent);
        }else{
            //error
        }
    }


}