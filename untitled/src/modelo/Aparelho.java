package modelo;

import java.time.Year;

public class Aparelho {
    private String modelo;
    private int ano;
    private String descricaoProblema;
    private String estadoAparelho;
    private String imei;

    public Aparelho(String modelo, int ano, String descricaoProblema, String estadoAparelho, String imei) {
        if (ano < 2000 || ano > Year.now().getValue()) throw new IllegalArgumentException("Ano inválido.");
        if (!Cliente.validarIMEI(imei)) throw new IllegalArgumentException("IMEI inválido.");

        this.modelo = modelo;
        this.ano = ano;
        this.descricaoProblema = descricaoProblema;
        this.estadoAparelho = estadoAparelho;
        this.imei = imei;
    }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    public String getDescricaoProblema() { return descricaoProblema; }
    public void setDescricaoProblema(String descricaoProblema) { this.descricaoProblema = descricaoProblema; }
    public String getEstadoAparelho() { return estadoAparelho; }
    public void setEstadoAparelho(String estadoAparelho) { this.estadoAparelho = estadoAparelho; }
    public String getImei() { return imei; }
    public void setImei(String imei) { this.imei = imei; }
}
