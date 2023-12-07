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
import ec.gob.educacion.model.jubilacion.JubEod;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.EodServicio;

/**
 * Rest para el manejo de transacccion de Agrupacion
 *
 */
@RestController
@RequestMapping("private/")
public class EodControlador {

	@Autowired
	private EodServicio eodService;

	/**
	 * REST para guardar o actualizar
	 * 
	 * @return Eod a guardar
	 */
	@PostMapping(value = "guardarEod")
	public ResponseGenerico<JubEod> guardarEod(@RequestBody JubEod jubAeod) {
		JubEod jubEod = eodService.registrar(jubAeod);
		// Respuesta
		ResponseGenerico<JubEod> response = new ResponseGenerico<>();
		response.setObjeto(jubEod);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para bucar por codigo Eod
	 * 
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto Eod
	 */
	@GetMapping(value = "buscarEodPorCodigo/{eodCodigo}")
	public ResponseGenerico<JubEod> buscarEodPorCodigo(@PathVariable("eodCodigo") Long eodCodigo) {
		ResponseGenerico<JubEod> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubEod eod = eodService.buscarEodPorCodigo(eodCodigo);
		response.setObjeto(eod);
		return response;
	}

	/**
	 * Rest para listar Eod
	 * 
	 * @return ResponseGenerico con el listado de Eod
	 */
	@GetMapping(value = "listarEod")
	public ResponseGenerico<JubEod> listarEod() {
		ResponseGenerico<JubEod> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubEod> agrupacionLista = eodService.listarEod();
		response.setListado(agrupacionLista);
		return response;
	}

	/**
	 * REST para eliminar logicamente por codigo tipo Eod
	 * 
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente tipo Eod
	 */
	@DeleteMapping(value = "eliminarEodPorId/{eodCodigo}")
	public ResponseEntity<Object> eliminarEodPorId(@PathVariable("eodCodigo") Long eodCodigo) {
		JubEod eodAux = eodService.buscarEodPorCodigo(eodCodigo);
		eodAux.setEodEstado(EstadoEnum.INACTIVO.getCodigo());
		eodService.eliminar(eodAux);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
