package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.Conexion;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Usuario validar(String user, String pass) {
        Usuario usr = new Usuario();
        String sql = "select * from usuarios where correo=? and contrasena=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                usr.setIdUsuario(rs.getInt("idUsuario"));
                usr.setNombre(rs.getString("nombre"));
                usr.setCorreo(rs.getString("correo"));
                usr.setContrasena(rs.getString("contrasena"));
                usr.setIdRol(rs.getInt("idRol"));
                usr.setEstatus(rs.getInt("estatus"));
            }
        } catch (Exception e) {
        }
        return usr;
    }

    public List listar() {
        String sql = "select * from usuarios";
        List<Usuario> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setContrasena(rs.getString("contrasena"));
                u.setIdRol(rs.getInt("idRol"));
                u.setEstatus(rs.getInt("estatus"));
                lista.add(u);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Usuario usr) {
        String sql = "insert into usuarios(nombre,correo,contrasena,idRol,estatus)values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getCorreo());
            ps.setString(3, usr.getContrasena());
            ps.setInt(4, usr.getIdRol());
            ps.setInt(5, usr.getEstatus());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
