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
public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List listar() {
        String sql = "select * from productos";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setInventario(rs.getInt("inventario"));
                p.setEstatus(rs.getString("estatus"));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Producto pro) {
        String sql = "insert into productos(nombre,descripcion,estatus)values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setString(3, pro.getEstatus());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Producto listarId(int id) {
        String sql = "select * from productos where idProducto="+id;
        Producto p = new Producto();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setInventario(rs.getInt(4));
                p.setEstatus(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }

    public int actualizarInventario(Producto pro) {
        String sql = "update productos set inventario=? where idProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getInventario());
            ps.setInt(2, pro.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int bajar(Producto pro) {
        String sql = "update productos set estatus=0 where idProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int activar(Producto pro) {
        String sql = "update productos set estatus=1 where idProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
