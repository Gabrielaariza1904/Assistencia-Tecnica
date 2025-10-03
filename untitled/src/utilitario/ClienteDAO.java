package utilitario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import config.Database;
import modelo.Cliente;

public class ClienteDAO {
    public void salvarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, sobrenome, cpf, email, ddd, numero_celular) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getDdd());
            stmt.setString(6, cliente.getNumeroCelular());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar cliente: " + e.getMessage());
        }
    }
}
