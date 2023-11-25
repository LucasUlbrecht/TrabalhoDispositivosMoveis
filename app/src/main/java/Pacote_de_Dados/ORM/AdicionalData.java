package Pacote_de_Dados.ORM;

import androidx.room.Entity;

import Model.Adicionais;
import Model.FotoUsuario;

@Entity(tableName ="adicionalData")
public class AdicionalData extends Adicionais {
    public AdicionalData(int codigo, String nome, String tipo, FotoUsuario foto, double quantidade) {
        super(codigo, nome, tipo, foto, quantidade);
    }
}
