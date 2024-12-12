/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAULSZSZ
 */
public class HistoricoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List listar(int filtro) {
        String sql="";
        switch(filtro){
            case 0:
            sql = "select historico.idHistorico, usuarios.correo, productos.nombre, historico.movimiento, historico.cantidad, historico.fecha from historico inner join usuarios on historico.idUsuario = usuarios.idUsuario inner join productos on historico.idProducto = productos.idProducto order by idHistorico desc";
                break;
            case 1:
            sql = "select historico.idHistorico, usuarios.correo, productos.nombre, historico.movimiento, historico.cantidad, historico.fecha from historico inner join usuarios on historico.idUsuario = usuarios.idUsuario inner join productos on historico.idProducto = productos.idProducto where movimiento = 'ENTRADA' order by idHistorico desc";
                break;
            case 2:
            sql = "select historico.idHistorico, usuarios.correo, productos.nombre, historico.movimiento, historico.cantidad, historico.fecha from historico inner join usuarios on historico.idUsuario = usuarios.idUsuario inner join productos on historico.idProducto = productos.idProducto where movimiento = 'SALIDA' order by idHistorico desc";
                break;
        }
        List<Historico> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Historico h = new Historico();
                h.setIdHistorico(rs.getInt("idHistorico"));
                h.setUsuario(rs.getString("correo"));
                h.setProducto(rs.getString("nombre"));
                h.setMovimiento(rs.getString("movimiento"));
                h.setCantidad(rs.getInt("cantidad"));
                h.setFecha(rs.getString("fecha"));
                lista.add(h);
            }
        } catch (Exception e) {
        }
        return lista;
    }

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
