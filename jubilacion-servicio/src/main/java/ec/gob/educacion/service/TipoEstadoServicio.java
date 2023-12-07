package ec.gob.educacion.service;

import java.util.List;

import ec.gob.educacion.model.jubilacion.JubTipoEstado;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TipoEstadoServicio {
	
	/**
	 * Permite guardar o actualizar Tipo Estado
	 * 
	 * @param Tipo Estado a guarda/actualizar
	 * @return Tipo Estado guardado
	 */
	JubTipoEstado registrar(JubTipoEstado jubTipoEstado);
	
	/**
	 * Permite buscar Tipo Estado por id
	 * @param codigo a buscar
	 * @return  Tipo Estado  buscado
	 */
	JubTipoEstado buscarTipoEstadoPorCodigo(long tipestCodigo);
	

	/**
	 * Permite listar Tipo Estado
	 * 
	 * @param estado a buscar
	 * @return lista Tipo Estado
	 */
	List<JubTipoEstado> listarTipoEstado();
}
