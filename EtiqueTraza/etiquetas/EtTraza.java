package etiquetas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import auxiliares.RellenarCeros;
import conexiones.ConexionServFumaca;
import etiqueTraza.EtiqueTraza;

/**
 * @author gcardillo
 * @version 1.0
 * @created 19-nov.-2020 10:00:43
 */
public class EtTraza {

	private int cantEtiquetas;
	private int cantxCaja;
	private int cantUnidades;
	private String descripcion;
	private String idArticulo;
	private int nroTraza;
	private String operario;
	private String codBarraEtiquetaTraza;
	private String codBarraEtiquetaControl;
	private String ubicacion;
	private String impresora;
	private String impText;
	
	RellenarCeros ceros=new RellenarCeros();

	public void EtiqTraza(String idArticulo,String descrip,Integer cantUnidades, String Operario, Integer CantxCaja,Integer nroEti,String Ubicacion){
		setIdArticulo(idArticulo);
		setCantUnidades(cantUnidades);
		setOperario(Operario);
		setCantxCaja(CantxCaja);
		setDescripcion(descrip);
		setNroTraza(nroEti);
		setUbicacion(Ubicacion);
		setCodBarraEtiquetaControl(getIdArticulo(),cantUnidades);
		setcodBarraEtiquetaTraza(getIdArticulo(),String.valueOf(getCantUnidades()),String.valueOf(getNroTraza()));
		cantEtiquetas=cantUnidades/CantxCaja;
		
		String cmd = null;
		String paraImprimir=impText+" "+getImpresora();
		cmd="cmd /c "+ paraImprimir;
		
		File fichero = new File("imprimir.epl");
		fichero.delete();
		
		imprimirCtrl();
		for(int i=0;i<cantEtiquetas;i++) {
			imprimir();
			setNroTraza(this.nroTraza);
			setcodBarraEtiquetaTraza(getIdArticulo(),String.valueOf(getCantxCaja()),String.valueOf(getNroTraza()));
		}
		
		/// IMPRIMIENDO 
		try {
			Runtime.getRuntime().exec(cmd);    
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	private void imprimirCtrl() {

		///Insertar comillas
		String descripcion="\""+getDescripcion()+"\"";
		String ubi="\""+getUbicacion()+"\"";
		String canTot="\"CANT: "+getCantUnidades()+"\"";
		String cd="\""+getCodBarraEtiquetaControl()+"\"";

		try {
			FileWriter flwriter = null;
			flwriter = new FileWriter("imprimir.epl");
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			bfwriter.write("N");
			bfwriter.newLine();
			bfwriter.write("A40,5,0,4,1,1,R,");
			bfwriter.write(descripcion);
			bfwriter.newLine();
			bfwriter.write("A40,35,0,3,1,1,R,");
			bfwriter.write(ubi);
			bfwriter.newLine();
			bfwriter.write("A350,35,0,3,1,1,R,");
			bfwriter.write(canTot);
			bfwriter.newLine();
			bfwriter.write("B40,60,0,1,2,4,60,B,");
			bfwriter.write(cd);
			bfwriter.newLine();
			bfwriter.write("P1");
			bfwriter.newLine();
			bfwriter.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	private void imprimir() {
		///Insertar comillas
		String descripcion="\""+getDescripcion()+"\"";
		String usuario="\""+getOperario()+"\"";
		String cantidad="\"CANT: "+getCantxCaja()+"\"";
		//String codigo="\""+cod+"\"";
		String codigo="\""+getcodBarraEtiquetaTraza()+"\"";
		
		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("imprimir.epl",true);
		
		BufferedWriter bfwriter = new BufferedWriter(flwriter);

			
		bfwriter.write("N");
		bfwriter.newLine();
		bfwriter.write("A40,5,0,4,1,1,N,");
		bfwriter.write(descripcion);
		bfwriter.newLine();
		bfwriter.write("A40,35,0,3,1,1,N,");
		bfwriter.write(usuario);
		bfwriter.newLine();
		bfwriter.write("A350,35,0,3,1,1,N,");
		bfwriter.write(cantidad);
		bfwriter.newLine();
		bfwriter.write("B40,60,0,1,2,4,60,B,");
		bfwriter.write(codigo);
		bfwriter.newLine();
		bfwriter.write("P1");
		bfwriter.newLine();
		bfwriter.newLine();
		bfwriter.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void finalize() throws Throwable {

	}
	private void setcodBarraEtiquetaTraza(String parte1,String parte2, String parte3) {
		//parte1=ceros.llenar(parte1, 13, "I"); QUEDA ASÍ MIENTRAS SE TRAIGA EL STRING CON 13 CARACTERES
		parte2=ceros.llenar(parte2,5,"I");
		parte3=ceros.llenar(parte3,5,"I");
		
		this.codBarraEtiquetaTraza=parte1+parte2+parte3;		
	}
	private String getcodBarraEtiquetaTraza() {
		return codBarraEtiquetaTraza;
	}

	public int getCantEtiquetas() {
		cantEtiquetas=getCantUnidades()/getCantxCaja();
		return cantEtiquetas;
	}

	public void setCantEtiquetas(int cantEtiquetas) {
		this.cantEtiquetas = cantEtiquetas;
	}

	public int getCantxCaja() {
		return cantxCaja;
	}

	private void setCantxCaja(int cantxCaja) {
		this.cantxCaja = cantxCaja;
	}

	public int getCantUnidades() {
		return cantUnidades;
	}

	private void setCantUnidades(int cantUnidades) {
		this.cantUnidades = cantUnidades;
	}

	public String getIdArticulo() {
		return idArticulo;
	}

	private void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getOperario() {
		return operario;
	}

	private void setOperario(String operario) {
		this.operario = operario;
	}

	public int getNroTraza() {
		return nroTraza;
	}

	private void setNroTraza(Integer nroActual) {
		this.nroTraza = nroActual+1;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodBarraEtiquetaControl() {
		return codBarraEtiquetaControl;
	}
	public void setCodBarraEtiquetaControl(String codBarraEtiquetaControl,Integer cant) {
		this.codBarraEtiquetaControl = codBarraEtiquetaControl+ceros.llenar(String.valueOf(cant), 5, "I");	
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public void setImpresora(String impDir) {
		this.impresora=impDir;
	}
	public String getImpresora() {
		return impresora;
	}
	public void setImpText(String impText) {
		this.impText=impText;
	}
	public String getImpText() {
		return impText;
	}
}//end EtTraza