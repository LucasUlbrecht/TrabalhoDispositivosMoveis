package Pacote_de_Dados;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import Pacote_de_Dados.DAO.PessoaDAO;

@Database(entities = {DB.class}, version = 1)
public abstract class DB extends RoomDatabase {
    private static DB INSTANCE; // Adicione esta linha para declarar a variável INSTANCE

    public abstract PessoaDAO pessoaDao();

    public static DB getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DB.class, "ControleDeUsuarios")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
