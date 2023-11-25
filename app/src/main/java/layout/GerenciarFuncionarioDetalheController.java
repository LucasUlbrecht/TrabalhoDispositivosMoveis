package layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.grandeatividade.R;

import LogicaDeNegocio.UseCaseGerenciarFuncionario;
import Model.Funcionairo;
import Pacote_de_Dados.DB;
import layout.Fragments.FragmentoDeCamposDinamicos;

public class GerenciarFuncionarioDetalheController extends AppCompatActivity implements FieldDeAcoes{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_funcionario_detalhe_page);
        FragmentoDeCamposDinamicos<Funcionairo> Ffunc = new FragmentoDeCamposDinamicos<>(Funcionairo.class,"",R.layout.fragment_fragmento_de_campos_dinamicos, this);
    }

    @Override
    public void onCreateField() {
        Intent intent = new Intent(this, GerenciarFuncionarioController.class);
        UseCaseGerenciarFuncionario.modificarCampo(this, "insert");
        startActivity(intent);
    }

    @Override
    public void onUpdateField() {
        Intent intent = new Intent(this, GerenciarFuncionarioController.class);
        UseCaseGerenciarFuncionario.modificarCampo(this, "update");
        startActivity(intent);
    }

    @Override
    public void onRemoveField() {
        Intent intent = new Intent(this, GerenciarFuncionarioController.class);
        UseCaseGerenciarFuncionario.modificarCampo(this, "remove");
        startActivity(intent);
    }

    @Override
    public void genCode() {

    }
}