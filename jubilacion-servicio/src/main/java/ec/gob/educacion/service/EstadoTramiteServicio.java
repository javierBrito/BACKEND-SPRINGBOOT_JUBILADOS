package ec.gob.educacion.service;

import java.util.List;
import ec.gob.educacion.model.jubilacion.JubEstadoTramite;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface EstadoTramiteServicio {
	/**
	 * Permite guardar o actualizar EstadoTramite
	 * 
	 * @param EstadoTramite a guarda/actualizar
	 * @return EstadoTramite guardado
	 */
	JubEstadoTramite registrar(JubEstadoTramite jubEstadoTramite);
	
	/**
	 * Permite buscar EstadoTramite por nombre
	 * @param nombre a buscar
	 * @return  EstadoTramite  buscado
	 */
	JubEstadoTramite buscarEstadoTramitePorNombre(String esttraNombre);
	
	/**
	 * Permite buscar EstadoTramite por id
	 * @param codigo a buscar
	 * @return  EstadoTramite  buscado
	 */
	JubEstadoTramite buscarEstadoTramitePorCodigo(Long esttraCodigo);	

	/**
	 * Permite listar EstadoTramite
	 * 
	 * @param estado a buscar
	 * @return lista EstadoTramite
	 */
	List<JubEstadoTramite> listarEstadoTramite();

	/**
	 * Permite listar EstadoTramite
	 * 
	 * @param estado a buscar
	 * @return lista EstadoTramite
	 */
	List<JubEstadoTramite> listarEstadoTramitePorAspirante(Long aspCodigo);
	
	/**
	 * Permite eliminar un EstadoTramite
	 * 
	 * @param EstadoTramite a eliminar
	 * @return EstadoTramite eliminada
	 */
	JubEstadoTramite eliminar(JubEstadoTramite jubEstadoTramite);
}
