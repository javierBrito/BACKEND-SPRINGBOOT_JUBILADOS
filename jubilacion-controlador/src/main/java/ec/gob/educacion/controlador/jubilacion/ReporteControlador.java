package ec.gob.educacion.controlador.jubilacion;

import ec.gob.educacion.model.DTO.ReporteDTO;
import ec.gob.educacion.service.ReporteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private/")
public class ReporteControlador {
	@Autowired
	private ReporteServicio reporteServicio;
	/**
	 * Servicio para obtener Reporte de Inscripción
	 * 
	 * @return ResponseEntity (reporte generado)
	 */
	@PostMapping(value = "obtenerReporteInscripcion")
	public ResponseEntity<Resource> obtenerReporteInscripcion(@RequestBody ReporteDTO reporteDTO) {
		// Reportes jbrito-20230415
		try {
			reporteDTO = reporteServicio.obtenerReporteInscripcion(reporteDTO);
			// Nombre del archivo
			StringBuilder stringBuilder = new StringBuilder().append("inscripcion:");
			ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
					.filename(stringBuilder.append("cedula_"+reporteDTO.getCedula()).append(".pdf").toString()).build();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(contentDisposition);
			return ResponseEntity.ok().contentLength((long) reporteDTO.getReporteByte().length).contentType(MediaType.APPLICATION_PDF)
					.headers(headers).body(new ByteArrayResource(reporteDTO.getReporteByte()));
		} catch (Exception e) {
			System.out.println("e.printStackTrace()" + e.getMessage());
		}

		return null;
	}
}
