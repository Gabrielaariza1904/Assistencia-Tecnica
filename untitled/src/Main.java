import modelo.Cliente;
import modelo.Aparelho;
import modelo.OrdemDeServico;
import modelo.Pagamento;
import modelo.NotificacaoCliente;
import utilitario.ClienteDAO;
import utilitario.AparelhoDAO;
import utilitario.ControleEstoque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Cadastro de model.Cliente ===");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("DDD: ");
        String ddd = sc.nextLine();
        System.out.print("Número Celular: ");
        String numeroCelular = sc.nextLine();

        Cliente cliente = new Cliente(nome, sobrenome, cpf, email, ddd, numeroCelular);
        // Salvar cliente no banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.salvarCliente(cliente);

        System.out.println("model.Cliente cadastrado com sucesso!");

        System.out.println("=== Cadastro de Aparelho ===");
        System.out.print("Modelo: ");
        String modeloAparelho = sc.nextLine();
        System.out.print("Ano: ");
        int anoAparelho = Integer.parseInt(sc.nextLine());
        System.out.print("Descrição do Problema: ");
        String descricaoProblema = sc.nextLine();
        System.out.print("Estado do Aparelho: ");
        String estadoAparelho = sc.nextLine();
        System.out.print("IMEI do Aparelho: ");
        String imeiAparelho = sc.nextLine();

        Aparelho aparelho = new Aparelho(modeloAparelho, anoAparelho, descricaoProblema, estadoAparelho, imeiAparelho);
        AparelhoDAO aparelhoDAO = new AparelhoDAO();
        aparelhoDAO.salvarAparelho(aparelho);
        System.out.println("Aparelho cadastrado com sucesso!");

        // Seleção de Peças
        ControleEstoque estoque = new ControleEstoque();
        System.out.println("=== Consulta de Peças Disponíveis ===");
        estoque.consultarEstoque();
        System.out.print("Digite os IDs das peças desejadas, separados por vírgula: ");
        String idsPecasStr = sc.nextLine();
        String[] idsPecasArray = idsPecasStr.split(",");
        int[] idsPecas = new int[idsPecasArray.length];
        for (int i = 0; i < idsPecasArray.length; i++) {
            idsPecas[i] = Integer.parseInt(idsPecasArray[i].trim());
        }
        System.out.println("Peças selecionadas com sucesso!");

        // Geração de Ordem de Serviço
        System.out.println("=== Criando Ordem de Serviço ===");
        System.out.print("Título do Pedido: ");
        String tituloPedido = sc.nextLine();
        System.out.print("Horas trabalhadas (estimativa): ");
        int horasTrabalhadas = Integer.parseInt(sc.nextLine());
        OrdemDeServico ordem = new OrdemDeServico(1, tituloPedido, horasTrabalhadas, idsPecas);
        System.out.println("Preço total: " + ordem.getPreco());

        // Pagamento
        System.out.print("Forma de pagamento (pix, dinheiro, debito, credito): ");
        String formaPagamento = sc.nextLine();
        Pagamento pagamento = new Pagamento(formaPagamento);
        double precoFinal = pagamento.aplicarTaxa(ordem.getPreco());
        pagamento.setPago(true);
        System.out.println("Valor final com taxa: " + precoFinal);

        // Notificação ao Cliente
        NotificacaoCliente notificacao = new NotificacaoCliente(
            cliente.getNome(), ordem.getTituloPedido(),
            ordem.getDataSaida().toString(), precoFinal, pagamento.isPago()
        );
        notificacao.enviarNotificacao();

        sc.close();
    }
}
