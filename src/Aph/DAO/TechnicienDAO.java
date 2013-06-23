/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aph.DAO;

import Aph.Technicien;
import java.util.List;

/**
 *
 * @author Medard
 */
public interface TechnicienDAO {

    public Technicien createTechnicien(Technicien technicien);

    public boolean deleteTechnicien(int id);

    public List<Technicien> getAllTechniciens();

    public boolean updateTechnicien(Technicien technicien);

    public List<Technicien> getTechnicienByLastName(String lastName);

    public List<Technicien> getTechnicienByFirstName(String firstName);

    public List<Technicien> getTechnicienByNames(String lastName, String firstName);

    public Technicien getTechnicienByPhoneNum(String phoneNum);

    public Technicien getTechnicienById(int id);

    public int getTechnicienCount();
}
