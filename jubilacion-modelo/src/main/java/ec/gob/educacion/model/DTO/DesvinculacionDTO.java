package ec.gob.educacion.model.DTO;

import java.util.Date;


public class DesvinculacionDTO {

	private Long desCodigo;

	private Date desFecha;

	private double desMonto;

	private Long aspCodigo;

	private Long tipdesCodigo;
	
	private int desEstado;
	

	public DesvinculacionDTO() {
	}

	public Long getDesCodigo() {
		return this.desCodigo;
	}

	public void setDesCodigo(Long desCodigo) {
		this.desCodigo = desCodigo;
	}

	public Date getDesFecha() {
		return this.desFecha;
	}

	public void setDesFecha(Date desFecha) {
		this.desFecha = desFecha;
	}

	public double getDesMonto() {
		return this.desMonto;
	}

	public void setDesMonto(double desMonto) {
		this.desMonto = desMonto;
	}

	public Long getAspCodigo() {
		return aspCodigo;
	}

	public void setAspCodigo(Long aspCodigo) {
		this.aspCodigo = aspCodigo;
	}

	public Long getTipdesCodigo() {
		return tipdesCodigo;
	}

	public void setTipdesCodigo(Long tipdesCodigo) {
		this.tipdesCodigo = tipdesCodigo;
	}

	public int getDesEstado() {
		return desEstado;
	}

	public void setDesEstado(int desEstado) {
		this.desEstado = desEstado;
	}
}