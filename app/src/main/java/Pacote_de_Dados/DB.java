package Pacote_de_Dados;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import Pacote_de_Dados.DAO.PessoaDAO;
import Pacote_de_Dados.DAO.SorveteDAO;

@Database(entities = {DB.class}, version = 1)
public abstract class DB extends RoomDatabase {
    private static DB INSTANCE;

    public abstract PessoaDAO pessoaDao();
    public abstract SorveteDAO sorveteDAO();

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
