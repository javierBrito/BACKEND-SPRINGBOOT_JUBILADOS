package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubInteres;

/**
* Repositorio para la entidad Interes
* 
* @author Belen Changoluisa
*
*/

public interface InteresRepositorio extends JpaRepository<JubInteres, Integer>{

	/**
	 * Permite buscar Interes  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Interes
	 */	
	JubInteres  findByIntCodigo( long intCodigo);

	/**
	 * Permite listar Interes
	 * 
	 * @param estado a buscar
	 * @return lista de Interes
	 */
	List<JubInteres> findByIntEstadoOrderByIntNombreAsc(int intEstado);
}
