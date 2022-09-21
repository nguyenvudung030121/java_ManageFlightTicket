/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import SelectSQL.userSQL;
import getItem.User;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class userService {
    private userSQL userSQL;
    public userService() {
        userSQL = new userSQL();
    }
    public List<User> getAllUser(){
        return userSQL.getAllUser();
        
    }
    public void addUser(User user){
        userSQL.addUser(user);
    }
    public User getUser(String email){
       return  userSQL.getUser(email);
    }
    
    public void updateUser(User user){
        userSQL.updateUser(user);
    }
    public void deleteUser(int ID){
        userSQL.deleteUser(ID);
    }
    public void ktTrungDL(User user,String  kt){
        userSQL.ktTrung(user, kt);
    }
}
