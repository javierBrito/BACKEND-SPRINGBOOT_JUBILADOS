package ec.gob.educacion.service;

import java.util.List;

import ec.gob.educacion.model.jubilacion.JubPago;


/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface PagoServicio {
	
	/**
	 * Permite guardar o actualizar Pago
	 * 
	 * @param Pago a guarda/actualizar
	 * @return Pago guardado
	 */
	JubPago registrar(JubPago jubPago);
	
	/**
	 * Permite buscar Pago por id
	 * @param codigo a buscar
	 * @return  Pago  buscado
	 */
	JubPago buscarPagoPorCodigo(long pagCodigo);
	

	/**
	 * Permite listar Pago
	 * 
	 * @param estado a buscar
	 * @return lista Pago
	 */
	List<JubPago> listarPago();
}
