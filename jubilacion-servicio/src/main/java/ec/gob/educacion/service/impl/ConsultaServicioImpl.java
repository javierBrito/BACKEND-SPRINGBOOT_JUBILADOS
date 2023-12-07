package ec.gob.educacion.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubConsulta;
import ec.gob.educacion.repositorio.ConsultaRepositorio;
import ec.gob.educacion.service.ConsultaServicio;

@Service
public class ConsultaServicioImpl implements ConsultaServicio{
	
	@Autowired
	private ConsultaRepositorio consultaRepositorio;

	@Override
	public JubConsulta registrar(JubConsulta jubConsulta) {
		
		return consultaRepositorio.save(jubConsulta);
	}

	@Override
	public JubConsulta buscarPagoPorCodigo(long conCodigo) {
	
		return consultaRepositorio.findByConCodigo(conCodigo);
	}

	@Override
	public List<JubConsulta> listaPagos() {
		
		return consultaRepositorio.findByConEstadoOrderByConAcuerdoAsc(EstadoEnum.ACTIVO.getCodigo());
	}

	
}
