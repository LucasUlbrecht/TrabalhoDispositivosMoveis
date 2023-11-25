package Pacote_de_Dados.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Adicionais;

@Dao
public interface AdicionaisDAO {
    @Query("SELECT * FROM adicionalData")
    List<Adicionais> getAllAdicionais();

    @Query("SELECT * FROM adicionalData WHERE codigo = :id")
    Adicionais getAdicionaisById(int id);

    @Insert
    void insertAdicionais(Adicionais adicionais);

    @Update
    void updateAdicionais(Adicionais adicionais);

    @Delete
    void deleteAdicionais(Adicionais adicionais);
    @Query("SELECT MAX(codigo) FROM adicionalData")
    int getLastDataCode();
}

