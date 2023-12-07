package ec.gob.educacion.service;

import java.util.List;
import ec.gob.educacion.model.jubilacion.JubTipoDesvinculacion;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TipoDesvinculacionServicio {
	/**
	 * Permite guardar o actualizar Tipo Desvinculacion	 * 
	 * @param Tipo Desvinculacion a guarda/actualizar
	 * @return Tipo Desvinculacion guardado
	 */
	JubTipoDesvinculacion registrar(JubTipoDesvinculacion jubTipoDesvinculacion);
	
	/**
	 * Permite buscar Tipo Desvinculacion por id
	 * @param codigo a buscar
	 * @return  Tipo Desvinculacion  buscado
	 */
	JubTipoDesvinculacion buscarTipoDesvinculacionPorCodigo(long tipdesCodigo);

	/**
	 * Permite listar Tipo Desvinculacion
	 * 
	 * @param estado a buscar
	 * @return lista Tipo Desvinculacion
	 */
	List<JubTipoDesvinculacion> listarTipoDesvinculacion();
	
	/**
	 * Permite eliminar un Tipo Desvinculacion
	 * 
	 * @param Tipo Desvinculacion a eliminar
	 * @return Tipo Desvinculacion eliminada
	 */
	JubTipoDesvinculacion eliminar(JubTipoDesvinculacion jubTipoDesvinculacion);
}
