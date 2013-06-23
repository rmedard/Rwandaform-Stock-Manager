/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO;

import Aph.ProduitSemiFini;
import java.util.List;

/**
 *
 * @author Medard
 */
public interface ProduitSemiFiniDAO {

    public ProduitSemiFini createProduitSemiFini(ProduitSemiFini produitSemiFini);

    public boolean deleteproduitSemiFini(int id);

    public boolean updateProduitSemiFini(ProduitSemiFini produitSemiFini);

    public List<ProduitSemiFini> getAllProduitSemiFini();

    public List<ProduitSemiFini> getProduitSemiFiniByDimension(String dimension);

    public List<ProduitSemiFini> getProduitSemiFiniByName(String name);

    public List<ProduitSemiFini> getProduitSemiFiniByPoids(double poids);

    public List<ProduitSemiFini> getProduitSemiFiniByDensity(int density);

    public List<Integer> getProduitSemiFiniIdByName(String name);

    public ProduitSemiFini getProduitSemiFiniById(int id);
}
