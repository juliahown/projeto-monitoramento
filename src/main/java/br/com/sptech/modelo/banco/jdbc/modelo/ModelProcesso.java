package br.com.sptech.modelo.banco.jdbc.modelo;

public class ModelProcesso {
    private Integer idProcesso;
    private Integer pid;
    private Double usoCpu;
    private Double usoMemoria;
    private Long bytesUtilizados;
    private Integer fkMaquina;

    public ModelProcesso(Integer idProcesso, Integer pid, Double usoCpu, Double usoMemoria, Long bytesUtilizados, Integer fkMaquina) {
        this.idProcesso = idProcesso;
        this.pid = pid;
        this.usoCpu = usoCpu;
        this.usoMemoria = usoMemoria;
        this.bytesUtilizados = bytesUtilizados;
        this.fkMaquina = fkMaquina;
    }

    public ModelProcesso(Double usoCpu, Integer pid, Double usoMemoria, Long bytesUtilizados, Integer fkMaquina) {
        this.idProcesso = null;
        this.pid = pid;
        this.usoCpu = usoCpu;
        this.usoMemoria = usoMemoria;
        this.bytesUtilizados = bytesUtilizados;
        this.fkMaquina = fkMaquina;
    }

    public ModelProcesso() {
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public Double getUsoCpu() {
        return usoCpu;
    }

    public void setUsoCpu(Double usoCpu) {
        this.usoCpu = usoCpu;
    }

    public Double getUsoMemoria() {
        return usoMemoria;
    }

    public void setUsoMemoria(Double usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    public Long getBytesUtilizados() {
        return bytesUtilizados;
    }

    public void setBytesUtilizados(Long bytesUtilizados) {
        this.bytesUtilizados = bytesUtilizados;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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
                "ID Processo: %d%n" +
                        "PID: %d" +
                        "Uso CPU: %.2f%n" +
                        "Uso Memória: %.2f%n" +
                        "Bytes Utilizados: %d%n",
                idProcesso, pid, usoCpu, usoMemoria, bytesUtilizados
        );
    }
}
