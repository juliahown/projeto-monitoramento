package br.com.sptech.modelo.banco.jdbc.validacoes;

import java.util.ArrayList;
import java.util.List;

public class ValidacoesUsuario {

    // VALIDAÇÕES DE SENHA
    public boolean isSenhaValida(String senha) {
        return senha.length() >= 8;
    }

    public boolean isSenhaComplexa(String senha) {
        boolean temEspecial = false;
        boolean temMaisculas = false;
        boolean temMinusculas = false;
        String caracteresEspeciais = "@#$%^&+=!";
        String letrasMaisculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";

        for (char c : senha.toCharArray()) {
            // Esse for transforma a senha em uma cadeia de caracteres, e ele percorre digito por digito comparando com as listas acima.

            if (caracteresEspeciais.indexOf(c) != -1) {
                temEspecial = true;
            }

            if (letrasMaisculas.indexOf(c) != -1) {
                temMaisculas = true;
            }

            if (letrasMinusculas.indexOf(c) != -1) {
                temMinusculas = true;
            }
        }
        if (!temEspecial || !temMaisculas || !temMinusculas) {
            return false;
        }

        // Se passou por todas as verificações, a senha é considerada complexa
        return true;
    }


    // VALIDAÇÕES DE EMAIL

    public boolean isEmailValido(String email) {
        Boolean cond01 = email.contains("@");
        Boolean cond02 = email.contains(".com");
        return cond01 && cond02;
    }

    public boolean naoTemEspacos(String email) {
        return !email.contains(" ");
    }


    public List obterNovaLista() {
        // Crie uma nova lista e a retorne
        return new ArrayList();
    }
}
