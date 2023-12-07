package ec.gob.educacion.model.DTO;

public class DiscapacidadDTO  {
	
	private long tipdisCodigo;

	private int tipdisEstado;

	private String tipdisNombre;

	public DiscapacidadDTO() {
		
	}

	public long getTipdisCodigo() {
		return tipdisCodigo;
	}

	public void setTipdisCodigo(long tipdisCodigo) {
		this.tipdisCodigo = tipdisCodigo;
	}

	public int getTipdisEstado() {
		return tipdisEstado;
	}

	public void setTipdisEstado(int tipdisEstado) {
		this.tipdisEstado = tipdisEstado;
	}

	public String getTipdisNombre() {
		return tipdisNombre;
	}

	public void setTipdisNombre(String tipdisNombre) {
		this.tipdisNombre = tipdisNombre;
	}

}