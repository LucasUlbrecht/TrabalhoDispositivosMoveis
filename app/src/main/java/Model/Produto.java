package Model;

public class Produto {
    private int codigo;
    private String nome;
    private String tipo;
    private FotoUsuario foto;
    private double quantidade;

    public Produto(int codigo, String nome, String tipo, FotoUsuario foto, double quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.foto = foto;
        this.quantidade = quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFoto(FotoUsuario foto) {
        this.foto = foto;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public FotoUsuario getFoto() {
        return foto;
    }

    public String getNome() {
        return nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }
}
