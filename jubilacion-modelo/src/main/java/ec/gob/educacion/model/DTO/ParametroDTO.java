package ec.gob.educacion.model.DTO;

public class ParametroDTO  {

	private long parCodigo;
	private int parEdadMin;
	private int parEdadMax;
	private int parEstado;
	private int parMinAportaciones;
	private int parTiempoServicio;
	private Long tipdisCodigo;
	private Long tipjubCodigo;
	private Long tipleyCodigo;
	private String parNombre;
	private String parNemonico;
	private Integer tipdisPorcentaje;
	
	public ParametroDTO() {
	}

	public long getParCodigo() {
		return parCodigo;
	}

	public void setParCodigo(long parCodigo) {
		this.parCodigo = parCodigo;
	}

	public int getParEdadMin() {
		return parEdadMin;
	}

	public void setParEdadMin(int parEdadMin) {
		this.parEdadMin = parEdadMin;
	}

	public int getParEstado() {
		return parEstado;
	}

	public void setParEstado(int parEstado) {
		this.parEstado = parEstado;
	}

	public int getParMinAportaciones() {
		return parMinAportaciones;
	}

	public void setParMinAportaciones(int parMinAportaciones) {
		this.parMinAportaciones = parMinAportaciones;
	}

	public int getParTiempoServicio() {
		return parTiempoServicio;
	}

	public void setParTiempoServicio(int parTiempoServicio) {
		this.parTiempoServicio = parTiempoServicio;
	}

	public Long getTipjubCodigo() {
		return tipjubCodigo;
	}

	public void setTipjubCodigo(Long tipjubCodigo) {
		this.tipjubCodigo = tipjubCodigo;
	}

	public Long getTipdisCodigo() {
		return tipdisCodigo;
	}

	public void setTipdisCodigo(Long tipdisCodigo) {
		this.tipdisCodigo = tipdisCodigo;
	}

	public String getParNombre() {
		return parNombre;
	}

	public void setParNombre(String parNombre) {
		this.parNombre = parNombre;
	}

	public String getParNemonico() {
		return parNemonico;
	}

	public void setParNemonico(String parNemonico) {
		this.parNemonico = parNemonico;
	}

	public int getParEdadMax() {
		return parEdadMax;
	}

	public void setParEdadMax(int parEdadMax) {
		this.parEdadMax = parEdadMax;
	}

	public Integer getTipdisPorcentaje() {
		return tipdisPorcentaje;
	}

	public void setTipdisPorcentaje(Integer tipdisPorcentaje) {
		this.tipdisPorcentaje = tipdisPorcentaje;
	}

	public Long getTipleyCodigo() {
		return tipleyCodigo;
	}

	public void setTipleyCodigo(Long tipleyCodigo) {
		this.tipleyCodigo = tipleyCodigo;
	}
}