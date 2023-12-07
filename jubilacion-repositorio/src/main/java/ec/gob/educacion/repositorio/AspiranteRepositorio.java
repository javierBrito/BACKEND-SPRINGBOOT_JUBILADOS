package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubAspirante;

/**
* Repositorio para la entidad JubAspirante
* 
* @author jbrito-20230426
*
*/

public interface AspiranteRepositorio extends JpaRepository<JubAspirante, Integer>{

	/**
	 * Permite buscar Aspirante  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Aspirante
	 */	
	JubAspirante  findByAspCodigo(Long aspCodigo);
	
	/**
	 * Permite buscar Aspirante  por cedula
	 * 
	 * @param cedula de busqueda
	 * @return objeto de Aspirante
	 */	
	JubAspirante  findByAspCedulaAndAspEstado(String aspCedula, int aspEstado);
	
	/**
	 * Permite listar Aspirante
	 * 
	 * @param estado a buscar
	 * @return lista de Aspirante
	 */
	List<JubAspirante> findByAspEstadoOrderByAspCedulaAsc(int aspEstado);

}
