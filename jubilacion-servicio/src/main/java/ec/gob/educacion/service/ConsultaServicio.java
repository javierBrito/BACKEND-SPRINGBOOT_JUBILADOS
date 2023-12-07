package ec.gob.educacion.service;

import java.util.List;

import ec.gob.educacion.model.jubilacion.JubConsulta;


/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface ConsultaServicio {
	
	/**
	 * Permite guardar o actualizar Pago
	 * 
	 * @param Pago a guarda/actualizar
	 * @return Pago guardado
	 */
	JubConsulta registrar(JubConsulta jubPago);
	
	/**
	 * Permite buscar Pago por id
	 * @param codigo a buscar
	 * @return  Pago  buscado
	 */
	JubConsulta buscarPagoPorCodigo(long conCodigo);
	

	/**
	 * Permite listar Pago
	 * 
	 * @param estado a buscar
	 * @return lista Pago
	 */
	List<JubConsulta> listaPagos();
}
