package LogicaDeNegocio;

import static androidx.appcompat.graphics.drawable.DrawableContainerCompat.Api21Impl.getResources;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grandeatividade.R;

import Model.Pessoa;
import Pacote_de_Dados.DB;
import Pacote_de_Dados.ORM.PessoaData;
import ProteceoDados.Security;
import layout.LoginController;

public class UseCaseLogin {
    private static AppCompatActivity controller;
    private static String idLogin="loginCriptografado";
    private static String idSenha="senhaCriptografada";
    private static String loginResource="LOGIN";
    //getters

    public static AppCompatActivity getController() {
        return controller;
    }

    public static String getIdLogin() {
        return idLogin;
    }

    public static String getIdSenha() {
        return idSenha;
    }

    public static String getLoginResource() {
        return loginResource;
    }

    public static boolean verificaCadastro(AppCompatActivity AppCompat, String login, String senha){
        Boolean resposta=verificaPessoaBD(login, senha);
        if(resposta) {
            Security.armazenar(AppCompat, login, getIdLogin());
            Security.armazenar(AppCompat, senha, getIdSenha());
        }
        return resposta;
    }
    public static void verificaLogin(AppCompatActivity AppCompat){
        controller = AppCompat;
        Resources res = getController().getResources();
        Boolean cadastrado = Boolean.parseBoolean(res.getString(R.string.cadastrado));

        if(cadastrado){
            String loginTmp = Security.recuperar(getController().getApplicationContext(), getIdLogin());
            String senhaTmp = Security.recuperar(getController().getApplicationContext(), getIdSenha());
            if(verificaPessoaBD(loginTmp, senhaTmp)){
                Intent intent = new Intent(getController(), paginaFuncionario.class);
                intent.putExtra(getLoginResource(), loginTmp);

                SharedPreferences sharedPreferences = getController().getSharedPreferences("app_preferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("cadastrado", "true");
                editor.apply();
                controller.startActivity(intent);
            }
            //Intent intent = new Intent(this, );
        }
    }

    private static boolean verificaPessoaBD(String login, String senha){
        try{
            DB bd = DB.getDatabase(getController());
            PessoaData pessoaTmp = bd.pessoaDao().buscarPessoaCpf(login);
            if(pessoaTmp.getPassword()==senha && pessoaTmp.getCpf()==login){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            Log.d("Erro", "Conectar bd");
            return false;
        }
    }
}
