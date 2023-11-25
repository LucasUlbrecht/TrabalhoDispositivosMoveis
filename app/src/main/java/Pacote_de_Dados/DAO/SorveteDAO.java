package Pacote_de_Dados.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Sorvete;

@Dao
public interface SorveteDAO {
    @Query("SELECT * FROM sorveteData")
    List<Sorvete> getAllSorvetes();

    @Query("SELECT * FROM sorveteData WHERE codigo = :id")
    Sorvete getSorveteById(int id);
    @Query("SELECT MAX(codigo) FROM sorveteData")
    int getLastDataCode();

    @Insert
    void insertSorvete(Sorvete sorvete);

    @Update
    void updateSorvete(Sorvete sorvete);

    @Delete
    void deleteSorvete(Sorvete sorvete);
}
