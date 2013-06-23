/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl;

import Aph.DAO.ConnectionInit;
import Aph.DAO.ProductionDAO;
import Aph.Production;
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
public class ProductionDAOImpl implements ProductionDAO {

    public Production createProduction(Production production) {
        PreparedStatement pstmt = null;
        Connection conn = new ConnectionInit().getCon();

        try {
            String sql = "INSERT INTO aphrodis.production(densiteId, duree) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, production.getDensitéId());
            pstmt.setInt(2, production.getMinutes());
            pstmt.executeUpdate();
            return production;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Production> getAllProduction() {
        List<Production> productions = new ArrayList<Production>();
        Connection conn = new ConnectionInit().getCon();
        ResultSet rs = null;
        String sql = "SELECT * FROM aphrodis.production";
        try {
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                Production prod = new Production(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4));
                productions.add(prod);
            }
            return productions;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Production> getProductionByTimeInterval(Date since, Date until) {
        List<Production> prods = new ArrayList<Production>();
        for (Production prod : getAllProduction()) {
            if (prod.getDate().before(until) && prod.getDate().after(since)) {
                prods.add(prod);
            }
        }
        return prods;
    }

    public List<Production> getProductionByDensity(int id) {
        List<Production> prods = new ArrayList<Production>();
        for (Production prod : getAllProduction()) {
            if (prod.getDensitéId() == id) {
                prods.add(prod);
            }
        }
        return prods;
    }

    public List<Production> getProductionByPeriodAndDensity(Date since, Date until, int id) {
        List<Production> prods = new ArrayList<Production>();
        for (Production prod : getAllProduction()) {
            if (prod.getDate().after(since) && prod.getDate().before(until) && prod.getDensitéId() == id) {
                prods.add(prod);
            }
        }
        return prods;
    }
}
