package ec.gob.educacion.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.gob.educacion.model.DTO.DiscapacidadDTO;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.jubilacion.JubTipoDiscapacidad;
import ec.gob.educacion.repositorio.TipoDiscapacidadRepositorio;
import ec.gob.educacion.service.TipoDiscapacidadServicio;

@Service
public class TipoDiscapacidadServicioImpl implements TipoDiscapacidadServicio{
	
	@Autowired
	private TipoDiscapacidadRepositorio tipoDiscapacidadRepositorio;
	
	@Override
	public JubTipoDiscapacidad registrar(DiscapacidadDTO discapacidadDTO) {
		JubTipoDiscapacidad jubTipoDiscapacidad = new JubTipoDiscapacidad();
		if (discapacidadDTO.getTipdisCodigo() != 0) {
			jubTipoDiscapacidad.setTipdisCodigo(discapacidadDTO.getTipdisCodigo());
		}
		jubTipoDiscapacidad.setTipdisEstado(discapacidadDTO.getTipdisEstado());
		jubTipoDiscapacidad.setTipdisNombre(discapacidadDTO.getTipdisNombre());

		return tipoDiscapacidadRepositorio.save(jubTipoDiscapacidad);
	}

	@Override
	public JubTipoDiscapacidad buscarTipoDiscapacidadPorCodigo(long tipjubCodigo) {
		return tipoDiscapacidadRepositorio.findByTipdisCodigo(tipjubCodigo);
	}

	@Override
	public List<JubTipoDiscapacidad> listarTipoDiscapacidad() {
		return tipoDiscapacidadRepositorio.findByTipdisEstadoOrderByTipdisNombreAsc(EstadoEnum.ACTIVO.getCodigo());
	}

	@Override
	public JubTipoDiscapacidad eliminar(JubTipoDiscapacidad jubTipoDiscapacidad) {
		return tipoDiscapacidadRepositorio.save(jubTipoDiscapacidad);
	}
}
