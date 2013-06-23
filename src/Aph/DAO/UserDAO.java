/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Aph.DAO;

import Aph.User;
import java.util.List;

/**
 *
 * @author Medard
 */
public interface UserDAO {

    public User createUser(User user);

    public boolean deleteUser(int id);

    public boolean updateUser(User user);

    public List<User> getAllUsers();

    public List<User> getUserByName(String name);

    public List<User> getUserByPostName(String pName);

    public User getUserByUsername(String username);

    public List<User> getUserByGrade(String grade);

    public User getUserByNames(String name, String pname);

//    public boolean changeStatus(User user, String status);
}
