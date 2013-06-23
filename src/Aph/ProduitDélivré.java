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
public class ProduitDélivré {

    private int id;
    private int produit_id;
    private int délivreur_id;
    private double quantité;
    private Date livraisonDate;

    public ProduitDélivré() {
    }

    public ProduitDélivré( int délivreur_id, int produit_id, double quantité) {
        this.produit_id = produit_id;
        this.délivreur_id = délivreur_id;
        this.quantité = quantité;
    }

    public ProduitDélivré(int délivreur_id, int produit_id, double quantité, Date livraisonDate) {
        this.produit_id = produit_id;
        this.délivreur_id = délivreur_id;
        this.quantité = quantité;
        this.livraisonDate = livraisonDate;
    }

    public ProduitDélivré(int id, int délivreur_id, int produit_id,  double quantité, Date livraisonDate) {
        this.id = id;
        this.produit_id = produit_id;
        this.délivreur_id = délivreur_id;
        this.quantité = quantité;
        this.livraisonDate = livraisonDate;
    }

    public int getDélivreur_id() {
        return délivreur_id;
    }

    public void setDélivreur_id(int délivreur_id) {
        this.délivreur_id = délivreur_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLivraisonDate() {
        return livraisonDate;
    }

    public void setLivraisonDate(Date livraisonDate) {
        this.livraisonDate = livraisonDate;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public double getQuantité() {
        return quantité;
    }

    public void setQuantité(double quantité) {
        this.quantité = quantité;
    }
}
