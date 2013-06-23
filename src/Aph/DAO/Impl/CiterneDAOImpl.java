/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl;

import Aph.Citerne;
import Aph.DAO.CiterneDAO;
import Aph.DAO.ConnectionInit;
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
public class CiterneDAOImpl implements CiterneDAO {

    private Citerne citerne;

    public CiterneDAOImpl() {
    }

    public Citerne createCiterne(Citerne citerne) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO aphrodis.citerne (nom, volume) VALUES (?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, citerne.getName());
            pstmt.setDouble(2, citerne.getCapacity());
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return citerne;
        } catch (SQLException ex) {
            Logger.getLogger(CiterneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean deleteCiterne(int id) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "DELETE FROM aphrodis.citerne WHERE id = \'" + id + "\'";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CiterneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean updateCiterne(Citerne citerne) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "UPDATE aphrodis.citerne SET nom = ?, volume= ?, productId=?, quantité=? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, citerne.getName());
            pstmt.setDouble(2, citerne.getCapacity());
            pstmt.setInt(3, citerne.getProduitId());
            pstmt.setDouble(4, citerne.getQuantité());
            pstmt.setInt(5, citerne.getId());
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CiterneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Citerne> getAllCiterne() {
        List<Citerne> citernes = new ArrayList<Citerne>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.citerne";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                citerne = new Citerne(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDouble(5));
                citernes.add(citerne);
            }
            return citernes;
        } catch (SQLException ex) {
            Logger.getLogger(CiterneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public Citerne getCiterneByName(String name) {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.citerne WHERE nom = \'" + name + "\'";
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            citerne = new Citerne(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDouble(5));
            return citerne;
        } catch (SQLException ex) {
            Logger.getLogger(CiterneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Citerne> getCiterneByCapacity(Double capacity) {
        List<Citerne> citernes = new ArrayList<Citerne>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        String sql = "SELECT * FROM aphrodis.citerne WHERE volume = \'" + capacity + "\'";
        try {
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                citerne = new Citerne(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDouble(5));
                citernes.add(citerne);
            }
            return citernes;
        } catch (SQLException ex) {
            Logger.getLogger(CiterneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Citerne> getCiterneByContent(int productId) {
        List<Citerne> citernes = new ArrayList<Citerne>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        String sql = "SELECT * FROM aphrodis.citerne WHERE productId = '" + productId + "'";
        try {
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                citerne = new Citerne(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDouble(5));
                citernes.add(citerne);
            }
            return citernes;
        } catch (SQLException ex) {
            Logger.getLogger(CiterneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public Citerne getCiterneById(int id) {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.citerne WHERE id = \'" + id + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                citerne = new Citerne(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDouble(5));
            }
            return citerne;
        } catch (SQLException ex) {
            Logger.getLogger(CiterneDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public double getTotalSameContentInCiternesByProductId(int productId) {
        List<Citerne> citernes = new ArrayList<Citerne>();
        citernes = getCiterneByContent(productId);
        double total = 0.0;
        for (Citerne cit : citernes) {
            total += cit.getQuantité();
        }
        return total;
    }
}
