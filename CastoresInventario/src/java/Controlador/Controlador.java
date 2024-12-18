/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Historico;
import Modelo.HistoricoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SAULSZSZ
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Usuario usr = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();
    Producto pro = new Producto();
    ProductoDAO prodao = new ProductoDAO();
    Historico his = new Historico();
    HistoricoDAO hisdao = new HistoricoDAO();
    int idPro;
    List lista;
    List listaHis;
    int VisAgregar;
    int VisAumentar;
    int VisSacar;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            usr = (Usuario) request.getAttribute("usuario");
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Inventario")) {
            switch (accion) {
                case "Listar":
                    lista = prodao.listar(usr.getIdRol());
                    request.setAttribute("productos", lista);
                    request.setAttribute("VisAgregar", VisAgregar);
                    request.setAttribute("VisAumentar", VisAumentar);
                    request.setAttribute("VisSacar", VisSacar);
                    request.setAttribute("usr", usr);
                    break;
                case "VistaAgregar":
                    VisAgregar = 1;
                    VisAumentar = 0;
                    VisSacar = 0;
                    request.getRequestDispatcher("Controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Agregar":
                    VisAgregar = 0;
                    String nombre = request.getParameter("txtNombre");
                    String descripcion = request.getParameter("txtDescripcion");
                    String estatus = request.getParameter("selEstatus");
                    pro.setNombre(nombre);
                    pro.setDescripcion(descripcion);
                    pro.setEstatus(estatus);
                    prodao.agregar(pro);
                    request.getRequestDispatcher("Controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Aumenta":
                    VisAgregar = 0;
                    VisAumentar = 1;
                    VisSacar = 0;
                    idPro = Integer.parseInt(request.getParameter("id"));
                    Producto p = prodao.listarId(idPro);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Aumentar":
                    VisAumentar = 0;
                    int idProductoAu = Integer.parseInt(request.getParameter("txtIdProductoAu"));
                    String nombreAu = request.getParameter("txtNombreAu");
                    int inventarioAu = Integer.parseInt(request.getParameter("txtInventarioAu")) + Integer.parseInt(request.getParameter("txtAumentar"));
                    pro.setIdProducto(idProductoAu);
                    pro.setNombre(nombreAu);
                    pro.setInventario(inventarioAu);
                    prodao.actualizarInventario(pro);
                    his.setIdUsuario(usr.getIdUsuario());
                    his.setIdProducto(pro.getIdProducto());
                    his.setMovimiento("ENTRADA");
                    his.setCantidad(Integer.parseInt(request.getParameter("txtAumentar")));
                    Date todayDate = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String fechaActual = sdf.format(todayDate);
                    his.setFecha(fechaActual);
                    hisdao.agregar(his);
                    request.getRequestDispatcher("Controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Saca":
                    VisAgregar = 0;
                    VisAumentar = 0;
                    VisSacar = 1;
                    idPro = Integer.parseInt(request.getParameter("id"));
                    Producto p2 = prodao.listarId(idPro);
                    request.setAttribute("producto", p2);
                    request.getRequestDispatcher("Controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Sacar":
                    VisSacar = 0;
                    int idProductoAu2 = Integer.parseInt(request.getParameter("txtIdProductoAu"));
                    String nombreAu2 = request.getParameter("txtNombreAu");
                    int inventarioAu2 = Integer.parseInt(request.getParameter("txtInventarioAu")) - Integer.parseInt(request.getParameter("txtAumentar"));
                    pro.setIdProducto(idProductoAu2);
                    pro.setNombre(nombreAu2);
                    pro.setInventario(inventarioAu2);
                    prodao.actualizarInventario(pro);
                    his.setIdUsuario(usr.getIdUsuario());
                    his.setIdProducto(pro.getIdProducto());
                    his.setMovimiento("SALIDA");
                    his.setCantidad(Integer.parseInt(request.getParameter("txtAumentar")));
                    Date todayDate2 = new Date();
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String fechaActual2 = sdf2.format(todayDate2);
                    his.setFecha(fechaActual2);
                    hisdao.agregar(his);
                    request.getRequestDispatcher("Controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Bajar":
                    VisAgregar = 0;
                    VisAumentar = 0;
                    VisSacar = 0;
                    idPro = Integer.parseInt(request.getParameter("id"));
                    pro.setIdProducto(idPro);
                    pro.setEstatus("BAJA");
                    prodao.bajar(pro);
                    request.getRequestDispatcher("Controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Activar":
                    VisAgregar = 0;
                    VisAumentar = 0;
                    VisSacar = 0;
                    idPro = Integer.parseInt(request.getParameter("id"));
                    pro.setIdProducto(idPro);
                    pro.setEstatus("ACTIVO");
                    prodao.activar(pro);
                    request.getRequestDispatcher("Controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Inventario.jsp").forward(request, response);
        }
        if (menu.equals("Historial")) {
            switch (accion) {
                case "Listar":
                    listaHis = hisdao.listar(0);
                    break;
                case "ListarEntrada":
                    listaHis = hisdao.listar(1);
                    break;
                case "ListarSalida":
                    listaHis = hisdao.listar(2);
                    break;
                default:
                    throw new AssertionError();
            }
            request.setAttribute("historicos", listaHis);
            request.getRequestDispatcher("Historial.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
