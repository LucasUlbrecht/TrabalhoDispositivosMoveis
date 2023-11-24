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
    @Query("SELECT * FROM PessoaData")
    List<Pessoa> getAllPessoas();

    @Query("SELECT * FROM PessoaData WHERE cpf = :cpf")
    Pessoa buscarPessoaCpf(String cpf);

    @Insert
    void insertPessoa(PessoaData pessoa);

    @Update
    void updatePessoa(PessoaData pessoa);

    @Delete
    void deletePessoa(PessoaData pessoa);

}
