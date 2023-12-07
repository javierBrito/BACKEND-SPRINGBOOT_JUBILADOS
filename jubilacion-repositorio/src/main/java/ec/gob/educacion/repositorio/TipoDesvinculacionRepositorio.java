package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubTipoDesvinculacion;

/**
* Repositorio para la entidad JubTipoDesvinculacion
*
*/

public interface TipoDesvinculacionRepositorio extends JpaRepository<JubTipoDesvinculacion, Integer>{

	/**
	 * Permite buscar Tipo Desvinculacion  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Tipo Desvinculacion
	 */	
	JubTipoDesvinculacion findByTipdesCodigo(long tipdesCodigo);
	
	/**
	 * Permite listar Tipo Desvinculacion
	 * 
	 * @param estado a buscar
	 * @return lista de Tipo Desvinculacion
	 */
	List<JubTipoDesvinculacion> findByTipdesEstadoOrderByTipdesNombreAsc(int tipdesEstado);

}
