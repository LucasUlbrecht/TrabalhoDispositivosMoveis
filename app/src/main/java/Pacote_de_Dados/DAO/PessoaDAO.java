package Pacote_de_Dados.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Pessoa;
import Pacote_de_Dados.ORM.PessoaData;

@Dao
public interface PessoaDAO {
    @Query("SELECT * FROM pessoaData")
    List<Pessoa> getAllPessoas();
    @Query("SELECT * FROM pessoaData where nivel=2")
    List<Pessoa> getAllFuncionario();
    @Query("SELECT * FROM pessoaData a inner join pessoaData f on a.pessoaId=f.gerenteId where :id=f.gerenteId")
    List<Pessoa> getAllFuncionarioPorGerente(String id);
    @Query("SELECT * FROM pessoaData WHERE cpf = :cpf")
    Pessoa buscarPessoaCpf(String cpf);

    @Insert
    void insertPessoa(Pessoa pessoa);

    @Update
    void updatePessoa(Pessoa pessoa);

    @Delete
    void deletePessoa(Pessoa pessoa);

}
