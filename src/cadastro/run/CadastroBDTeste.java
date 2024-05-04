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
import java.util.List;

//Nome - Logradouro - Cidade - Estado - Telefone - Email - Cpf
//Nome - Logradouro - Cidade - Estado - Telefone - Email - Cnpj
public class CadastroBDTeste {

    public static void main(String[] args) {
        PessoaFisica pessoaF = new PessoaFisica();
        pessoaF.setNome("Luffy");
        pessoaF.setLogradouro("Maca");
        pessoaF.setCidade("Lapa");
        pessoaF.setEstado("GO");
        pessoaF.setTelefone("1234-5678");
        pessoaF.setEmail("luffy@email.com");
        pessoaF.setCpf("12345678900");

        PessoaFisicaDAO pessoaFDao = new PessoaFisicaDAO();
        //pessoaFDao.inserir(pessoaF);

        //pessoaFDao.excluir(10);
        //pessoaFDao.excluir(15);
        
        List<PessoaFisica> pessoasFisicas = pessoaFDao.getPessoas();
        System.out.println("Pessoas Fisicas: ");
        for (PessoaFisica pf : pessoasFisicas) {
            pf.exibir();
        }

        PessoaJuridica pessoaJ = new PessoaJuridica();
        pessoaJ.setNome("Baratie");
        pessoaJ.setLogradouro("East Blue");
        pessoaJ.setCidade("Rio");
        pessoaJ.setEstado("OP");
        pessoaJ.setTelefone("1111-1111");
        pessoaJ.setEmail("sanji@opmail.com");
        pessoaJ.setCnpj("1111111111/1111");

        PessoaJuridicaDAO pessoaJDao = new PessoaJuridicaDAO();
        //pessoaJDao.inserir(pessoaJ);

        //pessoaJDao.excluir(14);
        
        List<PessoaJuridica> pessoasJuridicas = pessoaJDao.getPessoas();
        System.out.println("Pessoas Juridicas: ");
        for (PessoaJuridica pj : pessoasJuridicas) {
            pj.exibir();
        }
    }
}
