package ec.gob.educacion.service;

import java.util.List;

import ec.gob.educacion.model.DTO.DesvinculacionDTO;
import ec.gob.educacion.model.jubilacion.JubDesvinculacion;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface DesvinculacionServicio {

	/**
	 * Permite guardar o actualizar Desvinculacion
	 * 
	 * @param Desvinculacion a guarda/actualizar
	 * @return Desvinculacion guardado
	 */
	JubDesvinculacion registrar(DesvinculacionDTO desvinculacionDTO);
	
	/**
	 * Permite buscar Desvinculacion por id
	 * @param codigo a buscar
	 * @return  Desvinculacion  buscado
	 */
	JubDesvinculacion buscarDesvinculacionPorCodigo(long desCodigo);
	
	/**
	 * Permite listar Desvinculacion
	 * 
	 * @param estado a buscar
	 * @return lista Desvinculacion
	 */
	List<JubDesvinculacion> listarDesvinculacion();
	
	/**
	 * Permite eliminar un Desvinculacion
	 * 
	 * @param Desvinculacion a eliminar
	 * @return Desvinculacion eliminada
	 */
	JubDesvinculacion eliminar(JubDesvinculacion jubDesvinculacion);
}
