package Pacote_de_Dados.ORM;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import LogicaDeNegocio.FotoUsuario;
import LogicaDeNegocio.NivelAcesso;
import LogicaDeNegocio.Pessoa;

@Entity(foreignKeys = @ForeignKey(
        entity = PessoaORM.class,
        parentColumns = "gerenteId",
        childColumns = "pesssoaId",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
))
public class PessoaORM extends Pessoa{
    @PrimaryKey(autoGenerate = true)
    int pessoaId;
    int tipoId;
    int gerenteId;

    public PessoaORM(String cpf, String nome, String endereco, String cidade, String estado, String telefone, FotoUsuario foto, String email) {
        super(cpf, nome, endereco, cidade, estado, telefone, foto, email);
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoid) {
        tipoId=tipoid;
    }
}
