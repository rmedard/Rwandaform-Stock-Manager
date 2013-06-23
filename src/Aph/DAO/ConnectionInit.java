/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Medard
 */
public class ConnectionInit {

    final String host = "jdbc:mysql://localhost:3306/aphrodis";
    final String username = "root";
    final String password = "0Derfine";
    private Connection con;

    public ConnectionInit() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(host, username, password);
        } catch (InstantiationException ex) {
            Logger.getLogger(ConnectionInit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConnectionInit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionInit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         //   JOptionPane.showMessageDialog(null, "Connection à la base des données échouée. Vérifier vos paramètres de configuration.", "Erreur", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }
}
