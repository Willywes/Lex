/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

/**
 *
 * @author Funny
 */
public class PagosContratoClienteDTO {
    
    private ContratoDTO contrato;
    private PagoDTO pago;
    private UsuarioDTO cliente;
    private PlanPagoDTO planPago;

    public ContratoDTO getContrato() {
        return contrato;
    }

    public void setContrato(ContratoDTO contrato) {
        this.contrato = contrato;
    }

    public PagoDTO getPago() {
        return pago;
    }

    public void setPago(PagoDTO pago) {
        this.pago = pago;
    }

    public UsuarioDTO getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioDTO cliente) {
        this.cliente = cliente;
    }

    public PlanPagoDTO getPlanPago() {
        return planPago;
    }

    public void setPlanPago(PlanPagoDTO planPago) {
        this.planPago = planPago;
    }

   
    
    
    
}
