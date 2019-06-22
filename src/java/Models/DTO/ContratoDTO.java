package Models.DTO;

import java.sql.Date;

/**
 *
 * @author TECMAR
 */
public class ContratoDTO {
    private int id_contrato;
    private Date fecha_inicio;
    private Date fecha_termino;
    private int id_contrato_estado;
    private int id_presupuesto;
    private int id_abogado;
    private int id_plan_pago;
    private Date creado;
    private Date modificado;
    private int aprobado_abogado;
    private int aprobado_cliente;
    private int id_forma_pago;
    private String rol_causa;

    public ContratoDTO() {
    }

    public ContratoDTO(int id_contrato, Date fecha_inicio, Date fecha_termino, int id_contrato_estado, int id_presupuesto, int id_abogado, int id_plan_pago, Date creado, Date modificado, int aprobado_abogado, int aprobado_cliente, int id_forma_pago, String rol_causa) {
        this.id_contrato = id_contrato;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.id_contrato_estado = id_contrato_estado;
        this.id_presupuesto = id_presupuesto;
        this.id_abogado = id_abogado;
        this.id_plan_pago = id_plan_pago;
        this.creado = creado;
        this.modificado = modificado;
        this.aprobado_abogado = aprobado_abogado;
        this.aprobado_cliente = aprobado_cliente;
        this.id_forma_pago = id_forma_pago;
        this.rol_causa = rol_causa;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public int getId_contrato_estado() {
        return id_contrato_estado;
    }

    public void setId_contrato_estado(int id_contrato_estado) {
        this.id_contrato_estado = id_contrato_estado;
    }

    public int getId_presupuesto() {
        return id_presupuesto;
    }

    public void setId_presupuesto(int id_presupuesto) {
        this.id_presupuesto = id_presupuesto;
    }

    public int getId_abogado() {
        return id_abogado;
    }

    public void setId_abogado(int id_abogado) {
        this.id_abogado = id_abogado;
    }

    public int getId_plan_pago() {
        return id_plan_pago;
    }

    public void setId_plan_pago(int id_plan_pago) {
        this.id_plan_pago = id_plan_pago;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getModificado() {
        return modificado;
    }

    public void setModificado(Date modificado) {
        this.modificado = modificado;
    }

    public int getAprobado_abogado() {
        return aprobado_abogado;
    }

    public void setAprobado_abogado(int aprobado_abogado) {
        this.aprobado_abogado = aprobado_abogado;
    }

    public int getAprobado_cliente() {
        return aprobado_cliente;
    }

    public void setAprobado_cliente(int aprobado_cliente) {
        this.aprobado_cliente = aprobado_cliente;
    }

    public int getId_forma_pago() {
        return id_forma_pago;
    }

    public void setId_forma_pago(int id_forma_pago) {
        this.id_forma_pago = id_forma_pago;
    }

    public String getRol_causa() {
        return rol_causa;
    }

    public void setRol_causa(String rol_causa) {
        this.rol_causa = rol_causa;
    }

    @Override
    public String toString() {
        return "ContratoDTO{" + "id_contrato=" + id_contrato + ", fecha_inicio=" + fecha_inicio + ", fecha_termino=" + fecha_termino + ", id_contrato_estado=" + id_contrato_estado + ", id_presupuesto=" + id_presupuesto + ", id_abogado=" + id_abogado + ", id_plan_pago=" + id_plan_pago + ", creado=" + creado + ", modificado=" + modificado + ", aprobado_abogado=" + aprobado_abogado + ", aprobado_cliente=" + aprobado_cliente + ", id_forma_pago=" + id_forma_pago + ", rol_causa=" + rol_causa + '}';
    }

    

    
    
    
}
