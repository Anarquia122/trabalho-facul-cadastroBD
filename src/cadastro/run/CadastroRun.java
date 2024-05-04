/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.run;

import cadastro.model.DAO.PessoaFisicaDAO;
import cadastro.model.DAO.PessoaJuridicaDAO;
import cadastroBD.model.PessoaFisica;
import cadastroBD.model.PessoaJuridica;

/**
 *
 * @author italo
 */
import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;

//Nome - Logradouro - Cidade - Estado - Telefone - Email - Cpf
//Nome - Logradouro - Cidade - Estado - Telefone - Email - Cnpj
public class CadastroRun {
    
    private static Scanner entrada = new Scanner(System.in);
    private static PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
    private static PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();
    private static int acao;
    
    public static void main (String[] args) {
        do {
            try {
                System.out.println("Para continuar digite: ");
                System.out.println("============================");
                System.out.println("1 - Incluir");
                System.out.println("2 - Aterar");
                System.out.println("3 - Exibir");
                System.out.println("4 - Excluir");
                System.out.println("5 - Exibir Todos");
                System.out.println("0 - Finalizar");
                System.out.println("============================");
                
                acao = entrada.nextInt();
                entrada.nextLine();
                
                switch (acao) {
                    //incluir
                    case 1 :{
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                        String tipoPessoa = entrada.next();
                        entrada.nextLine();
                        
                        if (tipoPessoa.equalsIgnoreCase("f") || tipoPessoa.equalsIgnoreCase("F")) {
                            String nome, logradouro, cidade, estado, telefone, email, cpf;
                            PessoaFisica pf = new PessoaFisica();
                            
                            System.out.println("Insira os dados da Pessoa Fisica.");
                            
                            System.out.println("Nome: ");
                            nome = entrada.nextLine();
                            pf.setNome(nome);
                            
                            System.out.println("Logradouro: ");
                            logradouro = entrada.nextLine();
                            pf.setLogradouro(logradouro);
                            
                            System.out.println("Cidade: ");
                            cidade = entrada.nextLine();
                            pf.setCidade(cidade);
                            
                            System.out.println("Estado (max 2 caracteres): ");
                            estado = entrada.nextLine();
                            pf.setEstado(estado);
                            
                            System.out.println("Telefone: ");
                            telefone = entrada.nextLine();
                            pf.setTelefone(telefone);
                            
                            System.out.println("Email: ");
                            email = entrada.nextLine();
                            pf.setEmail(email);
                            
                            System.out.println("CPF: ");
                            cpf = entrada.nextLine();
                            pf.setCpf(cpf);
                            
                            pfDAO.inserir(pf);
                            System.out.println("Pessoa inserida com sucesso!");
                        } else if (tipoPessoa.equalsIgnoreCase("j") || tipoPessoa.equalsIgnoreCase("J")) {
                            String nome, logradouro, cidade, estado, telefone, email, cnpj;
                            PessoaJuridica pj = new PessoaJuridica();
                            
                            System.out.println("Insira os dados de Pessoa Juridica.");
                            
                            System.out.println("Nome: ");
                            nome = entrada.nextLine();
                            pj.setNome(nome);
                            
                            System.out.println("Logradouro: ");
                            logradouro = entrada.nextLine();
                            pj.setLogradouro(logradouro);
                            
                            System.out.println("Cidade: ");
                            cidade = entrada.nextLine();
                            pj.setCidade(cidade);
                            
                            System.out.println("Estado (max 2 caracteres): ");
                            estado = entrada.nextLine();
                            pj.setEstado(estado);
                            
                            System.out.println("Telefone: ");
                            telefone = entrada.nextLine();
                            pj.setTelefone(telefone);
                            
                            System.out.println("Email: ");
                            email = entrada.nextLine();
                            pj.setEmail(email);
                            
                            System.out.println("CNPJ: ");
                            cnpj = entrada.nextLine();
                            pj.setCnpj(cnpj);
                            
                            pjDAO.inserir(pj);
                            System.out.println("Pessoa inseridica com sucesso!");
                        } else {
                            System.out.println("Valor inserido é diferente do esperado.");
                        }
                        break;
                    }
                    //alterar
                    case 2 :{
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                        String tipoPessoa = entrada.next();
                        entrada.nextLine();
                        
                        if (tipoPessoa.equalsIgnoreCase("f") || tipoPessoa.equalsIgnoreCase("F")) {
                            System.out.println("Insira a ID da Pessoa Fisica que deseja alterar.");
                            int id = entrada.nextInt();
                            entrada.nextLine();
                            
                            PessoaFisica pf = pfDAO.getPessoa(id);
                            System.out.println("Esses são os dados atuais dessa pessoa.");
                            pf.exibir();
                            
                            System.out.println("Insira os novos dados: ");
                            
                            String nome, logradouro, cidade, estado, telefone, email, cpf;
                            
                            System.out.println("Nome: ");
                            nome = entrada.nextLine();
                            pf.setNome(nome);
                            
                            System.out.println("Logradouro: ");
                            logradouro = entrada.nextLine();
                            pf.setLogradouro(logradouro);
                            
                            System.out.println("Cidade: ");
                            cidade = entrada.nextLine();
                            pf.setCidade(cidade);
                            
                            System.out.println("Estado (max 2 caracteres): ");
                            estado = entrada.nextLine();
                            pf.setEstado(estado);
                            
                            System.out.println("Telefone: ");
                            telefone = entrada.nextLine();
                            pf.setTelefone(telefone);
                            
                            System.out.println("Email: ");
                            email = entrada.nextLine();
                            pf.setEmail(email);
                            
                            System.out.println("CPF: ");
                            cpf = entrada.nextLine();
                            pf.setCpf(cpf);
                            
                            pfDAO.alterar(pf);
                            System.out.println("Pessoa alterada com sucesso!");
                        } else if (tipoPessoa.equalsIgnoreCase("j") || tipoPessoa.equalsIgnoreCase("J")) {
                            System.out.println("Insira a IA da Pessoa Juridica que deseja alterar.");
                            int id = entrada.nextInt();
                            entrada.nextLine();
                            
                            PessoaJuridica pj = pjDAO.getPessoa(id);
                            System.out.println("Esses são os dados atuais dessa pessoa");
                            pj.exibir();
                            
                            System.out.println("Insira os novos dados.");
                            
                            String nome, logradouro, cidade, estado, telefone, email, cnpj;
                            
                            System.out.println("Nome: ");
                            nome = entrada.nextLine();
                            pj.setNome(nome);
                            
                            System.out.println("Logradouro: ");
                            logradouro = entrada.nextLine();
                            pj.setLogradouro(logradouro);
                            
                            System.out.println("Cidade: ");
                            cidade = entrada.nextLine();
                            pj.setCidade(cidade);
                            
                            System.out.println("Estado (max 2 caracteres): ");
                            estado = entrada.nextLine();
                            pj.setEstado(estado);
                            
                            System.out.println("Telefone: ");
                            telefone = entrada.nextLine();
                            pj.setTelefone(telefone);
                            
                            System.out.println("Email: ");
                            email = entrada.nextLine();
                            pj.setEmail(email);
                            
                            System.out.println("CNPJ: ");
                            cnpj = entrada.nextLine();
                            pj.setCnpj(cnpj);
                            
                            pjDAO.alterar(pj);
                            System.out.println("Pessoa alterada com sucesso!");
                        } else {
                            System.out.println("Valor inserido diferente do solicitado.");
                        }
                        break;
                    }
                    //exibir
                    case 3 :{
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                        String tipoPessoa = entrada.next();
                        entrada.nextLine();
                        
                        if (tipoPessoa.equalsIgnoreCase("f") || tipoPessoa.equalsIgnoreCase("F")) {
                            System.out.println("Insira a ID da Pessoa Fisica.");
                            int id = entrada.nextInt();
                            entrada.nextLine();
                            
                            PessoaFisica pf = pfDAO.getPessoa(id);
                            System.out.println("Buscando dados...");
                            
                            pf.exibir();
                        } else if (tipoPessoa.equalsIgnoreCase("j") || tipoPessoa.equalsIgnoreCase("J")) {
                            System.out.println("Insira a ID da Pessoa Juridica.");
                            int id = entrada.nextInt();
                            entrada.nextLine();
                            
                            PessoaJuridica pj = pjDAO.getPessoa(id);
                            System.out.println("Buscando dados...");
                            
                            pj.exibir();
                        } else {
                            System.out.println("Valor inserido diferente do solicitado.");
                        }
                        break;
                    }
                    //excluir
                    case 4 :{
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                        String tipoPessoa = entrada.next();
                        entrada.nextLine();
                        
                        if (tipoPessoa.equalsIgnoreCase("f") || tipoPessoa.equalsIgnoreCase("F")) {
                            System.out.println("Insira a ID da Pessoa Fisica.");
                            int id = entrada.nextInt();
                            entrada.nextLine();
                            
                            PessoaFisica pf = pfDAO.getPessoa(id);
                            System.out.println("Esses sao os dados da pessoa:");
                            pf.exibir();
                            
                            System.out.println("Deseja excluir? S - sim | N - nao");
                            String conf = entrada.next();
                            entrada.nextLine();
                            
                            if (conf.equalsIgnoreCase("S") || conf.equalsIgnoreCase("s")) {
                                pfDAO.excluir(id);
                                System.out.println("Pessoa Excluida com sucesso!");
                            } else if (conf.equalsIgnoreCase("N") || conf.equalsIgnoreCase("n")) {
                                System.out.println("Pessoa intacta!");
                            } else {
                                System.out.println("Valor inserido diferente do solicitado.");
                            }
                        } else if (tipoPessoa.equalsIgnoreCase("j") || tipoPessoa.equalsIgnoreCase("J")) {
                            System.out.println("Insira a ID da Pessoa Juridica");
                            int id = entrada.nextInt();
                            entrada.nextLine();
                            
                            PessoaJuridica pj = pjDAO.getPessoa(id);
                            System.out.println("Esses sao os dados atuais da pessoa:");
                            pj.exibir();
                            
                            System.out.println("Deseja excluir? S - sim | N - nao");
                            String conf = entrada.next();
                            entrada.nextLine();
                            
                            if (conf.equalsIgnoreCase("S") || conf.equalsIgnoreCase("s")) {
                                pjDAO.excluir(id);
                                System.out.println("Pessoa excluida com sucesso!");
                            } else if (conf.equalsIgnoreCase("N") || conf.equalsIgnoreCase("n")) {
                                System.out.println("Pessoa intacta!");
                            } else {
                                System.out.println("Valor inserido diferente do solicitado.");
                            }
                        } else {
                            System.out.println("Valor inserido diferente do solicitado.");
                        }
                        break;
                    }
                    //exibir todos
                    case 5 :{
                        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                        String tipoPessoa = entrada.next();
                        entrada.nextLine();
                        
                        if (tipoPessoa.equalsIgnoreCase("f") || tipoPessoa.equalsIgnoreCase("F")) {
                            System.out.println("Buscando dados das Pessoas Fisicas...");
                            
                            List<PessoaFisica> pessoas = pfDAO.getPessoas();
                            for (PessoaFisica pf : pessoas) {
                                pf.exibir();
                            }
                        } else if (tipoPessoa.equalsIgnoreCase("j") || tipoPessoa.equalsIgnoreCase("J")) {
                            System.out.println("Buscando dados das Pessoas Juridicas...");
                            
                            List<PessoaJuridica> pessoas = pjDAO.getPessoas();
                            for (PessoaJuridica pj : pessoas) {
                                pj.exibir();
                            }
                        } else {
                            System.out.println("Valor inserido diferente do solicitado.");
                        }
                        break;
                    }
                    case 0 :{
                        System.out.println("Programa encerrado.");
                        break;
                    }
                    default :{
                        System.out.println("Valor inserido diferente do solicitado.");
                        break;
                    }
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada nao permitida: " + e.getMessage());
                break;
            }
        } while (acao != 0);
    }
}
