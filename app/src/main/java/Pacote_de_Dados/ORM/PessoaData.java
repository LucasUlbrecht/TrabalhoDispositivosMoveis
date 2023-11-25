package Pacote_de_Dados.ORM;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import Model.FotoUsuario;
import Model.Pessoa;

@Entity(primaryKeys = "cpf", tableName ="pessoaData", foreignKeys = @ForeignKey(
        entity = PessoaData.class,
        parentColumns = "gerenteId",
        childColumns = "pessoaId",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
))
public class PessoaData extends Pessoa{
    @PrimaryKey(autoGenerate = true)
    int pessoaId;
    int tipoId;
    int gerenteId;
    String password;

    public PessoaData(String cpf, String password, String nome, String endereco, String cidade, String telefone, String estado, FotoUsuario foto, String email) {

        super(cpf,password, nome, endereco, cidade, estado, telefone, foto, email);
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
