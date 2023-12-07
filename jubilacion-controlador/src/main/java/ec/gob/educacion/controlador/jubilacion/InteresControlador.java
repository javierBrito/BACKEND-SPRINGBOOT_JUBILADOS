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
import ec.gob.educacion.model.jubilacion.JubInteres;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.InteresServicio;

@RestController
@RequestMapping("private/")
public class InteresControlador {
	
	@Autowired
	private InteresServicio interesServicio;	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return Interes a guardar
	 */
	@PostMapping(value = "guardarInteres")
	public ResponseGenerico<JubInteres> guardarInteres(@RequestBody JubInteres jubInteres){
		JubInteres jubInteresAux = interesServicio.registrar(jubInteres) ;
		// Respuesta
		ResponseGenerico<JubInteres> response = new ResponseGenerico<>();
		response.setObjeto(jubInteresAux);
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
	@GetMapping(value = "buscarInteresPorCodigo/{intCodigo}")
	public ResponseGenerico<JubInteres> buscarInteresPorCodigo(@PathVariable("intCodigo") long intCodigo){
		ResponseGenerico<JubInteres> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubInteres interes = interesServicio.buscarInteresPorCodigo(intCodigo);
		response.setObjeto(interes);
		return response;
	}
	
	/**
	 * Rest para listar Interes
	 * 
	 * @return ResponseGenerico con el listado de Interes
	 */
	@GetMapping(value = "listarInteres")
	public ResponseGenerico<JubInteres> listarInteres(){
		ResponseGenerico<JubInteres> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubInteres> listaTipoLeyes = interesServicio.listarInteres();
		response.setListado(listaTipoLeyes);
		return response;
	}

	/**
	 * REST para eliminar logicamente por codigo Interes
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente Interes
	 */
	@DeleteMapping(value = "eliminarInteresPorId/{intCodigo}")
	public ResponseEntity<Object> eliminarInteresPorId(@PathVariable("intCodigo") long intCodigo){
		JubInteres interesAux = interesServicio.buscarInteresPorCodigo(intCodigo);
		interesAux.setIntEstado(Constantes.REGISTRO_INACTIVO);	
		interesServicio.registrar(interesAux);	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
