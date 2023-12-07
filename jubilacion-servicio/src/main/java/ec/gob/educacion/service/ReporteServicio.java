package ec.gob.educacion.service;

import ec.gob.educacion.model.DTO.ReporteDTO;

public interface ReporteServicio {
	/**
	 * Permite obtener reporte Inscripción
	 * 
	 * @param ReporteDTO
	 * @return reporte generado Inscripción
	 */
	ReporteDTO obtenerReporteInscripcion(ReporteDTO reporteDTO);
}
