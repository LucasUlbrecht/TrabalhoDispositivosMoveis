package Pacote_de_Dados;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import Pacote_de_Dados.DAO.PessoaDAO;

@Database(entities = {DB.class}, version = 1)
public abstract class DB extends RoomDatabase {
    public abstract PessoaDAO pessoaDao(); // Defina os DAOs aqui
}
