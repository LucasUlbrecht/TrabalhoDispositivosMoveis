package layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.grandeatividade.R;

import LogicaDeNegocio.UseCaseGerenciarSorvete;
import Model.Sorvete;

public class SorveteDetalheController extends AppCompatActivity {
    Button btnAtualizar;
    Button btnDelete;
    Button btnInserir;
    EditText editTextCodigo;
    EditText editTextTipo;
    EditText editTextQuant;
    EditText editTextValor;
    EditText editTextNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorvete_detalhe_controller);
        Intent intent = getIntent();
        Sorvete s = UseCaseGerenciarSorvete.buscarSorvete(this, intent);
        iniciarTela(s);
    }
    public void retornar(View view){
        Intent intent = new Intent(this, GerenciarSorveteController.class);
        startActivity(intent);
    }
    public void adicionar(View view){
        UseCaseGerenciarSorvete.modificarTupla(this, "inserir");
        retornar(view);
    }
    public void atualizar(View view){
        UseCaseGerenciarSorvete.modificarTupla(this, "atualizar");
        retornar(view);
    }
    public void deletar(View view){
        UseCaseGerenciarSorvete.modificarTupla(this, "deletar");
        retornar(view);
    }
    public void iniciarTela(Sorvete s){
        UseCaseGerenciarSorvete.carregarTela(this, s);
    }
}