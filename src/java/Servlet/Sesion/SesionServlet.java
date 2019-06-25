/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Sesion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import JDBC.Conexion;
import Models.DAO.UsuarioDAO;
import Models.DTO.UsuarioDTO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.*;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Depredador
 */
@WebServlet(name = "SesionServlet", urlPatterns = {"/SesionServlet"})
public class SesionServlet extends HttpServlet {
      Conexion conex = new Conexion();
    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    String rut = null;
    String clave , clv= null;
    String perfil = null;
    String estado = null ;
    int rol = 0;
    int id;
     StringBuilder sb = new StringBuilder();
    boolean existe=false;
   
     
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
         UsuarioDTO usuarioDTO= new UsuarioDTO();
         UsuarioDAO usuarioDAO= new UsuarioDAO();
         
       // response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       out.println("ingresando al request");
        try  {
            rut = request.getParameter("usuario");
            clave= request.getParameter("clave");
            rol = request.getIntHeader("rol");
            id = request.getIntHeader("id");
            out.println("usuario"+rut);
            out.println("clave"+clave);
            orden= conex.open().createStatement();
            resul = orden.executeQuery("SELECT * from usuarios WHERE(RUT='"+rut+"')");
            if (resul.next()) {
                this.rut= resul.getString(2);
                this.clv= resul.getString(8);
                this.rol= resul.getInt(13);
                this.id= resul.getInt(1);
                
                out.println(resul.getString(2));
                out.println(resul.getString(8));
                out.println(resul.getInt(13));
              //  System.out.println(rut+"rut");
               // System.out.println(clv+"clave");
               // System.out.println(rol+"rol");
               // System.out.println(id+"id");
                usuarioDTO = usuarioDAO.findById(id);
                
                
                
                if (this.clave.toString().equals(clv) ) {
                     existe = true;
                }
               
                
            }
            if (existe) {
               
                //levanta
                   HttpSession misession= request.getSession(true);
              //esta arribba
              //Producto miproducto= new Producto(1,"telefono",300);
             misession.setAttribute("usuarioDTO",usuarioDTO);
        
               request.setAttribute("usuarioDTO",usuarioDTO);

                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
            }else out.println("<h3>Servlet de autenticacion fallado"+ request.getContextPath()+"<h3>");
            
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ServletAutenticacion</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ServletAutenticacion at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }catch (Exception e){
        out.println("<h3>no entrta al try"+ request.getContextPath()+"<h3>");
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
        
        request.getRequestDispatcher("/Lex");
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
