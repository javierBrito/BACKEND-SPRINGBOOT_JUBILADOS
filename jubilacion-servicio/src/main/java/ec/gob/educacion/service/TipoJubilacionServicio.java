package ec.gob.educacion.service;

import java.util.List;

import ec.gob.educacion.model.jubilacion.JubTipoJubilacion;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TipoJubilacionServicio {
	
	/**
	 * Permite guardar o actualizar Tipo Jubilacion
	 * 
	 * @param Tipo Jubilacion a guarda/actualizar
	 * @return Tipo Jubilacion guardado
	 */
	JubTipoJubilacion registrar(JubTipoJubilacion jubTipoJubilacion);
	
	/**
	 * Permite buscar Tipo Jubilacion por id
	 * @param codigo a buscar
	 * @return  Tipo Jubilacion  buscado
	 */
	JubTipoJubilacion buscarTipoJubilacionPorCodigo(long tipjubCodigo);
	

	/**
	 * Permite listar Tipo Jubilacion
	 * 
	 * @param estado a buscar
	 * @return lista Tipo Jubilacion
	 */
	List<JubTipoJubilacion> listarTipoJubilacion();
}
