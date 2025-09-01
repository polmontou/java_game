package db;

import gamescript.Menu;

import java.sql.*;

public class Select {
 public static void  main(String[] args) throws ClassNotFoundException, SQLException
 {
     try (
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sabefh?useSSL=false&serverTimezone=UTC","paulm","271195");
         Statement stmt = conn.createStatement();
     ) {
         String strSelect = "select * from `characters`";

         ResultSet rs = stmt.executeQuery(strSelect);

         while(rs.next())
         {
             String name = rs.getString("name");
             String type =  rs.getString("type");
             int health = rs.getInt("life_points");
             int strength = rs.getInt("strength");
             Menu.displayMessage(name + " est un "+type+" qui a "+health+" HP et "+strength+" points d'attaque.");
         }
     } catch (SQLException ex) {
         ex.printStackTrace();
     }

 }
}
