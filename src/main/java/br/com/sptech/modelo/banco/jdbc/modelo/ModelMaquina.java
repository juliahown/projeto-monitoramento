package br.com.sptech.modelo.banco.jdbc.modelo;

public class ModelMaquina {
    private Integer idMaquina;
    private String ip;
    private String so;
    private String modelo;
    private boolean desligada;
    private Integer fkUsuario;
    private Integer fkToken;

    public ModelMaquina() {
    }

    public ModelMaquina(String ip, String so, String modelo, boolean desligada, Integer fkUsuario, Integer fkToken) {
        this.ip = ip;
        this.so = so;
        this.modelo = modelo;
        this.desligada = desligada;
        this.fkUsuario = fkUsuario;
        this.fkToken = fkToken;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isDesligada() {
        return desligada;
    }

    public void setDesligada(boolean desligada) {
        this.desligada = desligada;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Integer getFkToken() {
        return fkToken;
    }

    public void setFkToken(Integer fkToken) {
        this.fkToken = fkToken;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d%n" +
                        "IP: %s%n" +
                        "Sistema Operacional: %s%n" +
                        "Modelo: %s%n" +
                        "Desligada: %s%n" +
                        "FK Usuário: %d%n" +
                        "FK Token: %d%n",
                idMaquina, ip, so, modelo, desligada, fkUsuario, fkToken
        );
    }
}
