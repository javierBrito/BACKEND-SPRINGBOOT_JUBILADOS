 package ec.gob.educacion.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubParametro;
import ec.gob.educacion.model.jubilacion.JubTipoDiscapacidad;
import ec.gob.educacion.model.jubilacion.JubTipoJubilacion;
import ec.gob.educacion.model.jubilacion.JubTipoLey;
import ec.gob.educacion.repositorio.ParametroRepositorio;
import ec.gob.educacion.service.ParametroServicio;
import ec.gob.educacion.service.TipoDiscapacidadServicio;
import ec.gob.educacion.service.TipoJubilacionServicio;
import ec.gob.educacion.service.TipoLeyServicio;

@Service
public class ParametroServicioImpl implements ParametroServicio{
	@Autowired
	private ParametroRepositorio parametroRepositorio;

	@Autowired
	private TipoDiscapacidadServicio tipoDiscapacidadServicio;
	
	@Autowired
	private TipoJubilacionServicio tipoJubilacionServicio;
	
	@Autowired
	private TipoLeyServicio tipoLeyServicio;
	
	@Override
	public JubParametro registrar(JubParametro jubParametro) {
		System.out.println("registrar(JubParametro jubParametro) 1 = "+jubParametro.getTipjubCodigo());
		if (jubParametro.getTipjubCodigo() != 0 && jubParametro.getTipjubCodigo() != null) {
			JubTipoJubilacion jubTipoJubilacion = tipoJubilacionServicio.buscarTipoJubilacionPorCodigo(jubParametro.getTipjubCodigo());
			jubParametro.setJubTipoJubilacion(jubTipoJubilacion);
		}
		System.out.println("registrar(JubParametro jubParametro) 2 = "+jubParametro.getTipdisCodigo());
		if (jubParametro.getTipdisCodigo() != 0 && jubParametro.getTipdisCodigo() != null) {
			JubTipoDiscapacidad jubTipoDiscapacidad = tipoDiscapacidadServicio.buscarTipoDiscapacidadPorCodigo(jubParametro.getTipdisCodigo());
			jubParametro.setJubTipoDiscapacidad(jubTipoDiscapacidad);
		}
		System.out.println("registrar(JubParametro jubParametro) 3 = "+jubParametro.getTipleyCodigo());
		if (jubParametro.getTipleyCodigo() != 0 && jubParametro.getTipleyCodigo() != null) {
			JubTipoLey jubTipoLey = tipoLeyServicio.buscarTipoLeyPorCodigo(jubParametro.getTipleyCodigo());
			jubParametro.setJubTipoLey(jubTipoLey);
		}
		System.out.println("registrar(JubParametro jubParametro) 4");
		
		return parametroRepositorio.save(jubParametro);
	}

	@Override
	public JubParametro buscarParametroPorCodigo(long codigo) {
		return parametroRepositorio.findByParCodigo(codigo);
	}

	@Override
	public List<JubParametro> listarParametro() {
		return parametroRepositorio.findByParEstadoOrderByParCodigoAsc(EstadoEnum.ACTIVO.getCodigo());
	}

	@Override
	public JubParametro eliminar(JubParametro jubParametro) {
		return parametroRepositorio.save(jubParametro);
	}


}
