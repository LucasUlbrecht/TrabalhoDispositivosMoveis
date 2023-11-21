package Pacote_de_Dados.ORM;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import Model.FotoUsuario;
import Model.Pessoa;

@Entity(foreignKeys = @ForeignKey(
        entity = PessoaData.class,
        parentColumns = "gerenteId",
        childColumns = "pesssoaId",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
))
public class PessoaData extends Pessoa{
    @PrimaryKey(autoGenerate = true)
    int pessoaId;
    int tipoId;
    int gerenteId;
    String password;

    public PessoaData(String cpf, String nome, String endereco, String cidade, String estado, String telefone, FotoUsuario foto, String email) {
        super(cpf, nome, endereco, cidade, estado, telefone, foto, email);
    }


    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }
}