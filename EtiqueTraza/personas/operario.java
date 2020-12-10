// Clase creada con el unico fin de utilizar el nombre del operario que 
// se imprimirá en la etiqueta y llevar un control de los mismos en los 
// movimientos. No tiene relación con las personas y empleados.

package personas;

public class operario {
	private String nombre;
	private Integer Operaciones;
	private String visible;
	
	public operario() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getOperaciones() {
		return Operaciones;
	}
	public void setOperaciones(Integer operaciones) {
		Operaciones = operaciones;
	}
	public String getVisible() {
		return visible;
	}
	public void setVisible(String visible) {
		this.visible = visible;
	}
		
}
