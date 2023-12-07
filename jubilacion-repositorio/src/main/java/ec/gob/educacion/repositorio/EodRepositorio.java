package ec.gob.educacion.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.gob.educacion.model.jubilacion.JubEod;

/**
* Repositorio para la entidad JubEod
* 
* @author jbrito
*
*/

public interface EodRepositorio extends JpaRepository<JubEod, Integer>{

	/**
	 * Permite buscar Eod  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Eod
	 */	
	JubEod  findByEodCodigo(Long eodCodigo);
	
	/**
	 * Permite listar Eod
	 * 
	 * @param estado a buscar
	 * @return lista de Eod
	 */
	List<JubEod> findByEodEstado(int eodEstado);
}
