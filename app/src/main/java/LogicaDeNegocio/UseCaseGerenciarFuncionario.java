package LogicaDeNegocio;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import Model.Funcionairo;
import Model.NivelAcesso;
import Model.Pessoa;
import Model.Sorvete;
import Pacote_de_Dados.DB;
import Pacote_de_Dados.ORM.PessoaData;
import ProteceoDados.Security;
import layout.GerenciarFuncionarioDetalheController;
import layout.TelaGeradora;
import layout.funcionarioController;

public class UseCaseGerenciarFuncionario {
    public static boolean verificaADM(funcionarioController app){
        String login=Security.recuperar(app.getApplicationContext(), "loginCriptografado");
        String senha=Security.recuperar(app.getApplicationContext(), "senhaCriptografada");
        DB db = DB.getDatabase(app);
        Funcionairo tmp= (Funcionairo) db.pessoaDao().buscarPessoaCpf(login);
        if(tmp.getNivel()== NivelAcesso.nivel3){
            return true;
        }
        return false;
    }

    public static List<Pessoa> obterListaFuncionario(AppCompatActivity app) {
        DB db = DB.getDatabase(app);
        return db.pessoaDao().getAllFuncionario();
    }

    public static void modificarCampo(AppCompatActivity app, String mod) {
        DB db=DB.getDatabase(app);
        Pessoa sorvete= TelaGeradora.obterDadosDosCampos(app, Pessoa.class);
        if(mod.equals("deletar")){
            db.pessoaDao().deletePessoa( sorvete);
        }else if(mod.equals("atualizar")){
            db.pessoaDao().updatePessoa(sorvete);
        }else if(mod.equals("inserir")){
            db.pessoaDao().insertPessoa(sorvete);
        }
    }
}
