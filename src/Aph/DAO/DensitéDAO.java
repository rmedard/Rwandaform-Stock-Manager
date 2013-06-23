/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO;

import Aph.Densité;
import Aph.Produit;
import java.util.List;

/**
 *
 * @author Medard
 */
public interface DensitéDAO {

    public Densité createDensité(Densité densité);

    public boolean updateDensité(Densité densité, Produit produit);

    public boolean deleteDensité(int id);

    public List<Densité> getAllDensité();

    public Densité getDensitéByName(String name);

    public Densité getDensitéById(int id);
}
