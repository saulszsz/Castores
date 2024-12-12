/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SAULSZSZ
 */
public class Historico {

    int idHistorico;
    int idUsuario;
    int idProducto;
    String movimiento;
    int cantidad;
    String fecha;

    public Historico() {
    }

    public Historico(int idHistorico, int idUsuario, int idProducto, String movimiento, int cantidad, String fecha) {
        this.idHistorico = idHistorico;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.movimiento = movimiento;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
