/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph;

import java.sql.Date;

/**
 *
 * @author Medard
 */
public class MatièrePremière {

    private int id;
    private int productId;
    private String origine;
    private Date dateProduction;
    private Date dateExpiration;
    private double quantity;

    public MatièrePremière() {
    }

    public MatièrePremière(String origine, Date dateProduction, Date dateExpiration, double quantity) {
        this.origine = origine;
        this.dateProduction = dateProduction;
        this.dateExpiration = dateExpiration;
        this.quantity = quantity;
    }

    public MatièrePremière(int productId, String origine, Date dateProduction, Date dateExpiration, double quantity) {

        this.productId = productId;
        this.origine = origine;
        this.dateProduction = dateProduction;
        this.dateExpiration = dateExpiration;
        this.quantity = quantity;
    }

    public MatièrePremière(int id, int productId, String origine, Date dateProduction, Date dateExpiration, double quantity) {
        this.id = id;
        this.productId = productId;
        this.origine = origine;
        this.dateProduction = dateProduction;
        this.dateExpiration = dateExpiration;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Date getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(Date dateProduction) {
        this.dateProduction = dateProduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
}
