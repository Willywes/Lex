/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Usuarios;

import Models.DAO.CitaDAO;
import Models.DTO.CitaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claudio
 */
@WebServlet(name = "CitaServlet", urlPatterns = {"/citas"})
public class CitaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final CitaDAO citaDAO = new CitaDAO();
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CitaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CitaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        
         List<CitaDTO> citas = citaDAO.getAll();
        request.setAttribute("citas", citas);        
        request.getRequestDispatcher("/modules/citas/index.jsp").forward(request, response);
       
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
        String accion= request.getParameter("accion");
        switch (accion){
            case "Listar":
             //   List<CitaDTO>datos= dao.listar() ;
                
            //    request.setAttribute("datos",datos);//enviar a vista
         //       request.getRequestDispatcher("index.jsp").forward(request, response);
                
                break;
            case "Nuevo":
                request.getRequestDispatcher("add.jsp").forward(request, response);
                break;
            
            case "Guardar":

                    int id=10;
                    String fechaHora =request.getParameter("txtfechaHora");
                    int idNotaria=Integer.parseInt(request.getParameter("txtidnotaria"));
                    int estadoCita = Integer.parseInt(request.getParameter("txtestadonotaria"));
                    
                    CitaDTO citaDTO = new CitaDTO();
                    citaDTO.setId_cita(id);
                    citaDTO.setFecha_hora(fechaHora);
                    citaDTO.setId_estado_cita(estadoCita); 
                    citaDTO.setId_notaria(idNotaria);
                   
                    
                    citaDAO.create(citaDTO);
                    request.getRequestDispatcher("/modules/citas/index.jsp").forward(request, response);
                    
                break;
                
            case "Editar":
               
                    int ide=Integer.parseInt(request.getParameter("id"));
           //         Solicitud sEditar=dao.listarID(ide);
          //          request.setAttribute("solicitud", sEditar);
                    request.getRequestDispatcher("edit.jsp").forward(request, response);
                    break;
                    
            case "Actualizar":
                
                    int idA=Integer.parseInt(request.getParameter("txtid"));
                    String fechahoraA=request.getParameter("txtfechaHora");
                    String descripcionA=request.getParameter("txtDescripcion");
                    int id_TipoA=Integer.parseInt(request.getParameter("txtid_tipo"));
                    int id_estadoA=Integer.parseInt(request.getParameter("txtid_estado"));
                    String creadoA=request.getParameter("txtcreado");
                    String modificadoA=request.getParameter("txtmodificado");
                    int id_clienteA=Integer.parseInt(request.getParameter("txtid_cliente"));
                    int id_tecnicoA=Integer.parseInt(request.getParameter("txtid_tecnico"));
         /*           s.setIdSolicitud(idA);
                    s.setFechaHora(fechahoraA);
                    s.setDescripcion(descripcionA);
                    s.setId_tipo(id_TipoA);
                    s.setId_estado(id_estadoA);
                    s.setCreado(creadoA);
                    s.setModificado(modificadoA);
                    s.setId_cliente(id_clienteA);
                    s.setId_tecnico(id_tecnicoA);
                    

                    dao.actualizar(s);
                    */
                    request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
                
            case "Eliminar":
                    System.out.println("Entro al SERVLET");
                    int idEliminar =Integer.parseInt(request.getParameter("id")); //rescato id desde index 
                     citaDAO.delete(idEliminar);//llamo a metodo y envio ID
                    request.getRequestDispatcher("/modules/citas/index.jsp").forward(request, response);
                    break;
            case "Cambiar estado":
                
                    int idC=Integer.parseInt(request.getParameter("txtid"));
                    
                    
                //     dao.cambiarEstado(idC);
                    request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                
                    break;
               
               
                default:
                throw new AssertionError();
            
        }
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
