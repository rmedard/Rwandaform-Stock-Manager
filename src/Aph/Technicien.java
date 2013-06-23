/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph;

/**
 *
 * @author Medard
 */
public class Technicien {

    private int id;
    private String lastName;
    private String firstName;
    private String numTel;

    public Technicien() {
    }

    public Technicien(String lastName, String firstName, String numTel) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.numTel = numTel;
    }
    public Technicien(int id, String lastName, String firstName, String numTel){

        this.id=id;
        this.lastName=lastName;
        this.firstName=firstName;
        this.numTel=numTel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    
}
