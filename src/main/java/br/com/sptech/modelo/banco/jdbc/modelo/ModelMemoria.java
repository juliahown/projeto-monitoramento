package br.com.sptech.modelo.banco.jdbc.modelo;

import java.util.Date;

public class ModelMemoria {
    private Integer idCapRam;
    private Long ramTotal;
    private Long memoriaUso;
    private Date dataCaptura;
    private Integer fkMaquina;

    public ModelMemoria(Integer idCapRam, Long ramTotal, Long memoriaUso, Date dataCaptura, Integer fkMaquina) {
        this.idCapRam = idCapRam;
        this.ramTotal = ramTotal;
        this.memoriaUso = memoriaUso;
        this.dataCaptura = dataCaptura;
        this.fkMaquina = fkMaquina;
    }

    public ModelMemoria(Long ramTotal, Long memoriaUso, Date dataCaptura, Integer fkMaquina) {
        this.idCapRam = null;
        this.ramTotal = ramTotal;
        this.memoriaUso = memoriaUso;
        this.dataCaptura = dataCaptura;
        this.fkMaquina = fkMaquina;
    }

    public ModelMemoria(Integer idCapRam, Long ramTotal, Long memoriaUso) {
        this.idCapRam = idCapRam;
        this.ramTotal = ramTotal;
        this.memoriaUso = memoriaUso;
        this.dataCaptura = null;
        this.fkMaquina = null;
    }

    public ModelMemoria() {
    }

    public Integer getIdCapRam() {
        return idCapRam;
    }

    public void setIdCapRam(Integer idCapRam) {
        this.idCapRam = idCapRam;
    }

    public Long getRamTotal() {
        return ramTotal;
    }

    public void setRamTotal(Long ramTotal) {
        this.ramTotal = ramTotal;
    }

    public Long getMemoriaUso() {
        return memoriaUso;
    }

    public void setMemoriaUso(Long memoriaUso) {
        this.memoriaUso = memoriaUso;
    }

    public Date getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(Date dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d%n" +
                        "RAM Total: %.2f%n" +
                        "Memória em Uso: %.2f%n" +
                        "Data de Captura: %s%n" +
                        "FK Maquina: %d%n",
                idCapRam, ramTotal, memoriaUso, dataCaptura, fkMaquina
        );
    }
}
