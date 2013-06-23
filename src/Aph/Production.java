/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Aph;

import java.util.Date;

/**
 *
 * @author Medard
 */
public class Production {

    private int id;
    private int densitéId;
    private int minutes;
    private Date date;

    public Production(int densitéId, int minutes) {
        this.densitéId = densitéId;
        this.minutes = minutes;
    }

    public Production(int densitéId, int minutes, Date date) {
        this.densitéId = densitéId;
        this.minutes = minutes;
        this.date = date;
    }

    public Production(int id, int densitéId, int minutes, Date date) {
        this.id = id;
        this.densitéId = densitéId;
        this.minutes = minutes;
        this.date = date;
    }

    public int getDensitéId() {
        return densitéId;
    }

    public void setDensitéId(int densitéId) {
        this.densitéId = densitéId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
   
}
