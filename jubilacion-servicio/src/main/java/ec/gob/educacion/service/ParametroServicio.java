package ec.gob.educacion.service;

import java.util.List;
import ec.gob.educacion.model.jubilacion.JubParametro;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface ParametroServicio {
	/**
	 * Permite guardar o actualizar Parametro
	 * 
	 * @param Parametro a guarda/actualizar
	 * @return Parametro guardado
	 */
	JubParametro registrar(JubParametro jubParametro);
	
	/**
	 * Permite buscar Parametro por id
	 * @param codigo a buscar
	 * @return  Parametro  buscado
	 */
	JubParametro buscarParametroPorCodigo(long parCodigo);
	
	/**
	 * Permite listar Parametro
	 * 
	 * @param estado a buscar
	 * @return lista Parametro
	 */
	List<JubParametro> listarParametro();
	
	/**
	 * Permite eliminar un Parametro
	 * 
	 * @param Parametro a eliminar
	 * @return Parametro eliminada
	 */
	JubParametro eliminar(JubParametro jubParametro);
}
