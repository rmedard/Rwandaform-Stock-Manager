/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl;

import Aph.DAO.ConnectionInit;
import Aph.DAO.TechnicienDAO;
import Aph.Technicien;
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
public class TechnicienProduitDAOImpl implements TechnicienDAO {

    private Technicien technicien;

    public TechnicienProduitDAOImpl() {
    }

    public Technicien createTechnicien(Technicien technicien) {

        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO aphrodis.technicien_prod(nom,prenom,tel) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, technicien.getLastName());
            pstmt.setString(2, technicien.getFirstName());
            pstmt.setString(3, technicien.getNumTel());
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);

            return technicien;

        } catch (SQLException ex) {
            Logger.getLogger(TechnicienProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);

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

    public boolean deleteTechnicien(int id) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "DELETE FROM aphrodis.technicien_prod WHERE id = \'" + id + "\'";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(TechnicienProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Technicien> getAllTechniciens() {
        List<Technicien> techniciens = new ArrayList<Technicien>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.technicien_prod";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                technicien = new Technicien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                techniciens.add(technicien);
            }
            return techniciens;
        } catch (SQLException ex) {
            Logger.getLogger(TechnicienProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean updateTechnicien(Technicien technicien) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            conn.setAutoCommit(false);
            String sql = "UPDATE aphrodis.technicien_prod SET nom = ?, prenom= ?, tel = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, technicien.getLastName());
            pstmt.setString(2, technicien.getFirstName());
            pstmt.setString(3, technicien.getNumTel());
            pstmt.setInt(4, technicien.getId());
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(TechnicienProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Technicien> getTechnicienByLastName(String lastName) {
        List<Technicien> techs = new ArrayList<Technicien>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.technicien_prod WHERE nom = '" + lastName + "'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                technicien = new Technicien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                techs.add(technicien);
            }
            return techs;

        } catch (SQLException ex) {
            Logger.getLogger(TechnicienBlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Technicien> getTechnicienByFirstName(String firstName) {
        List<Technicien> techs = new ArrayList<Technicien>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.technicien_prod WHERE prenom = \'" + firstName + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                technicien = new Technicien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                techs.add(technicien);
            }
            return techs;
        } catch (SQLException ex) {
            Logger.getLogger(TechnicienBlockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Technicien> getTechnicienByNames(String lastName, String firstName) {
        List<Technicien> techs = new ArrayList<Technicien>();
        List<Technicien> techns = new ArrayList<Technicien>();
        List<Technicien> techniciens = new ArrayList<Technicien>();
        technicien = new Technicien();
        techs = getTechnicienByLastName(lastName);
        techs = getTechnicienByFirstName(firstName);
        for (Technicien tech : techs) {
            for (Technicien techn : techns) {
                if (techn.getFirstName().equals(tech.getFirstName()) && techn.getLastName().equals(tech.getLastName())) {
                    techniciens.add(tech);
                }
            }
        }
        return techniciens;
    }

    public Technicien getTechnicienByPhoneNum(String phoneNum) {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT * FROM aphrodis.technicien_prod WHERE tel = \'" + phoneNum + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                technicien = new Technicien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            return technicien;
        } catch (SQLException ex) {
            Logger.getLogger(TechnicienProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public int getTechnicienCount() {
        int count = 0;
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        try {
            String sql = "SELECT COUNT(t.id) FROM technicien_prod t";
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            count = rs.getInt(1);
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(TechnicienProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
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

    public Technicien getTechnicienById(int id) {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        String sql = "SELECT * FROM aphrodis.technicien_prod WHERE id = '" + id + "'";
        try {
            rs = conn.createStatement().executeQuery(sql);
            rs.next();
            technicien = new Technicien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            return technicien;
        } catch (SQLException ex) {
            Logger.getLogger(TechnicienProduitDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
