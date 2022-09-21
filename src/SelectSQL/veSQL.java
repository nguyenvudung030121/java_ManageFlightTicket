/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectSQL;

import getItem.User;
import getItem.Ve;
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
public class veSQL {

    public void addVe(Ve ve) {
        Connection con = ketnoiSQL.getConnection();
        String sql = "Set dateformat dmy; INSERT INTO ve  VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, ve.getAccID());
            pstm.setInt(2, ve.getIdCB());
            pstm.setInt(3, ve.getIdghe());
            pstm.setString(4, ve.getHinhthucTT());
            pstm.setString(5, ve.getNgayTT());
            pstm.setInt(6, ve.getTongtien());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(veSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Ve> getVe_accID(int accID) {
        Connection con = ketnoiSQL.getConnection();
        List<Ve> ves = new ArrayList<Ve>();

        String sql = "Select * from ve Where accID = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, accID);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Ve ve = new Ve();
                ve.setVeID(rs.getInt("veID"));
                ve.setAccID(rs.getInt("accID"));
                ve.setIdCB(rs.getInt("idCB"));
                ve.setIdghe(rs.getInt("idghe"));
                ve.setHinhthucTT(rs.getString("hinhthucTT"));
                ve.setNgayTT(rs.getString("ngayTT"));
                ve.setTongtien(rs.getInt("tongtien"));
                ves.add(ve);
            }
        } catch (SQLException ex) {
            Logger.getLogger(veSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ves;
    }
    

    public List<Ve> getVe_idCB(int idCB) {
        Connection con = ketnoiSQL.getConnection();
        List<Ve> ves = new ArrayList<Ve>();
        String sql = "Select * from ve Where idCB = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCB);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Ve ve = new Ve();
                ve.setVeID(rs.getInt("veID"));
                ve.setAccID(rs.getInt("accID"));
                ve.setIdCB(rs.getInt("idCB"));
                ve.setIdghe(rs.getInt("idghe"));
                ve.setHinhthucTT(rs.getString("hinhthucTT"));
                ve.setNgayTT(rs.getString("ngayTT"));
                ve.setTongtien(rs.getInt("tongtien"));
                ves.add(ve);
            }
        } catch (SQLException ex) {
            Logger.getLogger(veSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ves;
    }
     public Ve getVeID(int accID, int idCB) {
        Connection con = ketnoiSQL.getConnection();

        String sql = "Select * from ve Where accID = ? and idCB = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, accID);
            pstm.setInt(2, idCB);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Ve ve = new Ve();
                ve.setVeID(rs.getInt("veID"));
                ve.setAccID(rs.getInt("accID"));
                ve.setIdCB(rs.getInt("idCB"));
                ve.setIdghe(rs.getInt("idghe"));
                ve.setHinhthucTT(rs.getString("hinhthucTT"));
                ve.setNgayTT(rs.getString("ngayTT"));
                ve.setTongtien(rs.getInt("tongtien"));
                return ve;
            }
        } catch (SQLException ex) {
            Logger.getLogger(veSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void deleteVe(int veID) {
        Connection con = ketnoiSQL.getConnection();
        String sql = "DELETE FROM nguoidicung WHERE veID = ? "+
                 "DELETE FROM ve WHERE veID = ? ";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, veID);
            pstm.setInt(2, veID);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(userSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
