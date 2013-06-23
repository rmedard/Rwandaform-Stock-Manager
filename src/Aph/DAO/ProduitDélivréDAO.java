/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO;

import Aph.ProduitDélivré;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Medard
 */
public interface ProduitDélivréDAO {

    public ProduitDélivré createProduitDélivré(ProduitDélivré produitDélivré);

    public boolean deleteProduitDélivré(int id);

    public boolean updateProduitDélivré(ProduitDélivré produitDélivré);

    public List<ProduitDélivré> getAllProduitDélivré();

    public ProduitDélivré getProduitDélivréByLivraisonId(int id);

    public List<ProduitDélivré> getProduitDélivréByDélivreur(int délivreurId);

    public List<ProduitDélivré> getProduitDélivréByProduitId(int id);

    public List<ProduitDélivré> getProduitDélivréByPeriod(Date since, Date until);

    public List<ProduitDélivré> getProduitDélivréByPeriodAndDélivreur(int délivreurId, Date since, Date until);
    
}
