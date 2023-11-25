package layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.grandeatividade.R;

import LogicaDeNegocio.UseCaseGerenciarAdicional;
import LogicaDeNegocio.UseCaseGerenciarSorvete;
import Model.Adicionais;
import Model.Sorvete;
import Pacote_de_Dados.DAO.AdicionaisDAO;
import Pacote_de_Dados.HandlerAcess.DataAccessHandler;

public class AdicionalDetalheController extends AppCompatActivity {
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
            setContentView(R.layout.activity_adicional_detalhe_page);
            Intent intent = getIntent();
            Adicionais s = UseCaseGerenciarAdicional.buscarAdicional(this, intent);
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
            Intent intent = new Intent(this, GerenciarAdicionaisController.class);
            startActivity(intent);
        }
        public void adicionar(View view){
            UseCaseGerenciarAdicional.modificarTupla(this, "inserir");
            retornar(view);
        }
        public void atualizar(View view){
            UseCaseGerenciarAdicional.modificarTupla(this, "atualizar");
            retornar(view);
        }
        public void deletar(View view){
            UseCaseGerenciarAdicional.modificarTupla(this, "deletar");
            retornar(view);
        }
        public void iniciarTela(Adicionais s){
            Intent intent = getIntent();
            UseCaseGerenciarAdicional.carregarTela(this, intent, s);
        }
        public void gerarCodigo(View view) {
            int lastSequenceValue = DataAccessHandler.getLastSequenceValue(AdicionaisDAO.class, getApplicationContext());
            lastSequenceValue++;

            editTextCodigo.setText(String.valueOf(lastSequenceValue));
        }

}