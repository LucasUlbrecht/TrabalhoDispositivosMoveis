package Model;

public class Sorvete extends Produto{
    private double valor;

    public Sorvete(int codigo, String nome, String tipo, FotoUsuario foto, double quantidade, double valor) {
        super(codigo, nome, tipo, foto, quantidade);
        setValor(valor);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
