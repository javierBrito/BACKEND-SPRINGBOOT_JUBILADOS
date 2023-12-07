package ec.gob.educacion.model.jubilacion;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the JUB_INTERES database table.
 * 
 */
@Entity
@Table(name="JUB_INTERES")
@NamedQuery(name="JubInteres.findAll", query="SELECT j FROM JubInteres j")
@SequenceGenerator(name = "SEQ_JUB_INTERES_GEN", sequenceName = "SEQ_JUB_INTERES", allocationSize = 1)
public class JubInteres implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INT_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_INTERES_GEN", strategy = GenerationType.SEQUENCE)
	private long intCodigo;

	@Column(name="INT_NOMBRE")
	private String intNombre;
	
	@Column(name="INT_ESTADO")
	private int intEstado;
	

	public JubInteres() {
	}

	public long getIntCodigo() {
		return this.intCodigo;
	}

	public void setIntCodigo(long intCodigo) {
		this.intCodigo = intCodigo;
	}

	public String getIntNombre() {
		return this.intNombre;
	}

	public void setIntNombre(String intNombre) {
		this.intNombre = intNombre;
	}

	public int getIntEstado() {
		return intEstado;
	}

	public void setIntEstado(int intEstado) {
		this.intEstado = intEstado;
	}

}