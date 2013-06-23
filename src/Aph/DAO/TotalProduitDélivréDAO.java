/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO;

import Aph.TotalProduitDélivré;

/**
 *
 * @author Medard
 */
public interface TotalProduitDélivréDAO {

    public TotalProduitDélivré createTotalProduitDélivré(TotalProduitDélivré totalProduitDélivré);

    public boolean updateTotalProduitDélivré(TotalProduitDélivré totalProduitDélivré);

    public TotalProduitDélivré getTotalById(int id);

    public TotalProduitDélivré getTotalProduitByProduitId(int produitId);
}
