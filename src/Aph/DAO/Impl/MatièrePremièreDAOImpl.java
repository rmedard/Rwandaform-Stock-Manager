/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl;

import Aph.DAO.ConnectionInit;
import Aph.DAO.MatièrePremièreDAO;
import Aph.MatièrePremière;
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
public class MatièrePremièreDAOImpl implements MatièrePremièreDAO {

    public MatièrePremièreDAOImpl() {
    }

    public MatièrePremière createMatièrePremière(Produit produit, MatièrePremière matièrePremière) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql1 = "INSERT INTO aphrodis.produit_details(product_id, origine, dateProduction, dateExpiration, quantité) VALUES "
                    + "((SELECT id FROM aphrodis.produit WHERE id = '" + produit.getId() + "'),'" + matièrePremière.getOrigine() + "','" + matièrePremière.getDateProduction() + "','" + matièrePremière.getDateExpiration() + "','" + matièrePremière.getQuantity() + "')";
            pstmt = conn.prepareStatement(sql1);
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return matièrePremière;
        } catch (SQLException ex) {
            Logger.getLogger(MatièrePremièreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean deleteMatièrePremière(int id) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "DELETE FROM aphrodis.produit WHERE id = \'" + id + "\'";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MatièrePremièreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean updateMatièrePremière(Produit produit, MatièrePremière matièrePremière) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "UPDATE aphrodis.produit_details SET origine= ?, dateProduction = ?, dateExpiration = ?, quantité = ? WHERE id = ?";
            String sql1 = "UPDATE aphrodis.produit SET name = '" + produit.getName() + "',quantite = (SELECT SUM(quantité) FROM aphrodis.produit_details WHERE product_id = '" + produit.getId() + "') WHERE id= ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, matièrePremière.getOrigine());
            pstmt.setDate(2, matièrePremière.getDateProduction());
            pstmt.setDate(3, matièrePremière.getDateExpiration());
            pstmt.setDouble(4, matièrePremière.getQuantity());
            pstmt.setInt(5, matièrePremière.getId());
            pstmt.executeUpdate();
            conn.commit();

            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setInt(1, produit.getId());
            pstmt1.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MatièrePremièreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<MatièrePremière> getAllMatièrePremière() {
        List<MatièrePremière> produits = new ArrayList<MatièrePremière>();
        MatièrePremière produit = null;
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.produit_details ORDER BY product_id";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                produit = new MatièrePremière(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getDouble(6));
                produits.add(produit);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(MatièrePremièreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<MatièrePremière> getMatièrePremièreByName(String name) {
        List<MatièrePremière> produits = new ArrayList<MatièrePremière>();
        MatièrePremière produit = null;
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.produit WHERE name = '" + name + "'";
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            String sql1 = "SELECT product_id, origine, dateProduction, dateExpiration, quantité FROM aphrodis.produit_details WHERE product_id = '" + rs.getInt(1) + "'";
            ResultSet rs1 = conn.createStatement().executeQuery(sql1);
            while (rs1.next()) {
                produit = new MatièrePremière(rs1.getInt(1), rs1.getString(2), rs1.getDate(3), rs1.getDate(4), rs1.getDouble(5));
                produits.add(produit);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(MatièrePremièreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<MatièrePremière> getMatièrePremièreByOrigine(String origine) {
        List<MatièrePremière> produits = new ArrayList<MatièrePremière>();
        MatièrePremière produit = null;
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT product_id, origine, dateProduction, dateExiration, quantité FROM aphrodis.produit_details WHERE origine = '" + origine + "'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {

                produit = new MatièrePremière(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDouble(5));
                produits.add(produit);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(MatièrePremièreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<MatièrePremière> getMatièrePremièreByProduitId(int id) {
        List<MatièrePremière> mats = new ArrayList<MatièrePremière>();
        MatièrePremière produit = null;
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        String sql = "SELECT * FROM aphrodis.produit_details WHERE product_id = '" + id + "' ORDER BY dateExpiration";
        try {
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                produit = new MatièrePremière(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getDouble(6));
                mats.add(produit);
            }
            return mats;
        } catch (SQLException ex) {
            Logger.getLogger(MatièrePremièreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public MatièrePremière getMatièrePremièreById(int id) {
        MatièrePremière mat = null;
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        String sql = "SELECT * FROM aphrodis.produit_details WHERE id = '" + id + "'";
        try {
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            mat = new MatièrePremière(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getDouble(6));
            return mat;
        } catch (SQLException ex) {
            Logger.getLogger(MatièrePremièreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
