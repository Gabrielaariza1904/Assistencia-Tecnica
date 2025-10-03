package utilitario;

import config.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControleEstoque {
    public void consultarEstoque() {
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ESTOQUE")) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_peca") +
                        " | Nome: " + rs.getString("nome_peca") +
                        " | Quantidade: " + rs.getInt("quantidade") +
                        " | Valor: " + rs.getDouble("valor"));

                if (rs.getInt("quantidade") < 6) {
                    System.out.println("⚠ Estoque baixo para peça: " + rs.getString("nome_peca"));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar estoque: " + e.getMessage());
        }
    }
}
