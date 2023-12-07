package ec.gob.educacion.service;

import java.util.List;
import ec.gob.educacion.model.jubilacion.JubEod;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface EodServicio {
	/**
	 * Permite guardar o actualizar Eod
	 * 
	 * @param Eod a guarda/actualizar
	 * @return Eod guardado
	 */
	JubEod registrar(JubEod jubEod);
	
	/**
	 * Permite buscar Eod por id
	 * @param codigo a buscar
	 * @return  Eod  buscado
	 */
	JubEod buscarEodPorCodigo(Long eodCodigo);	
	/**
	 * Permite listar Eod
	 * 
	 * @param estado a buscar
	 * @return lista Eod
	 */
	List<JubEod> listarEod();
	
	/**
	 * Permite eliminar un Eod
	 * 
	 * @param Eod a eliminar
	 * @return Eod eliminada
	 */
	JubEod eliminar(JubEod jubEod);
}
