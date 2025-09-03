package db;



import character.Character;
import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;

public class CharacterTable {
    private DatabaseConnection dbc;


    public CharacterTable() {
        this.dbc = new DatabaseConnection("jdbc:mysql://localhost:3306/sabefh", "paulm", "123saucisse");
    }

    public ArrayList<Object[]> getCharacters() {
        ArrayList<Object[]> characters = new ArrayList<Object[]>();

        try {
            Connection conn = this.dbc.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM characters");

            while(rs.next()){
                Object[] specs = new Object[7];

                specs[0] = rs.getInt("id");
                specs[1] = rs.getString("name");
                specs[2] = rs.getString("type");
                specs[3] = rs.getInt("health");
                specs[4] = rs.getInt("basic_attack");
                specs[5] = rs.getString("offensive_equipment");
                specs[6] = rs.getString("defensive_equipment");
                characters.add(specs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return characters;
    }

    public int createCharacter(Character character) {
        int newId = -1;
        
        try {
            Connection conn = this.dbc.getConnection();
            String insertSql =  "INSERT INTO characters (name, type, health, basic_attack) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, character.getName());
            pstmt.setString(2, character.getType());
            pstmt.setInt(3, character.getHealth());
            pstmt.setInt(4, character.getBasicAttack());

            pstmt.executeUpdate();

            //Récupérer l'ID créé
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                newId =  rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newId;
    }

    public void updateCharacter(Character character) {
        String attackItem = "none";
        String defenseItem = "none";

        if(character.getAttackItem() != null) {
            Gson gson = new Gson();
            attackItem = gson.toJson(character.getAttackItem());
        }
        if(character.getDefenseItem() != null) {
            Gson gson = new Gson();
            defenseItem = gson.toJson(character.getDefenseItem());
        }

        try {
            Connection conn = this.dbc.getConnection();
            String updateSql = "UPDATE characters SET name = ?, type = ?, health = ?, basic_attack = ?, offensive_equipment = ?, defensive_equipment = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateSql);

            pstmt.setString(1, character.getName());
            pstmt.setString(2, character.getType());
            pstmt.setInt(3, character.getHealth());
            pstmt.setInt(4, character.getBasicAttack());
            pstmt.setString(5, attackItem);
            pstmt.setString(6, defenseItem);
            pstmt.setInt(7, character.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeHealth(Character character) {
        try {
            Connection conn = this.dbc.getConnection();
            String updateHealthSql = "UPDATE characters SET health = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateHealthSql);

            pstmt.setInt(1, character.getHealth());
            pstmt.setInt(2, character.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCharacter(Character character) {
        try {
            Connection conn = this.dbc.getConnection();
            String deleteSql = "DELETE FROM characters WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(deleteSql);

            pstmt.setInt(1, character.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
