package ec.gob.educacion.service;

import java.util.List;

import ec.gob.educacion.model.DTO.DiscapacidadDTO;
import ec.gob.educacion.model.jubilacion.JubTipoDiscapacidad;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TipoDiscapacidadServicio {
	
	/**
	 * Permite guardar o actualizar Tipo Discapacidad
	 * 
	 * @param Tipo Discapacidad a guarda/actualizar
	 * @return Tipo Discapacidad guardado
	 */
	JubTipoDiscapacidad registrar(DiscapacidadDTO discapacidadDTO);
	
	/**
	 * Permite buscar Tipo Discapacidad por id
	 * @param codigo a buscar
	 * @return  Tipo Discapacidad  buscado
	 */
	JubTipoDiscapacidad buscarTipoDiscapacidadPorCodigo(long tipdisCodigo);
	

	/**
	 * Permite listar Tipo Discapacidad
	 * 
	 * @param estado a buscar
	 * @return lista Tipo Discapacidad
	 */
	List<JubTipoDiscapacidad> listarTipoDiscapacidad();
	
	/**
	 * Permite eliminar un Discapacidad
	 * 
	 * @param Discapacidad a eliminar
	 * @return Discapacidad eliminada
	 */
	JubTipoDiscapacidad eliminar(JubTipoDiscapacidad jubTipoDiscapacidad);
}
