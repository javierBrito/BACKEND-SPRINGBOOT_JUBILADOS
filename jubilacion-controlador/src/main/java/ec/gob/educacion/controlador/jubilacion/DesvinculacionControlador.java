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

import ec.gob.educacion.model.DTO.DesvinculacionDTO;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubDesvinculacion;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.DesvinculacionServicio;

/**
 * Rest para el manejo de transacccion de Agrupacion 
 *
 */
@RestController
@RequestMapping("private/")
public class DesvinculacionControlador {
	
	@Autowired
	private DesvinculacionServicio desvinculacionServicio;	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return Desvinculacion a guardar
	 */
	@PostMapping(value = "guardarDesvinculacion")
	public ResponseGenerico<JubDesvinculacion> guardarDesvinculacion(@RequestBody DesvinculacionDTO desvinculacionDTO){
		JubDesvinculacion jubDesvinculacion = desvinculacionServicio.registrar(desvinculacionDTO) ;
		// Respuesta
		ResponseGenerico<JubDesvinculacion> response = new ResponseGenerico<>();
		response.setObjeto(jubDesvinculacion);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}	
	
	/**
	 * REST para bucar por codigo Desvinculacion
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto Desvinculacion
	 */
	@GetMapping(value = "buscarDesvinculacionPorCodigo/{desCodigo}")
	public ResponseGenerico<JubDesvinculacion> buscarDesvinculacionPorCodigo(@PathVariable("desCodigo") long desCodigo){
		ResponseGenerico<JubDesvinculacion> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubDesvinculacion desvinculacion = desvinculacionServicio.buscarDesvinculacionPorCodigo(desCodigo);
		response.setObjeto(desvinculacion);
		return response;
	}
	
	/**
	 * Rest para listar Desvinculacion
	 * 
	 * @return ResponseGenerico con el listado de Desvinculacion
	 */
	@GetMapping(value = "listarDesvinculacion")
	public ResponseGenerico<JubDesvinculacion> listarDesvinculacion(){
		ResponseGenerico<JubDesvinculacion> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubDesvinculacion> agrupacionLista = desvinculacionServicio.listarDesvinculacion();
		response.setListado(agrupacionLista);
		return response;
	}
	
	/**
	 * REST para eliminar logicamente por codigo tipo Desvinculacion
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente tipo Desvinculacion
	 */
	@DeleteMapping(value = "eliminarDesvinculacionPorId/{desCodigo}")
	public ResponseEntity<Object> eliminarDesvinculacionPorId(@PathVariable("desCodigo") long desCodigo){
		JubDesvinculacion desvinculacionAux = desvinculacionServicio.buscarDesvinculacionPorCodigo(desCodigo);
		desvinculacionAux.setDesCodigo(EstadoEnum.INACTIVO.getCodigo());
		desvinculacionServicio.eliminar(desvinculacionAux);	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
