package Pacote_de_Dados.HandlerAcess;

import android.content.Context;

import Pacote_de_Dados.DAO.AdicionaisDAO;
import Pacote_de_Dados.DAO.DataAccess;
import Pacote_de_Dados.DAO.SorveteDAO;
import Pacote_de_Dados.DB;

public class DataAccessHandler {

    public static DB initialize(Context context) {
        return DB.getDatabase(context);
    }

    private static <T> DataAccess<T> getDataAccess(Class<T> clazz, Context context) {
        DB db= initialize(context);
        if (clazz.equals(SorveteDAO.class)) {
            return (DataAccess<T>) db.sorveteDAO();
        } else if (clazz.equals(AdicionaisDAO.class)) {
            return (DataAccess<T>) db.adicionalDAO();
        } else {
            throw new IllegalArgumentException("Classe de DAO não suportada: " + clazz.getName());
        }
    }

    static public <T> int getLastSequenceValue(Class<T> clazz, Context context) {
        DB db= initialize(context);
        DataAccess<T> dao = getDataAccess(clazz, context);
        return dao.getLastDataCode();
    }
}
