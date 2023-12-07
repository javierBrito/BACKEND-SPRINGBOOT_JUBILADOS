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
import ec.gob.educacion.model.jubilacion.JubPago;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.PagoServicio;

@RestController
@RequestMapping("private/")
public class PagoControlador {
	
	@Autowired
	private PagoServicio pagoServicio;	
	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return Pago a guardar
	 */
	@PostMapping(value = "guardarPago")
	public ResponseGenerico<JubPago> guardarPago(@RequestBody JubPago jubPago){
		JubPago jubPagoAux = pagoServicio.registrar(jubPago) ;
		// Respuesta
		ResponseGenerico<JubPago> response = new ResponseGenerico<>();
		response.setObjeto(jubPagoAux);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}	
	
	/**
	 * REST para bucar por codigo Pago
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto Pago
	 */
	@GetMapping(value = "buscarPagoPorCodigo/{pagCodigo}")
	public ResponseGenerico<JubPago> buscarPagoPorCodigo(@PathVariable("pagCodigo") long pagCodigo){
		ResponseGenerico<JubPago> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubPago pago = pagoServicio.buscarPagoPorCodigo(pagCodigo);
		response.setObjeto(pago);
		return response;
	}
	
	/**
	 * Rest para listar Pago
	 * 
	 * @return ResponseGenerico con el listado de Pago
	 */
	@GetMapping(value = "listarPago")
	public ResponseGenerico<JubPago> listarPago(){
		ResponseGenerico<JubPago> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubPago> listaPago = pagoServicio.listarPago();
		response.setListado(listaPago);
		return response;
	}


	/**
	 * REST para eliminar logicamente por codigo Interes
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente Interes
	 */
	@DeleteMapping(value = "eliminarPagoPorId/{pagCodigo}")
	public ResponseEntity<Object> eliminarPagoPorId(@PathVariable("pagCodigo") long pagCodigo){
		JubPago pagoAux = pagoServicio.buscarPagoPorCodigo(pagCodigo);
		pagoAux.setPagEstado(Constantes.REGISTRO_INACTIVO);	
		pagoServicio.registrar(pagoAux);	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
