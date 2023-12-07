package ec.gob.educacion.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubEod;
import ec.gob.educacion.repositorio.EodRepositorio;
import ec.gob.educacion.service.EodServicio;

@Service
public class EodServicioImpl implements EodServicio {

	@Autowired
	private EodRepositorio eodRepository;

	@Override
	public JubEod registrar(JubEod jubEod) {
		return eodRepository.save(jubEod);
	}

	@Override
	public JubEod buscarEodPorCodigo(Long aspCodigo) {
		return eodRepository.findByEodCodigo(aspCodigo);
	}

	@Override
	public List<JubEod> listarEod() {
		return eodRepository.findByEodEstado(EstadoEnum.ACTIVO.getCodigo());
	}

	@Override
	public JubEod eliminar(JubEod jubEod) {
		return eodRepository.save(jubEod);
	}
}
