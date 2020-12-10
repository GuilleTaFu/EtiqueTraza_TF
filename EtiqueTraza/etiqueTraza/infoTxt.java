package etiqueTraza;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class infoTxt {
	private String impDir;
	private String batNombre;
	private String batCuerpo;
	private String salPath;
	private String salNombre;
	private Integer col1;
	private Integer col2;
	private Integer col3;
	private String solcli;
	private String soltit1;
	private String soltit2;
	private String soltit3;


	private FileReader fr=new FileReader("config.txt");
	private BufferedReader bf=new BufferedReader(fr);
	
	public infoTxt() throws IOException {

		String sCadena,caso;
		
		while((sCadena=bf.readLine())!=null){
			if(sCadena.length()>6) {
			caso=sCadena.substring(0, 8);
					switch(caso) {
					case "[impdir]":
						impDir=sCadena.substring(8, sCadena.length());
						break;
					case "[batnom]":
						batNombre=sCadena.substring(8, sCadena.length());
						break;
					case "[battex]":
						batCuerpo=sCadena.substring(8, sCadena.length());
						break;
					case "[solpat]":
						salPath=sCadena.substring(8, sCadena.length());
						break;
					case "[solnom]":
						salNombre=sCadena.substring(8, sCadena.length());
						break;
					case "[solco1]":
						col1=Integer.parseInt(sCadena.substring(8, sCadena.length()));
						break;
					case "[solco2]":
						col2=Integer.parseInt(sCadena.substring(8, sCadena.length()));
						break;
					case "[solco3]":
						col3=Integer.parseInt(sCadena.substring(8, sCadena.length()));
							break;
					case "[solcli]":
						solcli=sCadena.substring(8, sCadena.length());
							break;
					case "[solti1]":
						soltit1=sCadena.substring(8, sCadena.length());
							break;
					case "[solti2]":
						soltit2=sCadena.substring(8, sCadena.length());
							break;
					case "[solti3]":
						soltit3=sCadena.substring(8, sCadena.length());
							break;
					default:
						break;				
					}//FIN SWITCH
			}// FIN IF
		}	/// FIN WHILE

		
	}/// FIN CONSTRUCTOR

	public String getImpDir() {
		return impDir;
	}

	public String getBatNombre() {
		return batNombre;
	}

	public String getBatCuerpo() {
		return batCuerpo;
	}

	public String getSalPath() {
		return salPath;
	}

	public String getSalNombre() {
		return salNombre;
	}

	public Integer getCol1() {
		return col1;
	}

	public Integer getCol2() {
		return col2;
	}

	public Integer getCol3() {
		return col3;
	}

	public FileReader getFr() {
		return fr;
	}

	public BufferedReader getBf() {
		return bf;
	}

	public String getSolcli() {
		return solcli;
	}

	public String getSoltit1() {
		return soltit1;
	}

	public String getSoltit2() {
		return soltit2;
	}

	public String getSoltit3() {
		return soltit3;
	}


}/// FIN CLASE
