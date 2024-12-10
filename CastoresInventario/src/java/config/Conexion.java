/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SAULSZSZ
 */
public class Conexion {

    Connection con;
    String url = "jdbc:mysql://localhost:8089/castores";
    String user = "admin";
    String pass = "admin";

    public Connection Conexion() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("libs.PostgreSQLDriver.classpath");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
        }
        return con;
    }
}
