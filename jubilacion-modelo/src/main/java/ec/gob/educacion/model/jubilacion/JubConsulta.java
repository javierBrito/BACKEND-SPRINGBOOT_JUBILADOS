package ec.gob.educacion.model.jubilacion;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the JUB_CONSULTA database table.
 * 
 */
@Entity
@Table(name="JUB_CONSULTA")
@NamedQuery(name="JubConsulta.findAll", query="SELECT j FROM JubConsulta j")
@SequenceGenerator(name = "SEQ_JUB_CONSULTA_GEN", sequenceName = "SEQ_JUB_CONSULTA", allocationSize = 1)
public class JubConsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CON_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_CONSULTA_GEN", strategy = GenerationType.SEQUENCE)
	private long conCodigo;

	@Column(name="CON_ACUERDO")
	private String conAcuerdo;

	@Temporal(TemporalType.DATE)
	@Column(name="CON_ANOSALIDA")
	private Date conAnosalida;

	@Column(name="CON_CEDULA")
	private String conCedula;

	@Column(name="CON_ENTIDADOPER")
	private String conEntidadoper;

	@Column(name="CON_ESTADO")
	private int conEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="CON_FECHAMDT")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date conFechamdt;

	@Temporal(TemporalType.DATE)
	@Column(name="CON_FECHAOBS")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date conFechaobs;

	@Temporal(TemporalType.DATE)
	@Column(name="CON_FECHASUBSA")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date conFechasubsa;

	@Column(name="CON_MODALIDADDESV")
	private BigDecimal conModalidaddesv;

	@Column(name="CON_NOMBRE")
	private String conNombre;

	@Column(name="CON_OFICIOMDT")
	private String conOficiomdt;

	@Column(name="CON_OFICIOOBS")
	private String conOficioobs;

	@Column(name="CON_OFICIOSUBSA")
	private String conOficiosubsa;

	@Column(name="CON_REGIMENL")
	private int conRegimenl;

	@Column(name="CON_ZONA")
	private int conZona;

	public JubConsulta() {
	}

	public long getConCodigo() {
		return this.conCodigo;
	}

	public void setConCodigo(long conCodigo) {
		this.conCodigo = conCodigo;
	}

	public String getConAcuerdo() {
		return this.conAcuerdo;
	}

	public void setConAcuerdo(String conAcuerdo) {
		this.conAcuerdo = conAcuerdo;
	}

	public Date getConAnosalida() {
		return this.conAnosalida;
	}

	public void setConAnosalida(Date conAnosalida) {
		this.conAnosalida = conAnosalida;
	}

	public String getConCedula() {
		return this.conCedula;
	}

	public void setConCedula(String conCedula) {
		this.conCedula = conCedula;
	}

	public String getConEntidadoper() {
		return this.conEntidadoper;
	}

	public void setConEntidadoper(String conEntidadoper) {
		this.conEntidadoper = conEntidadoper;
	}

	public int getConEstado() {
		return this.conEstado;
	}

	public void setConEstado(int conEstado) {
		this.conEstado = conEstado;
	}

	public Date getConFechamdt() {
		return this.conFechamdt;
	}

	public void setConFechamdt(Date conFechamdt) {
		this.conFechamdt = conFechamdt;
	}

	public Date getConFechaobs() {
		return this.conFechaobs;
	}

	public void setConFechaobs(Date conFechaobs) {
		this.conFechaobs = conFechaobs;
	}

	public Date getConFechasubsa() {
		return this.conFechasubsa;
	}

	public void setConFechasubsa(Date conFechasubsa) {
		this.conFechasubsa = conFechasubsa;
	}

	public BigDecimal getConModalidaddesv() {
		return this.conModalidaddesv;
	}

	public void setConModalidaddesv(BigDecimal conModalidaddesv) {
		this.conModalidaddesv = conModalidaddesv;
	}

	public String getConNombre() {
		return this.conNombre;
	}

	public void setConNombre(String conNombre) {
		this.conNombre = conNombre;
	}

	public String getConOficiomdt() {
		return this.conOficiomdt;
	}

	public void setConOficiomdt(String conOficiomdt) {
		this.conOficiomdt = conOficiomdt;
	}

	public String getConOficioobs() {
		return this.conOficioobs;
	}

	public void setConOficioobs(String conOficioobs) {
		this.conOficioobs = conOficioobs;
	}

	public String getConOficiosubsa() {
		return this.conOficiosubsa;
	}

	public void setConOficiosubsa(String conOficiosubsa) {
		this.conOficiosubsa = conOficiosubsa;
	}

	public int getConRegimenl() {
		return this.conRegimenl;
	}

	public void setConRegimenl(int conRegimenl) {
		this.conRegimenl = conRegimenl;
	}

	public int getConZona() {
		return this.conZona;
	}

	public void setConZona(int conZona) {
		this.conZona = conZona;
	}

}