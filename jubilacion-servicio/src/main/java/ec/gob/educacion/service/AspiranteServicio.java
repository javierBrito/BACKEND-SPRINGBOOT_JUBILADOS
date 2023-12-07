package ec.gob.educacion.service;

import java.util.List;
import ec.gob.educacion.model.jubilacion.JubAspirante;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface AspiranteServicio {
	/**
	 * Permite guardar o actualizar Aspirante
	 * 
	 * @param Aspirante a guarda/actualizar
	 * @return Aspirante guardado
	 */
	JubAspirante registrar(JubAspirante jubAspirante);
	
	/**
	 * Permite buscar Aspirante por cedula
	 * @param cedula a buscar
	 * @return  Aspirante  buscado
	 */
	JubAspirante buscarAspirantePorCedula(String aspCedula);
	
	/**
	 * Permite buscar Aspirante por id
	 * @param codigo a buscar
	 * @return  Aspirante  buscado
	 */
	JubAspirante buscarAspirantePorCodigo(Long aspCodigo);	
	/**
	 * Permite listar Aspirante
	 * 
	 * @param estado a buscar
	 * @return lista Aspirante
	 */
	List<JubAspirante> listarAspirante();
	
	/**
	 * Permite eliminar un Aspirante
	 * 
	 * @param Aspirante a eliminar
	 * @return Aspirante eliminada
	 */
	JubAspirante eliminar(JubAspirante jubAspirante);
}
