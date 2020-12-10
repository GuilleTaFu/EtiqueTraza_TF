package articulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import conexiones.ConexionServFumaca;

public class modiArticulo {
	private String idArticulo;
	private Integer cantEtiquetas;
	private String fechaHora;
	private Integer nroEtiqueta;
	private String usuario;
	private String descrip;
	
	
	public modiArticulo(String idArticulo,String descrip,Integer nroEtiqueta,String usuario,Integer cantidad,Integer cantXCaja) {
		setIdArticulo(idArticulo);
		setDescrip(descrip);
		setNroEtiqueta(nroEtiqueta);
		setUsuario(usuario);
		setCantEtiquetas(cantidad/cantXCaja);	
		setFechaHora();	
		guardarCambios();
		try {
			guardarMovi();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void guardarMovi() throws SQLException {
		ConexionServFumaca SQL = new ConexionServFumaca();
		Connection conn = SQL.conectarEtiquetas();
		
		PreparedStatement st = conn.prepareStatement("insert into movimiento values (?,?,?,?,?,?,?)");
		int nro=getNroEtiqueta();
		for(int a=0;a<getCantEtiquetas();a++) {
			nro=nro+1;
			st.setString(1, getIdArticulo()); 
			st.setString(2,getFechaHora() ); 
			st.setInt(3, nro); 
			st.setString(4,getUsuario());
			st.setString(5,getDescrip());
			st.setInt(6,getCantEtiquetas());
			st.setInt(7, 0);
			st.executeUpdate(); // 
		}
			
        try {
        	ConexionServFumaca.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void guardarCambios() {
		ConexionServFumaca SQL = new ConexionServFumaca();
		Connection conn = SQL.conectarEtiquetas();
		Integer nroNuevo=getCantEtiquetas()+getNroEtiqueta();
		String idact=getIdArticulo();
		String sSQL =   "";

			sSQL = "update articulos set nroetiqueta='"+nroNuevo+"' where idarticulo='"+idact+"'";

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
	}

	private String getIdArticulo() {
		return idArticulo;
	}


	private void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}


	private Integer getCantEtiquetas() {
		return cantEtiquetas;
	}


	private void setCantEtiquetas(Integer cantEtiquetas) {
		this.cantEtiquetas = cantEtiquetas;
	}


	private String getFechaHora() {
		return fechaHora;
	}


	private void setFechaHora() {
		Date objDate = new Date(); 

		 String strDateFormat = "dd-MMM-YYYY hh:mm:ss a"; 
	      SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); 

		this.fechaHora = objSDF.format(objDate).toString();

	}


	private Integer getNroEtiqueta() {
		return nroEtiqueta;
	}


	private void setNroEtiqueta(Integer nroEtiqueta) {
		this.nroEtiqueta = nroEtiqueta;
	}


	private String getUsuario() {
		return usuario;
	}


	private void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	private String getDescrip() {
		return descrip;
	}


	private void setDescrip(String descrip) {
		this.descrip = descrip;
	}

}
