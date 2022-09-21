/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectSQL;

import getItem.User;
import getItem.userNDC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ketnoiSQL.ketnoiSQL;

/**
 *
 * @author ASUS
 */
public class ndcSQL {


     public void addNdc(userNDC ndc) {
        Connection con = ketnoiSQL.getConnection();
        String sql = "Set dateformat dmy; INSERT INTO nguoidicung  VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, ndc.getAccID());
            pstm.setInt(2, ndc.getVeID());
            pstm.setString(3, ndc.getHoten());
            pstm.setString(4, ndc.getNgaysinh());
            pstm.setString(5, ndc.getGioitinh());
            pstm.setString(6, ndc.getQuoctich());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ndcSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<userNDC> getNdc(int accID) {
        List<userNDC> ndc = new ArrayList<userNDC>();
        Connection con = ketnoiSQL.getConnection();

        String sql = "Select * from nguoidicung Where accID = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, accID);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                userNDC user = new userNDC();
                user.setIdNdc(rs.getInt("idNdc"));
                user.setAccID(rs.getInt("accID"));
                user.setVeID(rs.getInt("veID"));
                user.setHoten(rs.getString("hoten"));
                user.setNgaysinh(rs.getString("ngaysinh"));
                user.setGioitinh(rs.getString("gioitinh"));
                user.setQuoctich(rs.getString("quoctich"));
               
                ndc.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ndcSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ndc;
    }
}


