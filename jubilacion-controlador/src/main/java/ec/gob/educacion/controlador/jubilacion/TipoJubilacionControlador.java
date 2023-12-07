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
import ec.gob.educacion.model.jubilacion.JubTipoJubilacion;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.TipoJubilacionServicio;

@RestController
@RequestMapping("private/")
public class TipoJubilacionControlador {
	
	@Autowired
	private TipoJubilacionServicio tipoJubilacionServicio;	
	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return tipo Jubilacion a guardar
	 */
	@PostMapping(value = "guardarTipoJubilacion")
	public ResponseGenerico<JubTipoJubilacion> guardarTipoJubilacion(@RequestBody JubTipoJubilacion jubTipoJubilacion){
		JubTipoJubilacion jubTipoJubilacionAux = tipoJubilacionServicio.registrar(jubTipoJubilacion) ;
		// Respuesta
		ResponseGenerico<JubTipoJubilacion> response = new ResponseGenerico<>();
		response.setObjeto(jubTipoJubilacionAux);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}	
	
	/**
	 * REST para bucar por codigo tipo Jubilacion
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto tipo Jubilacion
	 */
	@GetMapping(value = "buscarTipoJubilacionPorCodigo/{tipjubCodigo}")
	public ResponseGenerico<JubTipoJubilacion> buscarTipoJubilacionPorCodigo(@PathVariable("tipjubCodigo") long tipjubCodigo){
		ResponseGenerico<JubTipoJubilacion> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubTipoJubilacion tipoJubilacion = tipoJubilacionServicio.buscarTipoJubilacionPorCodigo(tipjubCodigo);
		response.setObjeto(tipoJubilacion);
		return response;
	}
	
	/**
	 * Rest para listar tipo Jubilacion
	 * 
	 * @return ResponseGenerico con el listado de tipo Jubilacion
	 */
	@GetMapping(value = "listarTipoJubilacion")
	public ResponseGenerico<JubTipoJubilacion> listarTipoJubilacion(){
		ResponseGenerico<JubTipoJubilacion> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubTipoJubilacion> listaTipoJubilacion = tipoJubilacionServicio.listarTipoJubilacion();
		response.setListado(listaTipoJubilacion);
		return response;
	}


	/**
	 * REST para eliminar logicamente por codigo tipo Jubilacion
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente tipo Jubilacion
	 */
	@DeleteMapping(value = "eliminarTipoJubilacionPorId/{tipjubCodigo}")
	public ResponseEntity<Object> eliminarTipoJubilacionPorId(@PathVariable("tipjubCodigo") long tipjubCodigo){
		JubTipoJubilacion tipoJubilacionAux = tipoJubilacionServicio.buscarTipoJubilacionPorCodigo(tipjubCodigo);
		tipoJubilacionAux.setTipjubEstado(Constantes.REGISTRO_INACTIVO);	
		tipoJubilacionServicio.registrar(tipoJubilacionAux);	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
