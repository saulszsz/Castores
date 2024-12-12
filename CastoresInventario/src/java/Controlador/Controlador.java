/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
    Producto pro = new Producto();
    ProductoDAO prodao = new ProductoDAO();
    int idPro;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Inventario")) {
            switch (accion) {
                case "Listar":
                    List lista = prodao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
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
                    idPro = Integer.parseInt(request.getParameter("id"));
                    Producto p = prodao.listarId(idPro);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Aumentar":
                    int idProductoAu = Integer.parseInt(request.getParameter("txtIdProductoAu"));
                    String nombreAu = request.getParameter("txtNombreAu");
                    int inventarioAu = Integer.parseInt(request.getParameter("txtInventarioAu")) + Integer.parseInt(request.getParameter("txtAumentar"));
                    pro.setIdProducto(idProductoAu);
                    pro.setNombre(nombreAu);
                    pro.setInventario(inventarioAu);
                    prodao.actualizarInventario(pro);
                    request.getRequestDispatcher("Controlador?menu=Inventario&accion=Listar").forward(request, response);
                    break;
                case "Sacar":
                    break;
                case "Bajar":
                    break;
                case "Activar":
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Inventario.jsp").forward(request, response);
        }
        if (menu.equals("Historial")) {
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
