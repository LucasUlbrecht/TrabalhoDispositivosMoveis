package layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.grandeatividade.R;

import LogicaDeNegocio.UseCaseGerenciarAdicional;
import LogicaDeNegocio.UseCaseGerenciarSorvete;
import Model.Adicionais;
import Model.Sorvete;
import layout.Adapter.ProdutoAdapter;
import layout.Adapter.SorveteAdapter;

public class GerenciarAdicionaisController extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_adicionais_page);
    }


    @Override
    protected void onResume() {
        super.onResume();
        carregarListView();
    }

    public void retornar(View view){
        Intent intent = new Intent(this, funcionarioController.class);
        startActivity(intent);
    }
    public void carregarListView(){
        ProdutoAdapter adapter = UseCaseGerenciarAdicional.gerarListView(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Adicionais objetoSelect = UseCaseGerenciarAdicional.coletarAdicional(this).get(i);

                Intent intent = new Intent(GerenciarAdicionaisController.this, AdicionalDetalheController.class);

                intent.putExtra("codigo", objetoSelect.getCodigo());
                intent.putExtra("criarNovo", false);

                startActivity(intent);
            }
        });
    }
    public void criarNovo(View view){
        Intent intent = new Intent(this, AdicionalDetalheController.class);
        intent.putExtra("criarNovo", true);
        startActivity(intent);
    }
}