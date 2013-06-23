/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl;

import Aph.DAO.ConnectionInit;
import Aph.DAO.ProduitSemiFiniDAO;
import Aph.ProduitSemiFini;
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
public class BlockDAOImpl implements ProduitSemiFiniDAO {

    private ProduitSemiFini produit;

    public BlockDAOImpl() {
    }

    public ProduitSemiFini createProduitSemiFini(ProduitSemiFini produitSemiFini) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO aphrodis.block(blockNom, blockDimension, blockPoids, densiteId) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, produitSemiFini.getName());
            pstmt.setString(2, produitSemiFini.getDimension());
            pstmt.setDouble(3, produitSemiFini.getPoids());
            pstmt.setInt(4, produitSemiFini.getDensityId());
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return produitSemiFini;
        } catch (SQLException ex) {
            try {
                conn.rollback();
                return null;
            } catch (SQLException ex1) {
                Logger.getLogger(BlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
                return null;
            }
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

    public boolean deleteproduitSemiFini(int id) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "DELETE FROM aphrodis.block WHERE id = \'" + id + "\'";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean updateProduitSemiFini(ProduitSemiFini produitSemiFini) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "UPDATE aphrodis.block SET name = ?, dimension= ?, poids = ? , dens_id = ?, sections= ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, produitSemiFini.getName());
            pstmt.setString(2, produitSemiFini.getDimension());
            pstmt.setDouble(3, produitSemiFini.getPoids());
            pstmt.setInt(4, produitSemiFini.getDensityId());
            pstmt.setInt(5, produitSemiFini.getNbrSections());
            pstmt.setInt(6, produitSemiFini.getId());
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<ProduitSemiFini> getAllProduitSemiFini() {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        List<ProduitSemiFini> produits = new ArrayList<ProduitSemiFini>();
        try {
            String sql = "SELECT * FROM aphrodis.block";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                produit = new ProduitSemiFini(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
                produits.add(produit);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<ProduitSemiFini> getProduitSemiFiniByDimension(String dimension) {
        List<ProduitSemiFini> produits = new ArrayList<ProduitSemiFini>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.block WHERE blockDimension = \'" + dimension + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                produit = new ProduitSemiFini(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
                produits.add(produit);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<ProduitSemiFini> getProduitSemiFiniByName(String name) {
        List<ProduitSemiFini> produits = new ArrayList<ProduitSemiFini>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM mydb.block WHERE nom = \'" + name + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                produit = new ProduitSemiFini(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
                produits.add(produit);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<ProduitSemiFini> getProduitSemiFiniByDensity(int density) {
        List<ProduitSemiFini> produits = new ArrayList<ProduitSemiFini>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.block WHERE densiteId = \'" + density + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                produit = new ProduitSemiFini(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
                produits.add(produit);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Integer> getProduitSemiFiniIdByName(String name) {
        List<Integer> produitsIds = new ArrayList<Integer>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.block WHERE blockNom = \'" + name + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                produit = new ProduitSemiFini(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
                produitsIds.add(produit.getId());
            }
            return produitsIds;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<ProduitSemiFini> getProduitSemiFiniByPoids(double poids) {
        List<ProduitSemiFini> produits = new ArrayList<ProduitSemiFini>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.block WHERE blockPoids = \'" + poids + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                produit = new ProduitSemiFini(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
                produits.add(produit);
            }
            return produits;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public ProduitSemiFini getProduitSemiFiniById(int id) {
        String sql = "SELECT * FROM aphrodis.block WHERE id = \'" + id + "\'";
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            produit = new ProduitSemiFini(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
            return produit;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
