package ec.gob.educacion.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubAspirante;
import ec.gob.educacion.model.jubilacion.JubParametro;
import ec.gob.educacion.model.jubilacion.JubTipoDiscapacidad;
import ec.gob.educacion.repositorio.AspiranteRepositorio;
import ec.gob.educacion.service.AspiranteServicio;
import ec.gob.educacion.service.ParametroServicio;
import ec.gob.educacion.service.TipoDiscapacidadServicio;

@Service
public class AspiranteServicioImpl implements AspiranteServicio {

	@Autowired
	private AspiranteRepositorio aspiranteRepository;

	@Autowired
	private TipoDiscapacidadServicio tipoDiscapacidadServicio;
	@Autowired
	private ParametroServicio parametroServicio;	

	@Override
	public JubAspirante registrar(JubAspirante jubAspirante) {
		if (jubAspirante.getTipdisCodigo() != null) {
			JubTipoDiscapacidad jubTipoDiscapacidad = tipoDiscapacidadServicio
					.buscarTipoDiscapacidadPorCodigo(jubAspirante.getTipdisCodigo());
			if (jubTipoDiscapacidad != null) {
				jubAspirante.setJubTipoDiscapacidad(jubTipoDiscapacidad);
			}
		}
		if (jubAspirante.getParCodigo() != null) {
			JubParametro jubParametro = parametroServicio
					.buscarParametroPorCodigo(jubAspirante.getParCodigo());
			if (jubParametro != null) {
				jubAspirante.setJubParametro(jubParametro);
			}
		}

		return aspiranteRepository.save(jubAspirante);
	}

	@Override
	public JubAspirante buscarAspirantePorCodigo(Long aspCodigo) {
		return aspiranteRepository.findByAspCodigo(aspCodigo);
	}

	@Override
	public JubAspirante buscarAspirantePorCedula(String aspCedula) {
		return aspiranteRepository.findByAspCedulaAndAspEstado(aspCedula, EstadoEnum.ACTIVO.getCodigo());
	}

	@Override
	public List<JubAspirante> listarAspirante() {
		return aspiranteRepository.findByAspEstadoOrderByAspCedulaAsc(EstadoEnum.ACTIVO.getCodigo());
	}

	@Override
	public JubAspirante eliminar(JubAspirante jubAspirante) {
		return aspiranteRepository.save(jubAspirante);
	}
}
