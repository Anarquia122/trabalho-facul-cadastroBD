/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.DAO;

import cadastroBD.model.PessoaJuridica;
import cadastro.model.util.ConectorBD;
import cadastro.model.util.SequenceManager;

/**
 *
 * @author italo
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {

    public PessoaJuridica getPessoa(int id) {
        PessoaJuridica pessoa = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sqlPessoaJuridica = "SELECT * FROM PessoaJuridica WHERE Pessoa_idPessoa = ?";
            ps = conn.prepareStatement(sqlPessoaJuridica);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            pessoa = new PessoaJuridica();

            if (rs.next()) {
                try {
                    pessoa.setId(rs.getInt("Pessoa_idPessoa"));
                    pessoa.setCnpj(rs.getString("cnpj"));
                } catch (SQLException e) {
                    System.out.println("Erro ao receber os dados da tabela PessoaJuridica: ");
                    e.printStackTrace();
                }
            }

            String sqlPessoa = "SELECT * FROM Pessoa WHERE idPessoa = ?";
            ps = conn.prepareStatement(sqlPessoa);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                try {
                    pessoa.setNome(rs.getString("nome"));
                    pessoa.setLogradouro(rs.getString("logradouro"));
                    pessoa.setCidade(rs.getString("cidade"));
                    pessoa.setEstado(rs.getString("estado"));
                    pessoa.setTelefone(rs.getString("telefone"));
                    pessoa.setEmail(rs.getString("email"));
                } catch (SQLException e) {
                    System.out.println("Erro ao receber os dados da tabela Pessoa: ");
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(ps);
            ConectorBD.close(conn);
        }

        return pessoa;
    }
    
    public List<PessoaJuridica> getPessoas() {
        List<PessoaJuridica> pessoas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT p.idPessoa, p.nome, p.logradouro, p.cidade, p.estado, p.telefone, p.email, pj.cnpj FROM Pessoa p INNER JOIN PessoaJuridica pj ON p.idPessoa = pj.Pessoa_idPessoa";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                PessoaJuridica pessoa = new PessoaJuridica();
                pessoa.setId(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setLogradouro(rs.getString("logradouro"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstado(rs.getString("estado"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setCnpj(rs.getString("cnpj"));

                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(ps);
            ConectorBD.close(conn);
        }

        return pessoas;
    }
    
    public void inserir (PessoaJuridica pessoa) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConectorBD.getConnection();
            conn.setAutoCommit(false);
            
            int pessoaId = SequenceManager.getNextValueA("Pessoa", "idPessoa");

            String sqlPessoa = "INSERT INTO Pessoa (idPessoa, nome, logradouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sqlPessoa, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pessoaId);
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getLogradouro());
            ps.setString(4, pessoa.getCidade());
            ps.setString(5, pessoa.getEstado());
            ps.setString(6, pessoa.getTelefone());
            ps.setString(7, pessoa.getEmail());
            ps.executeUpdate();
            
            int pessoaJuridicaId = SequenceManager.getNextValueA("PessoaJuridica", "idPessoaJuridica");

            String sqlPessoaJuridica = "INSERT INTO PessoaJuridica (idPessoaJuridica, Pessoa_idPessoa, cnpj) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sqlPessoaJuridica);
            ps.setInt(1, pessoaJuridicaId);
            ps.setInt(2, pessoaId);
            ps.setString(3, pessoa.getCnpj());
            ps.executeUpdate();
            
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Erro ao tentar o rollback: ");
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn);
            ConectorBD.close(ps);
        }
    }
    
    public void alterar(PessoaJuridica pessoa) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            int idPessoa = pessoa.getId();
            
            conn = ConectorBD.getConnection();
            String sqlPessoa = "UPDATE Pessoa SET nome=?, logradouro=?, cidade=?, estado=?, telefone=?, email=? WHERE idPessoa=?";
            ps = conn.prepareStatement(sqlPessoa);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getLogradouro());
            ps.setString(3, pessoa.getCidade());
            ps.setString(4, pessoa.getEstado());
            ps.setString(5, pessoa.getTelefone());
            ps.setString(6, pessoa.getEmail());
            ps.setInt(7, idPessoa);
            ps.executeUpdate();

            String sqlPessoaJuridica = "UPDATE PessoaJuridica SET cnpj=? WHERE Pessoa_idPessoa=?";
            ps = conn.prepareStatement(sqlPessoaJuridica);
            ps.setString(1, pessoa.getCnpj());
            ps.setInt(2, idPessoa);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn);
            ConectorBD.close(ps);
        }
    }
    
    public void excluir(int id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConectorBD.getConnection();
            conn.setAutoCommit(false);

            String sqlPessoaJuridica = "DELETE FROM PessoaJuridica WHERE Pessoa_idPessoa = ?";
            ps = conn.prepareStatement(sqlPessoaJuridica);
            ps.setInt(1, id);
            ps.executeUpdate();

            String sqlPessoa = "DELETE FROM Pessoa WHERE idPessoa = ?";
            ps = conn.prepareStatement(sqlPessoa);
            ps.setInt(1, id);
            ps.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Erro ao tentar rollback: ");
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            ConectorBD.close(conn);
            ConectorBD.close(ps);

        }
    }
}
