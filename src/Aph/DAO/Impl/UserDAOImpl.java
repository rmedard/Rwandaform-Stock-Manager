/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl;

import Aph.DAO.ConnectionInit;
import Aph.DAO.UserDAO;
import Aph.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Medard
 */
public class UserDAOImpl implements UserDAO {

    private User user;

    public User createUser(User user) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();

        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO aphrodis.user(nom, prenom, username, password, grade) VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getNom());
            pstmt.setString(2, user.getPrénom());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getGrade());
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean deleteUser(int id) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();

        try {
            conn.setAutoCommit(false);
            String sql = "DELETE FROM aphrodis.user WHERE id = \'" + id + "\'";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean updateUser(User user) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();

        try {
            conn.setAutoCommit(false);
            String sql = "UPDATE aphrodis.user SET nom = ?, prenom= ?, username = ?, password = ?, grade = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getNom());
            pstmt.setString(2, user.getPrénom());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getGrade());
            pstmt.setInt(6, user.getId());
            pstmt.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);

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

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();

        try {
            String sql = "SELECT * FROM aphrodis.user";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<User> getUserByName(String name) {
        List<User> users = new ArrayList<User>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();

        try {
            String sql = "SELECT * FROM aphrodis.user WHERE nom = \'" + name + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<User> getUserByPostName(String pName) {
        List<User> users = new ArrayList<User>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();

        try {
            String sql = "SELECT * FROM aphrodis.user WHERE prenom = \'" + pName + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public User getUserByUsername(String username) {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();

        try {
            String sql = "SELECT * FROM aphrodis.user WHERE username = \'" + username + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<User> getUserByGrade(String grade) {
        List<User> users = new ArrayList<User>();
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();

        try {
            String sql = "SELECT * FROM aphrodis.user WHERE grade = \'" + grade + "\'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public User getUserByNames(String name, String pname) {
        user = new User();
        for (User anyUser : getUserByName(name)) {
            for (User anotherUser : getUserByPostName(pname)) {
                if (anyUser.getUsername().equals(anotherUser.getUsername())) {
                    user = anyUser;
                    break;
                }
            }
        }
        return user;
    }

//    public boolean changeStatus(User user, String status) {
//        Connection conn = new ConnectionInit().getCon();
//        try {
//            String sql = "UPDATE aphrodis.user SET status= '" + status + "' WHERE id = '" + user.getId() + "'";
//            conn.createStatement().executeUpdate(sql);
//            return true;
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }finally{
//            try {
//                if (!conn.isClosed()) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
