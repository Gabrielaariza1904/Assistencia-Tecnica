package modelo;

import java.util.regex.Pattern;

public class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String ddd;
    private String numeroCelular;
    private int idOrdem;

    public Cliente(String nome, String sobrenome, String cpf, String email, String ddd, String numeroCelular) {
        if (!validarCPF(cpf)) throw new IllegalArgumentException("CPF inválido.");
        if (!validarEmail(email)) throw new IllegalArgumentException("Email inválido.");
        if (!validarDDD(ddd)) throw new IllegalArgumentException("DDD inválido.");
        if (!validarNumeroCelular(numeroCelular)) throw new IllegalArgumentException("Número de celular inválido.");

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.ddd = ddd;
        this.numeroCelular = numeroCelular;
    }

    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", "");
        if (cpf.length() != 11) return false;
        try {
            int soma1 = 0;
            int soma2 = 0;
            for (int i = 0; i < 9; i++) {
                soma1 += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
                soma2 += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int digito1 = soma1 % 11 < 2 ? 0 : 11 - (soma1 % 11);
            soma2 += digito1 * 2;
            int digito2 = soma2 % 11 < 2 ? 0 : 11 - (soma2 % 11);
            return cpf.equals(cpf.substring(0, 9) + digito1 + digito2);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validarEmail(String email) {
        return Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w+$").matcher(email).matches();
    }

    public static boolean validarDDD(String ddd) {
        return ddd.matches("\\d{2}");
    }

    public static boolean validarNumeroCelular(String numero) {
        return numero.matches("\\d{8,9}");
    }

    public static boolean validarIMEI(String imei) {
        if (!imei.matches("\\d{15}")) return false;
        int soma = 0;
        for (int i = 0; i < 15; i++) {
            int num = Character.getNumericValue(imei.charAt(i));
            if (i % 2 == 1) num *= 2;
            soma += num > 9 ? num - 9 : num;
        }
        return soma % 10 == 0;
    }

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDdd() { return ddd; }
    public void setDdd(String ddd) { this.ddd = ddd; }
    public String getNumeroCelular() { return numeroCelular; }
    public void setNumeroCelular(String numeroCelular) { this.numeroCelular = numeroCelular; }
    public int getIdOrdem() { return idOrdem; }
    public void setIdOrdem(int idOrdem) { this.idOrdem = idOrdem; }
}
