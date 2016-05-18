/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author abelo
 */
public class DbConnection {
    String url = "jdbc:mysql://localhost:3306/entries";
    String username = "admin";
    String password = "12345";
    Connection conn;
    JSONObject jsonobject;
    JSONArray jsonObjectList;
    
    DbConnection(){
        try {
            this.conn =  DriverManager.getConnection(url, username, password);
            jsonObjectList = new JSONArray();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void setJsonobject(String query_word) {
        Statement  stmt = null;
        String query = "select * from entries where word =" + "'" + query_word + "'" + ";";
        try{
            stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
//            ResultSetMetaData rsmd = rs.getMetaData();
//            String word = rsmd.getColumnName(1);
//            String wordtype = rsmd.getColumnName(2);
//            String definition = rsmd.getColumnName(3);
//            System.out.println("columns: "+word+" "+wordtype+" "+definition);
            int index = 0;
            while (rs.next()) {
                //Retrieve by column name
                jsonobject = new JSONObject();
                
                jsonobject.put("word", rs.getString("word"));
                jsonobject.put("wordtype", rs.getString("wordtype"));
                jsonobject.put("definition", rs.getString("definition"));
                jsonObjectList.add(index, jsonobject);

                index++;
            }

        }catch(Exception e){System.out.println(e);}                      

        
    }

    public JSONArray getJsonObjectList() {
        return jsonObjectList;
    }
    
    public JSONObject getJsonobject(){
        
        return this.jsonobject;
    }
        
}
