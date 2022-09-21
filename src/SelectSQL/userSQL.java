/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectSQL;

import QLbanVeMayBay.loginForm;
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
public class userSQL {

    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();
        Connection con = ketnoiSQL.getConnection();

        String sql = "Select * from Account";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setAccID(rs.getInt("accID"));
                user.setEmail(rs.getString("email"));
                user.setMk(rs.getString("mk"));
                user.setHoten(rs.getString("hoten"));
                user.setSdt(rs.getString("sdt"));
                user.setSoCM(rs.getString("soCM"));
                user.setNgaysinh(rs.getString("ngaysinh"));
                user.setGioitinh(rs.getString("gioitinh"));
                user.setQuyentk(rs.getString("quyentk"));
                user.setQuoctich(rs.getString("quoctich"));
                user.setDiachi(rs.getString("diachi"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public void addUser(User user) {
        Connection con = ketnoiSQL.getConnection();
        String sql = "Set dateformat dmy; INSERT INTO Account  VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getMk());
            pstm.setString(3, user.getHoten());
            pstm.setString(4, user.getSdt());
            pstm.setString(5, user.getSoCM());
            pstm.setString(6, user.getNgaysinh());
            pstm.setString(7, user.getGioitinh());
            pstm.setString(8, user.getQuyentk());
            pstm.setString(9, user.getQuoctich());
            pstm.setString(10, user.getDiachi());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(userSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public User getUser(String email) {
        Connection con = ketnoiSQL.getConnection();

        String sql = "Select * from Account Where email = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setAccID(rs.getInt("accID"));
                user.setEmail(rs.getString("email"));
                user.setMk(rs.getString("mk"));
                user.setHoten(rs.getString("hoten"));
                user.setSdt(rs.getString("sdt"));
                user.setSoCM(rs.getString("soCM"));
                user.setNgaysinh(rs.getString("ngaysinh"));
                user.setGioitinh(rs.getString("gioitinh"));
                user.setQuyentk(rs.getString("quyentk"));
                user.setQuoctich(rs.getString("quoctich"));
                user.setDiachi(rs.getString("diachi"));
                return user;
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

    public void updateUser(User user) {
        Connection con = ketnoiSQL.getConnection();
        String sql = "Set dateformat dmy;UPDATE Account SET email = ?, mk = ?, hoten = ?, sdt = ?, soCM = ?, ngaysinh = ?, gioitinh = ?, quyenTK = ?, quoctich = ?, diachi = ? WHERE accID = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getMk());
            pstm.setString(3, user.getHoten());
            pstm.setString(4, user.getSdt());
            pstm.setString(5, user.getSoCM());
            pstm.setString(6, user.getNgaysinh());
            pstm.setString(7, user.getGioitinh());
            pstm.setString(8, user.getQuyentk());
            pstm.setString(9, user.getQuoctich());
            pstm.setString(10, user.getDiachi());

            pstm.setInt(11, user.getAccID());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(userSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteUser(int accID) {
        Connection con = ketnoiSQL.getConnection();
        String sql = "DELETE FROM Account WHERE accID=?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, accID);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(userSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
