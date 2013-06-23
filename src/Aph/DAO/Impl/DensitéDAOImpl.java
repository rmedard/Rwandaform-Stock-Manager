/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl;

import Aph.DAO.ConnectionInit;
import Aph.DAO.DensitéDAO;
import Aph.DAO.Impl.UI.DAOS;
import Aph.Densité;
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
public class DensitéDAOImpl implements DensitéDAO {

    private Densité densité;
    private Object[][] consommation;
    private DAOS daos;

    public DensitéDAOImpl() {
    }

    public DAOS getDaos() {
        return daos;
    }

    public Densité createDensité(Densité densité) {
        ConnectionInit connectionInit = new ConnectionInit();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = connectionInit.getCon();
            conn.setAutoCommit(false);
            String sql1 = "INSERT INTO aphrodis.densite (nom) VALUES (?)";
            pstmt = conn.prepareStatement(sql1);
            pstmt.setString(1, densité.getName());
            pstmt.executeUpdate();
            conn.commit();

            String numProduit = "SELECT COUNT(p.id) FROM produit p";
            rs = conn.createStatement().executeQuery(numProduit);
            rs.next();
            for (int i = 0; i <= rs.getInt(1); i++) {
                String sql2 = "INSERT INTO aphrodis.densite_produit (densite_id, produit_id, consom_min) VALUES (?,?,?)";
                pstmt = conn.prepareStatement(sql2);
                pstmt.setInt(1, densité.getId());
                pstmt.setObject(2, getDaos().getMatièrePremièreDAO().getMatièrePremièreByName(densité.getConsommation()[i][0].toString()));
                pstmt.setObject(3, densité.getConsommation()[i][1]);
                pstmt.executeUpdate();
                conn.commit();
            }
            conn.setAutoCommit(true);
            return densité;
        } catch (SQLException ex) {
            Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
                if (!pstmt.isClosed()) {
                    pstmt.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean updateDensité(Densité densité, Produit produit) {
        ConnectionInit connectionInit = new ConnectionInit();
        ProduitDAOImpl produitDAOImpl = new ProduitDAOImpl();
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        try {
            conn = connectionInit.getCon();
            conn.setAutoCommit(false);
            if (produit == null) {
                String sql = "UPDATE aphrodis.densite SET nom = ? WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, densité.getName());
                pstmt.setInt(2, densité.getId());
                pstmt.executeUpdate();
                conn.commit();
                String sql1 = "UPDATE aphrodis.densite_produit SET consom_min = ? WHERE densite_id = ? AND produit_id = ?";
                pstmt1 = conn.prepareStatement(sql1);
                for (int i = 0; i < densité.getConsRowNum(); i++) {
                    pstmt1.setDouble(1, Double.parseDouble(densité.getConsommation()[i][1].toString()));
                    pstmt1.setInt(2, densité.getId());
                    pstmt1.setInt(3, produitDAOImpl.getProduitByName(densité.getConsommation()[i][0].toString()).getId());
                    pstmt1.executeUpdate();
                    conn.commit();
                }
            } else {
                String sql = "INSERT INTO aphrodis.densite_produit (densite_id, produit_id, consom_min) VALUES (?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, densité.getId());
                pstmt.setInt(2, produit.getId());
                pstmt.setDouble(3, 0.0);
                pstmt.executeUpdate();
                conn.commit();
            }
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (produit == null) {
                    if (!pstmt1.isClosed()) {
                        pstmt1.close();
                    }
                } else {
                    if (!pstmt.isClosed()) {
                        pstmt.close();
                    }
                }

                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    public boolean deleteDensité(int id) {
        ConnectionInit connectionInit = new ConnectionInit();
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = connectionInit.getCon();
            String sql = "DELETE FROM aphrodis.densite WHERE id = '" + id + "'";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Densité> getAllDensité() {
        List<Densité> densités = new ArrayList<Densité>();
        List<String> pNames = new ArrayList<String>();
        List<Double> cons = new ArrayList<Double>();
        ConnectionInit connectionInit = new ConnectionInit();
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = connectionInit.getCon();
            String sql = "SELECT d.id, d.nom, p.name, dp.consom_min FROM densite d, produit p, densite_produit dp "
                    + "WHERE (d.id = dp.densite_id AND p.id = dp.produit_id) ORDER BY id";
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt(1);
            String nom = rs.getString(2);
            rs.beforeFirst();
            while (rs.next()) {
                String nomTest = rs.getString(2);
                if (nom.equals(nomTest)) {
                    pNames.add(rs.getString(3));
                    cons.add(rs.getDouble(4));
                    if (rs.isLast()) {
                        consommation = new Object[pNames.size()][2];
                        for (int i = 0; i < pNames.size(); i++) {
                            consommation[i][0] = pNames.get(i);
                            consommation[i][1] = cons.get(i);
                        }
                        densité = new Densité(id, nom, consommation, pNames.size());
                        densités.add(densité);
                    }
                } else {
                    consommation = new Object[pNames.size()][2];
                    for (int i = 0; i < pNames.size(); i++) {
                        consommation[i][0] = pNames.get(i);
                        consommation[i][1] = cons.get(i);
                    }
                    densité = new Densité(id, nom, consommation, pNames.size());
                    densités.add(densité);
                    nom = nomTest;
                    id = rs.getInt(1);
                    pNames = new ArrayList<String>();
                    cons = new ArrayList<Double>();
                    if (!rs.isLast()) {
                        rs.previous();
                    }
                }
            }
            return densités;
        } catch (SQLException ex) {
            Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Densité getDensitéByName(String name) {
        ConnectionInit connectionInit = new ConnectionInit();
        Connection conn = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        int i = 0;
        try {
            conn = connectionInit.getCon();
            String object = "SELECT d.id, d.nom, p.name, dp.consom_min FROM densite d, produit p, densite_produit dp "
                    + "WHERE (d.id = dp.densite_id AND p.id = dp.produit_id AND d.nom = '" + name + "')";
            String rowCount = "SELECT COUNT(p.id) FROM produit p";
            rs1 = conn.createStatement().executeQuery(object);
            rs2 = conn.createStatement().executeQuery(rowCount);
            rs1.next();
            rs2.next();
            int densId = rs1.getInt(1);
            String densName = rs1.getString(2);
            rs1.beforeFirst();
            consommation = new Object[rs2.getInt(1)][2];
            while (rs1.next()) {
                consommation[i][0] = rs1.getString(3);
                consommation[i][1] = rs1.getString(4);
                ++i;
            }
            densité = new Densité(densId, densName, consommation, rs2.getInt(1));
            return densité;
        } catch (SQLException ex) {
            Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (!rs1.isClosed()) {
                    rs1.close();
                }
                if (!rs2.isClosed()) {
                    rs2.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Densité getDensitéById(int id) {
        ConnectionInit connectionInit = new ConnectionInit();
        Connection conn = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        int i = 0;
        try {
            conn = connectionInit.getCon();
            String object = "SELECT d.id, d.nom, p.name, dp.consom_min FROM densite d, produit p, densite_produit dp "
                    + "WHERE (d.id = dp.densite_id AND dp.densite_id = '" + id + "' AND p.id = dp.produit_id)";
            String rowCount = "SELECT COUNT(p.id) FROM produit p";
            rs1 = conn.createStatement().executeQuery(object);
            rs2 = conn.createStatement().executeQuery(rowCount);
            rs1.next();
            rs2.next();
            int densId = rs1.getInt(1);
            String densName = rs1.getString(2);
            rs1.beforeFirst();
            consommation = new Object[rs2.getInt(1)][2];
            while (rs1.next()) {
                consommation[i][0] = rs1.getString(3);
                consommation[i][1] = rs1.getString(4);
                ++i;
            }
            densité = new Densité(densId, densName, consommation, rs2.getInt(1));
            return densité;
        } catch (SQLException ex) {
            Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (!rs1.isClosed()) {
                    rs1.close();
                }
                if (!rs2.isClosed()) {
                    rs2.close();
                }
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DensitéDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
