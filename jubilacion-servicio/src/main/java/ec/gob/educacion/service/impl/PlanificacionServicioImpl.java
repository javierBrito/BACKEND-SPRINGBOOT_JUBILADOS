package ec.gob.educacion.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubPlanificado;
import ec.gob.educacion.repositorio.PlanificacionRepositorio;
import ec.gob.educacion.service.PlanificacionServicio;

@Service
public class PlanificacionServicioImpl implements PlanificacionServicio{
	
	@Autowired
	private PlanificacionRepositorio planificacionRepositorio;

	@Override
	public JubPlanificado registrar(JubPlanificado jubPlanificado) {
		return planificacionRepositorio.save(jubPlanificado);
	}

	@Override
	public JubPlanificado buscarPlanificacionPorCodigo(long plaCodigo) {
		return planificacionRepositorio.findByPlaCodigo(plaCodigo);
	}

	@Override
	public List<JubPlanificado> listarPlanificacion() {
		return planificacionRepositorio.findByPlaEstadoOrderByPlaNombreAsc(EstadoEnum.ACTIVO.getCodigo());
	}
	
}
