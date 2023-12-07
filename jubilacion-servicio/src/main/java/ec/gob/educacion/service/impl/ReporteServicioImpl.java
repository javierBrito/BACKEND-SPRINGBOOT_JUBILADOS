package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.DTO.ReporteDTO;
import ec.gob.educacion.model.jubilacion.JubAspirante;
import ec.gob.educacion.service.AspiranteServicio;
import ec.gob.educacion.service.ReporteServicio;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteServicioImpl implements ReporteServicio {
	@Autowired
	private AspiranteServicio aspiranteService;
	// Tratar valores de parámetros
	private String urlBackground;

	@Override
	public ReporteDTO obtenerReporteInscripcion(ReporteDTO reporteDTO) {
		// Mostrar imagen del fondo del título, según el ambiente
		urlBackground = "/reportes/Fondo.png";

		// Instanciar clase aspirante
		JubAspirante jubAspirante = aspiranteService.buscarAspirantePorCedula(reporteDTO.getCedula());

		// Para pasar el reporte pdf en base 64
		List<String> listaStringBase64 = new ArrayList<>();

		try {
			Map<String, Object> parametro = new HashMap<String, Object>();
			parametro.put("urlBackground", urlBackground);

			// Pasar variables normales tipo String. (En irepot se lo define como: java.util.String)
			parametro.put("apellidoNombre", reporteDTO.getApellidoNombre());
			parametro.put("fechaNacimiento", reporteDTO.getFechaNacimiento());
			parametro.put("edad", reporteDTO.getEdad());

			// Mapear registro, pasarlo como parametro. (En irepot se lo define como:
			// java.util.Map)
			Map<String, String> jubAspiranteMap = BeanUtils.describe(jubAspirante);
			parametro.put("jubAspirante", jubAspiranteMap);

			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(getClass().getResourceAsStream("/reportes/Inscripcion.jasper"));

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro,
					new JREmptyDataSource());
			//Para obtener el reporte y bajar
			reporteDTO.setReporteByte(JasperExportManager.exportReportToPdf(jasperPrint));
			
			//Para obtener el reporte y enviar como adjunto
			listaStringBase64.add(Base64.getEncoder().encodeToString(reporteDTO.getReporteByte()));
			reporteDTO.setListaStringBase64(listaStringBase64);
		} catch (Exception e) {
			System.out.println("ERROR al generar el PDF. e.getMessage() = " + e.getMessage());
		}

		return reporteDTO;
	}
}
