/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl;

import Aph.DAO.ConnectionInit;
import Aph.DAO.ProduitDAO;
import Aph.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Medard
 */
public class ProduitDAOImpl implements ProduitDAO {

    public Produit createProduit(Produit produit) {
        Connection conn = new ConnectionInit().getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO aphrodis.produit(name, quantite) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, produit.getName());
            pstmt.setDouble(2, produit.getQuantité());
            pstmt.executeUpdate();
            return produit;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            try {
                if (!pstmt.isClosed()) {
                    pstmt.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean deleteProduit(int id) {
        Connection conn = new ConnectionInit().getCon();
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM aphrodis.produit WHERE id = '" + id + "'";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                if (!pstmt.isClosed()) {
                    pstmt.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean updateProduit(Produit produit) {
        Connection conn = new ConnectionInit().getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE aphrodis.produit SET name = ?, quantite = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, produit.getName());
            pstmt.setDouble(2, produit.getQuantité());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
                if (!pstmt.isClosed()) {
                    pstmt.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Produit> getAllProduit() {
        Connection conn = new ConnectionInit().getCon();
        ResultSet rs = null;
        List<Produit> prods = new ArrayList<Produit>();

        String sql = "SELECT * FROM aphrodis.produit";
        try {
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                Produit prod = new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                prods.add(prod);
            }
            return prods;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Produit getProduitByName(String name) {
        Connection conn = new ConnectionInit().getCon();
        ResultSet rs = null;
        String sql = "SELECT * FROM aphrodis.produit WHERE name = '" + name + "'";
        try {
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            Produit produit = new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            return produit;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Produit getProduitById(int id) {
        Connection conn = new ConnectionInit().getCon();
        ResultSet rs = null;
        Produit produit = null;
        String sql = "SELECT * FROM aphrodis.produit WHERE id = '" + id + "'";
        try {
            rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
            produit = new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            }
            return produit;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
