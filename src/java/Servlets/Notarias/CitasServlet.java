///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Servlets.Notarias;
//
//import Models.DAO.NotariaDAO;
//import Models.DAO.CitaDAO;
//import Models.DTO.NotariaDTO;
//import Models.DTO.CitaDTO;
//import Utilidades.Validator;
//import Utilidades.Utils;
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author willywes
// */
//@WebServlet(name = "CitasServlet", urlPatterns = {"/modulo/citas/*"})
//public class CitasServlet extends HttpServlet {
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String route = request.getPathInfo().substring(1);
//
//// este metodo ql recibe solo las peticiones get
//// index el la venana principal solo la tabla con todos los datos
//// create retorna el formulario para crear algo
//// edit retorna un formulatio similar al de crear pero con los datos del objeto, ejemplo cita
//// show muestra el detalle del ojbeto, 
//// el edit es una mezcla del show y create
//        if (route.contains("index")) {
//
//            index(request, response);
//
//        } else if (route.contains("create")) {
//
//            create(request, response);
//
//        } else if (route.contains("edit")) {
//
//            edit(request, response);
//        } else if (route.contains("show")) {
//
//            show(request, response);
//        } else {
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
//        }
//
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//// este metodo ql recibe solo las peticiones POST
//// el store guadar todo lo que el create envia
//// el upate guarda todo lo que el edit envia
//// el delete elimina segun un parametro id por ejemplo. 
//// el change status cambia el estado de un ojeto mediante un id
//        String route = request.getPathInfo().substring(1);
//
//        if (route.contains("store")) {
//            store(request, response);
//
//        } else if (route.contains("update")) {
//
//            update(request, response);
//
//        } else if (route.contains("delete")) {
//
//            delete(request, response);
//
//        } else if (route.contains("change-status")) {
//
//            changeStatus(request, response);
//
//        } else {
//
//            request.getRequestDispatcher("/").forward(request, response);
//
//        }
//    }
//
//    public void index(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        List<NotariaDTO> notarias = new NotariaDAO().getAll();
//        List<CitaDTO> citas = new CitaDAO().getAll();
//
//        request.setAttribute("notarias", notarias);
//        request.setAttribute("citas", citas);
//
//        request.getRequestDispatcher("/modules/citas/index.jsp").forward(request, response);
//    }
//
//    public void create(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        List<NotariaDTO> notarias = new NotariaDAO().getAll();
//        request.setAttribute("notarias", notarias);
//
//        request.getRequestDispatcher("/modules/citas/create.jsp").forward(request, response);
//
//    }
//
//    public void store(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, ParseException {
//
//        String redirect = "/modules/citas/create.jsp";
//
//        Validator validator = new Validator();
////        validator.addRule("rut", "required|min:8|max:13");
////        validator.addRule("txtfechaHora", "required|min:4|max:30");
////        validator.addRule("paterno", "required|min:4|max:30");
////        validator.addRule("email", "required|email|unique:citas,email");
////        validator.addRule("clave", "required|min:4|max:30");
////        validator.addRule("rol_id", "required");
////
////        validator.addMessage("txtfechaHora.required", "La fecha");
//
//        validator.validar(request);
//
//        Map<String, String> errors = validator.getErrors();
//
//        if (errors.isEmpty()) {
//
//            String fechaCita = request.getParameter("txtfechaHora");
//            String horaCita = request.getParameter("txthora");
//            String minutosCita = request.getParameter("txtminutos");
//            String fechaHora = fechaCita + " " + horaCita + ":" + minutosCita + ":00";
//            System.out.println(fechaHora);
//
//            int idNotaria = Integer.parseInt(request.getParameter("txtidnotaria"));
//     
//
//            CitaDTO citaDTO = new CitaDTO();
//
//            String startDate = fechaHora;
//            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//            java.util.Date date = sdf1.parse(startDate);
//            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//
//            System.out.println(sqlStartDate.toString());
//
//            System.out.println(fechaHora);
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//            Date dateCita = formatter.parse(fechaHora);
//            java.sql.Date sqlDate = new java.sql.Date(dateCita.getTime());
//            System.out.println(sqlDate.toString());
//            citaDTO.setFecha_hora(sqlDate);
//            citaDTO.setId_estado_cita(1);
//            citaDTO.setId_notaria(idNotaria);
//
//            CitaDAO citaDAO = new CitaDAO();
//
//            if (citaDAO.create(citaDTO) == 1) {
//
//                HttpSession session = request.getSession();
//                session.setMaxInactiveInterval(1);
//                session.setAttribute("success", "cita creado correctamente.");
//                response.sendRedirect(request.getContextPath() + "/modulo/citas/index");
//                return;
//
//            } else {
//
//                request.setAttribute("error", "Error al crear al cita, inténtelo denuevo.");
//
//            }
//
//        } else {
//
//            request.setAttribute("error", "Error de validación");
//            request.setAttribute("inputs", validator.getInputs());
//            request.setAttribute("errors", errors);
//
//            List<NotariaDTO> notarias = new NotariaDAO().getAll();
//            request.setAttribute("notarias", notarias);
//
//        }
//
//        request.getRequestDispatcher(redirect).forward(request, response);
//
//    }
//
//    public void edit(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        try {
//
//            String id = request.getParameter("id");
//            if (id == null) {
//
//                HttpSession session = request.getSession();
//                session.setMaxInactiveInterval(1);
//                session.setAttribute("warning", "Cita no encontrada.");
//                response.sendRedirect(request.getContextPath() + "/modulo/citas/index");
//                return;
//
//            }
//
//            CitaDTO cita = new CitaDAO().findById(Integer.parseInt(id));
//
//            if (cita.getId_cita() == 0) {
//
//                HttpSession session = request.getSession();
//                session.setMaxInactiveInterval(1);
//                session.setAttribute("warning", "Cita no encontrada.");
//                response.sendRedirect(request.getContextPath() + "/modulo/citas/index");
//                return;
//
//            }
//
//            List<NotariaDTO> notarias = new NotariaDAO().getAll();
//            request.setAttribute("notarias", notarias);
//            request.setAttribute("cita", cita);
//
//            request.getRequestDispatcher("/modules/citas/update.jsp").forward(request, response);
//
//        } catch (Exception e) {
//
//            HttpSession session = request.getSession();
//            session.setMaxInactiveInterval(1);
//            session.setAttribute("warning", "Cita no encontrada.");
//            response.sendRedirect(request.getContextPath() + "/modulo/citas/index");
//            return;
//        }
//    }
//
//    public void update(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String redirect = "/modules/citas/update.jsp";
//
//        Validator validator = new Validator();
//        validator.addRule("rut", "required|min:8|max:13");
//        validator.addRule("nombres", "required|min:4|max:30");
//        validator.addRule("paterno", "required|min:4|max:30");
//        validator.addRule("email", "required|email|unique:citas,email");
//        validator.addRule("rol_id", "required");
//
//        validator.addMessage("rol_id.required", "Seleccione un rol");
//
//        validator.validar(request);
//
//        Map<String, String> errors = validator.getErrors();
//
//        CitaDTO cita = new CitaDAO().findById(Integer.parseInt(request.getParameter("id")));
//
//        if (errors.isEmpty()) {
//
//            cita.setRut(request.getParameter("rut").toUpperCase());
//            cita.setNombres(request.getParameter("nombres").toUpperCase());
//            cita.setPaterno(request.getParameter("paterno").toUpperCase());
//            cita.setMaterno(request.getParameter("materno").toUpperCase());
//            cita.setEmail(request.getParameter("email").toLowerCase());
//            cita.setId_rol(Integer.parseInt(request.getParameter("id_rol")));
//
//            CitaDAO u = new CitaDAO();
//
//            if (u.update(cita)) {
//
//                HttpSession session = request.getSession();
//                session.setMaxInactiveInterval(1);
//                session.setAttribute("success", "cita modificado correctamente.");
//                response.sendRedirect(request.getContextPath() + "/modulo/citas/index");
//                return;
//
//            } else {
//
//                request.setAttribute("error", "Error al modificar al cita, inténtelo denuevo.");
//
//            }
//
//        } else {
//
//            request.setAttribute("error", "Error de validación");
//            request.setAttribute("inputs", validator.getInputs());
//            request.setAttribute("cita", cita);
//            request.setAttribute("errors", errors);
//
//            List<NotariaDTO> notarias = new NotariaDAO().getAll();
//            request.setAttribute("notarias", notarias);
//
//        }
//
//        request.getRequestDispatcher(redirect).forward(request, response);
//
//    }
//
//    public void show(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    }
//
//    public void delete(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    }
//
//    public void changeStatus(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        try {
//
//            String id = request.getParameter("id");
//
//            if (id == null) {
//
//                HttpSession session = request.getSession();
//                session.setMaxInactiveInterval(1);
//                session.setAttribute("warning", "Cita no encontrada.");
//                response.sendRedirect(request.getContextPath() + "/modulo/citas/index");
//                return;
//            }
//
//            CitaDTO cita = new CitaDAO().findById(Integer.parseInt(id));
//
//            if (cita.getId_cita() == 0) {
//
//                HttpSession session = request.getSession();
//                session.setMaxInactiveInterval(1);
//                session.setAttribute("warning", "Cita no encontrada.");
//                response.sendRedirect(request.getContextPath() + "/modulo/citas/index");
//                return;
//            }
//
//            if (new CitaDAO().delete(cita)) {
//
//                HttpSession session = request.getSession();
//                session.setMaxInactiveInterval(1);
//                session.setAttribute("success", "Estado del cita cambiado correctamente.");
//                response.sendRedirect(request.getContextPath() + "/modulo/citas/index");
//                return;
//
//            } else {
//
//                HttpSession session = request.getSession();
//                session.setMaxInactiveInterval(1);
//                session.setAttribute("errr", "Error al cambiar el estado del cita.");
//                response.sendRedirect(request.getContextPath() + "/modulo/citas/index");
//                return;
//
//            }
//
//        } catch (Exception e) {
//
//            HttpSession session = request.getSession();
//            session.setMaxInactiveInterval(1);
//            session.setAttribute("warning", "Cita no encontrada.");
//            response.sendRedirect(request.getContextPath() + "/modulo/citas/index");
//            return;
//
//        }
//
//    }
//}
