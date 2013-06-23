/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Aph;

/**
 *
 * @author Medard
 */
public class User {

    private int id;
    private String nom;
    private String prénom;
    private String username;
    private String password;
    private String grade;

    public User(){
    }

    public User(String nom, String prénom, String username, String password, String grade){
        this.nom = nom;
        this.prénom = prénom;
        this.username = username;
        this.password = password;
        this.grade = grade;
    }

    public User(int id, String nom, String prénom, String username, String password, String grade){
        this.id = id;
        this.nom = nom;
        this.prénom = prénom;
        this.username = username;
        this.password = password;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
