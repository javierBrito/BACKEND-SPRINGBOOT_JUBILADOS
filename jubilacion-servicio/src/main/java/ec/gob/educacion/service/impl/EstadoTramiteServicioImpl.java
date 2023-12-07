package ec.gob.educacion.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubEstadoTramite;
import ec.gob.educacion.repositorio.EstadoTramiteRepositorio;
import ec.gob.educacion.service.EstadoTramiteServicio;

@Service
public class EstadoTramiteServicioImpl implements EstadoTramiteServicio {
	@Autowired
	private EstadoTramiteRepositorio estadoTramiteRepository;

	@Override
	public JubEstadoTramite registrar(JubEstadoTramite jubEstadoTramite) {
		return estadoTramiteRepository.save(jubEstadoTramite);
	}

	@Override
	public JubEstadoTramite buscarEstadoTramitePorCodigo(Long esttraCodigo) {
		return estadoTramiteRepository.findByEsttraCodigo(esttraCodigo);
	}

	@Override
	public JubEstadoTramite buscarEstadoTramitePorNombre(String esttraNombre) {
		return estadoTramiteRepository.findByEsttraNombre(esttraNombre);
	}

	@Override
	public List<JubEstadoTramite> listarEstadoTramite() {
		return estadoTramiteRepository.findByEsttraEstado(EstadoEnum.ACTIVO.getCodigo());
	}

	@Override
	public List<JubEstadoTramite> listarEstadoTramitePorAspirante(Long aspCodigo) {
		return estadoTramiteRepository.findByAspCodigo(aspCodigo);
	}

	@Override
	public JubEstadoTramite eliminar(JubEstadoTramite jubEstadoTramite) {
		return estadoTramiteRepository.save(jubEstadoTramite);
	}
}
