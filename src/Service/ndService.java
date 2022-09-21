/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import SelectSQL.ndcSQL;
import getItem.userNDC;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ndService {
    private ndcSQL ndcSQL;
    public ndService() {
        ndcSQL = new ndcSQL();
    }
     public void addNdc(userNDC ndc){
       ndcSQL.addNdc(ndc);
    }
    public List<userNDC> getNdc(int accID){
       return  ndcSQL.getNdc(accID);
    }
}
