package Aph.DAO.Impl.UI;

import Aph.DAO.ConnectionInit;
import Aph.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/*
 * signInUI.java
 *
 * Created on Dec 18, 2010, 12:01:23 PM
 */
/**
 *
 * @author Medard
 */
public class signInUI extends javax.swing.JFrame {

    private String nomUtilisateur;
    private String motDePasse, status;
    private Statement stmt;
    private UsersUI usersUI;
    private Gestion_Citerne gestionCiterne;
    private Gestion_Produit gestionProduit;
    private Gestion_blocks gestionBlocks;
    private ConnectionInit connectionInit;
    private Connection con = null;
    private DAOS daos;

    /** Creates new form signInUI */
    public signInUI() {
        initComponents();
        connectionInit = new ConnectionInit();
        gestionCiterne = new Gestion_Citerne();
        gestionProduit = new Gestion_Produit();
        gestionBlocks = new Gestion_blocks();
        usersUI = new UsersUI();
        gestionCiterne.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        gestionProduit.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        gestionBlocks.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        usersUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        con = connectionInit.getCon();
        this.setTitle("Login");
        daos = new DAOS();
    }

    public DAOS getDaos() {
        return daos;
    }

    public JPasswordField getPswdMotDePasse() {
        return pswdMotDePasse;
    }

    public void setPswdMotDePasse(JPasswordField pswdMotDePasse) {
        this.pswdMotDePasse = pswdMotDePasse;
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brownSugar1 = new com.jgoodies.looks.plastic.theme.BrownSugar();
        desertBlue1 = new com.jgoodies.looks.plastic.theme.DesertBlue();
        desertBlue2 = new com.jgoodies.looks.plastic.theme.DesertBlue();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUtilisateur = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        pswdMotDePasse = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Colonna MT", 3, 24));
        jLabel1.setText("Nouvelle session ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Nom d'utilisateur");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Mot de passe");

        cbxStatus.setText("Rester connecté");
        cbxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStatusActionPerformed(evt);
            }
        });

        btnLogin.setBackground(java.awt.Color.lightGray);
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 10));
        btnLogin.setText("Connecter");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnAnnuler.setBackground(java.awt.Color.lightGray);
        btnAnnuler.setFont(new java.awt.Font("Tahoma", 1, 10));
        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Login");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Cancel");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem3.setText("About");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Help");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pswdMotDePasse)
                            .addComponent(txtUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(cbxStatus, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAnnuler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnAnnuler)
                    .addComponent(pswdMotDePasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxStatus)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        nomUtilisateur = txtUtilisateur.getText();
        motDePasse = new String(pswdMotDePasse.getPassword());
        String userName = null;
        String passWord = null;
        String grade = null;
        try {
            if (nomUtilisateur.length() == 0) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer votre nom d'utilisateur", "Halte", JOptionPane.ERROR_MESSAGE);
                txtUtilisateur.requestFocus();
            } else if (motDePasse.length() == 0) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer votre mot de passe", "Halte", JOptionPane.ERROR_MESSAGE);
                pswdMotDePasse.requestFocus();
            } else {
                try {
                    stmt = con.createStatement();
                    String sql = "SELECT username,password FROM aphrodis.user WHERE username = '" + nomUtilisateur + "'";
                    ResultSet rs = stmt.executeQuery(sql);
                    rs.next();
                    userName = rs.getString("username");
                    passWord = rs.getString("password");
                    if (userName == null || passWord == null) {
                        JOptionPane.showMessageDialog(null, "Nom d'utilisateur n'existe pas. Veuillez réessayer" + userName + passWord, "Halte", JOptionPane.ERROR_MESSAGE);
                    } else {
                        User user = getDaos().getUserDAO().getUserByUsername(userName);
                        if (user.getPassword().equals(motDePasse)) {

                            String logger = "SELECT grade FROM aphrodis.user WHERE username = \'" + userName + "\'";
                            ResultSet rsLogger = stmt.executeQuery(logger);
                            while (rsLogger.next()) {
                                grade = rsLogger.getString("grade");
                                if (grade.equals("admin")) {
                                    usersUI.setVisible(true);
                                } else if (grade.equals("citerne")) {
                                    gestionCiterne.setVisible(true);
                                } else if (grade.equals("mat_prm")) {
                                    gestionProduit.setVisible(true);
                                } else if (grade.equals("prod_sfini")) {
                                    gestionBlocks.setVisible(true);
                                    gestionBlocks.setSignIn(this);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe érroné", "Halte", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Connection échouée, vérifiez vos paramètres de connectivité", "Erreur", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de connectivité", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter l'application?", "Confirmer", JOptionPane.YES_NO_CANCEL_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void cbxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStatusActionPerformed
        if (cbxStatus.isSelected()) {
            status = "on";
        } else {
            status = "off";
        }
    }//GEN-LAST:event_cbxStatusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new signInUI().setVisible(true);
            }
        });


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox cbxStatus;
    private com.jgoodies.looks.plastic.theme.DesertBlue desertBlue1;
    private com.jgoodies.looks.plastic.theme.DesertBlue desertBlue2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    public javax.swing.JPasswordField pswdMotDePasse;
    private javax.swing.JTextField txtUtilisateur;
    // End of variables declaration//GEN-END:variables
}
