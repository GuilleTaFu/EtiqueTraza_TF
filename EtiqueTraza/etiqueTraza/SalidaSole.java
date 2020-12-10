package etiqueTraza;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SalidaSole {
	private String pathSalida;//
	private String nombreSalida;//
	private String titCol1;
	private String titCol2;
	private String titCol3;
	private Integer largoCol1;//
	private Integer largoCol2;//
	private Integer largoCol3;//
	private String txtCol1;
	private String txtCol2;
	private String txtCol3;

	
	public void guardar() {
		txtCol3="-"+txtCol3;
	    FileWriter fw = null;
		
		try {
			File fichero=new File(pathSalida+nombreSalida);

			FileWriter flwriter = null;
			flwriter = new FileWriter(fichero.getAbsoluteFile(), true);
        	BufferedWriter bfwriter = new BufferedWriter(flwriter);
			if (!fichero.exists()) {
	        	fichero.createNewFile();
	

	        	bfwriter.write(titCol1.format("%1$"+largoCol1+"s",titCol1));
	        	bfwriter.write(titCol2.format("%1$"+largoCol2+"s",titCol2));
	        	bfwriter.write(titCol3.format("%1$"+largoCol3+"s",titCol3));
	        	bfwriter.write(txtCol1.format("%1$"+largoCol1+"s",txtCol1));
	        	bfwriter.write(txtCol2.format("%1$"+largoCol2+"s",txtCol2));
	        	bfwriter.write(txtCol3.format("%1$"+largoCol3+"s",txtCol3));
				
				bfwriter.close();	
				flwriter.close();
	        }else {

	        	fw = new FileWriter(fichero.getAbsoluteFile(), true);
	        	bfwriter = new BufferedWriter(fw);
				bfwriter.newLine();
	        	bfwriter.write(txtCol1.format("%1$"+largoCol1+"s",txtCol1));
	        	bfwriter.write(txtCol2.format("%1$"+largoCol2+"s",txtCol2));
	        	bfwriter.write(txtCol3.format("%1$"+largoCol3+"s",txtCol3));
				
				bfwriter.close();
				flwriter.close();
	        }
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}//FIN GUARDAR
	
	
	public String getPathSalida() {
		return pathSalida;
	}
	public void setPathSalida(String pathSalida) {
		this.pathSalida = pathSalida;
	}
	public String getNombreSalida() {
		return nombreSalida;
	}
	public void setNombreSalida(String nombreSalida) {
		this.nombreSalida = nombreSalida;
	}
	public String getTitCol1() {
		return titCol1;
	}
	public void setTitCol1(String titCol1) {
		this.titCol1 = titCol1;
	}
	public String getTitCol2() {
		return titCol2;
	}
	public void setTitCol2(String titCol2) {
		this.titCol2 = titCol2;
	}
	public String getTitCol3() {
		return titCol3;
	}
	public void setTitCol3(String titCol3) {
		this.titCol3 = titCol3;
	}
	public Integer getLargoCol1() {
		return largoCol1;
	}
	public void setLargoCol1(Integer largoCol1) {
		this.largoCol1 = largoCol1;
	}
	public Integer getLargoCol2() {
		return largoCol2;
	}
	public void setLargoCol2(Integer largoCol2) {
		this.largoCol2 = largoCol2;
	}
	public Integer getLargoCol3() {
		return largoCol3;
	}
	public void setLargoCol3(Integer largoCol3) {
		this.largoCol3 = largoCol3;
	}
	public String getTxtCol1() {
		return txtCol1;
	}
	public void setTxtCol1(String txtCol1) {
		this.txtCol1 = txtCol1;
	}
	public String getTxtCol2() {
		return txtCol2;
	}
	public void setTxtCol2(String txtCol2) {
		this.txtCol2 = txtCol2;
	}
	public String getTxtCol3() {
		return txtCol3;
	}
	public void setTxtCol3(String txtCol3) {
		this.txtCol3 = txtCol3;
	}

	
	
}/// FIN CLASE
