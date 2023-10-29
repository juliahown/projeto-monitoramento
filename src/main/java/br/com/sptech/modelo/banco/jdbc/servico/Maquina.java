package br.com.sptech.modelo.banco.jdbc.servico;

import br.com.sptech.modelo.banco.jdbc.conexao.Conexao;
import br.com.sptech.modelo.banco.jdbc.dao.*;
import br.com.sptech.modelo.banco.jdbc.modelo.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class Maquina {

    private Integer idMaquina;
    private MemoriaDao memoriaDao;
    private CpuDao cpuDao;
    private DiscoDao discoDao;
    private JanelaDao janelaDao;
    private ProcessoDao processoDao;
    private Boolean componenteSalvos = false;


    public Maquina() {
        this.memoriaDao = new MemoriaDao();
        this.cpuDao = new CpuDao();
        this.discoDao = new DiscoDao();
        this.janelaDao = new JanelaDao();
        this.processoDao = new ProcessoDao();
    }

    public void buscarDadosFixosDosComponentes() {
        memoriaDao.buscarDadosFixo(idMaquina);
        cpuDao.buscarDadosFixo(idMaquina);
        discoDao.buscarDadosFixo(idMaquina);
    }

    public void buscarIdMaquina(Integer idUsuario) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        String sql = "SELECT id_maquina FROM maquina WHERE fk_usuario = ?";
        idMaquina = con.queryForObject(sql, Integer.class, idUsuario);
    }

    public Boolean isComponenteSalvo(Integer fkMaquina) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        String sql = "SELECT count(*) FROM componente WHERE fk_maquina = ?";
        Integer count = con.queryForObject(sql, Integer.class, fkMaquina);

        return count > 0;
    }

    public void capturarDadosFixo(ModelMemoria novaCapturaRam,
                                  ModelCpu novaCapturaCpu,
                                  ModelDisco novaCapturaDisco) {

        memoriaDao.salvarCapturaFixa(novaCapturaRam, idMaquina);
        cpuDao.salvarCapturaFixa(novaCapturaCpu, idMaquina);
        discoDao.salvarCapturaFixa(novaCapturaDisco, idMaquina);


        componenteSalvos = true;
    }

    public void capturarDadosDinamico(ModelMemoria novaCapturaRam,
                                      ModelCpu novaCapturaCpu,
                                      ModelDisco novaCapturaDisco,
                                      ModelJanela novaCapturaJanela,
                                      ModelProcesso novaCapturaProcesso) {

        memoriaDao.salvarCapturaDinamica(novaCapturaRam);
        cpuDao.salvarCapturaDinamica(novaCapturaCpu);
        discoDao.salvarCapturaDinamica(novaCapturaDisco);
        janelaDao.atualizarJanela(novaCapturaJanela, idMaquina);
        processoDao.atualizarProcesso(novaCapturaProcesso, idMaquina);
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public MemoriaDao getMemoriaDao() {
        return memoriaDao;
    }

    public void setMemoriaDao(MemoriaDao memoriaDao) {
        this.memoriaDao = memoriaDao;
    }

    public Boolean getComponenteSalvos() {
        return componenteSalvos;
    }

    public void setComponenteSalvos(Boolean componenteSalvos) {
        this.componenteSalvos = componenteSalvos;
    }
}
