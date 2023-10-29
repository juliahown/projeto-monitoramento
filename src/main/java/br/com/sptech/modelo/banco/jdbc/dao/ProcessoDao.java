package br.com.sptech.modelo.banco.jdbc.dao;

import br.com.sptech.modelo.banco.jdbc.conexao.Conexao;
import br.com.sptech.modelo.banco.jdbc.modelo.ModelJanela;
import br.com.sptech.modelo.banco.jdbc.modelo.ModelProcesso;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessoDao {

    public void atualizarProcesso(ModelProcesso novaCapturaProcesso, Integer fkMaquina) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        con.update("INSERT INTO processo (pid, uso_cpu, uso_memoria, bytes_utilizados, fk_maquina) VALUES (?, ?, ?, ?, ?)",
                novaCapturaProcesso.getPid(),
                novaCapturaProcesso.getUsoCpu(),
                novaCapturaProcesso.getUsoMemoria(),
                novaCapturaProcesso.getBytesUtilizados(),
                fkMaquina
        );
    }

    public void excluirProcesso(Integer idProcesso) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        con.update("DELETE FROM processo WHERE idProcesso = ?", idProcesso);

        System.out.println("Processo excluído com sucesso!");
    }
}
