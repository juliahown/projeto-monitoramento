package br.com.sptech.modelo.banco.jdbc.modelo;

import java.util.Date;

public class ModelDisco {
    private Integer idCapDisco;
    private Long tamanhoFila;
    private Long leituras;
    private Long bytesLeitura;
    private Long escritas;
    private Long bytesEscrita;
    private Integer fkMaquina;
    private Integer fkInfoDisco;
    private Integer idInfoDisco;
    private Long totalDisco;
    private Date dataCaptura;

    public ModelDisco(Integer idCapDisco, Long tamanhoFila, Long leituras, Long bytesLeitura, Long escritas, Long bytesEscrita, Integer fkMaquina,
                      Integer fkInfoDisco, Integer idInfoDisco, Long totalDisco, Date dataCaptura) {
        this.idCapDisco = idCapDisco;
        this.tamanhoFila = tamanhoFila;
        this.leituras = leituras;
        this.bytesLeitura = bytesLeitura;
        this.escritas = escritas;
        this.bytesEscrita = bytesEscrita;
        this.dataCaptura = dataCaptura;
        this.fkMaquina = fkMaquina;
        this.fkInfoDisco = fkInfoDisco;
        this.idInfoDisco = idInfoDisco;
        this.totalDisco = totalDisco;
    }

    public ModelDisco(Long tamanhoFila, Long leituras, Long bytesLeitura, Long escritas, Long bytesEscrita, Integer fkMaquina, Integer fkInfoDisco,
                      Integer idInfoDisco, Long totalDisco, Date dataCaptura) {
        this.idCapDisco = null;
        this.tamanhoFila = tamanhoFila;
        this.leituras = leituras;
        this.bytesLeitura = bytesLeitura;
        this.escritas = escritas;
        this.bytesEscrita = bytesEscrita;
        this.fkMaquina = fkMaquina;
        this.fkInfoDisco = fkInfoDisco;
        this.idInfoDisco = idInfoDisco;
        this.totalDisco = totalDisco;
        this.dataCaptura = dataCaptura;
    }

    public ModelDisco() {
    }

    public Integer getIdCapDisco() {
        return idCapDisco;
    }

    public void setIdCapDisco(Integer idCapDisco) {
        this.idCapDisco = idCapDisco;
    }

    public Long getTamanhoFila() {
        return tamanhoFila;
    }

    public void setTamanhoFila(Long tamanhoFila) {
        this.tamanhoFila = tamanhoFila;
    }

    public Long getLeituras() {
        return leituras;
    }

    public void setLeituras(Long leituras) {
        this.leituras = leituras;
    }

    public Long getBytesLeitura() {
        return bytesLeitura;
    }

    public void setBytesLeitura(Long bytesLeitura) {
        this.bytesLeitura = bytesLeitura;
    }

    public Long getEscritas() {
        return escritas;
    }

    public void setEscritas(Long escritas) {
        this.escritas = escritas;
    }

    public Long getBytesEscrita() {
        return bytesEscrita;
    }

    public void setBytesEscrita(Long bytesEscrita) {
        this.bytesEscrita = bytesEscrita;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    public Integer getFkInfoDisco() {
        return fkInfoDisco;
    }

    public void setFkInfoDisco(Integer fkInfoDisco) {
        this.fkInfoDisco = fkInfoDisco;
    }

    public Integer getIdInfoDisco() {
        return idInfoDisco;
    }

    public void setIdInfoDisco(Integer idInfoDisco) {
        this.idInfoDisco = idInfoDisco;
    }

    public Long getTotalDisco() {
        return totalDisco;
    }

    public void setTotalDisco(Long totalDisco) {
        this.totalDisco = totalDisco;
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
                "ID Cap Disco: %d%n" +
                        "Tamanho da Fila: %d%n" +
                        "Leituras: %d%n" +
                        "Bytes de Leitura: %d%n" +
                        "Escritas: %d%n" +
                        "Bytes de Escrita: %d%n" +
                        "FK Maquina: %d%n" +
                        "FK Info Disco: %d%n" +
                        "ID Info Disco: %d%n" +
                        "Total Disco: %d%n" +
                        "Data de Captura: %s%n",
                idCapDisco, tamanhoFila, leituras, bytesLeitura, escritas, bytesEscrita, fkMaquina, fkInfoDisco, idInfoDisco, totalDisco, dataCaptura
        );
    }
}
