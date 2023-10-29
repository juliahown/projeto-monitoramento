package br.com.sptech.modelo.banco.jdbc.modelo;

import java.util.Date;

public class ModelJanela {
    private Integer idJanela;
    private Long pid;
    private String titulo;
    private String comando;
    private String localizacao;
    private Boolean visivel;
    private Integer fkMaquina;
    private Date dataCaptura;

    public ModelJanela(Integer idJanela, Long pid, String titulo, String comando, String localizacao,
                       Boolean visivel, Integer fkMaquina) {
        this.idJanela = idJanela;
        this.pid = pid;
        this.titulo = titulo;
        this.comando = comando;
        this.localizacao = localizacao;
        this.visivel = visivel;
        this.fkMaquina = fkMaquina;
    }

    public ModelJanela(Long pid, String titulo, String comando, String localizacao,
                       Boolean visivel, Integer fkMaquina) {
        this.idJanela = null;
        this.pid = pid;
        this.titulo = titulo;
        this.comando = comando;
        this.localizacao = localizacao;
        this.visivel = visivel;
        this.fkMaquina = fkMaquina;
    }

    public ModelJanela() {
    }

    public Integer getIdJanela() {
        return idJanela;
    }

    public void setIdJanela(Integer idJanela) {
        this.idJanela = idJanela;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    public Date getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(Date dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    @Override
    public String toString() {
        return String.format(
                "ID Janela: %d%n" +
                        "PID: %d%n" +
                        "Título: %s%n" +
                        "Comando: %s%n" +
                        "Localização: %s%n" +
                        "Visível: %s%n" +
                        "FK Maquina: %d%n",
                idJanela, pid, titulo, comando, localizacao, visivel, fkMaquina
        );
    }
}
