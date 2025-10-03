import modelo.*;
import utilitario.AparelhoDAO;
import utilitario.ClienteDAO;
import utilitario.OrdemDeServicoDAO;// Função de teste end-to-end com dados mockados
public class MainMock {

    public static void main(String[] args) {
        System.out.println("\n==============================");
        System.out.println("Iniciando teste end-to-end com dados mockados");
        System.out.println("==============================\n");

        // Mock Cliente
        Cliente cliente = new Cliente("Maria", "Silva", "41633957845", "maria@email.com", "11", "999999999");
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.salvarCliente(cliente);
        System.out.println("Cliente mock cadastrado com sucesso!");

        // Mock Aparelho
        Aparelho aparelho = new Aparelho("Samsung Galaxy S21", 2022, "Tela quebrada", "Usado", "351446982071342");
        AparelhoDAO aparelhoDAO = new AparelhoDAO();
        aparelhoDAO.salvarAparelho(aparelho);
        System.out.println("Aparelho mock cadastrado com sucesso!");

        // Mock seleção de peças
        int[] idsPecas = {1, 2}; // IDs fictícios
        System.out.println("Peças mock selecionadas: 1, 2");

        // Mock Ordem de Serviço
        OrdemDeServico ordem = new OrdemDeServico(1, "Troca de tela e bateria", 4, idsPecas);
        OrdemDeServicoDAO ordemDAO = new OrdemDeServicoDAO();
        ordemDAO.salvarOrdemDeServico(
                ordem,
                1, // idCliente mock
                aparelho.getModelo(),
                aparelho.getAno(),
                aparelho.getDescricaoProblema(),
                aparelho.getEstadoAparelho(),
                aparelho.getImei()
        );
        System.out.println("Ordem de serviço mock cadastrada no banco!");

        // Mock Pagamento
        Pagamento pagamento = new Pagamento("pix");
        double precoFinal = pagamento.aplicarTaxa(ordem.getPreco());
        precoFinal = Math.round(precoFinal * 100.0) / 100.0;
        pagamento.setPago(true);
        System.out.printf("Valor final mock com taxa: R$ %.2f\n", precoFinal);

        // Mock Notificação
        NotificacaoCliente notificacao = new NotificacaoCliente(
                cliente.getNome(), ordem.getTituloPedido(),
                ordem.getDataSaida().toString(), precoFinal, pagamento.isPago()
        );
        System.out.println("Enviando notificação mock ao cliente...");
        notificacao.enviarNotificacao();
        System.out.println("\n==============================");
        System.out.println("Teste end-to-end finalizado!");
        System.out.println("==============================\n");
    }
}
