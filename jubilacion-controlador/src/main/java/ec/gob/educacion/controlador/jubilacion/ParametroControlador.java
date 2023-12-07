package ec.gob.educacion.controlador.jubilacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubParametro;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.ParametroServicio;

/**
 * Rest para el manejo de transacccion de Parametro 
 *
 */
@RestController
@RequestMapping("private/")
public class ParametroControlador {
	@Autowired
	private ParametroServicio parametroServicio;	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return Parametro a guardar
	 */

	@PostMapping(value = "guardarParametro")
	public ResponseGenerico<JubParametro> guardarParametro(@RequestBody JubParametro jubParametro){
		JubParametro jubParametroAux = parametroServicio.registrar(jubParametro) ;
		// Respuesta
		ResponseGenerico<JubParametro> response = new ResponseGenerico<>();
		response.setObjeto(jubParametroAux);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}	
	
	/**
	 * REST para bucar por codigo Parametro
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto Parametro
	 */
	@GetMapping(value = "buscarParametroPorCodigo/{parCodigo}")
	public ResponseGenerico<JubParametro> buscarParametroPorCodigo(@PathVariable("parCodigo") long parCodigo){
		ResponseGenerico<JubParametro> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubParametro parametro = parametroServicio.buscarParametroPorCodigo(parCodigo);
		response.setObjeto(parametro);
		return response;
	}
	
	/**
	 * Rest para listar Parametro
	 * 
	 * @return ResponseGenerico con el listado de Parametro
	 */
	@GetMapping(value = "listarParametro")
	public ResponseGenerico<JubParametro> listarParametro(){
		ResponseGenerico<JubParametro> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubParametro> agrupacionLista = parametroServicio.listarParametro();
		response.setListado(agrupacionLista);
		return response;
	}
	
	/**
	 * REST para eliminar logicamente por codigo tipo Parametro
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente tipo Parametro
	 */
	@DeleteMapping(value = "eliminarParametroPorId/{parCodigo}")
	public ResponseEntity<Object> eliminarParametroPorId(@PathVariable("parCodigo") long parCodigo){
		JubParametro parametroAux = parametroServicio.buscarParametroPorCodigo(parCodigo);
		parametroAux.setParEstado(EstadoEnum.INACTIVO.getCodigo());
		parametroServicio.eliminar(parametroAux);	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
