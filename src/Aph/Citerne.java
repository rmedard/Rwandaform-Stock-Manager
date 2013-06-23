 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph;

/**
 *
 * @author Medard
 */
public class Citerne {

    private int id;
    private String name;
    private double capacity;
    private int produitId;
    private double quantité;

    public Citerne() {
    }

    public Citerne(String name, double capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Citerne(String name, double capacity, int produitId, double quantité) {
        this.name = name;
        this.capacity = capacity;
        this.produitId = produitId;
        this.quantité  = quantité;
    }

    public Citerne(int id, String name, double capacity, int produitId, double quantité) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.produitId = produitId;
        this.quantité = quantité;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
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

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int etatId) {
        this.produitId = etatId;
    }

    public double getQuantité() {
        return quantité;
    }

    public void setQuantité(double quantité) {
        this.quantité = quantité;
    }
    
}
