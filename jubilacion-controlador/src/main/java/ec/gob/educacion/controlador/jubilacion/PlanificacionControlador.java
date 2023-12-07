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
import ec.gob.educacion.model.jubilacion.JubPlanificado;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.PlanificacionServicio;

@RestController
@RequestMapping("private/")
public class PlanificacionControlador {
	
	@Autowired
	private PlanificacionServicio planificacionServicio;	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return Planificacion a guardar
	 */
	@PostMapping(value = "guardarPlanificacion")
	public ResponseGenerico<JubPlanificado> guardarPlanificacion(@RequestBody JubPlanificado jubPlanificado){
		JubPlanificado jubPlanificadoAux = planificacionServicio.registrar(jubPlanificado) ;
		// Respuesta
		ResponseGenerico<JubPlanificado> response = new ResponseGenerico<>();
		response.setObjeto(jubPlanificadoAux);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}	
	
	/**
	 * REST para bucar por codigo Interes
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto Interes
	 */
	@GetMapping(value = "buscarPlanificacionPorCodigo/{plaCodigo}")
	public ResponseGenerico<JubPlanificado> buscarPlanificacionPorCodigo(@PathVariable("plaCodigo") long plaCodigo){
		ResponseGenerico<JubPlanificado> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubPlanificado planificado = planificacionServicio.buscarPlanificacionPorCodigo(plaCodigo);
		response.setObjeto(planificado);
		return response;
	}
	
	/**
	 * Rest para listar Planificacion
	 * 
	 * @return ResponseGenerico con el listado de Planificacion
	 */
	@GetMapping(value = "listarPlanificacion")
	public ResponseGenerico<JubPlanificado> listarPlanificacion(){
		ResponseGenerico<JubPlanificado> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubPlanificado> listaTipoLeyes = planificacionServicio.listarPlanificacion();
		response.setListado(listaTipoLeyes);
		return response;
	}

	/**
	 * REST para eliminar logicamente por codigo Planificacion
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente Planificacion
	 */
	@DeleteMapping(value = "eliminarPlanificacionPorId/{plaCodigo}")
	public ResponseEntity<Object> eliminarPlanificacionPorId(@PathVariable("plaCodigo") long plaCodigo){
		JubPlanificado planificadoAux = planificacionServicio.buscarPlanificacionPorCodigo(plaCodigo);
		planificadoAux.setPlaEstado(Constantes.REGISTRO_INACTIVO);	
		planificacionServicio.registrar(planificadoAux);	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
