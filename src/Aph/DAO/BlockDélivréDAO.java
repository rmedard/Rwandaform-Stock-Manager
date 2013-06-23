/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO;

import Aph.BlockDélivré;
import Aph.Technicien;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Medard
 */
public interface BlockDélivréDAO {

    public BlockDélivré createBlockDélivré(BlockDélivré blockDélivré);

    public List<BlockDélivré> getAllBlockDélivré();

    public List<BlockDélivré> getBlockDélivréByRetirantId(int id);

    public List<BlockDélivré> getBlockDélivréByPeriod(Date since, Date until);

    public List<BlockDélivré> getBlockDélivréByPeriodAndRetirant(Date since, Date until, Technicien tech);
}
