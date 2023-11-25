package LogicaDeNegocio;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import Model.Sorvete;
import Pacote_de_Dados.DB;
import layout.Adapter.SorveteAdapter;
import layout.AdicionalDetalheController;
import layout.SorveteDetalheController;
import layout.TelaGeradora;

public class UseCaseGerenciarSorvete {
    static DB db;
    public static List<Sorvete> coletarSorvetes(AdapterView.OnItemClickListener app){
        db = DB.getDatabase((Context) app);
        return db.sorveteDAO().getAllSorvetes();
    }
    public static SorveteAdapter gerarListView(AppCompatActivity app){
        return new SorveteAdapter(app, coletarSorvetes((AdapterView.OnItemClickListener) app));

    }
    public static Sorvete RetornarSorvete(AppCompatActivity app, int id){
        return db.sorveteDAO().getSorveteById(id);
    }
    public static void AtualizarSorvete(AppCompatActivity app, Sorvete s, boolean delete){
        db = DB.getDatabase((Context) app);
        if(RetornarSorvete(app,s.getCodigo())!=null){
            if(delete){
                db.sorveteDAO().deleteSorvete(s);
                return;
            }
            db.sorveteDAO().updateSorvete(s);
            return;
        }
        db.sorveteDAO().insertSorvete(s);
        return;
    }

    public static Sorvete buscarSorvete(AppCompatActivity app, Intent s) {
        db=DB.getDatabase(app);
        return db.sorveteDAO().getSorveteById(s.getIntExtra("codigo", 0));
    }

    public static void carregarTela(SorveteDetalheController app, Intent i, Sorvete s) {
        TelaGeradora.preencherCampos(app, s);
        if(i.getBooleanExtra("criarNovo",false)){
            app.getBtnAtualizar().setVisibility(View.GONE);
            app.getBtnDelete().setVisibility(View.GONE);
        }else{
            app.getEditTextCodigo().setEnabled(false);
        }
    }

    public static void modificarTupla(AppCompatActivity app, String tipoOp) {
        db=DB.getDatabase(app);
        Sorvete sorvete= TelaGeradora.obterDadosDosCampos(app, Sorvete.class);
        if(tipoOp.equals("deletar")){
            db.sorveteDAO().deleteSorvete(sorvete);
        }else if(tipoOp.equals("atualizar")){
            db.sorveteDAO().updateSorvete(sorvete);
        }else if(tipoOp.equals("inserir")){
            db.sorveteDAO().insertSorvete(sorvete);
        }
    }
}
