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
import ec.gob.educacion.model.jubilacion.JubTipoLey;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.TipoLeyServicio;

@RestController
@RequestMapping("private/")
public class TipoLeyControlador {
	
	@Autowired
	private TipoLeyServicio tipoLeyService;	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return TipoLey a guardar
	 */
	@PostMapping(value = "guardarTipoLey")
	public ResponseGenerico<JubTipoLey> guardarTipoLey(@RequestBody JubTipoLey jubTipoLey){
		JubTipoLey jubTipoLeyAux = tipoLeyService.registrar(jubTipoLey) ;
		// Respuesta
		ResponseGenerico<JubTipoLey> response = new ResponseGenerico<>();
		response.setObjeto(jubTipoLeyAux);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}	
	
	/**
	 * REST para bucar por codigo TipoLey
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto TipoLey
	 */
	@GetMapping(value = "buscarTipoLeyPorCodigo/{tipleyCodigo}")
	public ResponseGenerico<JubTipoLey> buscarTipoLeyPorCodigo(@PathVariable("tipleyCodigo") long tipleyCodigo){
		ResponseGenerico<JubTipoLey> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubTipoLey tipoLeye = tipoLeyService.buscarTipoLeyPorCodigo(tipleyCodigo);
		response.setObjeto(tipoLeye);
		return response;
	}
	
	/**
	 * Rest para listar TipoLey
	 * 
	 * @return ResponseGenerico con el listado de TipoLey
	 */
	@GetMapping(value = "listarTipoLey")
	public ResponseGenerico<JubTipoLey> listarTipoLey(){
		ResponseGenerico<JubTipoLey> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubTipoLey> listaTipoLey = tipoLeyService.listarTipoLey();
		response.setListado(listaTipoLey);
		return response;
	}


	/**
	 * REST para eliminar logicamente por codigo TipoLey
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente TipoLey
	 */
	@DeleteMapping(value = "eliminarTipoLeyPorId/{tipleyCodigo}")
	public ResponseEntity<Object> eliminarTipoLeyPorId(@PathVariable("tipleyCodigo") long tipleyCodigo){
		JubTipoLey tipoLeyAux = tipoLeyService.buscarTipoLeyPorCodigo(tipleyCodigo);
		tipoLeyAux.setTipleyEstado(Constantes.REGISTRO_INACTIVO);	
		tipoLeyService.registrar(tipoLeyAux);	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
