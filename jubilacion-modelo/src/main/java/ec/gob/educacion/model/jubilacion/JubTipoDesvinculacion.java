package ec.gob.educacion.model.jubilacion;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the JUB_TIPO_DESVINCULACION database table.
 * 
 */
@Entity
@Table(name="JUB_TIPO_DESVINCULACION")
@NamedQuery(name="JubTipoDesvinculacion.findAll", query="SELECT j FROM JubTipoDesvinculacion j")
@SequenceGenerator(name = "SEQ_JUB_TIPO_DESVINCULACION_GEN", sequenceName = "SEQ_JUB_TIPO_DESVINCULACION", allocationSize = 1)
public class JubTipoDesvinculacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TIPDES_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_TIPO_DESVINCULACION_GEN", strategy = GenerationType.SEQUENCE)
	private long tipdesCodigo;

	@Column(name="TIPDES_ESTADO")
	private int tipdesEstado;

	@Column(name="TIPDES_NOMBRE")
	private String tipdesNombre;

	//bi-directional many-to-one association to JubDesvinculacion
	@OneToMany(mappedBy="jubTipoDesvinculacion")
	@JsonIgnore
	private List<JubDesvinculacion> jubDesvinculacions;

	//bi-directional many-to-one association to JubTipoLey
	@ManyToOne
	@JoinColumn(name="TIPLEY_CODIGO")
	//@JsonIgnore
	private JubTipoLey jubTipoLey;
	
	//@Transient
	//private long tipleyCodigo;
	

	public JubTipoDesvinculacion() {
	}

	public long getTipdesCodigo() {
		return this.tipdesCodigo;
	}

	public void setTipdesCodigo(long tipdesCodigo) {
		this.tipdesCodigo = tipdesCodigo;
	}

	public int getTipdesEstado() {
		return this.tipdesEstado;
	}

	public void setTipdesEstado(int tipdesEstado) {
		this.tipdesEstado = tipdesEstado;
	}

	public String getTipdesNombre() {
		return this.tipdesNombre;
	}

	public void setTipdesNombre(String tipdesNombre) {
		this.tipdesNombre = tipdesNombre;
	}

	public List<JubDesvinculacion> getJubDesvinculacions() {
		return this.jubDesvinculacions;
	}

	public void setJubDesvinculacions(List<JubDesvinculacion> jubDesvinculacions) {
		this.jubDesvinculacions = jubDesvinculacions;
	}

	public JubDesvinculacion addJubDesvinculacion(JubDesvinculacion jubDesvinculacion) {
		getJubDesvinculacions().add(jubDesvinculacion);
		jubDesvinculacion.setJubTipoDesvinculacion(this);

		return jubDesvinculacion;
	}

	public JubDesvinculacion removeJubDesvinculacion(JubDesvinculacion jubDesvinculacion) {
		getJubDesvinculacions().remove(jubDesvinculacion);
		jubDesvinculacion.setJubTipoDesvinculacion(null);

		return jubDesvinculacion;
	}

	public JubTipoLey getJubTipoLey() {
		return this.jubTipoLey;
	}

	public void setJubTipoLey(JubTipoLey jubTipoLey) {
		this.jubTipoLey = jubTipoLey;
	}
	/*
	public long getTipleyCodigo() {
		if (this.jubTipoLey != null) {
			return this.jubTipoLey.getTipleyCodigo();
		}
		return tipleyCodigo;
	}

	public void setTipleyCodigo(long tipleyCodigo) {
		this.tipleyCodigo = tipleyCodigo;
	}
	*/
}