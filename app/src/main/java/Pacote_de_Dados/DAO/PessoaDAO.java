package Pacote_de_Dados.DAO;

import androidx.room.Query;

import Pacote_de_Dados.ORM.PessoaData;

public interface PessoaDAO {
    @Query("select * from pessoadata where cpf=:cpf")
    PessoaData buscarPessoaCpf(String cpf);
}
