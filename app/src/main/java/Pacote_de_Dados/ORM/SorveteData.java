package Pacote_de_Dados.ORM;

import androidx.room.Entity;

import Model.FotoUsuario;
import Model.Sorvete;
@Entity (primaryKeys = "codigo",tableName ="sorveteData")
public class SorveteData extends Sorvete {

    public SorveteData(int codigo, String nome, String tipo, FotoUsuario foto, double quantidade, double valor) {
        super(codigo, nome, tipo, foto, quantidade, valor);
    }

}
