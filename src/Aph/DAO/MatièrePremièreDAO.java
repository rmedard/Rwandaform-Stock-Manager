/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO;

import Aph.MatièrePremière;
import Aph.Produit;
import java.util.List;

/**
 *
 * @author Medard
 */
public interface MatièrePremièreDAO {

    public MatièrePremière createMatièrePremière(Produit produit, MatièrePremière matièrePremière);

    public boolean deleteMatièrePremière(int id);

    public boolean updateMatièrePremière(Produit produit, MatièrePremière matièrePremière);

    public MatièrePremière getMatièrePremièreById(int id);

    public List<MatièrePremière> getMatièrePremièreByProduitId(int id);

    public List<MatièrePremière> getAllMatièrePremière();

    public List<MatièrePremière> getMatièrePremièreByName(String name);

    public List<MatièrePremière> getMatièrePremièreByOrigine(String origine);

}
