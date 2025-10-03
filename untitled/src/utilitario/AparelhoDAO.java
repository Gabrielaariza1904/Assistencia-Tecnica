package utilitario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import config.Database;
import modelo.Aparelho;

public class AparelhoDAO {
    public void salvarAparelho(Aparelho aparelho) {
        String sql = "INSERT INTO ESTOQUE (modelo, ano, descricao_problema, estado_aparelho, imei) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aparelho.getModelo());
            stmt.setInt(2, aparelho.getAno());
            stmt.setString(3, aparelho.getDescricaoProblema());
            stmt.setString(4, aparelho.getEstadoAparelho());
            stmt.setString(5, aparelho.getImei());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar aparelho: " + e.getMessage());
        }
    }
}

