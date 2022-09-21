/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectSQL;

import getItem.Ghe;
import getItem.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ketnoiSQL.ketnoiSQL;

/**
 *
 * @author ASUS
 */
public class gheSQL {
    public Ghe getGhe(int idghe) {
        Connection con = ketnoiSQL.getConnection();

        String sql = "select * from ghe where  idghe = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, idghe);
           
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                 Ghe item = new Ghe();
                item.setIdghe(rs.getInt("idghe"));
                item.setSoghe(rs.getString("soghe"));
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(userSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
