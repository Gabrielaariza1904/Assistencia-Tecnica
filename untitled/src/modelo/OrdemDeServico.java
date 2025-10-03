package modelo;

import config.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class OrdemDeServico {
    private int idOrdem;
    private String tituloPedido;
    private double preco;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public OrdemDeServico(int idOrdem, String tituloPedido, int horasTrabalhadas, int[] pecas) {
        this.idOrdem = idOrdem;
        this.tituloPedido = tituloPedido;
        this.preco = horasTrabalhadas * 50 + somaValorPecas(pecas);
        this.dataEntrada = LocalDate.now();
        this.dataSaida = dataEntrada.plusDays(3);
    }

    private double somaValorPecas(int[] pecas) {
        double total = 0;
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {
            for (int id : pecas) {
                ResultSet rs = stmt.executeQuery("SELECT valor FROM ESTOQUE WHERE id_peca = " + id);
                if (rs.next()) total += rs.getDouble("valor");
            }
        } catch (Exception e) {
            System.out.println("Erro ao calcular peças: " + e.getMessage());
        }
        return total;
    }

    public String getTituloPedido() { return tituloPedido; }
    public double getPreco() { return preco; }
    public LocalDate getDataEntrada() { return dataEntrada; }
    public LocalDate getDataSaida() { return dataSaida; }
}
