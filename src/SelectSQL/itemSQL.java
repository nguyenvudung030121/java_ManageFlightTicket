/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectSQL;

import getItem.User;
import QLbanVeMayBay.loginForm;
import getItem.Item;
import getItem.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ketnoiSQL.ketnoiSQL;
/**
 *
 * @author ASUS
 */
public class itemSQL {
     public List<Item> getAllItem() {
        List<Item> items = new ArrayList<Item>();
        Connection con = ketnoiSQL.getConnection();

        String sql = "Select * from dsChuyenBay";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setIdCB(rs.getInt("idCB"));
                item.setNoidi(rs.getString("noidi"));
                item.setNoiden(rs.getString("noiden"));
                item.setSoHK(rs.getString("soHK"));
                item.setNgaydi(rs.getString("ngaydi"));
                item.setHangghe(rs.getString("hangghe"));
                item.setTimedi(rs.getString("timedi"));
                item.setTimeden(rs.getString("timeden"));
                item.setGia(rs.getInt("gia"));
               
                items.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(itemSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }

    public void addItem (Item items) {
        Connection con = ketnoiSQL.getConnection();
        String sql = "Set dateformat dmy; INSERT INTO dsChuyenBay  VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, items.getNoidi());
            pstm.setString(2, items.getNoiden());
            pstm.setString(3, items.getSoHK());
            pstm.setString(4, items.getNgaydi());
            pstm.setString(5, items.getHangghe());
            pstm.setString(6, items.getTimedi());
            pstm.setString(7, items.getTimeden());
            pstm.setInt(8, items.getGia());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(itemSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Item> getItems (String noidi,String noiden,String ngaydi,String hangghe) {
          List<Item> items = new ArrayList<Item>();
        Connection con = ketnoiSQL.getConnection();

        String sql = "set dateformat dmy; select * from dsChuyenBay where  noidi = ? and noiden = ? and ngaydi = ? and hangghe = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, noidi);
            pstm.setString(2, noiden);
            pstm.setString(3, ngaydi);
            pstm.setString(4, hangghe);
            
           
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setIdCB(rs.getInt("idCB"));
                item.setNoidi(rs.getString("noidi"));
                item.setNoiden(rs.getString("noiden"));
                item.setSoHK(rs.getString("soHK"));
                item.setNgaydi(rs.getString("ngaydi"));
                item.setHangghe(rs.getString("hangghe"));
                item.setTimedi(rs.getString("timedi"));
                item.setTimeden(rs.getString("timeden"));
                item.setGia(rs.getInt("gia"));
                
                items.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(itemSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
          return items;
    }
    
     public Item getItem_one(String noidi,String noiden,String ngaydi,String hangghe) {
        Connection con = ketnoiSQL.getConnection();

        String sql = "set dateformat dmy; select * from dsChuyenBay where  noidi = ? and noiden = ? and ngaydi = ? and hangghe = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, noidi);
            pstm.setString(2, noiden);
            pstm.setString(3, ngaydi);
            pstm.setString(4, hangghe);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                 Item item = new Item();
                item.setIdCB(rs.getInt("idCB"));
                item.setNoidi(rs.getString("noidi"));
                item.setNoiden(rs.getString("noiden"));
                item.setSoHK(rs.getString("soHK"));
                item.setNgaydi(rs.getString("ngaydi"));
                item.setHangghe(rs.getString("hangghe"));
                item.setTimedi(rs.getString("timedi"));
                item.setTimeden(rs.getString("timeden"));
                item.setGia(rs.getInt("gia"));
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(userSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     
    public void ktTrung(User user, String kt) {
        Connection connectUser = ketnoiSQL.getConnection();
        try {
            Statement st = connectUser.createStatement();
            ResultSet rs = st.executeQuery("select * from Account");
            while (rs.next()) {
                if (rs.getString(2).equals(user.getEmail())) {
                    kt = "Email đã tồn tại";
                    break;
                }
                if (rs.getString(5).equals(user.getSdt())) {
                    kt = "Số điện thoại đã tồn tại";
                    break;
                }
                if (rs.getString(6).equals(user.getSoCM())) {
                    kt = "Số CMND đã tồn tại";
                    break;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(loginForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateItem(Item item) {
        Connection con = ketnoiSQL.getConnection();
        String sql = "Set dateformat dmy;UPDATE dsChuyenBay SET noidi = ?, noiden = ?, soHK = ?, ngaydi = ?, hangghe = ?, timedi = ?, timeden = ?, gia = ? WHERE idCB = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,  item.getNoidi());
            pstm.setString(2,  item.getNoiden());
            pstm.setString(3,  item.getSoHK());
            pstm.setString(4,  item.getNgaydi());
            pstm.setString(5,  item.getHangghe());
            pstm.setString(6, item.getTimedi());
            pstm.setString(7,  item.getTimeden());
            pstm.setInt(8,  item.getGia());
            pstm.setInt(9, item.getIdCB());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(itemSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteItem(int idCB) {
        Connection con = ketnoiSQL.getConnection();
        String sql = "DELETE FROM dsChuyenBay WHERE idCB=?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCB);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(itemSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}


