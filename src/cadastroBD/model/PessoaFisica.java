/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroBD.model;

/**
 *
 * @author italo
 */
public class PessoaFisica extends Pessoa {
    private String cpf;
    
    public PessoaFisica() {
        super();
    }
    
    public PessoaFisica (int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cpf) {
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cpf = cpf;
    }
    
    //Getter
    
    public String getCpf() {
        return this.cpf;
    }
    
    //Setter
    
    public void setCpf (String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: "+this.cpf);
        System.out.println("--------------------");
    }
}
