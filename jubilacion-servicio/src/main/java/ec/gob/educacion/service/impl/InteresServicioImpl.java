package ec.gob.educacion.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubInteres;
import ec.gob.educacion.repositorio.InteresRepositorio;
import ec.gob.educacion.service.InteresServicio;

@Service
public class InteresServicioImpl implements InteresServicio{
	
	@Autowired
	private InteresRepositorio interesRepositorio;

	@Override
	public JubInteres registrar(JubInteres jubInteres) {
		return interesRepositorio.save(jubInteres);
	}

	@Override
	public JubInteres buscarInteresPorCodigo(long intCodigo) {
		return interesRepositorio.findByIntCodigo(intCodigo);
	}

	@Override
	public List<JubInteres> listarInteres() {
		return interesRepositorio.findByIntEstadoOrderByIntNombreAsc(EstadoEnum.ACTIVO.getCodigo());
	}	
	
}
