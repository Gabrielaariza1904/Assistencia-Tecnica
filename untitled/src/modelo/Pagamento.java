package modelo;

public class Pagamento {
    private String formaPagamento;
    private boolean pago;
    private double taxa;

    public Pagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
        calcularTaxa();
    }

    private void calcularTaxa() {
        switch (formaPagamento.toLowerCase()) {
            case "pix":
            case "dinheiro":
                taxa = -0.05;
                break;
            case "debito":
                taxa = 0;
                break;
            case "credito":
                taxa = 0.03;
                break;
            default:
                taxa = 0;
        }
    }

    public double aplicarTaxa(double preco) {
        return preco + (preco * taxa);
    }

    public boolean isPago() { return pago; }
    public void setPago(boolean pago) { this.pago = pago; }
    public String getFormaPagamento() { return formaPagamento; }
}
