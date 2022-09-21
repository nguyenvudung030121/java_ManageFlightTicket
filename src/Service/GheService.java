/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import SelectSQL.gheSQL;
import getItem.Ghe;

/**
 *
 * @author ASUS
 */
public class GheService {

    private gheSQL gheSQL;

    public GheService() {
        gheSQL = new gheSQL();
    }

    public Ghe getGhe(int idghe) {
        return gheSQL.getGhe(idghe);
    }
}
