package ec.gob.educacion.model.jubilacion;

import java.io.Serializable;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the JUB_PARAMETROS database table.
 * 
 */
@Entity
@Table(name="JUB_PARAMETROS")
@NamedQuery(name="JubParametro.findAll", query="SELECT j FROM JubParametro j")
@SequenceGenerator(name = "SEQ_JUB_PARAMETROS_GEN", sequenceName = "SEQ_JUB_PARAMETROS", allocationSize = 1)
public class JubParametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PAR_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_PARAMETROS_GEN", strategy = GenerationType.SEQUENCE)
	private Long parCodigo;

	@Column(name="PAR_EDAD_MIN")
	private int parEdadMin;

	@Column(name="PAR_EDAD_MAX")
	private int parEdadMax;

	@Column(name="PAR_ESTADO")
	private int parEstado;

	@Column(name="PAR_MINAPORTACIONES")
	private int parMinAportaciones;

	@Column(name="PAR_TIEMPOSERVICIO")
	private int parTiempoServicio;

	@Column(name="PAR_NOMBRE")
	private String parNombre;

	@Column(name="PAR_NEMONICO")
	private String parNemonico;

	@Column(name="TIPDIS_PORCENTAJE")
	private Integer tipdisPorcentaje;

	//bi-directional many-to-one association to JubTipoDiscapacidad
	@ManyToOne
	@JoinColumn(name="TIPDIS_CODIGO")
	//@JsonIgnore
	private JubTipoDiscapacidad jubTipoDiscapacidad;

	//bi-directional many-to-one association to JubTipoJubilacion
	@ManyToOne
	@JoinColumn(name="TIPJUB_CODIGO")
	//@JsonIgnore
	private JubTipoJubilacion jubTipoJubilacion;

	//bi-directional many-to-one association to JubTipoLey
	@ManyToOne
	@JoinColumn(name="TIPLEY_CODIGO")
	//@JsonIgnore
	private JubTipoLey jubTipoLey;

	@Transient
	private Long tipdisCodigo;
	
	@Transient
	private Long tipjubCodigo;
	
	@Transient
	private Long tipleyCodigo;
	
	public JubParametro() {
	}

	public Long getParCodigo() {
		return this.parCodigo;
	}

	public void setParCodigo(Long parCodigo) {
		this.parCodigo = parCodigo;
	}

	public int getParEdadMin() {
		return this.parEdadMin;
	}

	public void setParEdadMin(int parEdadMin) {
		this.parEdadMin = parEdadMin;
	}

	public int getParEstado() {
		return this.parEstado;
	}

	public void setParEstado(int parEstado) {
		this.parEstado = parEstado;
	}

	public int getParMinAportaciones() {
		return parMinAportaciones;
	}

	public void setParMinAportaciones(int parMinAportaciones) {
		this.parMinAportaciones = parMinAportaciones;
	}

	public int getParTiempoServicio() {
		return parTiempoServicio;
	}

	public void setParTiempoServicio(int parTiempoServicio) {
		this.parTiempoServicio = parTiempoServicio;
	}

	public JubTipoDiscapacidad getJubTipoDiscapacidad() {
		return this.jubTipoDiscapacidad;
	}

	public void setJubTipoDiscapacidad(JubTipoDiscapacidad jubTipoDiscapacidad) {
		this.jubTipoDiscapacidad = jubTipoDiscapacidad;
	}

	public JubTipoJubilacion getJubTipoJubilacion() {
		return this.jubTipoJubilacion;
	}

	public void setJubTipoJubilacion(JubTipoJubilacion jubTipoJubilacion) {
		this.jubTipoJubilacion = jubTipoJubilacion;
	}

	public Long getTipjubCodigo() {
		if (jubTipoJubilacion != null) {
			return jubTipoJubilacion.getTipjubCodigo();
		}
		return tipjubCodigo;
	}

	public void setTipjubCodigo(Long tipjubCodigo) {
		this.tipjubCodigo = tipjubCodigo;
	}

	public Long getTipdisCodigo() {
		if (jubTipoDiscapacidad != null) {
			return jubTipoDiscapacidad.getTipdisCodigo();
		}
		return tipdisCodigo;
	}

	public void setTipdisCodigo(Long tipdisCodigo) {
		this.tipdisCodigo = tipdisCodigo;
	}

	public String getParNombre() {
		return parNombre;
	}

	public void setParNombre(String parNombre) {
		this.parNombre = parNombre;
	}

	public String getParNemonico() {
		return parNemonico;
	}

	public void setParNemonico(String parNemonico) {
		this.parNemonico = parNemonico;
	}

	public int getParEdadMax() {
		return parEdadMax;
	}

	public void setParEdadMax(int parEdadMax) {
		this.parEdadMax = parEdadMax;
	}

	public Integer getTipdisPorcentaje() {
		return tipdisPorcentaje;
	}

	public void setTipdisPorcentaje(Integer tipdisPorcentaje) {
		this.tipdisPorcentaje = tipdisPorcentaje;
	}

	public Long getTipleyCodigo() {
		if (jubTipoLey != null) {
			return jubTipoLey.getTipleyCodigo();
		}
		return tipleyCodigo;
	}

	public void setTipleyCodigo(Long tipleyCodigo) {
		this.tipleyCodigo = tipleyCodigo;
	}

	public JubTipoLey getJubTipoLey() {
		return jubTipoLey;
	}

	public void setJubTipoLey(JubTipoLey jubTipoLey) {
		this.jubTipoLey = jubTipoLey;
	}
}