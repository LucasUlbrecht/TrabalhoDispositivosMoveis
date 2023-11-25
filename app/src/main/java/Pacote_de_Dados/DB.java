package Pacote_de_Dados;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import Pacote_de_Dados.DAO.AdicionaisDAO;
import Pacote_de_Dados.DAO.PessoaDAO;
import Pacote_de_Dados.DAO.SorveteDAO;
import Pacote_de_Dados.ORM.AdicionalData;
import Pacote_de_Dados.ORM.PessoaData;
import Pacote_de_Dados.ORM.SorveteData;

@Database(entities = {DB.class, SorveteData.class, AdicionalData.class, PessoaData.class}, version = 1)
public abstract class DB extends RoomDatabase {
    private static DB INSTANCE;

    public abstract PessoaDAO pessoaDao();
    public abstract SorveteDAO sorveteDAO();
    public abstract AdicionaisDAO adicionalDAO();

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