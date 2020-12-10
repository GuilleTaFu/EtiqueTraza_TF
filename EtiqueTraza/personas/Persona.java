package personas;

import java.sql.Date;

/**
 * @author gcardillo
 * @version 1.0
 * @created 19-nov.-2020 09:24:57
 */
public class Persona {
	
	private int IDInterno;
	private String nombre;
	private String apellido;
	private String CUITCUIL;

	private String direccionPersonal;
	private int ciudadPersonal;
	private int provinciaPersonal;
	private int paisPersonal;
	private String telefonoPersonal;
	private String emailPersonal;
	private String nrocelular;
	
	private String direccionLaboral;
	private int ciudadLaboral;
	private int paisLaboral;
	private int provinciaLaboral;
	private String telefonoLaboral;
	private String emailLaboral;
	private Date fechaNac;


	public int getIDInterno() {
		return IDInterno;
	}

	public void setIDInterno(int iDInterno) {
		IDInterno = iDInterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCUITCUIL() {
		return CUITCUIL;
	}

	public void setCUITCUIL(String cUITCUIL) {
		CUITCUIL = cUITCUIL;
	}

	public String getDireccionPersonal() {
		return direccionPersonal;
	}

	public void setDireccionPersonal(String direccionPersonal) {
		this.direccionPersonal = direccionPersonal;
	}

	public int getCiudadPersonal() {
		return ciudadPersonal;
	}

	public void setCiudadPersonal(int ciudadPersonal) {
		this.ciudadPersonal = ciudadPersonal;
	}

	public int getProvinciaPersonal() {
		return provinciaPersonal;
	}

	public void setProvinciaPersonal(int provinciaPersonal) {
		this.provinciaPersonal = provinciaPersonal;
	}

	public int getPaisPersonal() {
		return paisPersonal;
	}

	public void setPaisPersonal(int paisPersonal) {
		this.paisPersonal = paisPersonal;
	}

	public String getTelefonoPersonal() {
		return telefonoPersonal;
	}

	public void setTelefonoPersonal(String telefonoPersonal) {
		this.telefonoPersonal = telefonoPersonal;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public String getNrocelular() {
		return nrocelular;
	}

	public void setNrocelular(String nrocelular) {
		this.nrocelular = nrocelular;
	}

	public String getDireccionLaboral() {
		return direccionLaboral;
	}

	public void setDireccionLaboral(String direccionLaboral) {
		this.direccionLaboral = direccionLaboral;
	}

	public int getCiudadLaboral() {
		return ciudadLaboral;
	}

	public void setCiudadLaboral(int ciudadLaboral) {
		this.ciudadLaboral = ciudadLaboral;
	}

	public int getPaisLaboral() {
		return paisLaboral;
	}

	public void setPaisLaboral(int paisLaboral) {
		this.paisLaboral = paisLaboral;
	}

	public int getProvinciaLaboral() {
		return provinciaLaboral;
	}

	public void setProvinciaLaboral(int provinciaLaboral) {
		this.provinciaLaboral = provinciaLaboral;
	}

	public String getTelefonoLaboral() {
		return telefonoLaboral;
	}

	public void setTelefonoLaboral(String telefonoLaboral) {
		this.telefonoLaboral = telefonoLaboral;
	}

	public String getEmailLaboral() {
		return emailLaboral;
	}

	public void setEmailLaboral(String emailLaboral) {
		this.emailLaboral = emailLaboral;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public Persona(){

	}

	public void finalize() throws Throwable {

	}
}//end Persona