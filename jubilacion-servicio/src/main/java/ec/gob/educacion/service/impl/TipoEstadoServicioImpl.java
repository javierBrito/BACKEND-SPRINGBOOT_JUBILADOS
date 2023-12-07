package ec.gob.educacion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubTipoEstado;
import ec.gob.educacion.repositorio.TipoEstadoRepositorio;
import ec.gob.educacion.service.TipoEstadoServicio;

@Service
public class TipoEstadoServicioImpl implements TipoEstadoServicio {
	
	@Autowired
	private TipoEstadoRepositorio tipoEstadoRepositorio;

	@Override
	public JubTipoEstado registrar(JubTipoEstado jubTipoEstado) {
		return tipoEstadoRepositorio.save(jubTipoEstado);
	}

	@Override
	public JubTipoEstado buscarTipoEstadoPorCodigo(long tipestCodigo) {
		return tipoEstadoRepositorio.findByTipestCodigo(tipestCodigo);
	}

	@Override
	public List<JubTipoEstado> listarTipoEstado() {
		return tipoEstadoRepositorio.findByTipestEstadoOrderByTipestNombreAsc(EstadoEnum.ACTIVO.getCodigo());
	}
}
