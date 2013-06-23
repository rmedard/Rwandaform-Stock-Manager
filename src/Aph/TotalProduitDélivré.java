/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Aph;

/**
 *
 * @author Medard
 */
public class TotalProduitDélivré {
     private int id;
     private int produitId;
     private double quantité;

    public TotalProduitDélivré() {
    }

    public TotalProduitDélivré(int produitId, double quantité) {
        this.produitId = produitId;
        this.quantité = quantité;
    }

    public TotalProduitDélivré(int id, int produitId, double quantité) {
        this.id = id;
        this.produitId = produitId;
        this.quantité = quantité;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public double getQuantité() {
        return quantité;
    }

    public void setQuantité(double quantité) {
        this.quantité = quantité;
    }
    
}
