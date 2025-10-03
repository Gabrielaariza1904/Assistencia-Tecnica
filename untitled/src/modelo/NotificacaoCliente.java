package modelo;

public class NotificacaoCliente {
    private String nomeCliente;
    private String tituloPedido;
    private String dataEntrega;
    private double preco;
    private boolean pago;
    private String informacoesRetirada;

    public NotificacaoCliente(String nomeCliente, String tituloPedido, String dataEntrega, double preco, boolean pago) {
        this.nomeCliente = nomeCliente;
        this.tituloPedido = tituloPedido;
        this.dataEntrega = dataEntrega;
        this.preco = preco;
        this.pago = pago;
        this.informacoesRetirada = "Data: " + dataEntrega + " | Endereço: Loja Central | Horário: 10h";
    }

    public void enviarNotificacao() {
        System.out.println("Notificação enviada para " + nomeCliente);
        System.out.println("Pedido: " + tituloPedido);
        System.out.println("Data Entrega: " + dataEntrega);
        System.out.println("Preço: " + preco);
        System.out.println("Pago: " + pago);
        System.out.println(informacoesRetirada);
    }
}
