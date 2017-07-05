/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controle.VariaveisDeControle;
import Entidades.Cliente;
import Visao.Principal;
import com.email.EmailService;
import com.mysql.jdbc.exceptions.MySQLNonTransientConnectionException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ClienteDAO {

    private PreparedStatement stmt;
    private Connection con;
    private ResultSet rs;

    public ClienteDAO() {
        con = VariaveisDeControle.CON;
    }

    public Cliente buscaCliente(String apelido) {

        try {
            stmt = con.prepareStatement("select email,inativo,confirmado from clientes_ml where apelido like '" + apelido + "';");
            rs = stmt.executeQuery();
            Cliente cliente = new Cliente();
            while (rs.next()) {
                cliente.setEmail(rs.getString("email"));
                cliente.setInativo(rs.getString("inativo"));
                cliente.setConfirmado(rs.getString("confirmado"));
                cliente.setRevendedor_assitencia("revendedor_assistencia");
            }
            rs.close();
            stmt.close();
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private boolean verificaClienteCadastrado(String apelido) {
        try {
            stmt = con.prepareStatement("select * from clientes_ml where apelido like ?");
            stmt.setString(1, "%" + apelido + "%");
            rs = stmt.executeQuery();
            return rs.first();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar se cliente já está cadastrado");
            return true;
        }
    }

    public boolean verificaClienteRevendedor(String apelido) {
        try {
            stmt = con.prepareStatement("select revendedor_assistencia from clientes_ml where apelido like ?");
            stmt.setString(1, "" + apelido + "");
            rs = stmt.executeQuery();
            String i = null;
            while (rs.next()) {
                i = rs.getString("revendedor_assistencia");

            }
            if (i != null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar se cliente já está cadastrado");
            return true;
        }
    }

    public void cadastrarCliente(Cliente c) {
        HashSet<Cliente> hs = new HashSet<>();
        hs.add(c);
        cadastrarCliente(hs);
    }

    public void cadastrarCliente(HashSet<Cliente> c) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (Cliente clt : c) {
                        if (!verificaClienteCadastrado(clt.getApelido())) {
                            stmt = con.prepareStatement("insert into clientes_ml(apelido,nome,email,cpf,estado,telefone) values(?,?,?,?,?,?);");
                            stmt.setString(1, clt.getApelido());
                            stmt.setString(2, clt.getNome());
                            stmt.setString(3, clt.getEmail());
                            stmt.setString(4, clt.getCpf());
                            stmt.setString(5, clt.getEstado());
                            stmt.setString(6, clt.getTelefone());
                            stmt.executeUpdate();
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Clientes cadastrados com sucesso");

                } catch (MySQLNonTransientConnectionException ex) {
                    new Principal().dialogAutenticacao();
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "Erro na transação! DAO.ClienteDAO().cadastrarCliente: " + ex.getMessage());
                } 
            }
        }).start();
    }

    public ArrayList<Cliente> getClientesRevendedores() {
        ArrayList<Cliente> set = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("select * from clientes_ml where revendedor_assistencia is not null and inativo is null;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente c1 = new Cliente();
                c1.setEmail(rs.getString("email"));
                c1.setApelido(rs.getString("apelido"));
                c1.setNome(rs.getString("nome"));

                set.add(c1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (MessagingException ex) {
//            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Cliente c : set) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String corpo = "Olá, " + c.getNome() + "(" + c.getApelido() + "), boa noite! Temos uma grande novidade para você: o nosso programa de fidelidades voltou!!! A cada 5 compras de produtos Kaspersky, você ganha um produto igual. Sem sorteio, sem pegadinha. Comprou, ganhou! :D\n"
                            + "Você pode verificar o regulamento aqui no Google Driver: https://drive.google.com/open?id=0B1fHjqINGZdoWHpLSDFGQktWcHM (se não conseguir, informe-nos). Qualquer dúvida, estamos a disposição!";
                    try {
                        EmailService email = new EmailService(c.getEmail(), "Novo programa de fidelidade para revendedores Kaspersky ", corpo);
                        email.sendEmail();
                    } catch (IOException ex) {
                        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MessagingException ex) {
                        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }).start();
        }
        return set;
    }

    public void setNumeroConfimado(String apelido) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE clientes_ml SET confirmado ='sim' WHERE apelido like ?;");
            stmt.setString(1, apelido);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao adicionar numero confirmado no cliente " + apelido);
        }
    }
}
