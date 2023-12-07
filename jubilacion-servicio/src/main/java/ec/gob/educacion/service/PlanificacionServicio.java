package ec.gob.educacion.service;

import java.util.List;
import ec.gob.educacion.model.jubilacion.JubPlanificado;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface PlanificacionServicio {
	
	/**
	 * Permite guardar o actualizar Planificacion
	 * 
	 * @param Planificacion a guarda/actualizar
	 * @return Planificacion guardado
	 */
	JubPlanificado registrar(JubPlanificado jubPlanificado);
	
	/**
	 * Permite buscar Planificacion por id
	 * @param codigo a buscar
	 * @return  Planificacion  buscado
	 */
	JubPlanificado buscarPlanificacionPorCodigo(long plaCodigo);
	

	/**
	 * Permite listar Planificacion
	 * 
	 * @param estado a buscar
	 * @return lista Planificacion
	 */
	List<JubPlanificado> listarPlanificacion();
}
