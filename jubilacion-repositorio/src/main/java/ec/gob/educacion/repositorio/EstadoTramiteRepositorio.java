package ec.gob.educacion.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.gob.educacion.model.jubilacion.JubEstadoTramite;

/**
* Repositorio para la entidad JubEstadoTramite
* 
* @author jbrito-20230426
*
*/

public interface EstadoTramiteRepositorio extends JpaRepository<JubEstadoTramite, Integer>{
	/**
	 * Permite buscar EstadoTramite  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de EstadoTramite
	 */	
	JubEstadoTramite  findByEsttraCodigo(Long esttraCodigo);
	
	/**
	 * Permite buscar EstadoTramite por nombre
	 * 
	 * @param nombre de busqueda
	 * @return objeto de EstadoTramite
	 */	
	JubEstadoTramite  findByEsttraNombre(String esttraNombre);
	
	/**
	 * Permite listar EstadoTramite
	 * 
	 * @param estado a buscar
	 * @return lista de EstadoTramite
	 */
	List<JubEstadoTramite> findByEsttraEstado(int esttraEstado);
	
	/**
	 * Permite listar EstadoTramite
	 * 
	 * @param estado a buscar
	 * @return lista de EstadoTramite
	 */
	List<JubEstadoTramite> findByAspCodigo(Long aspCodigo);
}
