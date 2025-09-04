package db;


import java.util.regex.*;
import character.Character;
import character.Warrior;
import character.Wizard;
import com.google.gson.Gson;
import environment.equipments.defensiveequipment.Shield;
import environment.equipments.offensiveequipment.OffensiveEquipment;
import environment.equipments.offensiveequipment.spell.Fireball;
import environment.equipments.offensiveequipment.spell.Thunder;
import environment.equipments.offensiveequipment.weapon.Club;
import environment.equipments.offensiveequipment.weapon.Sword;
import environment.equipments.offensiveequipment.weapon.Weapon;


import java.sql.*;
import java.util.ArrayList;

public class CharacterTable {
    private DatabaseConnection dbc;


    public CharacterTable() {
        this.dbc = new DatabaseConnection("jdbc:mysql://localhost:3306/sabefh", "paulm", "123saucisse");
    }

    public ArrayList<Character> getCharacters() {
        ArrayList<Character> characters = new ArrayList<Character>();

        try {
            Connection conn = this.dbc.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM characters");

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                String stringWeapon = rs.getString("offensive_equipment");
                String stringShield = rs.getString("defensive_equipment");

                Character newCharacter = characterFactory(id, name, type, stringWeapon, stringShield);
                characters.add(newCharacter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return characters;
    }

    private Character characterFactory(int id, String name, String type, String stringWeapon, String stringShield) {
        Character newCharacter = null ;
        switch (type) {
            case "Warrior":
                newCharacter = new Warrior(name);
                break;
            case "Wizard":
                newCharacter = new Wizard(name);
        }
        if (!stringWeapon.equals("none")) {
            newCharacter.setAttackItem(convertWeaponToObject(stringWeapon));
        }
        if (!stringShield.equals("none")) {
            newCharacter.setDefenseItem(convertShieldToObject(stringShield));
        }
        newCharacter.setId(id);
        return newCharacter;
    }

    private OffensiveEquipment convertWeaponToObject(String stringWeapon) {
        OffensiveEquipment weapon = null;
        Gson gson = new Gson();
        Pattern clubPattern = Pattern.compile("club", Pattern.CASE_INSENSITIVE);
        Pattern swordPattern = Pattern.compile("sword", Pattern.CASE_INSENSITIVE);
        Pattern fireballPattern = Pattern.compile("fireball", Pattern.CASE_INSENSITIVE);
        Pattern thunderPattern = Pattern.compile("thunder", Pattern.CASE_INSENSITIVE);
        Matcher matcher;

        if(clubPattern.matcher(stringWeapon).find()) {
           weapon = gson.fromJson(stringWeapon, Club.class);
        }
        if(swordPattern.matcher(stringWeapon).find()) {
            weapon = gson.fromJson(stringWeapon, Sword.class);
        }
        if(fireballPattern.matcher(stringWeapon).find()) {
            weapon = gson.fromJson(stringWeapon, Fireball.class);
        }
        if(thunderPattern.matcher(stringWeapon).find()) {
            weapon = gson.fromJson(stringWeapon, Thunder.class);
        }

        return weapon;
    }

    private Shield convertShieldToObject(String stringShield) {
        Gson gson = new Gson();
        return gson.fromJson(stringShield, Shield.class);
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
