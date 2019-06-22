/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Contrato;

import Models.DAO.CausaIdDAO;
import Models.DAO.ContratoDAO;
import Models.DTO.ContratoDTO;
import Models.DAO.ContratoEstadoDAO;
import Models.DTO.CausaIdDTO;
import Models.DTO.ContratoEstadoDTO;
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
@WebServlet(name = "ContratoServlet", urlPatterns = {"/contratos"})
public class ContratoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ContratoDAO contrantoDAO = new ContratoDAO();
    private final ContratoEstadoDAO contratoEstadoDAO = new ContratoEstadoDAO();
    //private final CausaIdDAO causaIdDAO = new CausaIdDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContratoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContratoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<ContratoDTO> contratos = contrantoDAO.getAll();
        List<ContratoEstadoDTO> estados = contratoEstadoDAO.getAll();
        //List<CausaIdDTO> causas = causaIdDAO.getAll();
       
        request.setAttribute("contratos", contratos);
        System.out.println("contratos "+contratos);
        request.setAttribute("estados", estados);
        //request.setAttribute("causas", causas);
        request.setAttribute("nombre", "miguel");
        request.getRequestDispatcher("/modules/contratos/index.jsp").forward(request, response);
         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
