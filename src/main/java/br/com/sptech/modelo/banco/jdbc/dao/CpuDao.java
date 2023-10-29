package br.com.sptech.modelo.banco.jdbc.dao;

import br.com.sptech.modelo.banco.jdbc.conexao.Conexao;
import br.com.sptech.modelo.banco.jdbc.modelo.ModelCpu;
import org.springframework.jdbc.core.JdbcTemplate;

public class CpuDao {
    private Integer idInfo;

    public void salvarCapturaFixa(ModelCpu novaCapturaCpu, Integer fkMaquina) {
        if (fkMaquina != null) {
            Conexao conexao = new Conexao();
            JdbcTemplate con = conexao.getConexaoDoBanco();

            // Inserir dados na tabela info_componente
            con.update("INSERT INTO info_componente (qtd_cpu_fisica, qtd_cpu_logica) VALUES (?, ?)", novaCapturaCpu.getNumCPUsFisicas(),
                                                                            novaCapturaCpu.getNumCPUsLogicas());

            // Obter o ID inserido na tabela info_componente
            idInfo = con.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

            // Inserir dados na tabela componente
            con.update("INSERT INTO componente (nome, parametro, fk_info, fk_maquina) VALUES (?, ?, ?, ?)",
                    "cpu", "%", idInfo, fkMaquina);
        } else {
            throw new RuntimeException("Precisa existir um processador no banco primeiro.");
        }
    }

    public void salvarCapturaDinamica(ModelCpu novaCapturaCpu) {
        if (idInfo != null) {
            Conexao conexao = new Conexao();
            JdbcTemplate con = conexao.getConexaoDoBanco();

            // Inserir dados na tabela dados_captura
            con.update("INSERT INTO dados_captura (uso, frequencia, data_captura, fk_componente) VALUES (?, ?, ?, ?)",
                    novaCapturaCpu.getUsoCpu(),
                    novaCapturaCpu.getFreq(),
                    novaCapturaCpu.getDataCaptura(),
                    idInfo
            );
        } else {
            throw new RuntimeException("ID não foi capturado. Execute salvarCapturaFixa() primeiro.");
        }
    }

    public void buscarDadosFixo(Integer idMaquina) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        String sql = "SELECT m.id_maquina\n" +
                "FROM componente c\n" +
                "JOIN info_componente i ON c.fk_info = i.id_info\n" +
                "JOIN maquina m ON c.fk_maquina = m.id_maquina\n" +
                "WHERE c.nome = ? AND m.id_maquina = ?";
        idInfo = con.queryForObject(sql, Integer.class, "cpu", idMaquina);
    }
}
