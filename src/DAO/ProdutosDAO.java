/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Controle.VariaveisDeControle;
import Entidades.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author HP
 */
public class ProdutosDAO {

    public ProdutosDAO() {

    }

    public int pegaIDProduto(String p) {
        p = p.toLowerCase();
        int produto = 0;
        if (p.contains("android")) {
            produto = 37;
        } else if (p.contains("internet security")) {
            if (p.contains("1 ano")) {
                if (p.contains("1 dispositivo")) {
                    produto = 19;
                } else if (p.contains("2 dispositivos")) {
                    produto = 20;
                } else if (p.contains("3 dispositivos")) {
                    produto = 21;
                } else if (p.contains("4 dispositivos")) {
                    produto = 22;
                } else if (p.contains("5 dispositivos")) {
                    produto = 23;
                } else if (p.contains("6 dispositivos")) {
                    produto = 24;
                }
            } else if (p.contains("2 anos")) {
                if (p.contains("1 dispositivo")) {
                    produto = 25;
                } else if (p.contains("2 dispositivos")) {
                    produto = 26;
                } else if (p.contains("3 dispositivos")) {
                    produto = 27;
                } else if (p.contains("4 dispositivos")) {
                    produto = 28;
                } else if (p.contains("5 dispositivos")) {
                    produto = 29;
                } else if (p.contains("6 dispositivos")) {
                    produto = 30;
                }
            } else if (p.contains("3 anos")) {
                if (p.contains("1 dispositivo")) {
                    produto = 31;
                } else if (p.contains("2 dispositivos")) {
                    produto = 32;
                } else if (p.contains("3 dispositivos")) {
                    produto = 33;
                } else if (p.contains("4 dispositivos")) {
                    produto = 34;
                } else if (p.contains("5 dispositivos")) {
                    produto = 35;
                } else if (p.contains("6 dispositivos")) {
                    produto = 36;
                }
            }
        } else if (p.contains("total security")) {
            if (p.contains("1 ano")) {
                if (p.contains("1 dispositivo")) {
                    produto = 1;
                } else if (p.contains("2 dispositivos")) {
                    produto = 2;
                } else if (p.contains("3 dispositivos")) {
                    produto = 3;
                } else if (p.contains("4 dispositivos")) {
                    produto = 4;
                } else if (p.contains("5 dispositivos")) {
                    produto = 5;
                } else if (p.contains("6 dispositivos")) {
                    produto = 6;
                } else if (p.contains("10 dispositivos")) {
                    produto = 50;
                } else if (p.contains("20 dispositivos")) {
                    produto = 39;
                } else if (p.contains("15 dispositivos")) {
                    produto = 51;
                }
            } else if (p.contains("2 anos")) {
                if (p.contains("1 dispositivo")) {
                    produto = 7;
                } else if (p.contains("2 dispositivos")) {
                    produto = 8;
                } else if (p.contains("3 dispositivos")) {
                    produto = 9;
                } else if (p.contains("4 dispositivos")) {
                    produto = 10;
                } else if (p.contains("5 dispositivos")) {
                    produto = 11;
                } else if (p.contains("6 dispositivos")) {
                    produto = 13;
                }
            } else if (p.contains("3 anos")) {
                if (p.contains("1 dispositivo")) {
                    produto = 13;
                } else if (p.contains("2 dispositivos")) {
                    produto = 14;
                } else if (p.contains("3 dispositivos")) {
                    produto = 15;
                } else if (p.contains("4 dispositivos")) {
                    produto = 16;
                } else if (p.contains("5 dispositivos")) {
                    produto = 17;
                } else if (p.contains("6 dispositivos")) {
                    produto = 18;
                } else if (p.contains("7 dispositivos")) {
                    produto = 57;
                }
            }
        } else if (p.contains("small")) {
            if (p.contains("1 ano")) {
                if (p.contains("1 server - kaspersky small office") || p.contains("1 dispositivo")) {
                    produto = 56;
                } else if ((p.contains("5 pcs")&&!p.contains("15 pcs")) || (p.contains("5 dispositivos")&&!p.contains("15 dispositivos"))) {
                    produto = 48;
                } else if (p.contains("10 pcs") || p.contains("10 dispositivos")) {
                    produto = 52;
                } else if (p.contains("15 pcs") || p.contains("15 dispositivos")) {
                    produto = 53;
                } else if (p.contains("20 pcs") || p.contains("20 dispositivos")) {
                    produto = 55;
                }
            } else if (p.contains("2 anos")) {
                if (p.contains("1 dispositivo") || p.contains("1 server - kaspersky small office") || p.contains("1 server 2 anos¹ - kaspersky small office security")) {
                    produto = 45;
                } else if (p.contains("5 pcs")&&(p.contains("5 pcs")&&!p.contains("15 pcs")) || p.contains("5 dispositivos")) {
                    produto = 40;
                } else if (p.contains("10 pcs") || p.contains("10 dispositivos")) {
                    produto = 44;
                } else if (p.contains("15 pcs") || p.contains("15 dispositivos")) {
                    produto = 54;
                } else if (p.contains("20 pcs") || p.contains("20 dispositivos")) {
                    produto = 49;
                }
            }
        }
        return produto;
    }

    public Produtos retornaProduto(int id) {
        Produtos p = new Produtos();
        try {
            PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select * from produtos p where p.id = ?;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p.setTipo(rs.getString("tipo"));
                p.setAnos(rs.getInt("duracao"));
                p.setQtd(rs.getInt("qtd"));
            }
            return p;
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar tipo do produto em ProdutoDAO.retornaProduto: " + ex.getMessage());
            return null;
        }
    }

    public HashMap<Integer, Produtos> getProdutosMap() {
        Produtos p;
        HashMap<Integer, Produtos> mapProd = new HashMap<>();
        try {
            if (VariaveisDeControle.CON == null) {
                return null;
            } else {
                PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select * from produtos");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    p = new Produtos();
                    p.setId(rs.getInt("id"));
                    p.setTipo(rs.getString("tipo"));
                    p.setAnos(rs.getInt("duracao"));
                    p.setQtd(rs.getInt("qtd"));
                    mapProd.put(p.getId(), p);
                }
                return mapProd;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar tipo do produto em ProdutoDAO.retornaProduto: " + ex.getMessage());
            return null;
        }
    }
     public ArrayList<Produtos> getProdutosList() {
        Produtos p;
        ArrayList<Produtos> listProd = new ArrayList<>();
        try {
                PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select * from produtos order by tipo, qtd,duracao;");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    p = new Produtos();
                    p.setId(rs.getInt("id"));
                    p.setTipo(rs.getString("tipo"));
                    p.setAnos(rs.getInt("duracao"));
                    p.setQtd(rs.getInt("qtd"));
                    p.setValor(rs.getDouble("valor"));
                    listProd.add(p);
                }
                return listProd;
            
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar tipo do produto em ProdutoDAO.retornaProduto: " + ex.getMessage());
            return null;
        }
    }
}
