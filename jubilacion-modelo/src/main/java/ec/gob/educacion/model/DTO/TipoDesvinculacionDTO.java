package ec.gob.educacion.model.DTO;

public class TipoDesvinculacionDTO {

	private long tipdesCodigo;

	private int tipdesEstado;

	private String tipdesNombre;
	
	private long tipleyCodigo;
	

	public TipoDesvinculacionDTO() {
	}


	public long getTipdesCodigo() {
		return tipdesCodigo;
	}


	public void setTipdesCodigo(long tipdesCodigo) {
		this.tipdesCodigo = tipdesCodigo;
	}


	public int getTipdesEstado() {
		return tipdesEstado;
	}


	public void setTipdesEstado(int tipdesEstado) {
		this.tipdesEstado = tipdesEstado;
	}


	public String getTipdesNombre() {
		return tipdesNombre;
	}


	public void setTipdesNombre(String tipdesNombre) {
		this.tipdesNombre = tipdesNombre;
	}


	public long getTipleyCodigo() {
		return tipleyCodigo;
	}


	public void setTipleyCodigo(long tipleyCodigo) {
		this.tipleyCodigo = tipleyCodigo;
	}

	
}