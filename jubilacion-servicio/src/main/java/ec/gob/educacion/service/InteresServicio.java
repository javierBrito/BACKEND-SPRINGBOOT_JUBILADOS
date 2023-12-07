package ec.gob.educacion.service;

import java.util.List;

import ec.gob.educacion.model.jubilacion.JubInteres;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface InteresServicio {
	
	/**
	 * Permite guardar o actualizar Interes
	 * 
	 * @param Interes a guarda/actualizar
	 * @return Interes guardado
	 */
	JubInteres registrar(JubInteres jubInteres);
	
	/**
	 * Permite buscar Interes por id
	 * @param codigo a buscar
	 * @return  Interes  buscado
	 */
	JubInteres buscarInteresPorCodigo(long intCodigo);

	/**
	 * Permite listar Interes
	 * 
	 * @param estado a buscar
	 * @return lista Interes
	 */
	List<JubInteres> listarInteres();
}
