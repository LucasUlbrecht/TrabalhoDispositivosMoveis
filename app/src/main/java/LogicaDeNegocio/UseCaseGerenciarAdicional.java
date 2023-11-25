package LogicaDeNegocio;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import Model.Adicionais;
import Model.Sorvete;
import Pacote_de_Dados.DB;

import layout.Adapter.ProdutoAdapter;
import layout.AdicionalDetalheController;
import layout.SorveteDetalheController;
import layout.TelaGeradora;

public class UseCaseGerenciarAdicional {
    static DB db;
    public static List<Adicionais> coletarAdicional(AdapterView.OnItemClickListener app){
        db = DB.getDatabase((Context) app);
        return db.adicionalDAO().getAllAdicionais();
    }
    public static ProdutoAdapter gerarListView(AppCompatActivity app){
        return new ProdutoAdapter(app, coletarAdicional((AdapterView.OnItemClickListener) app));

    }
    public static Adicionais RetornarAdicional(AppCompatActivity app, int id){
        return db.adicionalDAO().getAdicionaisById(id);
    }
    public static void AtualizarSorvete(AppCompatActivity app, Sorvete s, boolean delete){
        db = DB.getDatabase((Context) app);
        if(RetornarAdicional(app,s.getCodigo())!=null){
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

    public static Adicionais buscarAdicional(AppCompatActivity app, Intent s) {
        db=DB.getDatabase(app);
        return db.adicionalDAO().getAdicionaisById(s.getIntExtra("codigo", 0));
    }

    public static void carregarTela(AdicionalDetalheController app, Intent i, Adicionais s) {
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
        Adicionais sorvete= TelaGeradora.obterDadosDosCampos(app, Adicionais.class);
        if(tipoOp.equals("deletar")){
            db.adicionalDAO().deleteAdicionais(sorvete);
        }else if(tipoOp.equals("atualizar")){
            db.adicionalDAO().updateAdicionais(sorvete);
        }else if(tipoOp.equals("inserir")){
            db.adicionalDAO().insertAdicionais(sorvete);
        }
    }
}
