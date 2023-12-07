package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubTipoLey;

/**
* Repositorio para la entidad tiplCodigo
* 
* @author Belen Changoluisa
*
*/

public interface TipoLeyRepositorio extends JpaRepository<JubTipoLey, Integer>{

	/**
	 * Permite buscar TipoLey  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de TipoLey
	 */	
	JubTipoLey  findByTipleyCodigo( long tipleyCodigo);

	/**
	 * Permite listar TipoLey
	 * 
	 * @param estado a buscar
	 * @return lista de TipoLey
	 */
	List<JubTipoLey> findByTipleyEstadoOrderByTipleyNombreAsc(int tipleyEstado);
}
