package ec.gob.educacion.model.jubilacion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the JUB_EOD database table.
 * 
 */
@Entity
@Table(name = "JUB_EOD")
@NamedQuery(name = "JubEod.findAll", query = "SELECT j FROM JubEod j")
@SequenceGenerator(name = "SEQ_JUB_EOD_GEN", sequenceName = "SEQ_JUB_EOD", allocationSize = 1)
public class JubEod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EOD_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_EOD_GEN", strategy = GenerationType.SEQUENCE)
	private Long eodCodigo;

	@Column(name = "EOD_RUC")
	private String eodRuc;

	@Column(name = "EOD_NOMBRE")
	private String eodNombre;

	@Column(name = "EOD_TIPO")
	private String eodTipo;

	@Column(name = "EOD_ZONA")
	private String eodZona;

	@Column(name = "EOD_SUBSE_COORZONA")
	private String eodSubseCoorZona;

	@Column(name = "EOD_PROVINCIA")
	private String eodProvincia;

	@Column(name = "EOD_CANTON")
	private String eodCanton;

	@Column(name = "EOD_ESTADO")
	private int eodEstado;

	public JubEod() {
	}

	public Long getEodCodigo() {
		return eodCodigo;
	}

	public void setEodCodigo(Long eodCodigo) {
		this.eodCodigo = eodCodigo;
	}

	public String getEodRuc() {
		return eodRuc;
	}

	public void setEodRuc(String eodRuc) {
		this.eodRuc = eodRuc;
	}

	public String getEodNombre() {
		return eodNombre;
	}

	public void setEodNombre(String eodNombre) {
		this.eodNombre = eodNombre;
	}

	public String getEodTipo() {
		return eodTipo;
	}

	public void setEodTipo(String eodTipo) {
		this.eodTipo = eodTipo;
	}

	public String getEodZona() {
		return eodZona;
	}

	public void setEodZona(String eodZona) {
		this.eodZona = eodZona;
	}

	public String getEodSubseCoorZona() {
		return eodSubseCoorZona;
	}

	public void setEodSubseCoorZona(String eodSubseCoorZona) {
		this.eodSubseCoorZona = eodSubseCoorZona;
	}

	public String getEodProvincia() {
		return eodProvincia;
	}

	public void setEodProvincia(String eodProvincia) {
		this.eodProvincia = eodProvincia;
	}

	public String getEodCanton() {
		return eodCanton;
	}

	public void setEodCanton(String eodCanton) {
		this.eodCanton = eodCanton;
	}

	public int getEodEstado() {
		return eodEstado;
	}

	public void setEodEstado(int eodEstado) {
		this.eodEstado = eodEstado;
	}
}