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
import ec.gob.educacion.model.jubilacion.JubTipoDesvinculacion;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.TipoDesvinculacionServicio;

/**
 * Rest para el manejo de transacccion de Agrupacion 
 *
 */
@RestController
@RequestMapping("private/")
public class TipoDesvinculacionControlador {
	@Autowired
	private TipoDesvinculacionServicio tipoDesvinculacionServicio;	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return Tipo Desvinculacion a guardar
	 */
	@PostMapping(value = "guardarTipoDesvinculacion")
	public ResponseGenerico<JubTipoDesvinculacion> guardarTipoDesvinculacion(@RequestBody JubTipoDesvinculacion jubTipoDesvinculacion){
		jubTipoDesvinculacion = tipoDesvinculacionServicio.registrar(jubTipoDesvinculacion) ;
		// Respuesta
		ResponseGenerico<JubTipoDesvinculacion> response = new ResponseGenerico<>();
		response.setObjeto(jubTipoDesvinculacion);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}	
	
	/**
	 * REST para bucar por codigo Tipo Desvinculacion
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto Tipo Desvinculacion
	 */
	@GetMapping(value = "buscarTipoDesvinculacionPorCodigo/{tipdesCodigo}")
	public ResponseGenerico<JubTipoDesvinculacion> buscarTipoDesvinculacionPorCodigo(@PathVariable("tipdesCodigo") long tipdesCodigo){
		ResponseGenerico<JubTipoDesvinculacion> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubTipoDesvinculacion tipoDesvinculacion = tipoDesvinculacionServicio.buscarTipoDesvinculacionPorCodigo(tipdesCodigo);
		response.setObjeto(tipoDesvinculacion);
		return response;
	}
	
	/**
	 * Rest para listar Tipo Desvinculacion
	 * 
	 * @return ResponseGenerico con el listado de Tipo Desvinculacion
	 */
	@GetMapping(value = "listarTipoDesvinculacion")
	public ResponseGenerico<JubTipoDesvinculacion> listarTipoDesvinculacion(){
		ResponseGenerico<JubTipoDesvinculacion> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubTipoDesvinculacion> agrupacionLista = tipoDesvinculacionServicio.listarTipoDesvinculacion();
		response.setListado(agrupacionLista);
		return response;
	}
	
	/**
	 * REST para eliminar logicamente por codigo Tipo Desvinculacion
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente Tipo Desvinculacion
	 */
	@DeleteMapping(value = "eliminarTipoDesvinculacionPorId/{tipdesCodigo}")
	public ResponseEntity<Object> eliminarTipoDesvinculacionPorId(@PathVariable("tipdesCodigo") long tipdesCodigo){
		JubTipoDesvinculacion tipoDesvinculacionAux = tipoDesvinculacionServicio.buscarTipoDesvinculacionPorCodigo(tipdesCodigo);
		tipoDesvinculacionAux.setTipdesEstado(EstadoEnum.INACTIVO.getCodigo());
		tipoDesvinculacionServicio.eliminar(tipoDesvinculacionAux);	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
