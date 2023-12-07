package ec.gob.educacion.model.jubilacion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the JUB_ESTADO_TRAMITE database table.
 * 
 */
@Entity
@Table(name = "JUB_ESTADO_TRAMITE")
@NamedQuery(name = "JubEstadoTramite.findAll", query = "SELECT t FROM JubEstadoTramite t")
@SequenceGenerator(name = "SEQ_JUB_ESTADO_TRAMITE_GEN", sequenceName = "SEQ_JUB_ESTADO_TRAMITE", allocationSize = 1)
public class JubEstadoTramite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ESTTRA_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_ESTADO_TRAMITE_GEN", strategy = GenerationType.SEQUENCE)
	private Long esttraCodigo;

	@Column(name = "ESTTRA_NOMBRE")
	private String esttraNombre;

	@Column(name = "ESTTRA_ESTADO")
	private int esttraEstado;

	@Column(name = "ESTTRA_FECHA")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date esttraFecha;

	@Column(name = "ESTTRA_USUARIO")
	private String esttraUsuario;

	@Column(name = "ASP_CODIGO")
	private Long aspCodigo;

	// bi-directional many-to-one association to JubTipoDiscapacidad
	@ManyToOne
	@JoinColumn(name = "TIPEST_CODIGO")
	// @JsonIgnore
	private JubTipoEstado JubTipoEstado;

	public JubEstadoTramite() {
	}

	public Long getEsttraCodigo() {
		return esttraCodigo;
	}

	public void setEsttraCodigo(Long esttraCodigo) {
		this.esttraCodigo = esttraCodigo;
	}

	public String getEsttraNombre() {
		return esttraNombre;
	}

	public void setEsttraNombre(String esttraNombre) {
		this.esttraNombre = esttraNombre;
	}

	public int getEsttraEstado() {
		return esttraEstado;
	}

	public void setEsttraEstado(int esttraEstado) {
		this.esttraEstado = esttraEstado;
	}

	public Date getEsttraFecha() {
		return esttraFecha;
	}

	public void setEsttraFecha(Date esttraFecha) {
		this.esttraFecha = esttraFecha;
	}

	public JubTipoEstado getJubTipoEstado() {
		return JubTipoEstado;
	}

	public void setJubTipoEstado(JubTipoEstado jubTipoEstado) {
		JubTipoEstado = jubTipoEstado;
	}

	public Long getAspCodigo() {
		return aspCodigo;
	}

	public void setAspCodigo(Long aspCodigo) {
		this.aspCodigo = aspCodigo;
	}

	public String getEsttraUsuario() {
		return esttraUsuario;
	}

	public void setEsttraUsuario(String esttraUsuario) {
		this.esttraUsuario = esttraUsuario;
	}
}