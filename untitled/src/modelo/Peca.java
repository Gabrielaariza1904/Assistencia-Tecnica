package modelo;

public class Peca {
    private int idPeca;
    private String nomePeca;
    private int quantidade;
    private double valor;

    public Peca(int idPeca, String nomePeca, int quantidade, double valor) {
        this.idPeca = idPeca;
        this.nomePeca = nomePeca;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public int getIdPeca() { return idPeca; }
    public void setIdPeca(int idPeca) { this.idPeca = idPeca; }
    public String getNomePeca() { return nomePeca; }
    public void setNomePeca(String nomePeca) { this.nomePeca = nomePeca; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
}
