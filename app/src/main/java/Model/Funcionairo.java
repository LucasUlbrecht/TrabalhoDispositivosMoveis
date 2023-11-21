package Model;

public class Funcionairo extends Pessoa {
    public Funcionairo(String cpf, String nome, String endereco, String cidade, String estado, String telefone, FotoUsuario foto, String email) {
        super(cpf, nome, endereco, cidade, estado, telefone, foto, email);
        setNivel(NivelAcesso.nivel2);
    }
}
