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
    @Query("SELECT * FROM SorveteData")
    List<Sorvete> getAllSorvetes();

    @Query("SELECT * FROM SorveteData WHERE codigo = :id")
    Sorvete getSorveteById(int id);

    @Insert
    void insertSorvete(Sorvete sorvete);

    @Update
    void updateSorvete(Sorvete sorvete);

    @Delete
    void deleteSorvete(Sorvete sorvete);
}

