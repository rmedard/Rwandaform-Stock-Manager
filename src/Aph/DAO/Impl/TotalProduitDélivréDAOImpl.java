/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl;

import Aph.DAO.ConnectionInit;
import Aph.DAO.TotalProduitDélivréDAO;
import Aph.TotalProduitDélivré;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Medard
 */
public class TotalProduitDélivréDAOImpl implements TotalProduitDélivréDAO {

    private TotalProduitDélivré produit;

    public TotalProduitDélivré createTotalProduitDélivré(TotalProduitDélivré totalProduitDélivré) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "INSERT INTO aphrodis.produit_dispo VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, totalProduitDélivré.getProduitId());
            pstmt.setDouble(2, totalProduitDélivré.getQuantité());
            pstmt.executeUpdate();
            return totalProduitDélivré;
        } catch (SQLException ex) {
            Logger.getLogger(TotalProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
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

    public boolean updateTotalProduitDélivré(TotalProduitDélivré totalProduitDélivré) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "UPDATE aphrodis.produit_dispo SET produitId = ?, quantité = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, totalProduitDélivré.getProduitId());
            pstmt.setDouble(2, totalProduitDélivré.getQuantité());
            pstmt.setInt(3, totalProduitDélivré.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TotalProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
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

    public TotalProduitDélivré getTotalById(int id) {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.produit_dispo WHERE id = '" + id + "'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                produit = new TotalProduitDélivré(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
            }
            return produit;
        } catch (SQLException ex) {
            Logger.getLogger(TotalProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public TotalProduitDélivré getTotalProduitByProduitId(int produitId) {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.produit_dispo WHERE produitId = '" + produitId + "'";
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            produit = new TotalProduitDélivré(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
            return produit;
        } catch (SQLException ex) {
            Logger.getLogger(TotalProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
