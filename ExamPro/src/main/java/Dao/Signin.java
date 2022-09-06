package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;

public class Signin {

    
 public ResultSet UserSignin(String Role,String email,String password) throws SQLException {
	 
	 Connection con = Database.getConnection();
     PreparedStatement ps = con.prepareStatement("select * from "+ Role +" where useremail=? and userpassword=? and active=? and checked=?");
     ps.setString(1, email);
     ps.setString(2, password);
     ps.setInt(3, 1);
     ps.setInt(4, 1);
     ResultSet rs = ps.executeQuery();
     return rs;
     
     }}
