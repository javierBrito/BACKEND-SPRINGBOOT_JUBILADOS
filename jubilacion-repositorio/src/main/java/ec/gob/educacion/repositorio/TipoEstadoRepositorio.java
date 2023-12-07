package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubTipoEstado;

/**
* Repositorio para la entidad JubTipoEstado
*
*/

public interface TipoEstadoRepositorio extends JpaRepository<JubTipoEstado, Integer>{

	/**
	 * Permite buscar Tipo Estado  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Tipo Estado
	 */	
	JubTipoEstado  findByTipestCodigo( long tipestCodigo);

	/**
	 * Permite listar Tipo Estado
	 * 
	 * @param estado a buscar
	 * @return lista de Tipo Estado
	 */
	List<JubTipoEstado> findByTipestEstadoOrderByTipestNombreAsc(int tipestEstado);
}
