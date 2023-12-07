package ec.gob.educacion.model.jubilacion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the JUB_TIPO_LEYES database table.
 * 
 */
@Entity
@Table(name="JUB_TIPO_LEY")
@NamedQuery(name="JubTipoLey.findAll", query="SELECT j FROM JubTipoLey j")
@SequenceGenerator(name = "SEQ_JUB_TIPO_LEY_GEN", sequenceName = "SEQ_JUB_TIPO_LEY", allocationSize = 1)
public class JubTipoLey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TIPLEY_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_TIPO_LEY_GEN", strategy = GenerationType.SEQUENCE)
	private long tipleyCodigo;

	@Column(name="TIPLEY_ESTADO")
	private int tipleyEstado;

	@Column(name = "TIPLEY_FECHA")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date tipleyFecha;

	@Column(name="TIPLEY_NOMBRE")
	private String tipleyNombre;

	public JubTipoLey() {
	}

	public long getTipleyCodigo() {
		return this.tipleyCodigo;
	}

	public void setTipleyCodigo(long tipleyCodigo) {
		this.tipleyCodigo = tipleyCodigo;
	}

	public int getTipleyEstado() {
		return this.tipleyEstado;
	}

	public void setTipleyEstado(int tipleyEstado) {
		this.tipleyEstado = tipleyEstado;
	}

	public Date getTipleyFecha() {
		return this.tipleyFecha;
	}

	public void setTipleyFecha(Date tipleyFecha) {
		this.tipleyFecha = tipleyFecha;
	}

	public String getTipleyNombre() {
		return this.tipleyNombre;
	}

	public void setTipleyNombre(String tipleyNombre) {
		this.tipleyNombre = tipleyNombre;
	}

}