package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.Conexion;

public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

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
                usr.setContrasena(rs.getString("nombre"));
                usr.setIdRol(rs.getInt("idUsuario"));
                usr.setEstatus(rs.getInt("nombre"));
            }
        } catch (Exception e) {
        }
        return usr;
    }
}
