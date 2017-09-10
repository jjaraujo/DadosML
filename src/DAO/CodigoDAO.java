/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Controle.VariaveisDeControle;
import Entidades.Codigos;
import Entidades.Desbloqueios;
import Entidades.Produtos;
import Entidades.QtdUsoCodigos;
import Entidades.Vendas;
import Entidades.codigos_has_vendas;
import Visao.Principal;
import com.mysql.jdbc.exceptions.MySQLNonTransientConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 *
 * @author HP
 */
public class CodigoDAO {

    private final Connection con;
    private static boolean situacaoCodigosVerificado = false;
    private PreparedStatement stmtInicial;

    public CodigoDAO() {
        con = VariaveisDeControle.CON;
        getUsoMaximoCodigos();
    }

    private void getUsoMaximoCodigos() {
        try {
            stmtInicial = con.prepareStatement("select * from usocodigos");
            ResultSet rs = stmtInicial.executeQuery();
            QtdUsoCodigos cod = new QtdUsoCodigos();
            while (rs.next()) {
                cod.setQtdMaxTotal(rs.getInt("qtdMaxTotal"));
                cod.setQtdMaxKis(rs.getInt("qtdMaxKis"));
                cod.setDiasMaxTotal1A(rs.getInt("diasMaxTotal1A"));
                cod.setDiasMaxTotal2A(rs.getInt("diasMaxTotal2A"));
                cod.setDiasMaxTotal3A(rs.getInt("diasMaxTotal3A"));
                cod.setDiasMaxKis1A(rs.getInt("diasMaxKis1A"));
                cod.setDiasMaxSmall1A(rs.getInt("diasMaxSmall1A"));
                cod.setDiasMaxSmall2A(rs.getInt("diasMaxSmall2A"));

            }
        } catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
        }catch (SQLException ex) {
            Logger.getLogger(CodigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setUsoMaximoCodigos(int QtdDispMaxTotal, int QtdDispMaxKis, int QtdDiasMaxTotal1A,
            int QtdDiasMaxTotal2A, int QtdDiasMaxTotal3A,
            int QtdDiasMaxKIS1A, int QtdDiasMaxSmall1A, int QtdDiasMaxSmall2A) {
        try {
            PreparedStatement stmt = con.prepareStatement("update qtd_uso_cods set TOTAL1_disp = ?"
                    + ",KIS1_disp = ?,TOTAL1_dias = ?,TOTAL2_dias = ?,TOTAL3_dias = ?,"
                    + "KIS1_dias = ?,SMALL1_dias = ?,SMALL2_dias = ?");
            stmt.setInt(1, QtdDispMaxTotal);
            stmt.setInt(2, QtdDispMaxKis);
            stmt.setInt(3, QtdDiasMaxTotal1A);
            stmt.setInt(4, QtdDiasMaxTotal2A);
            stmt.setInt(5, QtdDiasMaxTotal3A);
            stmt.setInt(6, QtdDiasMaxKIS1A);
            stmt.setInt(7, QtdDiasMaxSmall1A);
            stmt.setInt(8, QtdDiasMaxSmall2A);
            stmt.executeUpdate();
            stmt.close();
        } catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
        }catch (SQLException ex) {
            Logger.getLogger(CodigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Codigos buscaUmCodigo(int id) {
        try {
            PreparedStatement stmt = con.prepareCall("select * from codigos where id = " + id + ";");
            ResultSet rs = stmt.executeQuery();
            Codigos codigo = null;
            while (rs.next()) {
             codigo =   pegaDadosCodigos(rs);
            }
            rs.close();
            stmt.close();
            return codigo;
        }catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
        } catch (SQLException ex) {
            Logger.getLogger(CodigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Codigos> buscaTodosOsCodigos() {
        PreparedStatement stmt;
        ResultSet rs;
        try {
            List<Codigos> listCod = new LinkedList<>();
            stmt = con.prepareStatement("select * from codigos;");
            rs = stmt.executeQuery();
            while (rs.next()) {
                listCod.add(pegaDadosCodigos(rs));
            }
            return listCod;
        } catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
            return null;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public HashMap<Integer,Codigos> buscaTodosOsCodigosMap() {
        PreparedStatement stmt;
        ResultSet rs;
        try {
            HashMap<Integer,Codigos> mapCod = new HashMap<>();
            stmt = con.prepareStatement("select * from codigos;");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Codigos cod = pegaDadosCodigos(rs);
                mapCod.put(cod.getId(),cod);
            }
            return mapCod;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Codigos> buscaTodosOsCodigos(String tipo, String situacao, int anos) {
        PreparedStatement stmt;
        ResultSet rs;
        try {
            ArrayList<Codigos> listCod = new ArrayList<>();
            stmt = con.prepareStatement("select * from codigos where tipo = ?" + situacao + " and duracao = ? order by id and data_expiracao;");
            stmt.setString(1, tipo);
            stmt.setInt(2, anos);
            rs = stmt.executeQuery();
            while (rs.next()) {
                listCod.add(pegaDadosCodigos(rs));
            }
            stmt.close();
            rs.close();
            return listCod;
        }catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
            return null;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Codigos getCodigosPorCodigo(String sequencia) {
        try {
            PreparedStatement stmt = con.prepareStatement("select * from codigos where codigo like ? or codigo_substituido like ? order by id;");
            stmt.setString(1, "%" + sequencia + "%");
            stmt.setString(2, "%" + sequencia + "%");
            ResultSet rs = stmt.executeQuery();
            Codigos cod = new Codigos();
            while (rs.next()) {
            cod = pegaDadosCodigos(rs);
            }
            rs.close();
            stmt.close();
            return cod;
        }catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Codigos> getCodigosUtilizaveis() {
        ArrayList<Codigos> listCodUtilizaveis = new ArrayList<>();
        ArrayList<Codigos> listTodosCod1 = new ArrayList<>();
        ArrayList<Codigos> listTodosCod2;
        QtdUsoCodigos qtdUso = new QtdUsoCodigosDAO().getQtdUsada();
        try {
            PreparedStatement stmt = con.prepareStatement("select * from codigos where situacao like 'UTILIZANDO';");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listTodosCod1.add(pegaDadosCodigos(rs));
            }

            listTodosCod2 = verificaDesbloqueioEQuantidadeUsada(listTodosCod1);
            System.out.println("listTodosCod2 isEmpty:" + listTodosCod2.isEmpty());
            for (Codigos c : listTodosCod1) {
                System.out.println("Código: " + c.getCodigo() + ". Tipo codigo: " + c.getTipo());
                if (controlaSituacaoCodigos(c, qtdUso)) {
                    setSituacaoCodigo("REPOSICAO", c.getId());
                    System.out.println("Entrou no if para mudar a situacao: " + c.getCodigo());
                } else {
                    System.out.println("Código "+ c.getCodigo() +" livre para uso ");
                    listCodUtilizaveis.add(c);
                }
            }
        } catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listCodUtilizaveis;
    }

    public void setQtdUsadaCodigo(int id, int qtd) {
        try {
            PreparedStatement stmt = con.prepareStatement("update codigos c set c.qtd_usada = c.qtd_usada + ? where c.id = ?;");
            stmt.setInt(1, qtd);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            stmt.close();

        }catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
        } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "Erro na transação em ClienteDAO.adicionar_qtd_usada_codigo! Erro: " + ex);
        }
    }

    public void adicionar_valor_venda_no_codigo(Vendas v, int id) {
        codigos_has_vendas chv = new Codigos_has_vendasDAO().getUmaVenda(v.getId(), id);
        double qtddispvenda = chv.getQtd();
        double valordispositivo = v.getValorPorDispositivo();
        double valordispositivodesc = v.getValorPorDispositivoDesconto();
        try {
            PreparedStatement stmt = con.prepareStatement("update codigos c set c.valor_total_vendas = "
                    + "c.valor_total_vendas + (? * ?) where c.id = ?");
            stmt.setDouble(1, valordispositivo);
            stmt.setDouble(2, qtddispvenda);
            stmt.setInt(3, id);
            PreparedStatement stmt2 = con.prepareStatement("update codigos c set c.valor_total_lucro ="
                    + " c.valor_total_lucro + (? * ?) where c.id = ?;");
            stmt.setDouble(1, valordispositivodesc);
            stmt.setDouble(2, qtddispvenda);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            stmt2.executeUpdate();
        } catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
        } catch (SQLException ex) {
            Logger.getLogger(CodigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean controlaSituacaoCodigos(Codigos c, QtdUsoCodigos qtdUso) {
        int anos = c.getDuracao();
        String tipo = c.getTipo();
        LocalDate expiracao = LocalDate.parse(c.getData_expiracao());
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate hoje = LocalDate.parse(formatarDate.format(data));
        int diasRestantes = getDiasRestantes(hoje, expiracao);
        int qtd_usada = c.getQtd_usada();
        if (tipo.toLowerCase().equals("total")) {
            if (qtd_usada > qtdUso.getQtdMaxTotal()) {
                System.out.println("Qtd usada no codigo " + c.getCodigo() + " maior que o permitido: " + qtd_usada);
                return true;
            } else {
                if (anos == 1 && (diasRestantes < qtdUso.getDiasMaxTotal1A())) {
                    System.out.println("true total, ano 1, dias menores que o permitido");
                    return true;
                }
                if (anos == 2 && (diasRestantes < qtdUso.getDiasMaxTotal2A())) {
                    System.out.println("true total, anos 2, dias menores que o permitido");
                    return true;
                }
                if (anos == 3 && (diasRestantes < qtdUso.getDiasMaxTotal3A())) {
                    System.out.println("true total, ano 3, dias menores que o permitido");
                    return true;
                }
            }
        }
        if ((tipo.toLowerCase().equals("kis") || tipo.toLowerCase().equals("android")) && ((qtd_usada >= qtdUso.getQtdMaxKis()) || (diasRestantes < qtdUso.getDiasMaxKis1A()))) {
            System.out.println("true kis, ano 1, dias menores que o permitido ou qtd usada maior - ID COD1: " + c.getId());
            return true;
        }
        if (tipo.toLowerCase().equals("small")) {
            if (anos == 1 && (diasRestantes < qtdUso.getDiasMaxSmall1A())) {
                System.out.println("Entro aqui no if do small no metodo controlaSituacaoCodigos");
                return true;
            }
            if (anos == 2 && (diasRestantes < qtdUso.getDiasMaxSmall2A())) {
                System.out.println("true total, ano 2, dias menores que o permitido");
                return true;
            }
        }
        return false;
    }

    private ArrayList<Codigos> verificaDesbloqueioEQuantidadeUsada(ArrayList<Codigos> list1) {
        System.out.println("verificaDesbloqueioEQuantidadeUsada");
        DesbloqueioDAO desbloqueioDAO = new DesbloqueioDAO();
        HashMap<Integer, Integer> map = desbloqueioDAO.getDesbloqueiosPorVariosID(list1);
        ArrayList<Codigos> list2 = new ArrayList<>();
        for (Codigos c : list1) {
            System.out.println("Id do código:" + c.getId() + " Qtd usada:" + c.getQtd_usada());
            if (c.getTipo().toLowerCase().equals("kis") || c.getTipo().toLowerCase().equals("android")) {
                if (!map.containsKey(c.getId()) && c.getQtd_usada() > 100) {
                        // nao faz nada
                } else if (map.containsKey(c.getId()) && (map.get(c.getId()) == 1 && c.getQtd_usada() > 140)) {
                     // nao faz nada
                } else if (map.containsKey(c.getId()) && map.get(c.getId()) == 2) {
                     // nao faz nada
                } else {
                    list2.add(c);
                }
            } else if (c.getTipo().toLowerCase().equals("total")) {
                if (map.containsKey(c.getId()) && (map.containsKey(c.getId()) && c.getQtd_usada() > 50)) {

                } else if (map.containsKey(c.getId()) && (map.get(c.getId()) == 1 && c.getQtd_usada() > 60)) {

                } else if (map.containsKey(c.getId()) && map.get(c.getId()) == 2) {
                    list2.add(c);
                } else {
                    list2.add(c);
                }
            } else if (c.getTipo().toLowerCase().equals("small")) {
                list2.add(c);
            } else {

            }
        }
        return list2;
    }

    private int getDiasRestantes(LocalDate hoje, LocalDate expiracao) {
        return Days.daysBetween(hoje, expiracao).getDays();
    }

    public void setSituacaoCodigo(String situacao, int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("update codigos set situacao = ? where id = ?;");
            stmt.setString(1, situacao);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
        } catch (SQLException ex) {
            System.err.println("Erro em CodigoDQAO.setSituacaoCodigo: " + ex.getMessage());
            
        }
        //Coloca a conexão como autoCommit    
        
    }

    // metodo para verificar se a quantidade de usos do código é compativel com a quantidade de desbloqueios
    public void updateQtdUsadaCodigo(int id) {
        int qtd;
        try {
            PreparedStatement stmt = con.prepareStatement("select sum(chv.qtd_dispositivos) qtd_dispositivos from codigos_has_vendas chv join vendas v on v.id = chv.id_venda where chv.id_codigo = ? and v.cancelada is null;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                qtd = rs.getInt("qtd_dispositivos");
                PreparedStatement stmt2 = con.prepareStatement("update codigos set qtd_usada = ? where id = ?");
                stmt2.setInt(2, id);
                stmt2.setInt(1, qtd);
                stmt2.executeUpdate();
            }
            System.out.println("Atualização concluida");
        } catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
        }catch (SQLException ex1) {
            System.err.println("Erro na transação de adicionar qtd do código " + id + ":" + ex1.getMessage());
            ex1.printStackTrace();
        }
    }

    public void updateQtdUsadaCodigo() {
        int id = 0;
        try {
            PreparedStatement stmt = con.prepareStatement("select id from codigos;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PreparedStatement stmt2 = con.prepareStatement("select sum(chv.qtd_dispositivos) qtd_dispositivos from codigos_has_vendas chv join vendas v on v.id = chv.id_venda where chv.id_codigo = ? and v.cancelada is null;");
                id = rs.getInt("id");
                stmt2.setInt(1, id);
                ResultSet rs1 = stmt2.executeQuery();
                while (rs1.next()) {
                    int qtd = rs1.getInt("qtd_dispositivos");
                    PreparedStatement stmt3 = con.prepareStatement("update codigos set qtd_usada = ? where id = ?");
                    stmt3.setInt(2, id);
                    stmt3.setInt(1, qtd);
                    stmt3.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null, "Atualização concluida");
        } catch(MySQLNonTransientConnectionException e){
            new Principal().dialogAutenticacao();
        }catch (SQLException ex1) {
            System.err.println("Erro na transação de adicionar qtd do código " + id + ":" + ex1.getMessage());
            ex1.printStackTrace();
        }
    }
    public ArrayList<Codigos> getCodigosProximosExpirar(){
       ArrayList list = new ArrayList();
       try {
            PreparedStatement stmt = con.prepareStatement("select * from codigos where data_expiracao = ? or data_expiracao = ?;");
            stmt.setString(1, somaDias(5));
            stmt.setString(2, somaDias(15));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                list.add(pegaDadosCodigos(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CodigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    private String somaDias(int dias) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate hoje = LocalDate.parse(formatarDate.format(date));
        return hoje.plusDays(dias).toString();
    }
    
    private Codigos pegaDadosCodigos(ResultSet rs){
        Codigos cod = new Codigos();
        try {            
            cod.setId(rs.getInt("id"));
            cod.setCodigo(rs.getString("codigo"));
            cod.setPedido(rs.getString("pedido"));
            cod.setQtd_usada(rs.getInt("qtd_usada"));
            cod.setData_compra(rs.getString("data_compra"));
            cod.setData_expiracao(rs.getString("data_expiracao"));
            cod.setQtd_usada(rs.getInt("qtd_usada"));
            cod.setTipo(rs.getString("tipo"));
            cod.setDispositivos(rs.getInt("dispositivos"));
            cod.setDuracao(rs.getInt("duracao"));
            cod.setNome(rs.getString("nome"));
            cod.setEmail(rs.getString("email"));
            cod.setSuspeito(rs.getString("suspeito_de_revenda"));
            cod.setSenha_mykaspersky(rs.getString("senha_mykaspersky"));
        } catch (SQLException ex) {
            Logger.getLogger(CodigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cod;
    }
}
