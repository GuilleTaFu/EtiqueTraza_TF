package articulos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexiones.ConexionServFumaca;

public class Articulos {
	private String idSole;
	private String idArticulo;
	private String idProveedor;
	private Integer nroEtiqueta;
	private String descripcion;
	private Integer cantxcaja;
	private String ubicacion;
	private Connection conn;
	private Boolean encontro;

	public Articulos(String idarticulos){
		encontro=false;
		setIdArticulo(idarticulos);
		traerDatos();
	}
	public void porProveedor(String idProveedor) {

			ConexionServFumaca SQL = new ConexionServFumaca();
			conn = SQL.conectarEtiquetas();
			String sSQL =   "";
			try {
				sSQL = "SELECT * FROM articulos where idproveedor= '"+idProveedor+"'";
				PreparedStatement ps=conn.prepareStatement(sSQL);
				ResultSet rs=ps.executeQuery(); 
				rs=ps.executeQuery(); 
			
				while (rs.next()){
					setEncontro(true);
					setIdArticulo(rs.getNString("idarticulo"));
					setIdSole(rs.getNString("idsole"));
					setNroEtiqueta(rs.getInt("nroEtiqueta"));
					setDescripcion(rs.getNString("descripcion"));
					setIdProveedor(rs.getNString("idproveedor"));
					setCantxcaja(Integer.parseInt(rs.getNString("cantxcaja"))); //EL CAMPO DE LA BD ES STRING Y NO QUISE MODIFICARLO AÚN
					setUbicacion(rs.getNString("ubicacion"));
				}
				
				ConexionServFumaca.cerrar();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public Articulos(String idarticulos,Integer Sobre){
		encontro=false;
		setIdArticulo(idarticulos);
		traerDatos();

	}
	private void traerDatos(){
		
		ConexionServFumaca SQL = new ConexionServFumaca();
		conn = SQL.conectarEtiquetas();
		String sSQL =   "";
		try{	
			sSQL = "SELECT * FROM articulos where idarticulo= '"+getIdArticulo()+"'";
			PreparedStatement ps=conn.prepareStatement(sSQL);
			ResultSet rs=ps.executeQuery(); 
	
				while (rs.next()){
					setEncontro(true);
					setIdSole(rs.getNString("idsole"));
					setNroEtiqueta(rs.getInt("nroEtiqueta"));
					setDescripcion(rs.getNString("descripcion"));
					setIdProveedor(rs.getNString("idproveedor"));
					setCantxcaja(Integer.parseInt(rs.getNString("cantxcaja"))); //EL CAMPO DE LA BD ES STRING Y NO QUISE MODIFICARLO AÚN
					setUbicacion(rs.getNString("ubicacion"));
				}

			ConexionServFumaca.cerrar();


		}catch (SQLException e) {
			e.printStackTrace();
		}

	}/// FIN METODO TRAER DATOS
	
	public void guardarNroFinal(Integer ultimo) {
		ConexionServFumaca SQL = new ConexionServFumaca();
		Connection conn = SQL.conectarEtiquetas();
		
		String sSQL =   "";

			sSQL = "update articulos set nroetiqueta='"+ultimo+"' where idarticulo='"+getIdArticulo()+"'";

			 try (PreparedStatement pstm = conn.prepareStatement(sSQL)) {

		            pstm.executeUpdate();
		     } catch (SQLException e) {
				e.printStackTrace();
			}

			
            try {
				ConexionServFumaca.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}//FIN METODO GUARDARNROFINAL
	
	public String getIdSole() {
		return idSole;
	}
	private void setIdSole(String idSole) {
		this.idSole = idSole;
	}
	public String getIdArticulo() {
		return idArticulo;
	}
	private void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}
	public String getIdProveedor() {
		return idProveedor;
	}
	private void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	public Integer getNroEtiqueta() {
		return nroEtiqueta;
	}
	private void setNroEtiqueta(Integer nroEtiqueta) {
		this.nroEtiqueta = nroEtiqueta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCantxcaja() {
		return cantxcaja;
	}
	private void setCantxcaja(Integer cantxcaja) {
		this.cantxcaja = cantxcaja;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	private void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	private void setEncontro(Boolean encontro) {
		this.encontro=encontro;
	}
	public Boolean getEncontro() {
		return encontro;
	}
	
}
