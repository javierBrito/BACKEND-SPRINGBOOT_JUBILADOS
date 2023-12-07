package ec.gob.educacion.service;

import ec.gob.educacion.model.DTO.ReporteDTO;

/**
 * Interfaz 
 * 
 * @author Gabriel Avalos
 *
 */
public interface EnviarCorreoService {

	String enviarCorreoAux(ReporteDTO reporteDTO);
	
	String enviarCorreo(ReporteDTO reporteDTO);
}
