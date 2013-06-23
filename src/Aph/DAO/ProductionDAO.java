/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO;

import Aph.Production;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Medard
 */
public interface ProductionDAO {

    public Production createProduction(Production production);

    public List<Production> getAllProduction();

    public List<Production> getProductionByTimeInterval(Date since, Date until);

    public List<Production> getProductionByDensity(int id);

    public List<Production> getProductionByPeriodAndDensity(Date since, Date until, int id);
}
