package testers;
import java.io.IOException;

import etiqueTraza.infoTxt;
public class testConfig {
	static infoTxt importar;
	
	public static void main(String[] args) {
		try {
			importar=new infoTxt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
