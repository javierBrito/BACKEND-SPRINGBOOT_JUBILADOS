package ec.gob.educacion.model.jubilacion;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the JUB_DESVINCULACION database table.
 * 
 */
@Entity
@Table(name="JUB_DESVINCULACION")
@NamedQuery(name="JubDesvinculacion.findAll", query="SELECT j FROM JubDesvinculacion j")
@SequenceGenerator(name = "SEQ_JUB_DESVINCULACION_GEN", sequenceName = "SEQ_JUB_DESVINCULACION", allocationSize = 1)
public class JubDesvinculacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DES_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_DESVINCULACION_GEN", strategy = GenerationType.SEQUENCE)
	private long desCodigo;

	@Temporal(TemporalType.DATE)
	@Column(name="DES_FECHA")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date desFecha;

	@Column(name="DES_MONTO")
	private double desMonto;

	//bi-directional many-to-one association to JubAspirante
	@ManyToOne
	@JoinColumn(name="ASP_CODIGO")
	@JsonIgnore
	private JubAspirante jubAspirante;

	@Column(name="DES_ESTADO")
	private int desEstado;
	
	//bi-directional many-to-one association to JubTipoDesvinculacion
	@ManyToOne
	@JoinColumn(name="TIPDES_CODIGO")
	@JsonIgnore
	private JubTipoDesvinculacion jubTipoDesvinculacion;
	
	@Transient
	private long aspCodigo;
	
	@Transient
	private long tipdesCodigo;

	public JubDesvinculacion() {
	}

	public long getDesCodigo() {
		return this.desCodigo;
	}

	public void setDesCodigo(long desCodigo) {
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

	public JubAspirante getJubAspirante() {
		return this.jubAspirante;
	}

	public void setJubAspirante(JubAspirante jubAspirante) {
		this.jubAspirante = jubAspirante;
	}

	public JubTipoDesvinculacion getJubTipoDesvinculacion() {
		return this.jubTipoDesvinculacion;
	}

	public void setJubTipoDesvinculacion(JubTipoDesvinculacion jubTipoDesvinculacion) {
		this.jubTipoDesvinculacion = jubTipoDesvinculacion;
	}

	public long getAspCodigo() {
		return jubAspirante.getAspCodigo();
	}

	public void setAspCodigo(long aspCodigo) {
		this.aspCodigo = aspCodigo;
	}

	public long getTipdesCodigo() {
		return jubTipoDesvinculacion.getTipdesCodigo();
	}

	public void setTipdesCodigo(long tipdesCodigo) {
		this.tipdesCodigo = tipdesCodigo;
	}

	public int getDesEstado() {
		return desEstado;
	}

	public void setDesEstado(int desEstado) {
		this.desEstado = desEstado;
	}

}