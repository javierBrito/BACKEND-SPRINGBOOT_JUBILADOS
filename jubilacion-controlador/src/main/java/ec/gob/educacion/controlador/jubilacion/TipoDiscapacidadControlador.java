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
import ec.gob.educacion.model.DTO.DiscapacidadDTO;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.jubilacion.JubTipoDiscapacidad;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.TipoDiscapacidadServicio;

@RestController
@RequestMapping("private/")
public class TipoDiscapacidadControlador {
	
	@Autowired
	private TipoDiscapacidadServicio tipoDiscapacidadServicio;	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return tipo Discapacidad a guardar
	 */
	@PostMapping(value = "guardarTipoDiscapacidad")
	public ResponseGenerico<JubTipoDiscapacidad> guardarTipoDiscapacidad(@RequestBody DiscapacidadDTO discapacidadDTO){
		JubTipoDiscapacidad jubTipoDiscapacidad = tipoDiscapacidadServicio.registrar(discapacidadDTO) ;
		// Respuesta
		ResponseGenerico<JubTipoDiscapacidad> response = new ResponseGenerico<>();
		response.setObjeto(jubTipoDiscapacidad);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}	
	
	/**
	 * REST para bucar por codigo tipo Discapacidad
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto tipo Discapacidad
	 */
	@GetMapping(value = "buscarTipoDiscapacidadPorCodigo/{tipdisCodigo}")
	public ResponseGenerico<JubTipoDiscapacidad> buscarTipoDiscapacidadPorCodigo(@PathVariable("tipdisCodigo") long tipdisCodigo){
		ResponseGenerico<JubTipoDiscapacidad> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubTipoDiscapacidad tipoDiscapacidad = tipoDiscapacidadServicio.buscarTipoDiscapacidadPorCodigo(tipdisCodigo);
		response.setObjeto(tipoDiscapacidad);
		return response;
	}
	
	/**
	 * Rest para listar tipo Discapacidad
	 * 
	 * @return ResponseGenerico con el listado de tipo Discapacidad
	 */
	@GetMapping(value = "listarTipoDiscapacidad")
	public ResponseGenerico<JubTipoDiscapacidad> listarTipoDiscapacidad(){
		ResponseGenerico<JubTipoDiscapacidad> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubTipoDiscapacidad> listaTipoDiscapacidad= tipoDiscapacidadServicio.listarTipoDiscapacidad();
		response.setListado(listaTipoDiscapacidad);
		return response;
	}

	/**
	 * REST para eliminar logicamente por codigo tipo Discapacidad
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente tipo Discapacidad
	 */
	@DeleteMapping(value = "eliminarTipoDiscapacidadPorId/{tipdisCodigo}")
	public ResponseEntity<Object> eliminarTipoDiscapacidadPorId(@PathVariable("tipdisCodigo") long tipdisCodigo){
		JubTipoDiscapacidad tipoDiscapacidadAux = tipoDiscapacidadServicio.buscarTipoDiscapacidadPorCodigo(tipdisCodigo);
		tipoDiscapacidadAux.setTipdisEstado(Constantes.REGISTRO_INACTIVO);	
		tipoDiscapacidadServicio.eliminar(tipoDiscapacidadAux);	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
