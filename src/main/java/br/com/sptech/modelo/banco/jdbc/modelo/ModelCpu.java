package br.com.sptech.modelo.banco.jdbc.modelo;

import java.util.Date;

public class ModelCpu {
    private Long freq;
    private Integer numCPUsFisicas;
    private Integer numCPUsLogicas;
    private Double usoCpu;
    private Date dataCaptura;

    public ModelCpu(Long freq, Integer numCPUsFisicas, Integer numCPUsLogicas, Double usoCpu, Date dataCaptura) {
        this.freq = freq;
        this.numCPUsFisicas = numCPUsFisicas;
        this.numCPUsLogicas = numCPUsLogicas;
        this.usoCpu = usoCpu;
        this.dataCaptura = dataCaptura;
    }

    public ModelCpu() {
    }

    public Long getFreq() {
        return freq;
    }

    public void setFreq(Long freq) {
        this.freq = freq;
    }

    public Integer getNumCPUsFisicas() {
        return numCPUsFisicas;
    }

    public void setNumCPUsFisicas(Integer numCPUsFisicas) {
        this.numCPUsFisicas = numCPUsFisicas;
    }

    public Integer getNumCPUsLogicas() {
        return numCPUsLogicas;
    }

    public void setNumCPUsLogicas(Integer numCPUsLogicas) {
        this.numCPUsLogicas = numCPUsLogicas;
    }

    public Double getUsoCpu() {
        return usoCpu;
    }

    public void setUsoCpu(Double usoCpu) {
        this.usoCpu = usoCpu;
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
                "Frequência: %d%n" +
                        "Número de CPUs Físicas: %d%n" +
                        "Número de CPUs Lógicas: %d%n" +
                        "Uso da CPU: %.2f%n" +
                        "Data de Captura: %s%n",
                freq, numCPUsFisicas, numCPUsLogicas, usoCpu, dataCaptura
        );
    }
}
