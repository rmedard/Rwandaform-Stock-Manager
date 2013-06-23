/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl;

import Aph.DAO.ConnectionInit;
import Aph.DAO.ProduitDélivréDAO;
import Aph.MatièrePremière;
import Aph.Produit;
import Aph.ProduitDélivré;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Medard
 */
public class ProduitDélivréDAOImpl implements ProduitDélivréDAO {

    private ProduitDélivré produit;

    public ProduitDélivré createProduitDélivré(ProduitDélivré produitDélivré) {
        PreparedStatement pstmt = null;
        PreparedStatement ps = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO aphrodis.requisition_Produit (techn_id, produit_id, quantite)VALUES (?, ?, ?)";
            String sql1 = "UPDATE aphrodis.produit_dispo SET quantité = ? WHERE produitId = '" + produitDélivré.getProduit_id() + "'";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, produitDélivré.getDélivreur_id());
            pstmt.setInt(2, produitDélivré.getProduit_id());
            pstmt.setDouble(3, produitDélivré.getQuantité());
            pstmt.executeUpdate();
            conn.commit();

            ps = conn.prepareStatement(sql1);
            ps.setDouble(1, new TotalProduitDélivréDAOImpl().getTotalById(produitDélivré.getProduit_id()).getQuantité() + produitDélivré.getQuantité());
            ps.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);

            List<MatièrePremière> delivrés = new MatièrePremièreDAOImpl().getMatièrePremièreByProduitId(produitDélivré.getProduit_id());
            for (MatièrePremière mat : delivrés) {
                Produit prod = new ProduitDAOImpl().getProduitById(mat.getProductId());
                double matQuant = mat.getQuantity();
                double matDelvQuant = produitDélivré.getQuantité();
                double matActualQuant = matQuant - matDelvQuant;
                if (matActualQuant < 0.0) {
                    mat.setQuantity(0.0);
                    produitDélivré.setQuantité(matDelvQuant - matQuant);
                    new MatièrePremièreDAOImpl().updateMatièrePremière(prod, mat);
                } else {
                    mat.setQuantity(matActualQuant);
                    new MatièrePremièreDAOImpl().updateMatièrePremière(prod, mat);
                    break;
                }
            }
            return produitDélivré;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (!pstmt.isClosed()) {
                    pstmt.close();
                }
                if (!ps.isClosed()) {
                    ps.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public boolean deleteProduitDélivré(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<ProduitDélivré> getAllProduitDélivré() {
        List<ProduitDélivré> prods = new ArrayList<ProduitDélivré>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.requisition_produit ORDER BY date";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                produit = new ProduitDélivré(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5));
                prods.add(produit);
            }
            return prods;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public ProduitDélivré getProduitDélivréByLivraisonId(int id) {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.requisition_produit WHERE id = '" + id + "' ORDER BY date";
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            produit = new ProduitDélivré(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5));
            return produit;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<ProduitDélivré> getProduitDélivréByDélivreur(int délivreurId) {
        List<ProduitDélivré> produits = new ArrayList<ProduitDélivré>();
        ProduitDélivré prod;
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        String sql = "SELECT * FROM aphrodis.requisition_produit WHERE techn_id = '" + délivreurId + "' ORDER BY date";
        try {
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                prod = new ProduitDélivré(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5));
                produits.add(prod);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<ProduitDélivré> getProduitDélivréByProduitId(int id) {
        List<ProduitDélivré> produits = new ArrayList<ProduitDélivré>();
        ProduitDélivré prod;
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        String sql = "SELECT * FROM aphrodis.requisition_produit WHERE produit_id = '" + id + "' ORDER BY date";
        try {
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                prod = new ProduitDélivré(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5));
                produits.add(prod);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean updateProduitDélivré(ProduitDélivré produitDélivré) {
        String sql = "UPDATE aphrodis.requisition_produit SET quantite = ? WHERE id = ?";
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {

            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, produitDélivré.getQuantité());
            pstmt.setInt(2, produitDélivré.getId());
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<ProduitDélivré> getProduitDélivréByPeriod(Date since, Date until) {
        List<ProduitDélivré> produits = new ArrayList<ProduitDélivré>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        String sql = "SELECT * FROM aphrodis.requisition_produit WHERE date BETWEEN '" + since + "' AND '" + until + "' ORDER BY date";
        try {
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                ProduitDélivré prod = new ProduitDélivré(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5));
                produits.add(prod);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<ProduitDélivré> getProduitDélivréByPeriodAndDélivreur(int délivreurId, Date since, Date until) {
        List<ProduitDélivré> produits = new ArrayList<ProduitDélivré>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        String sql = "SELECT * FROM aphrodis.requisition_produit WHERE techn_id = '" + délivreurId + "' AND date BETWEEN '" + since + "' AND '" + until + "' ORDER BY date";
        try {
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                ProduitDélivré prod = new ProduitDélivré(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5));
                produits.add(prod);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
