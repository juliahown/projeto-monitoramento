package br.com.sptech.modelo.banco.jdbc.modelo;

public class ModelUsuario {
    private Integer idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String area;
    private String cargo;
    private Integer fkEmpresa;
    private Integer fkTipoUsuario;

    public ModelUsuario() {
    }

    public ModelUsuario(String nome, String email, String senha, String area, String cargo, Integer fkEmpresa, Integer fkTipoUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.area = area;
        this.cargo = cargo;
        this.fkEmpresa = fkEmpresa;
        this.fkTipoUsuario = fkTipoUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getFkTipoUsuario() {
        return fkTipoUsuario;
    }

    public void setFkTipoUsuario(Integer fkTipoUsuario) {
        this.fkTipoUsuario = fkTipoUsuario;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d%n" +
                        "Nome: %s%n" +
                        "Email: %s%n" +
                        "Área: %s%n" +
                        "Cargo: %s%n" +
                        "Empresa: %d%n" +
                        "Tipo de Usuário: %d%n",
                idUsuario, nome, email, area, cargo, fkEmpresa, fkTipoUsuario
        );
    }
}
