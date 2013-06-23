/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO;

import Aph.Citerne;
import java.util.List;

/**
 *
 * @author Medard
 */
public interface CiterneDAO {

    public Citerne createCiterne(Citerne citerne);

    public boolean deleteCiterne(int id);

    public boolean updateCiterne(Citerne citerne);

    public List<Citerne> getAllCiterne();

    public Citerne getCiterneByName(String name);

    public List<Citerne> getCiterneByCapacity(Double capacity);

    public List<Citerne> getCiterneByContent(int productId);

    public double getTotalSameContentInCiternesByProductId(int productId);

    public Citerne getCiterneById(int id);
}
