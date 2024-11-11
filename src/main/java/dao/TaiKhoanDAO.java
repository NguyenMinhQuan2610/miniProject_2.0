/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.taikhoan;

/**
 *
 * @author ADMIN
 */
public class TaiKhoanDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public taikhoan CheckLogin(String tendangnhap, String matkhau)
    {
        taikhoan tk=null;
        conn=DbContext.getConnection();
        
        try {
            ps=conn.prepareStatement("select*from taikhoan where tendangnhap=? and matkhau=?");
            ps.setString(1, tendangnhap);
            ps.setString(2, matkhau);
            rs=ps.executeQuery();
            if(rs.next()){
                tk=new taikhoan(rs.getString(1),rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Loi" +e.toString());
        }
        return tk;
    }
}
