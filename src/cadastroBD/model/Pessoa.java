/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroBD.model;

/**
 *
 * @author italo
 */
public class Pessoa {
    private int id;
    private String nome;
    private String logradouro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    
    public Pessoa() {}
    
    public Pessoa (int id, String nome, String logradouro, String cidade, String estado, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
    }
    
    //Getters
    
    public int getId() {
        return this.id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getLogradouro() {
        return this.logradouro;
    }
    
    public String getCidade() {
        return this.cidade;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    //Setters
    
    public void setId (int id) {
        this.id = id;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public void setLogradouro (String logradouro) {
        this.logradouro = logradouro;
    }
    
    public void setCidade (String cidade) {
        this.cidade = cidade;
    }
    
    public void setEstado (String estado) {
        this.estado = estado;
    }
    
    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public void exibir() {
        System.out.println("--------------------");
        System.out.println("ID: "+this.id);
        System.out.println("Nome: "+this.nome);
        System.out.println("Logradouro: "+this.logradouro);
        System.out.println("Cidade: "+this.cidade);
        System.out.println("Estado: "+this.estado);
        System.out.println("Telefone: "+this.telefone);
        System.out.println("E-mail: "+this.email);
    }
}
