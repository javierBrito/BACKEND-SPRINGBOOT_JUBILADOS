package ec.gob.educacion.model.jubilacion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the JUB_ASPIRANTE database table.
 * 
 */
@Entity
@Table(name = "JUB_ASPIRANTE")
@NamedQuery(name = "JubAspirante.findAll", query = "SELECT j FROM JubAspirante j")
@SequenceGenerator(name = "SEQ_JUB_ASPIRANTE_GEN", sequenceName = "SEQ_JUB_ASPIRANTE", allocationSize = 1)
public class JubAspirante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ASP_CODIGO")
	@GeneratedValue(generator = "SEQ_JUB_ASPIRANTE_GEN", strategy = GenerationType.SEQUENCE)
	private Long aspCodigo;

	@Column(name = "ASP_APORTACIONESPRI")
	private int aspAportacionesPri;

	@Column(name = "ASP_APORTACIONESPUB")
	private int aspAportacionesPub;

	@Column(name = "ASP_CEDULA")
	private String aspCedula;

	@Column(name = "ASP_CORREO")
	private String aspCorreo;

	@Column(name = "ASP_DIRECCION")
	private String aspDireccion;

	@Column(name = "ASP_ESTADO")
	private int aspEstado;

	@Column(name = "ASP_IMPEDIMENTO")
	private int aspImpedimento;

	@Column(name = "ASP_MODALIDADCON")
	private int aspModalidadCon;

	@Column(name = "ASP_NUMERORES")
	private int aspNumeroRes;

	@Column(name = "ASP_PARTIDAGEN")
	private String aspPartidaGen;

	@Column(name = "ASP_PARTIDAIND")
	private int aspPartidaInd;

	@Column(name = "ASP_REGIMENLAB")
	private int aspRegimenLab;

	@Column(name = "ASP_TELEFONO")
	private String aspTelefono;

	@Column(name = "ASP_UNIDADEDU")
	private String aspUnidadEdu;

	// Respaldar datos hasta el momento de la inscripción
	@Column(name = "ASP_NOMREGIMENLAB")
	private String aspNomRegimenLab;

	@Column(name = "ASP_NOMMODALIDADCON")
	private String aspNomModalidadCon;

	@Column(name = "ASP_NOMIMPEDIMENTO")
	private String aspNomImpedimento;

	@Column(name = "TIPDIS_NOMDISCAPACIDAD")
	private String tipdisNomDiscapacidad;

	@Column(name = "TIPDIS_PORCENTAJE")
	private Integer tipdisPorcentaje;

	@Column(name = "TIPJUB_NOMJUBILACION")
	private String tipjubNomJubilacion;

	@Column(name = "ASP_FECHA")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date aspFecha;

	// bi-directional many-to-one association to JubTipoDiscapacidad
	@ManyToOne
	@JoinColumn(name = "TIPDIS_CODIGO")
	@JsonIgnore
	private JubTipoDiscapacidad jubTipoDiscapacidad;

	// bi-directional many-to-one association to JubParametro
	@ManyToOne
	@JoinColumn(name = "PAR_CODIGO")
	// @JsonIgnore
	private JubParametro jubParametro;

	@Transient
	private Long tipdisCodigo;
	@Transient
	private Long parCodigo;
	@Transient
	private List<JubEstadoTramite> listaEstadoTramite;

	public JubAspirante() {
	}

	public Long getAspCodigo() {
		return this.aspCodigo;
	}

	public void setAspCodigo(Long aspCodigo) {
		this.aspCodigo = aspCodigo;
	}

	public int getAspAportacionesPri() {
		return this.aspAportacionesPri;
	}

	public void setAspAportacionesPri(int aspAportacionesPri) {
		this.aspAportacionesPri = aspAportacionesPri;
	}

	public int getAspAportacionesPub() {
		return this.aspAportacionesPub;
	}

	public void setAspAportacionesPub(int aspAportacionesPub) {
		this.aspAportacionesPub = aspAportacionesPub;
	}

	public String getAspCedula() {
		return this.aspCedula;
	}

	public void setAspCedula(String aspCedula) {
		this.aspCedula = aspCedula;
	}

	public String getAspCorreo() {
		return this.aspCorreo;
	}

	public void setAspCorreo(String aspCorreo) {
		this.aspCorreo = aspCorreo;
	}

	public String getAspDireccion() {
		return this.aspDireccion;
	}

	public void setAspDireccion(String aspDireccion) {
		this.aspDireccion = aspDireccion;
	}

	public int getAspEstado() {
		return this.aspEstado;
	}

	public void setAspEstado(int aspEstado) {
		this.aspEstado = aspEstado;
	}

	public int getAspImpedimento() {
		return this.aspImpedimento;
	}

	public void setAspImpedimento(int aspImpedimento) {
		this.aspImpedimento = aspImpedimento;
	}

	public int getAspModalidadCon() {
		return this.aspModalidadCon;
	}

	public void setAspModalidadCon(int aspModalidadCon) {
		this.aspModalidadCon = aspModalidadCon;
	}

	public int getAspNumeroRes() {
		return this.aspNumeroRes;
	}

	public void setAspNumeroRes(int aspNumeroRes) {
		this.aspNumeroRes = aspNumeroRes;
	}

	public int getAspPartidaInd() {
		return this.aspPartidaInd;
	}

	public void setAspPartidaInd(int aspPartidaInd) {
		this.aspPartidaInd = aspPartidaInd;
	}

	public int getAspRegimenLab() {
		return this.aspRegimenLab;
	}

	public void setAspRegimenLab(int aspRegimenLab) {
		this.aspRegimenLab = aspRegimenLab;
	}

	public String getAspTelefono() {
		return this.aspTelefono;
	}

	public void setAspTelefono(String aspTelefono) {
		this.aspTelefono = aspTelefono;
	}

	public String getAspUnidadEdu() {
		return this.aspUnidadEdu;
	}

	public void setAspUnidadEdu(String aspUnidadEdu) {
		this.aspUnidadEdu = aspUnidadEdu;
	}

	public JubTipoDiscapacidad getJubTipoDiscapacidad() {
		return this.jubTipoDiscapacidad;
	}

	public void setJubTipoDiscapacidad(JubTipoDiscapacidad jubTipoDiscapacidad) {
		this.jubTipoDiscapacidad = jubTipoDiscapacidad;
	}

	public Long getTipdisCodigo() {
		if (jubTipoDiscapacidad != null) {
			return jubTipoDiscapacidad.getTipdisCodigo();
		}
		return this.tipdisCodigo;
	}

	public void setTipdisCodigo(Long tipdisCodigo) {
		this.tipdisCodigo = tipdisCodigo;
	}

	public Long getParCodigo() {
		if (jubParametro != null) {
			return jubParametro.getParCodigo();
		}
		return this.parCodigo;
	}

	public void setParCodigo(Long parCodigo) {
		this.parCodigo = parCodigo;
	}

	public String getAspPartidaGen() {
		return aspPartidaGen;
	}

	public void setAspPartidaGen(String aspPartidaGen) {
		this.aspPartidaGen = aspPartidaGen;
	}

	public String getAspNomRegimenLab() {
		return aspNomRegimenLab;
	}

	public void setAspNomRegimenLab(String aspNomRegimenLab) {
		this.aspNomRegimenLab = aspNomRegimenLab;
	}

	public String getAspNomModalidadCon() {
		return aspNomModalidadCon;
	}

	public void setAspNomModalidadCon(String aspNomModalidadCon) {
		this.aspNomModalidadCon = aspNomModalidadCon;
	}

	public String getAspNomImpedimento() {
		return aspNomImpedimento;
	}

	public void setAspNomImpedimento(String aspNomImpedimento) {
		this.aspNomImpedimento = aspNomImpedimento;
	}

	public String getTipdisNomDiscapacidad() {
		return tipdisNomDiscapacidad;
	}

	public void setTipdisNomDiscapacidad(String tipdisNomDiscapacidad) {
		this.tipdisNomDiscapacidad = tipdisNomDiscapacidad;
	}

	public Integer getTipdisPorcentaje() {
		return tipdisPorcentaje;
	}

	public void setTipdisPorcentaje(Integer tipdisPorcentaje) {
		this.tipdisPorcentaje = tipdisPorcentaje;
	}

	public JubParametro getJubParametro() {
		return jubParametro;
	}

	public void setJubParametro(JubParametro jubParametro) {
		this.jubParametro = jubParametro;
	}

	public String getTipjubNomJubilacion() {
		return tipjubNomJubilacion;
	}

	public void setTipjubNomJubilacion(String tipjubNomJubilacion) {
		this.tipjubNomJubilacion = tipjubNomJubilacion;
	}

	public Date getAspFecha() {
		return aspFecha;
	}

	public void setAspFecha(Date aspFecha) {
		this.aspFecha = aspFecha;
	}
	
	public List<JubEstadoTramite> getListaEstadoTramite() {
		return listaEstadoTramite;
	}

	public void setListaEstadoTramite(List<JubEstadoTramite> listaEstadoTramite) {
		this.listaEstadoTramite = listaEstadoTramite;
	}
}