package ec.gob.educacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.educacion.model.jubilacion.JubPago;

/**
* Repositorio para la entidad Pago
* 
*
*/

public interface PagoRepositorio extends JpaRepository<JubPago, Integer>{

	/**
	 * Permite buscar Pago  por id
	 * 
	 * @param id de busqueda
	 * @return objeto de Pago
	 */	
	JubPago  findByPagCodigo( long pagCodigo);

	/**
	 * Permite listar Pago
	 * 
	 * @param estado a buscar
	 * @return lista de Pago
	 */
	List<JubPago> findByPagEstadoOrderByPagCargoaspAsc(int pagEstado);
}
