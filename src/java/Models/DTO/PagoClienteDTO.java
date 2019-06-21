/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DTO;

/**
 *
 * @author jean
 */
public class PagoClienteDTO {
    
    private PagoDTO pagoDTO;
    private UsuarioDTO cliente;

    public PagoDTO getPagoDTO() {
        return pagoDTO;
    }

    public void setPagoDTO(PagoDTO pagoDTO) {
        this.pagoDTO = pagoDTO;
    }

    public UsuarioDTO getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioDTO cliente) {
        this.cliente = cliente;
    }
    
    
    
}
