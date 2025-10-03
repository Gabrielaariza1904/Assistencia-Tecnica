package utilitario;

import modelo.OrdemDeServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import config.Database;

public class OrdemDeServicoDAO {
    public void salvarOrdemDeServico(OrdemDeServico ordem, int idCliente, String modelo, int ano, String descricaoProblema, String estadoAparelho, String imei) {
        String sql = "INSERT INTO ordem_servico (id_cliente, titulo_pedido, preco, data_entrada, data_saida, modelo, ano, descricao_problema, estado_aparelho, imei) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.setString(2, ordem.getTituloPedido());
            stmt.setDouble(3, ordem.getPreco());
            stmt.setString(4, ordem.getDataEntrada().toString());
            stmt.setString(5, ordem.getDataSaida().toString());
            stmt.setString(6, modelo);
            stmt.setInt(7, ano);
            stmt.setString(8, descricaoProblema);
            stmt.setString(9, estadoAparelho);
            stmt.setString(10, imei);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar ordem de serviço: " + e.getMessage());
        }
    }
}

