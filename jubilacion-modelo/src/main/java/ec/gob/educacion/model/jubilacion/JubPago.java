package ec.gob.educacion.model.jubilacion;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * The persistent class for the "JUB_PAGO " database table.
 * 
 */
@Entity
@Table(name="JUB_PAGO")
@NamedQuery(name="JubPago.findAll", query="SELECT j FROM JubPago j")
@SequenceGenerator(name = "SEQ_JUB_PAGO_GEN", sequenceName = "SEQ_JUB_PAGO", allocationSize = 1)
public class JubPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PAG_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_PAGO_GEN", strategy = GenerationType.SEQUENCE)
	private long pagCodigo;

	@Column(name="DES_CODIGO")
	private long desCodigo;

	@Column(name="INT_CODIGO")
	private long intCodigo;

	@Column(name="PAG_CARGOASP")
	private String pagCargoasp;

	@Column(name="PAG_ESTADO")
	private int pagEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="PAG_FCERPAGASP")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date pagFcerpagasp;

	@Temporal(TemporalType.DATE)
	@Column(name="PAG_FECDESASP")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date pagFecdesasp;

	@Temporal(TemporalType.DATE)
	@Column(name="PAG_FECFALLASP")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date pagFecfallasp;

	public JubPago() {
	}

	public long getPagCodigo() {
		return this.pagCodigo;
	}

	public void setPagCodigo(long pagCodigo) {
		this.pagCodigo = pagCodigo;
	}

	public long getDesCodigo() {
		return this.desCodigo;
	}

	public void setDesCodigo(long desCodigo) {
		this.desCodigo = desCodigo;
	}

	public long getIntCodigo() {
		return this.intCodigo;
	}

	public void setIntCodigo(long intCodigo) {
		this.intCodigo = intCodigo;
	}

	public String getPagCargoasp() {
		return this.pagCargoasp;
	}

	public void setPagCargoasp(String pagCargoasp) {
		this.pagCargoasp = pagCargoasp;
	}

	public int getPagEstado() {
		return this.pagEstado;
	}

	public void setPagEstado(int pagEstado) {
		this.pagEstado = pagEstado;
	}

	public Date getPagFcerpagasp() {
		return this.pagFcerpagasp;
	}

	public void setPagFcerpagasp(Date pagFcerpagasp) {
		this.pagFcerpagasp = pagFcerpagasp;
	}

	public Date getPagFecdesasp() {
		return this.pagFecdesasp;
	}

	public void setPagFecdesasp(Date pagFecdesasp) {
		this.pagFecdesasp = pagFecdesasp;
	}

	public Date getPagFecfallasp() {
		return this.pagFecfallasp;
	}

	public void setPagFecfallasp(Date pagFecfallasp) {
		this.pagFecfallasp = pagFecfallasp;
	}

}