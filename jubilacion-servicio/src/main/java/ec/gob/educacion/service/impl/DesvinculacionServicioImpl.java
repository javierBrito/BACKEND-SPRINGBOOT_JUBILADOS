package ec.gob.educacion.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.DTO.DesvinculacionDTO;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubAspirante;
import ec.gob.educacion.model.jubilacion.JubDesvinculacion;
import ec.gob.educacion.model.jubilacion.JubTipoDesvinculacion;
import ec.gob.educacion.repositorio.DesvinculacionRepositorio;
import ec.gob.educacion.service.AspiranteServicio;
import ec.gob.educacion.service.DesvinculacionServicio;
import ec.gob.educacion.service.TipoDesvinculacionServicio;

@Service
public class DesvinculacionServicioImpl implements DesvinculacionServicio{
	
	@Autowired
	private DesvinculacionRepositorio desvinculacionRepositorio;

	@Autowired
	private TipoDesvinculacionServicio tipoDesvinculacionServicio;
	
	@Autowired
	private AspiranteServicio aspiranteServicio;

	@Override
	public JubDesvinculacion registrar(DesvinculacionDTO desvinculacionDTO) {
		
		JubDesvinculacion jubDesvinculacion= new JubDesvinculacion();
		if (desvinculacionDTO.getDesCodigo() != null) {
			jubDesvinculacion.setDesCodigo(desvinculacionDTO.getDesCodigo());
		}
		jubDesvinculacion.setDesFecha(desvinculacionDTO.getDesFecha());
		jubDesvinculacion.setDesMonto(desvinculacionDTO.getDesMonto());
		jubDesvinculacion.setDesEstado(desvinculacionDTO.getDesEstado());
		if (desvinculacionDTO.getTipdesCodigo() != null) {
			JubTipoDesvinculacion jubTipoDesvinculacion = tipoDesvinculacionServicio.buscarTipoDesvinculacionPorCodigo(desvinculacionDTO.getTipdesCodigo());
			jubDesvinculacion.setJubTipoDesvinculacion(jubTipoDesvinculacion);
		}
		if (desvinculacionDTO.getAspCodigo() != null) {
			JubAspirante jubAspirante  = aspiranteServicio.buscarAspirantePorCodigo(desvinculacionDTO.getAspCodigo());
			jubDesvinculacion.setJubAspirante(jubAspirante);
		}

		return desvinculacionRepositorio.save(jubDesvinculacion);
	}

	@Override
	public JubDesvinculacion buscarDesvinculacionPorCodigo(long desCodigo) {
		return desvinculacionRepositorio.findByDesCodigo(desCodigo);
	}

	@Override
	public List<JubDesvinculacion> listarDesvinculacion() {
		return desvinculacionRepositorio.findByDesEstadoOrderByDesCodigoAsc(EstadoEnum.ACTIVO.getCodigo());
	}

	@Override
	public JubDesvinculacion eliminar(JubDesvinculacion jubDesvinculacion) {
		return desvinculacionRepositorio.save(jubDesvinculacion);
	}
}
