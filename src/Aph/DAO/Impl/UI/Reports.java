/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO.Impl.UI;

import Aph.DAO.ConnectionInit;
import Aph.Densité;
import Aph.Technicien;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Medard
 */
public class Reports {

    public static void viewLivraisonProduitAll() {

        Connection conn = new ConnectionInit().getCon();
        try {
            HashMap parameterMap = new HashMap();
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\livraisonProduit.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void viewBlockLivraisonAll() {
        Connection conn = new ConnectionInit().getCon();
        try {
            HashMap parameterMap = new HashMap();
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\livraisonBlock.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void viewBlockLivraisonByTech() {
    }

    public static void viewProduitLivraisonByNameReport(Technicien tech) {
        Connection conn = new ConnectionInit().getCon();
        try {
            HashMap<String, Integer> parameterMap = new HashMap<String, Integer>();
            parameterMap.put("techId", new Integer(tech.getId()));
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\livraisonProduitByTech.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            //JasperViewer.viewReport(jasperPrint, false);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "Livraison par technicien.pdf");
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void viewProduitLivraisonByPeriod(Date since, Date until) {
        Connection conn = new ConnectionInit().getCon();
        try {
            HashMap<String, Date> parameterMap = new HashMap<String, Date>();
            parameterMap.put("dtSince", new java.sql.Date(since.getTime()));
            parameterMap.put("dtUntil", new java.sql.Date(until.getTime()));
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\LivraisonProduitByPeriod.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void viewProduitLivraisonByPeriodAndTech(Technicien tech, Date since, Date until) {
        Connection conn = new ConnectionInit().getCon();
        try {
            HashMap parameterMap = new HashMap();
            parameterMap.put("techId", new Integer(tech.getId()));
            parameterMap.put("dtSince", new java.sql.Date(since.getTime()));
            parameterMap.put("dtUntil", new java.sql.Date(until.getTime()));
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\LivraisonProduitByPeriodAndTech.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void viewAllProduction() {
        Connection conn = new ConnectionInit().getCon();
        try {
            HashMap parameterMap = new HashMap();
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\AllProduction.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException jRException) {
            jRException.printStackTrace();
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void viewProductionByPeriod(Date since, Date until) {
        Connection conn = new ConnectionInit().getCon();
        try {
            HashMap<String, Date> parameterMap = new HashMap<String, Date>();
            parameterMap.put("dtSince", new java.sql.Date(since.getTime()));
            parameterMap.put("dtUntil", new java.sql.Date(until.getTime()));
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\ProductionByPeriod.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void viewProductionByDensité(Densité dens) {
        Connection conn = new ConnectionInit().getCon();
        try {
            HashMap<String, Integer> parameterMap = new HashMap<String, Integer>();
            parameterMap.put("densitéId", new Integer(dens.getId()));
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\ProductionByDensité.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @SuppressWarnings({"unchecked", "unchecked"})
    public static void viewProductionByDensityAndPeriod(Date since, Date until, Densité dens){
        Connection conn = new ConnectionInit().getCon();
        try {
            HashMap parameterMap = new HashMap();
            parameterMap.put("densitéId", new Integer(dens.getId()));
            parameterMap.put("dtSince", new java.sql.Date(since.getTime()));
            parameterMap.put("dtUntil", new java.sql.Date(until.getTime()));
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\ProductionByDensityAndPeriod.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void viewRequisitionBlockByTech(Technicien tech){
          Connection conn = new ConnectionInit().getCon();
          try {
            HashMap<String, Integer> parameterMap = new HashMap<String, Integer>();
            parameterMap.put("techId", new Integer(tech.getId()));
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\RequisitionBlockByRetirant.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   public static void viewRequisitionBlockByPeriod(Date since, Date until) {
        Connection conn = new ConnectionInit().getCon();
        try {
            HashMap<String, Date> parameterMap = new HashMap<String, Date>();
            parameterMap.put("dtSince", new java.sql.Date(since.getTime()));
            parameterMap.put("dtUntil", new java.sql.Date(until.getTime()));
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\RequisitionBlockByPeriod.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @SuppressWarnings({"unchecked", "unchecked"})
   public static void viewRequisitionBlockByPeriodAndTech(Date since, Date until, Technicien tech){
        Connection conn = new ConnectionInit().getCon();
        try {
            HashMap parameterMap = new HashMap();
            parameterMap.put("techId", new Integer(tech.getId()));
            parameterMap.put("dtSince", new java.sql.Date(since.getTime()));
            parameterMap.put("dtUntil", new java.sql.Date(until.getTime()));
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Medard\\Documents\\NetBeansProjects\\Aphrodis\\src\\Aph\\DAO\\RequisitionBlockByPeriodAndTech.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
