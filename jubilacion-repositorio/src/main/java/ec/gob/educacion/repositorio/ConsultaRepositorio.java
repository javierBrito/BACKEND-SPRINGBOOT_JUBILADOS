package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubConsulta;

/**
* Repositorio para la entidad Consulta
* 
*
*/

public interface ConsultaRepositorio extends JpaRepository<JubConsulta, Integer>{

	/**
	 * Permite buscar Consulta  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Consulta
	 */	
	JubConsulta  findByConCodigo( long conCodigo);

	/**
	 * Permite listar Consulta
	 * 
	 * @param estado a buscar
	 * @return lista de Consulta
	 */
	List<JubConsulta> findByConEstadoOrderByConAcuerdoAsc(int conEstado);
}
