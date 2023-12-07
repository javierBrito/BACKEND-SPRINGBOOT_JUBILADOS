package ec.gob.educacion.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubPago;
import ec.gob.educacion.repositorio.PagoRepositorio;
import ec.gob.educacion.service.PagoServicio;

@Service
public class PagoServicioImpl implements PagoServicio{
	
	@Autowired
	private PagoRepositorio pagoRepositorio;

	@Override
	public JubPago registrar(JubPago jubPago) {
		return pagoRepositorio.save(jubPago);
	}

	@Override
	public JubPago buscarPagoPorCodigo(long pagCodigo) {
		return pagoRepositorio.findByPagCodigo(pagCodigo);
	}

	@Override
	public List<JubPago> listarPago() {
		return pagoRepositorio.findByPagEstadoOrderByPagCargoaspAsc(EstadoEnum.ACTIVO.getCodigo());
	}

	
}
