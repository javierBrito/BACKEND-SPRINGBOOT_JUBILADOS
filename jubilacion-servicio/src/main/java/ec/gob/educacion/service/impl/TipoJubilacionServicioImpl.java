package ec.gob.educacion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubTipoJubilacion;
import ec.gob.educacion.repositorio.TipoJubilacionRepositorio;
import ec.gob.educacion.service.TipoJubilacionServicio;

@Service
public class TipoJubilacionServicioImpl implements TipoJubilacionServicio{
	
	@Autowired
	private TipoJubilacionRepositorio tipoJubilacionRepositorio;

	@Override
	public JubTipoJubilacion registrar(JubTipoJubilacion jubTipoJubilacion) {
		return tipoJubilacionRepositorio.save(jubTipoJubilacion);
	}

	@Override
	public JubTipoJubilacion buscarTipoJubilacionPorCodigo(long tipjubCodigo) {
		return tipoJubilacionRepositorio.findByTipjubCodigo(tipjubCodigo);
	}

	@Override
	public List<JubTipoJubilacion> listarTipoJubilacion() {
		return tipoJubilacionRepositorio.findByTipjubEstadoOrderByTipjubNombreAsc(EstadoEnum.ACTIVO.getCodigo());
	}
}
