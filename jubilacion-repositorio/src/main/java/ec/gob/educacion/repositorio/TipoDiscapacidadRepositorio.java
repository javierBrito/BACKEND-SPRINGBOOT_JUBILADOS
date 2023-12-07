package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubTipoDiscapacidad;

/**
* Repositorio para la entidad JubTipoDiscapacidad
*
*/

public interface TipoDiscapacidadRepositorio extends JpaRepository<JubTipoDiscapacidad, Integer>{

	/**
	 * Permite buscar Tipo Discapacidad  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Tipo Discapacidad
	 */	
	JubTipoDiscapacidad  findByTipdisCodigo( long tipdisCodigo);

	/**
	 * Permite listar Tipo Discapacidad
	 * 
	 * @param estado a buscar
	 * @return lista de Tipo Discapacidad
	 */
	List<JubTipoDiscapacidad> findByTipdisEstadoOrderByTipdisNombreAsc(int tipdisEstado);
}
