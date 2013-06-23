/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph;

/**
 *
 * @author Medard
 */
public class ProduitSemiFini {

    private int id;
    private String name;
    private String dimension;
    private double poids;
    private int densityId;
    private int nbrSections;

    public ProduitSemiFini() {
    }

    public ProduitSemiFini(String name, int densityId) {
        this.name = name;
        this.densityId = densityId;
    }

    public ProduitSemiFini(String name, String dimension, double poids, int densityId, int nbrSections) {

        this.name = name;
        this.dimension = dimension;
        this.poids = poids;
        this.densityId = densityId;
        this.nbrSections = nbrSections;
    }

    public ProduitSemiFini(int id, String name, String dimension, double poids, int densityId, int nbrSections) {

        this.id = id;
        this.name = name;
        this.dimension = dimension;
        this.poids = poids;
        this.densityId = densityId;
        this.nbrSections = nbrSections;
    }

    public int getDensityId() {
        return densityId;
    }

    public void setDensityId(int densityId) {
        this.densityId = densityId;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
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

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public int getNbrSections() {
        return nbrSections;
    }

    public void setNbrSections(int nbrSections) {
        this.nbrSections = nbrSections;
    }
}
