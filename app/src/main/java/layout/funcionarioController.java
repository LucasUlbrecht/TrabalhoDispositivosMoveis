package layout;

import static LogicaDeNegocio.UseCaseLogin.getController;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grandeatividade.R;

import LogicaDeNegocio.UseCaseGerenciarFuncionario;
import ProteceoDados.Security;

public class funcionarioController extends AppCompatActivity {
    Button btnGerenciarFuncionario;
    Button btnGerenciarPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario_page);
        btnGerenciarFuncionario = findViewById(R.id.btnGerenciarFuncionario);
        btnGerenciarPessoa = findViewById(R.id.btnGerenciarPessoas);
        btnGerenciarPessoa.setVisibility(View.INVISIBLE);
        btnGerenciarFuncionario.setVisibility(View.INVISIBLE);
        if(UseCaseGerenciarFuncionario.verificaADM(this)){
            btnGerenciarPessoa.setVisibility(View.VISIBLE);
            btnGerenciarFuncionario.setVisibility(View.VISIBLE);
        }
    }
    public void retornar(View view){
        Intent intent = new Intent(this, LoginController.class);
        Resources res = getController().getResources();
        SharedPreferences sharedPreferences = getController().getSharedPreferences("app_preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("cadastrado", "false");
        editor.apply();
        startActivity(intent);
    }
    public void irGerenciarSorvete(View view){
        Intent intent = new Intent(this, GerenciarSorveteController.class);
        startActivity(intent);
    }
    public void irGerenciarAdicionais(View view){
        Intent intent = new Intent(this, GerenciarAdicionaisController.class);
        startActivity(intent);
    }
    public void gerenciarFuncionario(View view){
        Intent intent = new Intent(this, GerenciarFuncionarioController.class);
        startActivity(intent);
    }
    public void gerenciarPessoas(View view){
        Intent intent = new Intent(this, GerenciarPessoasController.class);
        startActivity(intent);

    }
}
