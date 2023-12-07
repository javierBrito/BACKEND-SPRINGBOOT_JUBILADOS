package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubDesvinculacion;

/**
* Repositorio para la entidad JubAspirante
* 
* @author Belen Changoluisa
*
*/

public interface DesvinculacionRepositorio extends JpaRepository<JubDesvinculacion, Integer>{

	/**
	 * Permite buscar Desvinculacion  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Desvinculacion
	 */	
	JubDesvinculacion  findByDesCodigo(long desCodigo);
	
	
	/**
	 * Permite listar Desvinculacion
	 * 
	 * @param estado a buscar
	 * @return lista de Desvinculacion
	 */
	List<JubDesvinculacion> findByDesEstadoOrderByDesCodigoAsc(int desEstado);

}
