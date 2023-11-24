package layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.grandeatividade.R;

import LogicaDeNegocio.UseCaseGerenciarSorvete;
import Model.Sorvete;
import layout.Adapter.SorveteAdapter;
import layout.ItemClickListeneer.PersonItemClickListener;

public class GerenciarSorveteController extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_sorvete_page);
        listView = findViewById(R.id.listaSorvete);
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
        SorveteAdapter adapter = UseCaseGerenciarSorvete.gerarListView(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Sorvete objetoSelect = UseCaseGerenciarSorvete.coletarSorvetes(this).get(i);

                Intent intent = new Intent(GerenciarSorveteController.this, SorveteDetalheController.class);

                intent.putExtra("codigo", objetoSelect.getCodigo());

                startActivity(intent);
            }
        });
    }

}