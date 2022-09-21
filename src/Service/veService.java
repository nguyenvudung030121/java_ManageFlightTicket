/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import SelectSQL.veSQL;
import getItem.Ve;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class veService {

    private veSQL veSQL;

    public veService() {
        veSQL = new veSQL();
    }

    public void addVe(Ve ve) {
        veSQL.addVe(ve);
    }

    public List<Ve> getVe_idCB(int idCB) {
        return veSQL.getVe_idCB(idCB);
    }

    public List<Ve> getVe_accID(int accID) {
        return veSQL.getVe_idCB(accID);
    }

    public Ve getVeID(int accID, int idCB) {
        return veSQL.getVeID(accID, idCB);
    }

    public void deleteVe(int veID) {
        veSQL.deleteVe(veID);
    }
}
