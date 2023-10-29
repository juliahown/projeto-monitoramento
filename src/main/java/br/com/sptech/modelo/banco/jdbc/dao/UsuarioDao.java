package br.com.sptech.modelo.banco.jdbc.dao;

import br.com.sptech.modelo.banco.jdbc.conexao.Conexao;
import br.com.sptech.modelo.banco.jdbc.modelo.ModelUsuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UsuarioDao {
    private Integer idUsuario;

    public UsuarioDao() {}

    public Integer salvarUsuario(ModelUsuario novoUsuario) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        con.update("INSERT INTO usuario (nome, email, senha, area, cargo, fk_empresa, fk_tipo_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)", novoUsuario.getNome(), novoUsuario.getEmail(), novoUsuario.getSenha(), novoUsuario.getArea(), novoUsuario.getCargo(), novoUsuario.getFkEmpresa(), novoUsuario.getFkTipoUsuario());

        idUsuario = con.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        System.out.println(idUsuario);
        return idUsuario;
    }

    public Boolean isUsuarioExistente(ModelUsuario usuario) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        String sql = "SELECT COUNT(*) FROM usuario WHERE email = ? AND senha = ?";
        Integer count = con.queryForObject(sql, Integer.class, usuario.getEmail(), usuario.getSenha());

        return count > 0;
    }

    public Integer buscarIdUsuario(ModelUsuario usuario) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        String sql = "SELECT id_usuario FROM usuario WHERE email = ? AND senha = ?";
        Integer idUsuario = con.queryForObject(sql, Integer.class, usuario.getEmail(), usuario.getSenha());

        return idUsuario;
    }



    public Boolean isTokenValido(String token) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        String dbToken = con.queryForObject("SELECT token FROM token WHERE token = ?", String.class, token);
        
        return token.equals(dbToken); // O token é válido
    }

    public Integer buscarIdToken(String token) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        Integer idToken = con.queryForObject("SELECT idToken FROM token WHERE token = ?", Integer.class, token);

        return idToken; // O token é válido
    }

    public Integer buscarEmpresaPorNome(String empresa) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        Integer fkEmpresa = con.queryForObject("SELECT id_empresa FROM empresa WHERE nome LIKE ?", Integer.class, empresa.toLowerCase());

        return fkEmpresa;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

}
