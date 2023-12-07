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
import ec.gob.educacion.model.jubilacion.JubTipoEstado;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.TipoEstadoServicio;

@RestController
@RequestMapping("private/")
public class TipoEstadoControlador {
	@Autowired
	private TipoEstadoServicio tipoEstadoServicio;	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return tipo Estado a guardar
	 */
	@PostMapping(value = "guardarTipoEstado")
	public ResponseGenerico<JubTipoEstado> guardarTipoEstado(@RequestBody JubTipoEstado jubTipoEstado){
		jubTipoEstado = tipoEstadoServicio.registrar(jubTipoEstado) ;
		// Respuesta
		ResponseGenerico<JubTipoEstado> response = new ResponseGenerico<>();
		response.setObjeto(jubTipoEstado);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}	
	
	/**
	 * REST para bucar por codigo tipo Estado
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto tipo Estado
	 */
	@GetMapping(value = "buscarTipoEstadoPorCodigo/{tipestCodigo}")
	public ResponseGenerico<JubTipoEstado> buscarTipoEstadoPorCodigo(@PathVariable("tipestCodigo") long tipestCodigo){
		ResponseGenerico<JubTipoEstado> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubTipoEstado tipoEstado = tipoEstadoServicio.buscarTipoEstadoPorCodigo(tipestCodigo);
		response.setObjeto(tipoEstado);
		return response;
	}
	
	/**
	 * Rest para listar tipo Estado
	 * 
	 * @return ResponseGenerico con el listado de tipo Estado
	 */
	@GetMapping(value = "listarTipoEstado")
	public ResponseGenerico<JubTipoEstado> listarTipoEstado(){
		ResponseGenerico<JubTipoEstado> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubTipoEstado> listaTipoEstado = tipoEstadoServicio.listarTipoEstado();
		response.setListado(listaTipoEstado);
		return response;
	}


	/**
	 * REST para eliminar logicamente por codigo tipo Estado
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente tipo Estado
	 */
	@DeleteMapping(value = "eliminarTipoEstadoPorId/{tipestCodigo}")
	public ResponseEntity<Object> eliminarTipoEstadoPorId(@PathVariable("tipestCodigo") long tipestCodigo){
		JubTipoEstado tipoEstado = tipoEstadoServicio.buscarTipoEstadoPorCodigo(tipestCodigo);
		tipoEstado.setTipestEstado(Constantes.REGISTRO_INACTIVO);	
		tipoEstadoServicio.registrar(tipoEstado);	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
