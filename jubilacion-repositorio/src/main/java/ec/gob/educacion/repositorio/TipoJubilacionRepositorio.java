package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubTipoJubilacion;

/**
* Repositorio para la entidad JubTipoJubilacion
*
*/

public interface TipoJubilacionRepositorio extends JpaRepository<JubTipoJubilacion, Integer>{

	/**
	 * Permite buscar Tipo Jubilacion  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Tipo Jubilacion
	 */	
	JubTipoJubilacion  findByTipjubCodigo( long tipjubCodigo);

	/**
	 * Permite listar Tipo Jubilacion
	 * 
	 * @param estado a buscar
	 * @return lista de Tipo Jubilacion
	 */
	List<JubTipoJubilacion> findByTipjubEstadoOrderByTipjubNombreAsc(int tipjubEstado);
}
