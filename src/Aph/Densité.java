/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph;

/**
 *
 * @author Medard
 */
public class Densité {

    private int id;
    private String name;
    private Object[][] consommation;
    private int consRowNum;

    public Densité() {
    }

    public Densité(String name, Object[][] consommation) {
        this.name = name;
        this.consommation = consommation;
    }

    public Densité(int id, String name, Object[][] consommation) {
        this.id = id;
        this.name = name;
        this.consommation = consommation;
    }

    public Densité(int id, String name, Object[][] consommation, int consRowNum) {
        this.id = id;
        this.name = name;
        this.consommation = consommation;
        this.consRowNum = consRowNum;
    }

    public Densité(String name, Object[][] consommation, int consRowNum) {
        this.name = name;
        this.consommation = consommation;
        this.consRowNum = consRowNum;
    }

    public int getConsRowNum() {
        return consRowNum;
    }

    public void setConsRowNum(int consRowNum) {
        this.consRowNum = consRowNum;
    }

    public Object[][] getConsommation() {
        return consommation;
    }

    public void setConsommation(Object[][] consommation) {
        this.consommation = consommation;
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
}
