package Model;

import Model.FotoUsuario;
import Model.NivelAcesso;

public class Pessoa {

    private String Cpf;
    private String Nome;
    private String Endereco;
    private String Cidade;
    private String Estado;
    private String Telefone;
    private FotoUsuario foto;
    int nivel;
    private String email;
    private String password;
    //private String local;


    //função gerar pessoa objeto
    public Pessoa(String cpf, String password, String nome, String endereco, String cidade, String estado, String telefone, FotoUsuario foto, String email){
        setCidade(cidade);
        setCpf(cpf);
        setEmail(email);
        setNome(nome);
        setEndereco(endereco);
        setEstado(estado);
        setTelefone(telefone);
        setFoto(foto);
        setNivel(NivelAcesso.nivel1);
        setPassword(password);
    }

    //getters & setters


    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return Nome;
    }

    public FotoUsuario getFoto() {
        return foto;
    }

    public String getCidade() {
        return Cidade;
    }

    public String getCpf() {
        return Cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return Endereco;
    }

    public String getEstado() {
        return Estado;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setFoto(FotoUsuario foto) {
        this.foto = foto;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public String getPassword() {
        return password;
    }
}
