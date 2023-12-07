package ec.gob.educacion.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubTipoDesvinculacion;
import ec.gob.educacion.repositorio.TipoDesvinculacionRepositorio;
import ec.gob.educacion.service.TipoDesvinculacionServicio;

@Service
public class TipoDesvinculacionServicioImpl implements TipoDesvinculacionServicio{
	@Autowired
	private TipoDesvinculacionRepositorio tipoDesvinculacionRepositorio;

	@Override
	public JubTipoDesvinculacion registrar(JubTipoDesvinculacion jubTipoDesvinculacion) {
		return tipoDesvinculacionRepositorio.save(jubTipoDesvinculacion);
	}

	@Override
	public JubTipoDesvinculacion buscarTipoDesvinculacionPorCodigo(long tipdesCodigo) {
		return tipoDesvinculacionRepositorio.findByTipdesCodigo(tipdesCodigo);
	}

	@Override
	public List<JubTipoDesvinculacion> listarTipoDesvinculacion() {
		return tipoDesvinculacionRepositorio.findByTipdesEstadoOrderByTipdesNombreAsc(EstadoEnum.ACTIVO.getCodigo());
	}

	@Override
	public JubTipoDesvinculacion eliminar(JubTipoDesvinculacion jubTipoDesvinculacion) {
		return tipoDesvinculacionRepositorio.save(jubTipoDesvinculacion);
	}

}
