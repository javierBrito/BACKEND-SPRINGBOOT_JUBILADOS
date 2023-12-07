package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubParametro;

/**
* Repositorio para la entidad Parametro
* 
*
*/

public interface ParametroRepositorio extends JpaRepository<JubParametro, Integer>{

	/**
	 * Permite buscar Parametro  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Parametro
	 */	
	JubParametro  findByParCodigo(long parCodigo);
	
	/**
	 * Permite listar Parametro
	 * 
	 * @param estado a buscar
	 * @return lista de Parametro
	 */
	List<JubParametro> findByParEstadoOrderByParCodigoAsc(int parEstado);

}
