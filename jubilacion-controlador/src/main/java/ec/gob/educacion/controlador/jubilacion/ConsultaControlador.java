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
import ec.gob.educacion.model.jubilacion.JubConsulta;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.ConsultaServicio;

@RestController
@RequestMapping("private/")
public class ConsultaControlador {
	
	@Autowired
	private ConsultaServicio consultaServicio;	
	

	/**
	 * REST para guardar o actualizar 
	 * 
	 * @return Consulta a guardar
	 */
	@PostMapping(value = "guardarConsulta")
	public void guardarConsulta(@RequestBody JubConsulta jubConsulta){
		consultaServicio.registrar(jubConsulta);
	
	}
	
	/**
	 * REST para bucar por codigo Consulta
	 * @param codigo a buscar
	 * @return ResponseGenerico con el objeto Consulta
	 */
	@GetMapping(value = "buscarConsultaPorCodigo/{codigo}")
	public ResponseGenerico<JubConsulta> buscarConsultaPorCodigo(@PathVariable("codigo") long codigo){
		ResponseGenerico<JubConsulta> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		JubConsulta consultas = consultaServicio.buscarPagoPorCodigo(codigo);
		response.setObjeto(consultas);
		return response;
	}
	
	/**
	 * Rest para listar Consulta
	 * 
	 * @return ResponseGenerico con el listado de Consulta
	 */
	@GetMapping(value = "listarConsultas")
	public ResponseGenerico<JubConsulta> listarConsultas(){
		ResponseGenerico<JubConsulta> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA);
		response.setMensaje(Constantes.MENSAJE_OK);
		List<JubConsulta> listaTipoLeyes = consultaServicio.listaPagos();
		response.setListado(listaTipoLeyes);
		return response;
	}


	/**
	 * REST para eliminar logicamente por codigo Interes
	 * @param codigo de eliminar
	 * @return ResponseGenerico con el que se elimina logicamente Interes
	 */
	@DeleteMapping(value = "eliminarConsultaPorId/{intCodigo}")
	public ResponseEntity<Object> eliminarConsultaPorId(@PathVariable("conEstado") long conEstado){
		JubConsulta consultaAux = consultaServicio.buscarPagoPorCodigo(conEstado);
		consultaAux.setConEstado(Constantes.REGISTRO_INACTIVO);	
		consultaServicio.registrar(consultaAux);	
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
