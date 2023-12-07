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
 * The persistent class for the JUB_TIPO_DISCAPACIDAD database table.
 * 
 */
@Entity
@Table(name="JUB_TIPO_DISCAPACIDAD")
@NamedQuery(name="JubTipoDiscapacidad.findAll", query="SELECT j FROM JubTipoDiscapacidad j")
@SequenceGenerator(name = "SEQ_JUB_TIPO_DISCAPACIDAD_GEN", sequenceName = "SEQ_JUB_TIPO_DISCAPACIDAD", allocationSize = 1)
public class JubTipoDiscapacidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TIPDIS_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_TIPO_DISCAPACIDAD_GEN", strategy = GenerationType.SEQUENCE)
	private long tipdisCodigo;

	@Column(name="TIPDIS_ESTADO")
	private int tipdisEstado;

	@Column(name="TIPDIS_NOMBRE")
	private String tipdisNombre;

	public JubTipoDiscapacidad() {
	}

	public long getTipdisCodigo() {
		return this.tipdisCodigo;
	}

	public void setTipdisCodigo(long tipdisCodigo) {
		this.tipdisCodigo = tipdisCodigo;
	}

	public int getTipdisEstado() {
		return this.tipdisEstado;
	}

	public void setTipdisEstado(int tipdisEstado) {
		this.tipdisEstado = tipdisEstado;
	}

	public String getTipdisNombre() {
		return this.tipdisNombre;
	}

	public void setTipdisNombre(String tipdisNombre) {
		this.tipdisNombre = tipdisNombre;
	}
}