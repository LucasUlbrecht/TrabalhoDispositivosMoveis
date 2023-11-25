package layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.grandeatividade.R;

import java.util.List;

import LogicaDeNegocio.UseCaseGerenciarFuncionario;
import Model.Funcionairo;
import Model.Pessoa;
import layout.Adapter.GenericAdapter;
import layout.ItemClickListeneer.PersonItemClickListener;

public class GerenciarFuncionarioController extends AppCompatActivity {
    ListView lView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_funcionario_page);
        lView=findViewById(R.id.listView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Pessoa> lFunc = UseCaseGerenciarFuncionario.obterListaFuncionario(this);
        String[] campos = {"Cpf", "Nome", "nivel"};
        GenericAdapter<Pessoa> adapter = new GenericAdapter<>(this, R.id.listView, lFunc,campos);
        lView.setAdapter(adapter);
        PersonItemClickListener personItemClickListener = new PersonItemClickListener(this, "GerenciarFuncionarioDetalheController");
        lView.setOnItemClickListener((AdapterView.OnItemClickListener) personItemClickListener);
    }
    public void retornar(View view){
        Intent intent = new Intent(this, funcionarioController.class);
        startActivity(intent);
    }
}