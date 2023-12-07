package ec.gob.educacion.service;

import java.util.List;

import ec.gob.educacion.model.jubilacion.JubTipoLey;

/**
 * Definine las operaciones disponibles en el servicio transacciones 
 */
public interface TipoLeyServicio {
	
	/**
	 * Permite guardar o actualizar TipoLey
	 * 
	 * @param TipoLey a guarda/actualizar
	 * @return TipoLey guardado
	 */
	JubTipoLey registrar(JubTipoLey jubTipoLey);
	
	/**
	 * Permite buscar TipoLey por id
	 * @param codigo a buscar
	 * @return  TipoLey  buscado
	 */
	JubTipoLey buscarTipoLeyPorCodigo(long tipleyCodigo);
	

	/**
	 * Permite listar TipoLey
	 * 
	 * @param estado a buscar
	 * @return lista TipoLey
	 */
	List<JubTipoLey> listarTipoLey();
}
