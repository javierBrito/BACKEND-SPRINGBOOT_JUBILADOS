package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubPlanificado;

/**
* Repositorio para la entidad Planificacion
* 
*
*/

public interface PlanificacionRepositorio extends JpaRepository<JubPlanificado, Integer>{

	/**
	 * Permite buscar Planificacion  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Planificacion
	 */	
	JubPlanificado  findByPlaCodigo( long plaCodigo);

	/**
	 * Permite listar Planificacion
	 * 
	 * @param estado a buscar
	 * @return lista de Planificacion
	 */
	List<JubPlanificado> findByPlaEstadoOrderByPlaNombreAsc(int plaEstado);
}
