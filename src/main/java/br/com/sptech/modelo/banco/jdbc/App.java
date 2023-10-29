package br.com.sptech.modelo.banco.jdbc;

import br.com.sptech.modelo.banco.jdbc.dao.MaquinaDao;
import br.com.sptech.modelo.banco.jdbc.dao.UsuarioDao;
import br.com.sptech.modelo.banco.jdbc.modelo.*;
import br.com.sptech.modelo.banco.jdbc.servico.Maquina;
import br.com.sptech.modelo.banco.jdbc.validacoes.ValidacoesUsuario;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.janelas.Janela;
import com.github.britooo.looca.api.group.janelas.JanelaGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {

        // Crie um agendador de tarefas
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Maquina maquina01 = new Maquina();

        ModelUsuario novoUsuario = new ModelUsuario();
        UsuarioDao usuarioDao = new UsuarioDao();

        Looca looca = new Looca();
        Scanner leitor = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);
        Boolean logado = false;
        ValidacoesUsuario validacoesUsuario = new ValidacoesUsuario();

        System.out.println("""
      
                
                
                
                        :::   :::  ::::::::  ::::::::::: ::::::::::: ::::::::::
                        :+:   :+: :+:    :+:     :+:         :+:     :+:
                         +:+ +:+  +:+    +:+     +:+         +:+     +:+
                          +#++:   +#+    +:+     +#+         +#+     +#++:++#
                           +#+    +#+    +#+     +#+         +#+     +#+
                           #+#    #+#    #+#     #+#         #+#     #+#
                           ###     ########      ###         ###     ##########
                 
                 
                                
                Olá, seja bem-vindo ao app de monitoramento da Yotte! :D
                
                Escolha a sua ação:
                
                0 - Realizar cadastro.
                1 - Fazer Login.
                2 - Sair da aplicação.
                """);
        Integer opcao = leitor.nextInt();

        switch (opcao) {
            case 0:

                // Cadastrar um novo usuário
                String nome, email, senha, area, cargo, empresa, ip, modelo, so, matricula;
                Boolean todasValidacoes = false;

                do {
                    String input;

                    System.out.println("Digite o seu nome:");
                    nome = leitorTexto.nextLine();

                    System.out.println("Digite o seu endereço de email:");
                    email = leitorTexto.nextLine();

                    System.out.println("Crie uma senha segura:");
                    senha = leitorTexto.nextLine();

                    System.out.println("Informe a sua área de atuação:");
                    area = leitorTexto.nextLine();

                    System.out.println("Qual é o seu cargo?");
                    cargo = leitorTexto.nextLine();

                    System.out.println("Nome da empresa em que você trabalha:");
                    empresa = leitorTexto.nextLine();

                    System.out.println("Digite o endereço IP da sua máquina: ");
                    ip = leitorTexto.nextLine();

                    System.out.println("Qual é o modelo do seu dispositivo?");
                    modelo = leitorTexto.nextLine();

                    System.out.println("Sistema Operacional da sua máquina: ");
                    so = leitorTexto.nextLine();

                    System.out.println("Insira seu token de acesso: ");
                    matricula = leitorTexto.nextLine();

                    Boolean editarCadastro = true;

                    while (editarCadastro) {
                        System.out.printf("""
                                Revisão do Cadastro:

                                Nome: %s
                                Email: %s
                                Senha: %s
                                Área de Atuação: %s
                                Cargo: %s
                                Empresa: %s
                                Endereço IP: %s
                                Modelo do Dispositivo: %s
                                Sistema Operacional: %s
                                Token de Acesso: %s%n""", nome, email, senha, area, cargo, empresa, ip, modelo, so, matricula);

                    System.out.println("Deseja editar alguma informação? (S/N)");

                    input = leitorTexto.nextLine();

                    if (input.equalsIgnoreCase("S")) {
                        System.out.println("Escolha o item a ser editado (ex: Nome, Email, Senha, ...):");
                        String itemParaEditar = leitorTexto.nextLine();

                        switch (itemParaEditar.toLowerCase()) {
                            case "nome":
                                System.out.println("Digite o novo nome:");
                                nome = leitorTexto.nextLine();
                                break;
                            case "email":
                                System.out.println("Digite o novo email:");
                                email = leitorTexto.nextLine();
                                break;
                            case "senha":
                                System.out.println("Digite uma nova senha:");
                                senha = leitorTexto.nextLine();
                                break;
                            case "area":
                                System.out.println("Digite a nova área de atuação:");
                                area = leitorTexto.nextLine();
                                break;
                            case "cargo":
                                System.out.println("Digite o novo cargo:");
                                cargo = leitorTexto.nextLine();
                                break;
                            case "empresa":
                                System.out.println("Digite novamente o nome da empresa:");
                                empresa = leitorTexto.nextLine();
                                break;
                            case "ip":
                                System.out.println("Digite o novo ip:");
                                ip = leitorTexto.nextLine();
                                break;
                            case "modelo":
                                System.out.println("Digite o modelo novamente:");
                                modelo = leitorTexto.nextLine();
                                break;
                            case "sistema operacional":
                            case "so":
                            case "sistema":
                                System.out.println("Digite o o Sistema Operacional novamente:");
                                so = leitorTexto.nextLine();
                                break;
                            case "token":
                                System.out.println("Digite o novo token:");
                                matricula = leitorTexto.nextLine();
                                break;
                            default:
                                System.out.println("Item não encontrado.");
                        }
                    } else if (input.equalsIgnoreCase("N")) {
                        editarCadastro = false;
                    }
                    }

                        Boolean isSenhaValida = validacoesUsuario.isSenhaValida(senha);
                        Boolean emailNaoTemEspacos = !email.contains(" ");
                        Boolean isEmailValido = validacoesUsuario.isEmailValido(email);

                        if (isSenhaValida && emailNaoTemEspacos && isEmailValido) {
                            todasValidacoes = true;

                            if (usuarioDao.isTokenValido(matricula) && usuarioDao.buscarEmpresaPorNome(empresa) != null) {
                                Integer fkEmpresa = usuarioDao.buscarEmpresaPorNome(empresa);

                                novoUsuario.setNome(nome);
                                novoUsuario.setEmail(email);
                                novoUsuario.setSenha(senha);
                                novoUsuario.setArea(area);
                                novoUsuario.setCargo(cargo);
                                novoUsuario.setFkEmpresa(fkEmpresa);
                                novoUsuario.setFkTipoUsuario(3);

                                MaquinaDao maquinaDao = new MaquinaDao();
                                ModelMaquina novaMaquina = new ModelMaquina();
                                novaMaquina.setIp(ip);
                                novaMaquina.setSo(so);
                                novaMaquina.setModelo(modelo);

                                usuarioDao.salvarUsuario(novoUsuario);
                                maquinaDao.salvarMaquina(novaMaquina, usuarioDao.buscarIdUsuario(novoUsuario), usuarioDao.buscarIdToken(matricula));
                                maquina01.buscarIdMaquina(usuarioDao.buscarIdUsuario(novoUsuario));

                                logado = true;
                            } else {
                                System.out.println("Seu token não é válido ou a empresa não existe!");
                            }
                        } else {
                            System.out.println("Desculpe, os dados fornecidos são inválidos. Por favor, revise e preencha o formulário novamente. \n");
                        }
                    }
                    while (!todasValidacoes) ;
                    break;

            case 1:

                // Realizar o Login
                Boolean todasValidacoesLogin = false;
                String validarEmail, validarSenha;

                do {
                    ModelUsuario usuario = new ModelUsuario();
                    System.out.println("Digite o seu email:");
                    validarEmail = leitorTexto.nextLine();
                    System.out.println("Digite a sua senha:");
                    validarSenha = leitorTexto.nextLine();

                    usuario.setEmail(validarEmail);
                    usuario.setSenha(validarSenha);

                    if (usuarioDao.isUsuarioExistente(usuario)) {
                        todasValidacoesLogin = true;
                        System.out.println("Id usuario: " + usuarioDao.buscarIdUsuario(usuario));
                        maquina01.buscarIdMaquina(usuarioDao.buscarIdUsuario(usuario));
                        logado = true;
                    } else {
                        System.out.println("Email ou senha estão incorretos. Tente novamente!");
                    }
                } while (!todasValidacoesLogin);

                System.out.println("Login realizado com sucesso! \uD83D\uDE04");
                break;

            case 2:
                System.out.println("Saindo da aplicação...");
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }

        // Fecha os recursos necessários, como Scanners
        leitor.close();
        leitorTexto.close();

        if (logado.equals(true)) {

            // Obtenha os dados da API Looca
            Memoria memoria = looca.getMemoria();

            Processador cpu = looca.getProcessador();

            DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
            List<Disco> discos = grupoDeDiscos.getDiscos();

            JanelaGrupo grupodDeJanelas = looca.getGrupoDeJanelas();
            List<Janela> janelas = grupodDeJanelas.getJanelas();

            ProcessoGrupo grupoDeProcessos = looca.getGrupoDeProcessos();
            List<Processo> processos = grupoDeProcessos.getProcessos();

            ModelMemoria novaCapturaRam = new ModelMemoria();
            ModelCpu novaCapturaCpu = new ModelCpu();
            ModelDisco novaCapturaDisco = new ModelDisco();
            ModelJanela novaCapturaJanela = new ModelJanela();
            ModelProcesso novaCapturaProcesso = new ModelProcesso();


            // IF para captura fixa, acontece apenas 1 vez.
            if(!maquina01.isComponenteSalvo(maquina01.getIdMaquina())){
                novaCapturaRam.setRamTotal(memoria.getTotal());
                novaCapturaCpu.setNumCPUsFisicas(cpu.getNumeroCpusFisicas());
                novaCapturaCpu.setNumCPUsLogicas(cpu.getNumeroCpusLogicas());

                for (Disco disco : discos) {
                    novaCapturaDisco.setTotalDisco(disco.getTamanho());
                }

                maquina01.capturarDadosFixo(novaCapturaRam, novaCapturaCpu, novaCapturaDisco);

            } else {
                maquina01.buscarDadosFixosDosComponentes();
            };

            // Scheduler de 10 segundos para capturas dinâmicas
            scheduler.scheduleAtFixedRate(() -> {
                try {
                    // Crie uma nova instância da sua classe com os dados capturados
                    novaCapturaRam.setMemoriaUso(memoria.getEmUso());
                    novaCapturaRam.setDataCaptura(new Date());

                    novaCapturaCpu.setUsoCpu(cpu.getUso());
                    novaCapturaCpu.setFreq(cpu.getFrequencia());
                    novaCapturaCpu.setDataCaptura(new Date());

                    for (Disco disco : discos) {
                        novaCapturaDisco.setBytesEscrita(disco.getBytesDeEscritas());
                        novaCapturaDisco.setDataCaptura(new Date());
                        novaCapturaDisco.setBytesLeitura(disco.getBytesDeLeitura());
                        novaCapturaDisco.setEscritas(disco.getEscritas());
                        novaCapturaDisco.setLeituras(disco.getLeituras());
                        novaCapturaDisco.setTamanhoFila(disco.getTamanhoAtualDaFila());
                    }

                    for (Janela janela : janelas) {
                        novaCapturaJanela.setPid(janela.getPid());
                        novaCapturaJanela.setTitulo(janela.getTitulo());
                        novaCapturaJanela.setComando(janela.getComando());
                        novaCapturaJanela.setVisivel(janela.isVisivel());
                        novaCapturaJanela.setDataCaptura(new Date());
                    }

                    for (Processo processo : processos) {
                        novaCapturaProcesso.setPid(processo.getPid());
                        novaCapturaProcesso.setUsoCpu(processo.getUsoCpu());
                        novaCapturaProcesso.setUsoMemoria(processo.getUsoMemoria());
                        novaCapturaProcesso.setBytesUtilizados(processo.getBytesUtilizados());
                    }

                    maquina01.capturarDadosDinamico(novaCapturaRam, novaCapturaCpu, novaCapturaDisco, novaCapturaJanela, novaCapturaProcesso);

                    // Imprima uma mensagem de sucesso no console
                    System.out.println("Dados de memória capturados e salvos com sucesso!");
                } catch (Exception e) {
                    // Imprima quaisquer erros no console
                    e.printStackTrace();
                    System.err.println("Erro ao capturar e salvar dados de memória.");
                }
            }, 0, 10, TimeUnit.SECONDS);
        }
    }
}

