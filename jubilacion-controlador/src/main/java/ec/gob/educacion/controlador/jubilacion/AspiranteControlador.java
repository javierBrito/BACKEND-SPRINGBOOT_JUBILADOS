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
import ec.gob.educacion.model.jubilacion.JubAspirante;
import ec.gob.educacion.model.jubilacion.JubEstadoTramite;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.AspiranteServicio;
import ec.gob.educacion.service.EstadoTramiteServicio;

/**
 * Rest para el manejo de transacccion de Agrupacion
 *
 */
@RestController
@RequestMapping("private/")
public class AspiranteControlador {
	@Autowired
	private AspiranteServicio aspiranteService;
	@Autowired
	private EstadoTramiteServicio estadoTramiteServicio;

	/**
	 * REST para guardar o actualizar
	 * 
	 * @return Aspirante a guardar
	 */
	@PostMapping(value = "guardarAspirante")
	public ResponseGenerico<JubAspirante> guardarAspirante(@RequestBody JubAspirante jubAspirante) {
		jubAspirante = aspiranteService.registrar(jubAspirante);
		// Respuesta
		ResponseGenerico<JubAspirante> response = new ResponseGenerico<>();
		response.setObjeto(jubAspirante);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para bucar por codigo Aspirante
	 * 
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto Aspirante
	 */
	@GetMapping(value = "buscarAspirantePorCodigo/{aspCodigo}")
	public ResponseGenerico<JubAspirante> buscarAspirantePorCodigo(@PathVariable("aspCodigo") Long aspCodigo) {
		ResponseGenerico<JubAspirante> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubAspirante jubAspirante = aspiranteService.buscarAspirantePorCodigo(aspCodigo);
		if (jubAspirante != null) {
			List<JubEstadoTramite> listaEstadoTramite = estadoTramiteServicio.listarEstadoTramitePorAspirante(jubAspirante.getAspCodigo());
			if (listaEstadoTramite != null) {
				jubAspirante.setListaEstadoTramite(listaEstadoTramite);
			}
		}
		response.setObjeto(jubAspirante);
		return response;
	}

	/**
	 * REST para bucar por cedula Aspirante
	 * 
	 * @param cedula a buscar
	 * @return ResponseGenerico con el objeto Aspirante
	 */
	@GetMapping(value = "buscarAspirantePorCedula/{aspCedula}")
	public ResponseGenerico<JubAspirante> buscarAspirantePorCedula(@PathVariable("aspCedula") String aspCedula) {
		ResponseGenerico<JubAspirante> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubAspirante jubAspirante = aspiranteService.buscarAspirantePorCedula(aspCedula);
		if (jubAspirante != null) {
			List<JubEstadoTramite> listaEstadoTramite = estadoTramiteServicio.listarEstadoTramitePorAspirante(jubAspirante.getAspCodigo());
			if (listaEstadoTramite != null) {
				jubAspirante.setListaEstadoTramite(listaEstadoTramite);
			}
		}
		response.setObjeto(jubAspirante);
		return response;
	}

	/**
	 * Rest para listar Aspirante
	 * 
	 * @return ResponseGenerico con el listado de Aspirante
	 */
	@GetMapping(value = "listarAspirante")
	public ResponseGenerico<JubAspirante> listarAspirante() {
		ResponseGenerico<JubAspirante> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubAspirante> agrupacionLista = aspiranteService.listarAspirante();
		response.setListado(agrupacionLista);
		return response;
	}

	/**
	 * REST para eliminar logicamente por codigo tipo Aspirante
	 * 
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente tipo Aspirante
	 */
	@DeleteMapping(value = "eliminarAspirantePorId/{aspCodigo}")
	public ResponseEntity<Object> eliminarAspirantePorId(@PathVariable("aspCodigo") Long aspCodigo) {
		JubAspirante aspiranteAux = aspiranteService.buscarAspirantePorCodigo(aspCodigo);
		aspiranteAux.setAspEstado(EstadoEnum.INACTIVO.getCodigo());
		aspiranteService.eliminar(aspiranteAux);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
