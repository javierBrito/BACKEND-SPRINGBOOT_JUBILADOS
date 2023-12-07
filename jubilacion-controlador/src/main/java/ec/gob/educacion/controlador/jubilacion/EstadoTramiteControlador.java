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
import ec.gob.educacion.model.jubilacion.JubEstadoTramite;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.EstadoTramiteServicio;

/**
 * Rest para el manejo de transacccion de Agrupacion
 *
 */
@RestController
@RequestMapping("private/")
public class EstadoTramiteControlador {

	@Autowired
	private EstadoTramiteServicio estadoTramiteService;

	/**
	 * REST para guardar o actualizar
	 * 
	 * @return EstadoTramite a guardar
	 */
	@PostMapping(value = "guardarEstadoTramite")
	public ResponseGenerico<JubEstadoTramite> guardarEstadoTramite(@RequestBody JubEstadoTramite jubEstadoTramite) {
		jubEstadoTramite = estadoTramiteService.registrar(jubEstadoTramite);
		// Respuesta
		ResponseGenerico<JubEstadoTramite> response = new ResponseGenerico<>();
		response.setObjeto(jubEstadoTramite);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para bucar por codigo EstadoTramite
	 * 
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto EstadoTramite
	 */
	@GetMapping(value = "buscarEstadoTramitePorCodigo/{esttraCodigo}")
	public ResponseGenerico<JubEstadoTramite> buscarEstadoTramitePorCodigo(@PathVariable("esttraCodigo") Long esttraCodigo) {
		ResponseGenerico<JubEstadoTramite> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubEstadoTramite estadoTramite = estadoTramiteService.buscarEstadoTramitePorCodigo(esttraCodigo);
		response.setObjeto(estadoTramite);
		return response;
	}

	/**
	 * REST para bucar por cedula EstadoTramite
	 * 
	 * @param cedula a buscar
	 * @return ResponseGenerico con el objeto EstadoTramite
	 */
	@GetMapping(value = "buscarEstadoTramitePorNombre/{esttraNombre}")
	public ResponseGenerico<JubEstadoTramite> buscarEstadoTramitePorNombre(@PathVariable("esttraNombre") String esttraNombre) {
		ResponseGenerico<JubEstadoTramite> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubEstadoTramite jubEstadoTramite = estadoTramiteService.buscarEstadoTramitePorNombre(esttraNombre);
		response.setObjeto(jubEstadoTramite);
		return response;
	}

	/**
	 * Rest para listar EstadoTramite
	 * 
	 * @return ResponseGenerico con el listado de EstadoTramite
	 */
	@GetMapping(value = "listarEstadoTramite")
	public ResponseGenerico<JubEstadoTramite> listarEstadoTramite() {
		ResponseGenerico<JubEstadoTramite> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubEstadoTramite> listaEstadoTramite = estadoTramiteService.listarEstadoTramite();
		response.setListado(listaEstadoTramite);
		return response;
	}

	/**
	 * Rest para listar EstadoTramite
	 * 
	 * @return ResponseGenerico con el listado de EstadoTramite
	 */
	@GetMapping(value = "listarEstadoTramitePorAspirante/{esttraCodigo}")
	public ResponseGenerico<JubEstadoTramite> listarEstadoTramitePorAspirante(@PathVariable("aspCodigo") Long aspCodigo) {
		ResponseGenerico<JubEstadoTramite> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		//List<JubEstadoTramite> listaEstadoTramite = estadoTramiteService.listarEstadoTramitePorAspirante(aspCodigo);
		//response.setListado(listaEstadoTramite);
		return response;
	}

	/**
	 * REST para eliminar logicamente por codigo tipo EstadoTramite
	 * 
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente tipo EstadoTramite
	 */
	@DeleteMapping(value = "eliminarEstadoTramitePorId/{esttraCodigo}")
	public ResponseEntity<Object> eliminarEstadoTramitePorId(@PathVariable("esttraCodigo") Long esttraCodigo) {
		JubEstadoTramite jubEstadoTramite = estadoTramiteService.buscarEstadoTramitePorCodigo(esttraCodigo);
		jubEstadoTramite.setEsttraEstado(EstadoEnum.INACTIVO.getCodigo());
		estadoTramiteService.eliminar(jubEstadoTramite);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
