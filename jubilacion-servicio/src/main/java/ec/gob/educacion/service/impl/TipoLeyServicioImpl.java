package ec.gob.educacion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubTipoLey;
import ec.gob.educacion.repositorio.TipoLeyRepositorio;
import ec.gob.educacion.service.TipoLeyServicio;

@Service
public class TipoLeyServicioImpl implements TipoLeyServicio{
	
	@Autowired
	private TipoLeyRepositorio jubTipoLeyRepository;

	@Override
	public JubTipoLey registrar(JubTipoLey jubTipoLey) {
		return jubTipoLeyRepository.save(jubTipoLey);
	}

	@Override
	public JubTipoLey buscarTipoLeyPorCodigo(long tipleyCodigo) {
		return jubTipoLeyRepository.findByTipleyCodigo(tipleyCodigo);
	}

	@Override
	public List<JubTipoLey> listarTipoLey() {
		return jubTipoLeyRepository.findByTipleyEstadoOrderByTipleyNombreAsc(EstadoEnum.ACTIVO.getCodigo());
	}


}
