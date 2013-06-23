/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO;

import Aph.Produit;
import java.util.List;

/**
 *
 * @author Medard
 */
public interface ProduitDAO {

    public Produit createProduit(Produit produit);

    public boolean deleteProduit(int id);

    public boolean updateProduit(Produit produit);

    public List<Produit> getAllProduit();

    public Produit getProduitByName(String name);

    public Produit getProduitById(int id);
}
