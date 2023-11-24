package layout;

import static LogicaDeNegocio.UseCaseLogin.getController;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grandeatividade.R;

public class funcionarioController extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario_page);
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
}
