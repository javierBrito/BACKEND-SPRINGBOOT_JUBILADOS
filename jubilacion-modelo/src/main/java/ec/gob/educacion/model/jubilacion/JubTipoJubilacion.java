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
 * The persistent class for the JUB_TIPO_JUBILACION database table.
 * 
 */
@Entity
@Table(name="JUB_TIPO_JUBILACION")
@NamedQuery(name="JubTipoJubilacion.findAll", query="SELECT j FROM JubTipoJubilacion j")
@SequenceGenerator(name = "SEQ_JUB_TIPO_JUBILACION_GEN", sequenceName = "SEQ_JUB_TIPO_JUBILACION", allocationSize = 1)
public class JubTipoJubilacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TIPJUB_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_TIPO_JUBILACION_GEN", strategy = GenerationType.SEQUENCE)
	private long tipjubCodigo;

	@Column(name="TIPJUB_ESTADO")
	private int tipjubEstado;

	@Column(name="TIPJUB_NOMBRE")
	private String tipjubNombre;

	public JubTipoJubilacion() {
	}

	public long getTipjubCodigo() {
		return this.tipjubCodigo;
	}

	public void setTipjubCodigo(long tipjubCodigo) {
		this.tipjubCodigo = tipjubCodigo;
	}

	public int getTipjubEstado() {
		return this.tipjubEstado;
	}

	public void setTipjubEstado(int tipjubEstado) {
		this.tipjubEstado = tipjubEstado;
	}

	public String getTipjubNombre() {
		return this.tipjubNombre;
	}

	public void setTipjubNombre(String tipjubNombre) {
		this.tipjubNombre = tipjubNombre;
	}
}