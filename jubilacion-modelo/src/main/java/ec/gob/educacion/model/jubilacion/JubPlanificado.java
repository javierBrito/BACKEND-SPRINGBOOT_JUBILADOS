package ec.gob.educacion.model.jubilacion;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * The persistent class for the JUB_PLANIFICADOS database table.
 * 
 */
@Entity
@Table(name="JUB_PLANIFICADOS")
@NamedQuery(name="JubPlanificado.findAll", query="SELECT j FROM JubPlanificado j")
@SequenceGenerator(name = "SEQ_JUB_PLANIFICADOS_GEN", sequenceName = "SEQ_JUB_PLANIFICADOS", allocationSize = 1)
public class JubPlanificado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PLA_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_PLANIFICADOS_GEN", strategy = GenerationType.SEQUENCE)
	private long plaCodigo;

	@Column(name="PLA_CEDULA")
	private String plaCedula;

	@Column(name="PLA_CODIGOAMIE")
	private String plaCodigoamie;

	@Temporal(TemporalType.DATE)
	@Column(name="PLA_FECHASALIDA")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date plaFechasalida;

	@Column(name="PLA_NOMBRE")
	private String plaNombre;

	@Column(name="PLA_NUMAPORTACIONES")
	private String plaNumaportaciones;

	@Column(name="PLA_REGIMENESCOLAR")
	private String plaRegimenescolar;

	@Column(name="PLA_REGIMENLABORAL")
	private String plaRegimenlaboral;

	@Column(name="PLA_ESTADO")
	private int plaEstado;
	
	public JubPlanificado() {
	}

	public long getPlaCodigo() {
		return this.plaCodigo;
	}

	public void setPlaCodigo(long plaCodigo) {
		this.plaCodigo = plaCodigo;
	}

	public String getPlaCedula() {
		return this.plaCedula;
	}

	public void setPlaCedula(String plaCedula) {
		this.plaCedula = plaCedula;
	}

	public String getPlaCodigoamie() {
		return this.plaCodigoamie;
	}

	public void setPlaCodigoamie(String plaCodigoamie) {
		this.plaCodigoamie = plaCodigoamie;
	}

	public Date getPlaFechasalida() {
		return this.plaFechasalida;
	}

	public void setPlaFechasalida(Date plaFechasalida) {
		this.plaFechasalida = plaFechasalida;
	}

	public String getPlaNombre() {
		return this.plaNombre;
	}

	public void setPlaNombre(String plaNombre) {
		this.plaNombre = plaNombre;
	}

	public String getPlaNumaportaciones() {
		return this.plaNumaportaciones;
	}

	public void setPlaNumaportaciones(String plaNumaportaciones) {
		this.plaNumaportaciones = plaNumaportaciones;
	}

	public String getPlaRegimenescolar() {
		return this.plaRegimenescolar;
	}

	public void setPlaRegimenescolar(String plaRegimenescolar) {
		this.plaRegimenescolar = plaRegimenescolar;
	}

	public String getPlaRegimenlaboral() {
		return this.plaRegimenlaboral;
	}

	public void setPlaRegimenlaboral(String plaRegimenlaboral) {
		this.plaRegimenlaboral = plaRegimenlaboral;
	}

	public int getPlaEstado() {
		return plaEstado;
	}

	public void setPlaEstado(int plaEstado) {
		this.plaEstado = plaEstado;
	}

}