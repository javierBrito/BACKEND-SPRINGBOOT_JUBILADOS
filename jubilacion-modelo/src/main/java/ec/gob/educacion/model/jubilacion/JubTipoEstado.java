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
 * The persistent class for the JUB_TIPO_ESTADO database table.
 * 
 */
@Entity
@Table(name="JUB_TIPO_ESTADO")
@NamedQuery(name="JubTipoEstado.findAll", query="SELECT j FROM JubTipoEstado j")
@SequenceGenerator(name = "SEQ_JUB_TIPO_ESTADO_GEN", sequenceName = "SEQ_JUB_TIPO_ESTADO", allocationSize = 1)
public class JubTipoEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TIPEST_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_TIPO_ESTADO_GEN", strategy = GenerationType.SEQUENCE)
	private long tipestCodigo;

	@Column(name="TIPEST_ESTADO")
	private int tipestEstado;

	@Column(name="TIPEST_NOMBRE")
	private String tipestNombre;

	public JubTipoEstado() {
	}

	public long getTipestCodigo() {
		return this.tipestCodigo;
	}

	public void setTipestCodigo(long tipestCodigo) {
		this.tipestCodigo = tipestCodigo;
	}

	public int getTipestEstado() {
		return this.tipestEstado;
	}

	public void setTipestEstado(int tipestEstado) {
		this.tipestEstado = tipestEstado;
	}

	public String getTipestNombre() {
		return this.tipestNombre;
	}

	public void setTipestNombre(String tipestNombre) {
		this.tipestNombre = tipestNombre;
	}
}