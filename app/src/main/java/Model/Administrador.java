package Model;

public class Administrador extends Pessoa {
    public Administrador(String cpf, String nome, String endereco, String cidade, String estado, String telefone, FotoUsuario foto, String email) {
        super(cpf, nome, endereco, cidade, estado, telefone, foto, email);
        setNivel(NivelAcesso.nivel3);
    }
}
