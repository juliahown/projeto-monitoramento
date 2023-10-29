package br.com.sptech.modelo.banco.jdbc.dao;

import br.com.sptech.modelo.banco.jdbc.conexao.Conexao;
import br.com.sptech.modelo.banco.jdbc.modelo.ModelJanela;
import org.springframework.jdbc.core.JdbcTemplate;

public class JanelaDao {

    public void atualizarJanela(ModelJanela novaCapturaJanela, Integer fkMaquina) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        con.update("INSERT INTO janela (pid, titulo, comando, visivel, fk_maquina) VALUES (?, ?, ?, ?, ?)",
                novaCapturaJanela.getPid(),
                novaCapturaJanela.getTitulo(),
                novaCapturaJanela.getComando(),
                novaCapturaJanela.getVisivel(),
                fkMaquina
        );
    }

    public void excluirJanela(Integer idJanela) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        con.update("DELETE FROM janela WHERE idJanela = ?", idJanela);

        System.out.println("Janela excluída com sucesso!");
    }
}
