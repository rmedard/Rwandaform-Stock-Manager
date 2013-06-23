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
public class BlockDélivré {

    private int id;
    private int techn_id;
    private int block_id;
    private Date livraisonDate;
    private int numberSections;

    public BlockDélivré(int techn_id, int block_id, int numberSections) {
        this.techn_id = techn_id;
        this.block_id = block_id;
        this.numberSections = numberSections;
    }

    public BlockDélivré(int id, int techn_id, int block_id, int numberSections, Date livraisonDate) {
        this.id = id;
        this.techn_id = techn_id;
        this.block_id = block_id;
        this.livraisonDate = livraisonDate;
        this.numberSections = numberSections;
    }

    public int getBlock_id() {
        return block_id;
    }

    public void setBlock_id(int block_id) {
        this.block_id = block_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberSections() {
        return numberSections;
    }

    public void setNumberSections(int numberSections) {
        this.numberSections = numberSections;
    }

    public int getTechn_id() {
        return techn_id;
    }

    public void setTechn_id(int techn_id) {
        this.techn_id = techn_id;
    }

    public Date getDate() {
        return livraisonDate;
    }

    public void setDate(Date date) {
        this.livraisonDate = date;
    }
}
