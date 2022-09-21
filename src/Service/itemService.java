/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import SelectSQL.itemSQL;
import SelectSQL.userSQL;
import getItem.Item;
import getItem.User;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class itemService {
    private itemSQL itemSQL;
    public itemService() {
        itemSQL = new itemSQL();
    }
    public List<Item> getAllItem(){
        return itemSQL.getAllItem();
        
    }
    public void addItem(Item Item){
        itemSQL.addItem(Item);
    }
    public List<Item> getItems(String noidi,String noiden,String ngaydi,String hangghe){
       return  itemSQL.getItems(noidi, noiden, ngaydi, hangghe);
    }
    
    public Item getItem_one(String noidi,String noiden,String ngaydi,String hangghe){
        return itemSQL.getItem_one(noidi,noiden,ngaydi,hangghe);
    }
    
    public void updateItem(Item item){
        itemSQL.updateItem(item);
    }
    public void deleteItem(int idCB){
        itemSQL.deleteItem(idCB);
    }
    public void ktTrungDL(User user,String  kt){
        itemSQL.ktTrung(user, kt);
    }
}
