/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Aph;

/**
 *
 * @author Medard
 */
public class Produit {

    private int id;
    private String name;
    private double quantité;

    public Produit() {
    }
    
    public Produit(String name, double quantité) {
        this.name = name;
        this.quantité = quantité;
    }

    public Produit(int id, String name, double quantité) {
        this.id = id;
        this.name = name;
        this.quantité = quantité;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantité() {
        return quantité;
    }

    public void setQuantité(double quantité) {
        this.quantité = quantité;
    }
    
}
