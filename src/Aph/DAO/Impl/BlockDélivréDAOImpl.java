/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl;

import Aph.BlockDélivré;
import Aph.DAO.BlockDélivréDAO;
import Aph.DAO.ConnectionInit;
import Aph.ProduitSemiFini;
import Aph.Technicien;
import java.sql.Connection;
import java.sql.Date;
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
public class BlockDélivréDAOImpl implements BlockDélivréDAO {

    public BlockDélivré createBlockDélivré(BlockDélivré blockDélivré) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();

        try {
            String sql = "INSERT INTO aphrodis.requisition_block(tech_id, block_id, numberSections) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, blockDélivré.getTechn_id());
            pstmt.setInt(2, blockDélivré.getBlock_id());
            pstmt.setInt(3, blockDélivré.getNumberSections());
            pstmt.executeUpdate();
            BlockDAOImpl impl = new BlockDAOImpl();
            ProduitSemiFini prod = impl.getProduitSemiFiniById(blockDélivré.getBlock_id());
            prod.setNbrSections(prod.getNbrSections() - blockDélivré.getNumberSections());
            impl.updateProduitSemiFini(prod);
            return blockDélivré;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<BlockDélivré> getAllBlockDélivré() {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        List<BlockDélivré> blocks = new ArrayList<BlockDélivré>();
        try {
            String sql = "SELECT * FROM aphrodis.requisition_block";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                BlockDélivré block = new BlockDélivré(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
                blocks.add(block);
            }
            return blocks;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(BlockDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<BlockDélivré> getBlockDélivréByRetirantId(int id) {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        List<BlockDélivré> blocks = new ArrayList<BlockDélivré>();

        try {
            String sql = "SELECT * FROM aphrodis.requisition_block WHERE tech_id = '" + id + "'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                BlockDélivré block = new BlockDélivré(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
                blocks.add(block);
            }
            return blocks;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(BlockDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<BlockDélivré> getBlockDélivréByPeriod(Date since, Date until) {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        List<BlockDélivré> blocks = new ArrayList<BlockDélivré>();
        try {
            String sql = "SELECT * FROM aphrodis.requisition_block WHERE date BETWEEN '" + since + "' AND '" + until + "'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                BlockDélivré block = new BlockDélivré(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
                blocks.add(block);
            }
            return blocks;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<BlockDélivré> getBlockDélivréByPeriodAndRetirant(Date since, Date until, Technicien tech) {
        ResultSet rs = null;
        Connection conn = new ConnectionInit().getCon();
        List<BlockDélivré> blocks = new ArrayList<BlockDélivré>();
        try {
            String sql = "SELECT * FROM aphrodis.requisition_block WHERE date BETWEEN '" + since + "' AND '" + until + "' AND tech_id = '" + tech.getId() + "'";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                BlockDélivré block = new BlockDélivré(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
                blocks.add(block);
            }
            return blocks;
        } catch (SQLException ex) {
            Logger.getLogger(BlockDélivréDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
