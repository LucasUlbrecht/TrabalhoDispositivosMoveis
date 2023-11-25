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
import Pacote_de_Dados.DAO.SorveteDAO;
import Pacote_de_Dados.HandlerAcess.DataAccessHandler;

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

    public Button getBtnAtualizar() {
        return btnAtualizar;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public EditText getEditTextCodigo() {
        return editTextCodigo;
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
        Intent intent = getIntent();
        UseCaseGerenciarSorvete.carregarTela(this, intent, s);
    }
    public void gerarCodigo(View view) {
        int lastSequenceValue = DataAccessHandler.getLastSequenceValue(SorveteDAO.class, getApplicationContext());
        lastSequenceValue++;

        editTextCodigo.setText(String.valueOf(lastSequenceValue));
    }
}