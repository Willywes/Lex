/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import JDBC.Conexion;
import Models.DTO.CausaIdDTO;
import Models.DTO.PresupuestoIDDTO;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author TECMAR
 */
public class CausaIdDAO {
     private final String GET_ALL = "{call LEX.PKG_CAUSAS.READ_ALL_CAUSAS(?)}";
     
     Conexion con = new Conexion();
     
      public List<CausaIdDTO> getAll() {

        List<CausaIdDTO> list = new ArrayList<>();

        try {

            Connection cn = con.open();
            CallableStatement cs = cn.prepareCall(GET_ALL);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            //System.out.println("ANtes de EJecutar");
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {

                CausaIdDTO causaId = new CausaIdDTO();
                causaId.setId_causa(rs.getInt("ID_CAUSA"));
                causaId.setRol(rs.getString("ROL"));
                causaId.setFecha(rs.getDate("FECHA"));
                causaId.setCaratula(rs.getString("CARATULA"));
                causaId.setId_tribunal(rs.getInt("ID_TRIBUNAL"));
               
                list.add(causaId);
            }


        } catch (SQLException | IOException ex) {
            Logger.getLogger(PresupuestoIDDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

        return list;
    }
}
