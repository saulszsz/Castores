/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author SAULSZSZ
 */
public class HistoricoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    int r;

    public int agregar(Historico his) {
        String sql = "insert into historico(idUsuario,idProducto,movimiento,cantidad,fecha)values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, his.getIdUsuario());
            ps.setInt(2, his.getIdProducto());
            ps.setString(3, his.getMovimiento());
            ps.setInt(4, his.getCantidad());
            ps.setString(5, his.getFecha());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
